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
public class registerAcc {
        public int regACc(String fname, String lname, String uname, String pword){
            int x =1;
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/delacruzm?", "root", "");
                String sqlquery = "insert into register values(null,?,?,?,md5(?));";
                PreparedStatement prestate = (PreparedStatement) con.prepareStatement(sqlquery);
                prestate.setString(1, fname);
                prestate.setString(2, lname);
                prestate.setString(3, uname);
                prestate.setString(4, pword);
                
                x = prestate.executeUpdate();
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(registerAcc.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(registerAcc.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            return x;
            
        }
}

        



        
