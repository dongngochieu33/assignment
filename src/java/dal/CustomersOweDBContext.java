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
import model.Customer;
import model.CustomersOwe;
import model.SaleHistory;

/**
 *
 * @author ADMIN
 */
public class CustomersOweDBContext extends DBContext {

    public ArrayList<CustomersOwe> getCustomersOwe(int addressId) {
        ArrayList<CustomersOwe> owns = new ArrayList<>();
        try {

            String sql = "WITH a AS( SELECT* from (SELECT  firstName,lastName, date,customerId, SUM(price * quantity) - AVG(paid) AS 'TienNo',Xom,Address.id FROM dbo.SaleHistory JOIN dbo.SaleDetail\n"
                    + "ON SaleDetail.saleId = SaleHistory.id JOIN dbo.Product\n"
                    + "ON Product.id = SaleDetail.productId JOIN dbo.Customer\n"
                    + "ON Customer.id = SaleHistory.customerId JOIN dbo.Address\n"
                    + "ON Address.id = Customer.addressId\n"
                    + "GROUP BY SaleHistory.id,customerId,firstName,lastName,date,Xom,Address.id) AS A WHERE TienNo > 0\n"
                    + ")\n"
                    + "SELECT a.customerId,a.firstName,a.lastName,sum(a.TienNo) AS 'tongno',id,a.Xom FROM a";

            if (addressId != -1) {
                sql += " WHERE id = ?";
            }
            sql += " GROUP BY a.customerId,a.firstName,a.lastName,a.Xom,a.id\n"
                    + "ORDER BY xom,a.lastName,a.firstName";
            PreparedStatement stm = connection.prepareStatement(sql);
            if(addressId != -1){
                stm.setInt(1, addressId);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CustomersOwe co = new CustomersOwe();
                Customer c = new Customer();
                Address add = new Address();
                c.setCid(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                co.setOwnMoney(rs.getFloat(4));
                add.setId(rs.getInt(5));
                add.setXom(rs.getString(6));
                co.setAdd(add);
                co.setCus(c);
                owns.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersOweDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owns;
    }
}
