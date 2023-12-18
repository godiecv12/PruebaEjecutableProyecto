/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author ChaconReyes
 */
public class Conexion {
    Connection con;
    public Conexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?autoReconnect=true&useSSL=false","root", "dD04070407");
        }catch(Exception e){
            System.err.println("Error"+e);
         }
}
  public static void main(String[] args) {
        // TODO code application logic here
        Conexion cn= new Conexion();
        Statement st;
        ResultSet rs;
        try{
        st=cn.con.createStatement();
        rs=st.executeQuery("select * from contactos");
        while(rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getString("nombre"));
         }   
    }catch(Exception e){
         }
         }
}
