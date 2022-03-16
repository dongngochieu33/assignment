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
import model.Company;
import model.OrderDetail;
import model.OrderHistory;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDBContext extends DBContext {

    public ArrayList<Product> getProduct(int id) {
        ArrayList<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT productName,Product.id AS 'productId',companyId,cost,description FROM product JOIN dbo.Company\n"
                    + "				ON Company.id = Product.companyId\n"
                    + "				WHERE companyId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                Company c = new Company();
                p.setId(rs.getInt(2));
                p.setName(rs.getString(1));
                p.setCost(rs.getFloat(4));
                c.setId(rs.getInt(3));
                p.setCompany(c);
                p.setDiscription(rs.getString(5));
                products.add(p);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Date getNow() {
        try {

            String sql = "select GETDATE(); ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Date d = rs.getDate(1);
                return d;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getBigestOrderId() {
        try {

            String sql = "select max(id) from orderHistory";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void insertOrder(ArrayList<Product> prodcuts, OrderHistory orderHistory, ArrayList<OrderDetail> orderdetail, int cid) {
        {
            try {
                String sql_insert_orderHistory = "INSERT INTO [dbo].[OrderHistory]\n"
                        + "           ([id]\n"
                        + "           ,[orderDate]\n"
                        + "           ,[paid]\n"
                        + "           ,[companyId]\n"
                        + "           ,[maturityDate])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,GETDATE()\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";

                String sql_insert_orderDetail = "INSERT INTO [dbo].[OrderDetail]\n"
                        + "           ([orderId]\n"
                        + "           ,[productId]\n"
                        + "           ,[quantity]\n"
                        + "           ,[discount])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?)";
                connection.setAutoCommit(false);

                PreparedStatement stm_insert_orderHistory = connection.prepareStatement(sql_insert_orderHistory);
                stm_insert_orderHistory.setInt(1, orderHistory.getId());
                stm_insert_orderHistory.setFloat(2, (float) orderHistory.getPaid());
                stm_insert_orderHistory.setInt(3, cid);
            
                stm_insert_orderHistory.setDate(4, orderHistory.getMaturityDate());
                stm_insert_orderHistory.executeUpdate();

                for (int i = 0; i < orderdetail.size(); i++) {
                    PreparedStatement stm_insert_orderDetail = connection.prepareStatement(sql_insert_orderDetail);
                    stm_insert_orderDetail.setInt(1, orderHistory.getId());
                    stm_insert_orderDetail.setInt(2, prodcuts.get(i).getId());
                    stm_insert_orderDetail.setInt(3, orderdetail.get(i).getQuantity());
                    stm_insert_orderDetail.setFloat(4, orderdetail.get(i).getDiscount());
                    stm_insert_orderDetail.executeUpdate();
                }

                connection.commit();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
                //close connection       
            }

        }
    }

}
