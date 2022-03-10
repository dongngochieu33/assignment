/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Address;
import model.Customer;
import model.CustomerOwe;
import model.CustomersOwe;
import model.Product;
import model.SaleDetail;
import model.SaleHistory;

/**
 *
 * @author ADMIN
 */
public class CustomersOweDBContext extends DBContext {

    public ArrayList<CustomersOwe> getCustomersOwe(int addressId, int pageIndex, int pagesize) {
        ArrayList<CustomersOwe> owns = new ArrayList<>();
        try {

            String sql = "  WITH a AS( SELECT* from (SELECT  firstName,lastName, date,customerId, SUM(price * quantity) - AVG(paid) AS 'TienNo',Xom,Address.id FROM dbo.SaleHistory JOIN dbo.SaleDetail\n"
                    + "ON SaleDetail.saleId = SaleHistory.id JOIN dbo.Product\n"
                    + "ON Product.id = SaleDetail.productId JOIN dbo.Customer\n"
                    + "ON Customer.id = SaleHistory.customerId JOIN dbo.Address\n"
                    + "ON Address.id = Customer.addressId\n"
                    + "GROUP BY SaleHistory.id,customerId,firstName,lastName,date,Xom,Address.id) AS A WHERE TienNo > 0\n"
                    + ")\n"
                    + "SELECT * from ( SELECT ROW_NUMBER() OVER(ORDER BY a.customerId) AS row_index ,a.customerId,a.firstName,a.lastName,sum(a.TienNo) AS 'tongno',id,a.Xom FROM a";

            if (addressId != -1) {
                sql += " WHERE id = ?";
            }
            sql += " GROUP BY a.customerId,a.firstName,a.lastName,a.Xom,a.id\n"
                    + ") dum WHERE dum.row_index > (?-1)*? AND dum.row_index <= ?*?\n"
                    + "ORDER BY tongno DESC, lastName,firstName ASC";
            PreparedStatement stm = connection.prepareStatement(sql);
            if (addressId != -1) {
                stm.setInt(1, addressId);
                stm.setInt(2, pageIndex);
                stm.setInt(3, pagesize);
                stm.setInt(4, pageIndex);
                stm.setInt(5, pagesize);
            } else {
                stm.setInt(1, pageIndex);
                stm.setInt(2, pagesize);
                stm.setInt(3, pageIndex);
                stm.setInt(4, pagesize);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CustomersOwe co = new CustomersOwe();
                Customer c = new Customer();
                Address add = new Address();
                c.setCid(rs.getInt(2));
                c.setFirstName(rs.getString(3));
                c.setLastName(rs.getString(4));
                co.setOwnMoney(rs.getFloat(5));
                add.setId(rs.getInt(6));
                add.setXom(rs.getString(7));
                co.setAdd(add);
                co.setCus(c);
                owns.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owns;
    }

    public int getTotalPage(int addressId) {
        try {
            String sql = "  WITH a AS( SELECT* from (SELECT  firstName,lastName, date,customerId, SUM(price * quantity) - AVG(paid) AS 'TienNo',Xom,Address.id FROM dbo.SaleHistory JOIN dbo.SaleDetail\n"
                    + "ON SaleDetail.saleId = SaleHistory.id JOIN dbo.Product\n"
                    + "ON Product.id = SaleDetail.productId JOIN dbo.Customer\n"
                    + "ON Customer.id = SaleHistory.customerId JOIN dbo.Address\n"
                    + "ON Address.id = Customer.addressId\n"
                    + "GROUP BY SaleHistory.id,customerId,firstName,lastName,date,Xom,Address.id) AS A WHERE TienNo > 0\n"
                    + ")\n"
                    + "SELECT COUNT(*) as page  from ( SELECT ROW_NUMBER() OVER(ORDER BY a.customerId) AS row_index ,a.customerId,a.firstName,a.lastName,sum(a.TienNo) AS 'tongno',id,a.Xom FROM a\n"
                    + "\n"
                    + "GROUP BY a.customerId,a.firstName,a.lastName,a.Xom,a.id\n"
                    + ") page";

            if (addressId != -1) {
                sql += " WHERE id = ?";
            }

            PreparedStatement stm = connection.prepareStatement(sql);
            if (addressId != -1) {
                stm.setInt(1, addressId);
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public ArrayList<CustomerOwe> getOneCustomerOwe(int cusId, int pageIndex, int pagesize, Date date) {
        ArrayList<CustomerOwe> owns = new ArrayList<>();
        try {

            String sql = "SELECT * FROM  (SELECT ROW_NUMBER() OVER (ORDER BY SaleHistory.id) AS 'row_number', SaleHistory.id,date,firstName,lastName,SUM( price *quantity)AS 'Total', paid FROM dbo.Customer JOIN dbo.SaleHistory\n"
                    + "ON SaleHistory.customerId = Customer.id\n"
                    + "JOIN dbo.SaleDetail ON SaleDetail.saleId = SaleHistory.id\n"
                    + "JOIN dbo.Product ON Product.id = SaleDetail.productId\n"
                    + "WHERE Customer.id = ?\n";

            if (date != null) {
                sql += " AND date >= ?";
            }
            sql += " GROUP BY SaleHistory.id,date,firstName,lastName,paid HAVING SUM( price *quantity) - paid > 0) a\n"
                    + "                    WHERE a.row_number > (? - 1) * ? AND a.row_number <= ?*? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            if (date != null) {
                stm.setDate(2, date);
                stm.setInt(3, pageIndex);
                stm.setInt(4, pagesize);
                stm.setInt(5, pageIndex);
                stm.setInt(6, pagesize);
            } else {
                stm.setInt(2, pageIndex);
                stm.setInt(3, pagesize);
                stm.setInt(4, pageIndex);
                stm.setInt(5, pagesize);
            }
            stm.setInt(1, cusId);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CustomerOwe co = new CustomerOwe();
                Customer c = new Customer();
                SaleHistory saleh = new SaleHistory();
                saleh.setShId(rs.getInt(2));
                saleh.setDate(rs.getDate(3));
                c.setFirstName(rs.getString(4));
                c.setLastName(rs.getString(5));
                saleh.setTotal(rs.getFloat(6));
                saleh.setPaid(rs.getFloat(7));
                co.setCus(c);
                co.setSaleHistory(saleh);
                owns.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owns;
    }

    public int getTotalPageOfOneCustomerOwe(int cusId, Date date) {
        try {
            String sql = " SELECT COUNT(*) AS totalPage FROM  (SELECT ROW_NUMBER() OVER (ORDER BY SaleHistory.id) AS 'row_number', SaleHistory.id,date,firstName,lastName,SUM( price *quantity)AS 'Total', paid FROM dbo.Customer JOIN dbo.SaleHistory\n"
                    + "ON SaleHistory.customerId = Customer.id\n"
                    + "JOIN dbo.SaleDetail ON SaleDetail.saleId = SaleHistory.id\n"
                    + "JOIN dbo.Product ON Product.id = SaleDetail.productId\n"
                    + "WHERE Customer.id = ? \n";
            if (date != null) {
                sql += " AND date > ?";
            }
            sql += " GROUP BY SaleHistory.id,date,firstName,lastName,paid HAVING SUM( price *quantity) - paid > 0) a";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, cusId);
            if (date != null) {
                stm.setDate(2, date);
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int getTotalPageOfCustomerDetail(int saleHistoryId) {
        try {
            String sql = " SELECT COUNT(*) AS totalRow FROM (SELECT ROW_NUMBER() OVER(ORDER BY saleId) AS row, saleId,productName,description,price,quantity,discount FROM dbo.SaleDetail JOIN dbo.Product\n"
                    + "ON Product.id = SaleDetail.productId\n"
                    + "WHERE saleId = ?) a";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, saleHistoryId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public ArrayList<SaleDetail> getSaleDetailById(int saleHistoryId, int pageindex, int pagesize) {
        ArrayList<SaleDetail> saleDetail = new ArrayList<>();
        try {

            String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY saleId) AS row, saleId,productName,description,price,quantity,discount FROM dbo.SaleDetail JOIN dbo.Product\n"
                    + "ON Product.id = SaleDetail.productId\n"
                    + "WHERE saleId = ?) a\n"
                    + "WHERE a.row > (?-1)*? and  a.row <= ? * ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, saleHistoryId);
            stm.setInt(2, pageindex);
            stm.setInt(3, pagesize);
            stm.setInt(4, pageindex);
            stm.setInt(5, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SaleDetail s = new SaleDetail();
                Product p = new Product();
                SaleHistory sh = new SaleHistory();
                sh.setShId(rs.getInt(2));
                p.setName(rs.getString(3));
                p.setDiscription(rs.getString(4));
                p.setPrice(rs.getFloat(5));
                s.setSaleHistory(sh);
                s.setPro(p);
                s.setQuantity(rs.getInt(6));
                s.setDiscount(rs.getFloat(7));
                saleDetail.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleDetail;
    }

   
    public void payOrder(int shId, float tienPhaiTra) {
        String sql = "UPDATE [SaleHistory]\n"
                + "   SET \n"
                + "      [paid] = ?\n"
                + "      \n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setFloat(1, tienPhaiTra);
            stm.setInt(2, shId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
