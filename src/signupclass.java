
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
public class signupclass {
    
      String forname = "com.mysql.jdbc.Driver";
    String drive = "jdbc:mysql://localhost/myrah";
    String runame = "root";
    String rpass ="";
    
    
    public int Register(String fname , String lname, String uname, String pw){ int x=0;
        try {
            Class.forName(forname);
            Connection con = (Connection) DriverManager.getConnection(drive,runame,rpass);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into tbluser values(null,?,?,?,md5(?))");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, uname);
            ps.setString(4, pw);
         x =   ps.executeUpdate();
            
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginclass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginclass.class.getName()).log(Level.SEVERE, null, ex);
        }return x;
    }
    
}
