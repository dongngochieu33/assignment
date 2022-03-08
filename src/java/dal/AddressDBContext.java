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

/**
 *
 * @author ADMIN
 */
public class AddressDBContext extends DBContext{
     public ArrayList<Address> getAllAddress(){
        ArrayList<Address> addresss = new ArrayList<>();
        try {
            
            String sql = "SELECT id,Xom FROM dbo.Address";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Address d = new Address();
                d.setId(rs.getInt(1));
                d.setXom(rs.getString(2));
                addresss.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addresss;
    }
}
