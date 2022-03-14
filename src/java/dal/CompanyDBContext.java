/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

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
import model.OrderHistory;
import model.SaleHistory;

/**
 *
 * @author ADMIN
 */
public class CompanyDBContext extends DBContext {

    public ArrayList<CompanysOwe> getAllCompanyOwe() {
        ArrayList<CompanysOwe> owns = new ArrayList<>();
        try {

            String sql = "WITH a as (SELECT OrderHistory.id,companyName,SUM(cost * quantity ) - AVG(paid) AS 'tienno',OrderHistory.companyId AS 'idc' FROM dbo.OrderDetail JOIN dbo.OrderHistory\n"
                    + "ON OrderHistory.id = OrderDetail.orderId\n"
                    + "JOIN dbo.Product ON Product.id = OrderDetail.productId\n"
                    + "JOIN dbo.Company ON Company.id = OrderHistory.companyId\n"
                    + "GROUP BY OrderHistory.id,companyName,OrderHistory.companyId \n"
                    + "HAVING SUM(cost * quantity ) - AVG(paid) > 0\n"
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
}
