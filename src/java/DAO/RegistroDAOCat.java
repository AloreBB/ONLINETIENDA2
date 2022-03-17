/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexionBD.ConexBD;
import beans.RegistroBeans;
import beans.RegistroBeansCat;

import beans.RegistroBeansP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SENA-WS-H50-1
 */
public class RegistroDAOCat {

    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    //======================================Insertar Producto=========================================================
    public int insertarCat(RegistroBeansCat r) {

        String sql = "insert into categoria(nombre)"
                + "value(?)";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            //ps.setInt(1, r.getId());
            ps.setString(1, r.getNombre());
            //ps.setInt(3, r.getEstado());
            
            ps.executeUpdate();

        } catch (SQLException ex) { 
            Logger.getLogger(RegistroDAOCat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    } 
     //======================================listar Producto=========================================================
    
    public List getAll() throws SQLException, ClassNotFoundException{
        
            String sql = "select * from categoria";
            List<RegistroBeansCat> lista = new ArrayList<>();
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            RegistroBeansCat RES = new RegistroBeansCat();
            
            RES.setId(rs.getInt("id"));
            RES.setNombre(rs.getString("nombre"));
            RES.setEstado(rs.getInt("estado"));
            
            lista.add(RES);
    }  
        return lista;
    
    }
    public boolean eliminarCat(int id){
           String sql="delete from categoria where id=" + id;
               
           try {
            cnx = con.ConexBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(RegistroDAOCat.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    public RegistroBeansCat cargar(int id){
    RegistroBeansCat miregisB_c = new RegistroBeansCat();
    String sql = "select * from categoria where id=" + id;
    
        try {
            cnx=con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                miregisB_c.setId(rs.getInt(1));
                miregisB_c.setNombre(rs.getString(2));
                miregisB_c.setEstado(rs.getInt(3));        
            }
        } catch (SQLException ex) {
             System.err.println(ex);
            Logger.getLogger(RegistroDAOCat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miregisB_c;
    
    }
    
    
   public int modificar(RegistroBeansCat r) {

       String sql = "update categoria set nombre = ?" + "where id = ?";
       //String sql = "insert into productos(nombre,costo,cantidad,categoria)"
               // + "value(?,?,?,?)";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            
            ps.setString(1, r.getNombre());
            ps.setInt(2, r.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
             System.err.println(ex);
            Logger.getLogger(RegistroDAOCat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    } 
 
    } 
    
    
    
    
    
        

     
