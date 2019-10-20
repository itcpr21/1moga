
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
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
public class product_class {
   connection_class con = new  connection_class();
   
  public int addpro(String prod_name, int prod_quantity, Float prod_price){
     int x = 0;
     try{
         Class.forName(con.forname);
         Connection cnn = (Connection) DriverManager.getConnection(con.drive, con.usern, con.rpass);
         PreparedStatement pr = (PreparedStatement) cnn.prepareStatement("Insert into tblproduct values (null,?,?,?)");
         pr.setString(1, prod_name);
         pr.setInt(2, prod_quantity);
         pr.setObject(3,prod_price);
         x = pr.executeUpdate();
         
         
     } catch (ClassNotFoundException ex) {   
           Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
       }
return x;   
    }
public void deleteproduct(int id){

    try{
        Class.forName(con.forname);
        Connection ccon = (Connection) DriverManager.getConnection(con.drive,con.usern,con.rpass);
        PreparedStatement prep = (PreparedStatement) ccon.prepareStatement("delete from tblproduct where id = ?");
        prep.setInt(1, id);
        prep.executeUpdate();
        
    }  catch (ClassNotFoundException ex) {
           Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
       }
    }


public void edit(int id , String product, float price){
       try {
           Class.forName(con.forname);
           Connection ccon = (Connection) DriverManager.getConnection(con.drive,con.usern,con.rpass);
        PreparedStatement prep = (PreparedStatement) ccon.prepareStatement("update tblproduct set product ? , price = ? where id = ?");
        prep.setString(1, product);
        prep.setFloat(2, price);
        prep.setInt(3, id);
        prep.executeUpdate();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(product_class.class.getName()).log(Level.SEVERE, null, ex);
       }
{
    
}
}


}
