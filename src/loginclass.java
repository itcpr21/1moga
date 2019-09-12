
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
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
public class loginclass {
    String forname = "com.mysql.jdbc.Driver";
    String drive = "jdbc:mysql://localhost/myrah";
    String runame = "root";
    String rpass ="";
    String name ="";
    
    public int enter(String username, String password){ int x=0;
        try {
            Class.forName(forname);
            Connection con = (Connection) DriverManager.getConnection(drive,runame,rpass);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("Select * from tbluser user where user =? and pass =md5(?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                x=1;
                name = rs.getString("fname")+" "+rs.getString("lname");
            }else{
                x=-1;
            }
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginclass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginclass.class.getName()).log(Level.SEVERE, null, ex);
        }return x;
    }
    
    
    
}
