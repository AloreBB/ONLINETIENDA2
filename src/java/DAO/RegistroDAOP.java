/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Carrito;
import conexionBD.ConexBD;


import beans.RegistroBeansP;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SENA-WS-H50-1
 */
public class RegistroDAOP {

    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado = 0;

    //======================================Insertar Producto=========================================================
    public int insertarP(RegistroBeansP r) {

        String sql = "insert into productos(nombre,foto,costo,cantidad,descripcion,id_categoria)"
               + "values(?,?,?,?,?,?)";
              
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            //ps.setInt(6, r.getId());
            ps.setString(1, r.getNombre());
            ps.setBlob(2, r.getFoto());
            ps.setFloat(3, r.getCosto());
            ps.setInt(4, r.getCantidad());
            ps.setString(5, r.getDescripcion());
            ps.setInt(6, r.getId_categoria());
            
            

            ps.executeUpdate();

        } catch (SQLException ex) { 
            Logger.getLogger(RegistroDAOP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    } 
    
    
    public int insertarPCarrito(RegistroBeansP r) {

        String sql = "insert into carrito(nombre,costo,id_categoria)"
               + "values(?,?,?)";
              
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            //ps.setInt(6, r.getId());
            ps.setString(1, r.getNombre());
            ps.setFloat(2, r.getCosto());
            ps.setInt(3, r.getCategoria());
            
            

            ps.executeUpdate();

        } catch (SQLException ex) { 
            Logger.getLogger(RegistroDAOP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
     //======================================listar Producto=========================================================
    
    public List getAll() throws SQLException, ClassNotFoundException{
        
            String sql = "select * from productos";
            List<RegistroBeansP> lista = new ArrayList<>();
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            RegistroBeansP RES = new RegistroBeansP();
            
            RES.setId(rs.getInt("id"));
            RES.setNombre(rs.getString("nombre"));
            //RES.setFoto(rs.getBinaryStream("foto"));
            RES.setCosto(rs.getFloat(4));
            RES.setCantidad(rs.getInt("cantidad"));
            RES.setDescripcion(rs.getString("descripcion"));
            RES.setEstado(rs.getInt("estado"));
            RES.setCategoria(rs.getInt("id_categoria"));
            lista.add(RES);
    }  
        return lista;
    
    }
    
    
    
    public RegistroBeansP listarId(int id){
        String sql = "select * from productos where id ="+id;
        RegistroBeansP p = new RegistroBeansP();
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setCosto(rs.getFloat(4));
                p.setCantidad(rs.getInt(5));
                p.setDescripcion(rs.getString(6));
                p.setEstado(rs.getInt(7));
                p.setId_categoria(rs.getInt(8));
                
                
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    //======================================listar Producto=========================================================
    
    
    public List listar() throws SQLException, ClassNotFoundException{
        
            String sql = "select * from productos";
            List<RegistroBeansP> lista = new ArrayList<>();
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            try {
                while(rs.next()){
                RegistroBeansP RES = new RegistroBeansP();

                RES.setId(rs.getInt("id"));
                RES.setNombre(rs.getString("nombre"));
                RES.setFoto(rs.getBinaryStream("foto"));
                RES.setCosto(rs.getFloat("costo"));
                RES.setCantidad(rs.getInt("cantidad"));
                RES.setDescripcion(rs.getString("descripcion"));
                RES.setEstado(rs.getInt("estado"));
                RES.setCategoria(rs.getInt("id_categoria"));
                lista.add(RES);
            }
        } catch (Exception e) {
        }
              
        return lista;
    
    }
    
    
    public void listarImg(int id, HttpServletResponse response){
        String sql = "select * from productos where id="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        
        try {
            outputStream = response.getOutputStream();
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read())!= -1) {                
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
    
    
    public boolean eliminar(int id){
               String sql="delete from productos where id =" + id;
               
           try {
            cnx = con.ConexBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(RegistroDAOP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public RegistroBeansP cargar(int id){
    RegistroBeansP miregisB_p = new RegistroBeansP();
    String sql = "select * from productos where id=" + id;
    
        try {
            cnx=con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                miregisB_p.setId(rs.getInt(1));
                miregisB_p.setNombre(rs.getString(2));
                miregisB_p.setCosto(rs.getFloat(4));
                miregisB_p.setCantidad(rs.getInt(5));
                miregisB_p.setDescripcion(rs.getString(6));
                miregisB_p.setEstado(rs.getInt(7));
                miregisB_p.setCategoria(rs.getInt(8));
                
            }
        } catch (SQLException ex) {
             System.err.println(ex);
            Logger.getLogger(RegistroDAOP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miregisB_p;
    
    }
    
    
   public int modificar(RegistroBeansP r) {

       String sql = "update productos set nombre = ?, costo = ?, cantidad = ?, descripcion = ?, id_categoria = ?" 
               + " where id = ?";
       //String sql = "insert into productos(nombre,costo,cantidad,id_categoria)"
               // + "value(?,?,?,?)";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            
            ps.setString(1, r.getNombre());
            ps.setFloat(2, r.getCosto());
            ps.setInt(3, r.getCantidad());
            ps.setString(4, r.getDescripcion());
            ps.setInt(5, r.getId_categoria());
            
            ps.setInt(6, r.getId());

            ps.executeUpdate();

        } catch (Exception ex) {
             System.err.println(ex);
            Logger.getLogger(RegistroDAOP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    } 
 
    } 
    
    
    
    
    
        

     
