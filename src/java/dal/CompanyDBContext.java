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
import model.Company;
import model.CompanysOwe;
import model.Customer;
import model.CustomersOwe;
import model.OrderDetail;
import model.OrderHistory;
import model.Product;
import model.SaleHistory;

/**
 *
 * @author ADMIN
 */
public class CompanyDBContext extends DBContext {

    public ArrayList<CompanysOwe> getAllCompanyOwe() {
        ArrayList<CompanysOwe> owns = new ArrayList<>();
        try {

            String sql = "WITH a as (SELECT OrderHistory.id,companyName,SUM(cost*quantity*(1-discount)) - AVG(paid) AS 'tienno',OrderHistory.companyId AS 'idc' FROM dbo.OrderDetail JOIN dbo.OrderHistory\n"
                    + "ON OrderHistory.id = OrderDetail.orderId\n"
                    + "JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "JOIN dbo.Company ON Company.id = OrderHistory.companyId\n"
                    + "GROUP BY OrderHistory.id,companyName,OrderHistory.companyId \n"
                    + "HAVING SUM(cost * quantity * (1-discount) ) - AVG(paid) > 0\n"
                    + ") \n"
                    + "SELECT a.idc,a.companyName,SUM(a.tienno) AS 'tongno'  FROM a \n"
                    + "GROUP BY a.companyName,a.idc\n"
                    + "ORDER BY tongno DESC";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CompanysOwe co = new CompanysOwe();
                Company c = new Company();
                OrderHistory oh = new OrderHistory();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                oh.setCompany(c);
                co.setCompany(c);
                co.setOrderHistory(oh);
                co.setOweMoney(rs.getFloat(3));
                owns.add(co);
            }
            return owns;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owns;
    }

    public Company getCompany(int id) {

        try {

            String sql = "SELECT * FROM dbo.Company \n"
                    + "WHERE id = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Company c = new Company();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhoneNumber(rs.getString(4));
                c.setAddress(rs.getString(5));
                return c;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<OrderHistory> getCompanyOwe(int id, int pageindex, int pagesize, Date orderdate) {
        ArrayList<OrderHistory> owns = new ArrayList<>();
        try {

            String sql = "WITH k as (SELECT ROW_NUMBER() OVER (ORDER BY OrderHistory.id) AS 'row', companyName,orderDate,maturityDate,OrderHistory.id,SUM(cost*quantity*(1-discount)) AS 'total' , AVG(paid) AS 'tientra'FROM dbo.OrderHistory JOIN dbo.OrderDetail\n"
                    + "ON OrderDetail.orderId = OrderHistory.id\n"
                    + "JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "JOIN dbo.Company ON Company.id = OrderHistory.companyId\n"
                    + "WHERE Company.id = ?";
            if (orderdate != null) {
                sql += " AND orderDate >= ?";
            }
            sql += " GROUP BY orderDate,maturityDate,OrderHistory.id,companyName\n"
                    + "HAVING SUM(cost * quantity * (1-discount)) - AVG(paid) > 0)\n"
                    + "SELECT * FROM k\n"
                    + "WHERE k.row > (?-1)*? AND k.row <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            if (orderdate != null) {
                stm.setDate(2, orderdate);
                stm.setInt(3, pageindex);
                stm.setInt(4, pagesize);
                stm.setInt(5, pageindex);
                stm.setInt(6, pagesize);
            } else {
                stm.setInt(2, pageindex);
                stm.setInt(3, pagesize);
                stm.setInt(4, pageindex);
                stm.setInt(5, pagesize);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                OrderHistory oh = new OrderHistory();
                oh.setId(rs.getInt(5));
                Company c = new Company();
                c.setName(rs.getString(2));
                oh.setOrderDate(rs.getDate(3));
                oh.setMaturityDate(rs.getDate(4));
                oh.setTotal(rs.getFloat(6));
                oh.setPaid(rs.getFloat(7));
                oh.setCompany(c);
                owns.add(oh);
            }
            return owns;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owns;
    }

    public int getTotalPageOfOneCompanyOwe(int id, Date orderdate) {

        try {

            String sql = "WITH k as (SELECT ROW_NUMBER() OVER (ORDER BY OrderHistory.id) AS 'row', companyName,orderDate,maturityDate,OrderHistory.id,SUM(cost * quantity * (1-discount)) AS 'total' , AVG(paid) AS 'tientra'FROM dbo.OrderHistory JOIN dbo.OrderDetail\n"
                    + "ON OrderDetail.orderId = OrderHistory.id\n"
                    + "JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "JOIN dbo.Company ON Company.id = OrderHistory.companyId\n"
                    + "WHERE Company.id = ?";
            if (orderdate != null) {
                sql += " AND orderDate >= ?";
            }
            sql += " GROUP BY orderDate,maturityDate,OrderHistory.id,companyName\n"
                    + "HAVING SUM(cost * quantity * (1-discount)) - AVG(paid) > 0)\n"
                    + "SELECT COUNT(*) AS allrow FROM k";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            if (orderdate != null) {
                stm.setDate(2, orderdate);

            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public Date getNow() {
        try {

            String sql = "SELECT GETDATE();";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getDate(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalPageOfCompanyDetail(int id) {
        try {

            String sql = "SELECT COUNT(*) AS allrow FROM (SELECT ROW_NUMBER() OVER(ORDER BY orderId) AS rowindex, orderId,productName,quantity,price,discount,price*quantity AS 'thanhtien',description FROM dbo.OrderDetail\n"
                    + "	JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "	WHERE orderId = ?) a";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public ArrayList<OrderDetail> getOrderDetailById(int id, int pageindex, int pagesize) {
        ArrayList<OrderDetail> owns = new ArrayList<>();
        try {

            String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY orderId) AS rowindex, orderId,productName,quantity,cost,discount,(cost*quantity*(1-discount)) AS 'thanhtien',description FROM dbo.OrderDetail\n"
                    + "JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "WHERE orderId = ?) a\n"
                    + "WHERE a.rowindex > (?-1)*? AND a.rowindex <= ? *?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, pageindex);
            stm.setInt(3, pagesize);
            stm.setInt(4, pageindex);
            stm.setInt(5, pagesize);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                Product p = new Product();
                OrderHistory oh = new OrderHistory();
                oh.setId(rs.getInt(2));
                p.setName(rs.getString(3));
                o.setQuantity(rs.getInt(4));
                p.setCost(rs.getFloat(5));
                o.setDiscount(rs.getFloat(6));
                p.setDiscription(rs.getString(8));
                o.setProduct(p);
                o.setOrderHistory(oh);
                o.setTotal(rs.getFloat(7));
                owns.add(o);

            }
            return owns;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void payOneOrder(int orderSaleId, float toatl) {
        String sql = "UPDATE [dbo].[OrderHistory]\n"
                + "   SET [paid] = ?\n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setFloat(1, toatl);
            stm.setInt(2, orderSaleId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CompanyDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public ArrayList<OrderHistory> getAllOweOfCompany(int id) {
        ArrayList<OrderHistory> owns = new ArrayList<>();
        try {

            String sql = "WITH k as (SELECT ROW_NUMBER() OVER (ORDER BY OrderHistory.id) AS 'row', companyName,orderDate,maturityDate,OrderHistory.id,SUM(cost*quantity*(1-discount)) AS 'total' , AVG(paid) AS 'tientra'FROM dbo.OrderHistory JOIN dbo.OrderDetail\n"
                    + "                   ON OrderDetail.orderId = OrderHistory.id\n"
                    + "                   JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "                   JOIN dbo.Company ON Company.id = OrderHistory.companyId\n"
                    + "                   WHERE Company.id = ?\n"
                    + "				   GROUP BY orderDate,maturityDate,OrderHistory.id,companyName\n"
                    + "                   HAVING SUM(cost * quantity * (1-discount)) - AVG(paid) > 0)\n"
                    + "                   SELECT k.id,k.total FROM k";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                OrderHistory co = new OrderHistory();
                co.setId(rs.getInt(1));
                co.setTotal(rs.getFloat(2));
                owns.add(co);
            }
            return owns;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owns;
    }

    public void payManyOrder(ArrayList<OrderHistory> orderHistory) {

        String sql = "UPDATE [dbo].[OrderHistory]\n"
                + "   SET [paid] = ?\n"
                + " WHERE id = ?";
        PreparedStatement stm = null;
        try {

            for (OrderHistory order : orderHistory) {
                stm = connection.prepareStatement(sql);       
                stm.setFloat(1, (float) order.getTotal());
                stm.setInt(2, order.getId());
                stm.executeUpdate();
            }
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
