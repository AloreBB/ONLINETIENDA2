/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import beans.RegistroBeans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aprendiz
 */
public class ConexBD {
    Connection cnx;
    
    String url="jdbc:mysql://localhost/inventarioj";
    String usr="root";
    String pass="";
    
    public Connection ConexBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection(url, usr, pass);
            //SE CARGA EL DRIVER DE MYSQL
            if(cnx != null) {
                System.out.println("Conexion establecida");
                return cnx;
            }
        }
        catch (SQLException e) {
            System.out.println("Error: "+e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
        
    }
    public static void main(String[] args) throws ClassNotFoundException {
            ConexBD miCone = new ConexBD();
            RegistroBeans rbean =new RegistroBeans();
            miCone.ConexBD();
            System.out.println(rbean.getRol());
    }
}
