/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class Dbconnect {
      public static Connection con;
    public static Statement st;
    public static PreparedStatement insertClient,getClients,updateClient;
    static{
        try{
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            c=DriverManager.getConnection(
//            "jdbc:oracle:thin:@localhost:1521:xe","clientsoldb4","clientsoldb4");
Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","clientsoldb","clientsoldb");    st=con.createStatement();
    insertClient=con.prepareStatement(
  "insert into client_info (name,gender,dob,country,address,language) values(?,?,?,?,?,?)");
    getClients=con.prepareStatement(
       "select * from client_info where name like ?");
    updateClient=con.prepareStatement(
 "update client_info set name=?,gender=?,dob=?,country=?,address=?,language=? where cid=?");
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
    }
}
