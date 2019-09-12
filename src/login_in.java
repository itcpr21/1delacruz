
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class login_in {
    
    String name ="";
    public int log(String uname, String pword){
        int z = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/delacruzm?","root","");
            String sql = "select * from register where username=? and password=md5(?);";
            PreparedStatement pre = con.prepareStatement(sql);
            
            pre.setString(1, uname);
            pre.setString(2, pword);
            
            ResultSet rs = pre.executeQuery();
            if(rs.next())
            {name =rs.getString("firstname")+" "+rs.getString("lastname");
                z=1;
            }else{
                z=0;
            }     
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login_in.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login_in.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return z;
    }
}
