/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.RegistroBeans;
import conexionBD.ConexBD;
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
 * @author Aprendiz
 */
public class RegistroDAO {
    ConexBD cn = new ConexBD();
    Connection cnx;
    //prepara la setencia sql
    PreparedStatement ps;
    //ejecuta la sentencia
    ResultSet rs;
    int v = 0;
    
    // metodo para modificar
    public int modificar (RegistroBeans r){
        
        String sql = "update registro set nombres = ?, contacto = ?, correo = ?" + "where id = ?";
        try{
            cnx = cn.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            ps.setString(1, r.getNombres());
            ps.setString(2, r.getContacto());
            ps.setString(3, r.getEmail());
            //ps.setString(4, r.getPass());
            
            ps.setInt(4, r.getId());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return v;
        
    }
    
    public RegistroBeans cargar(int id){
        RegistroBeans miRB = new RegistroBeans();
        String sql = "select * from registro where id =" + id;
        
        try {
            //se establece la conexion en la bd
            cnx = cn.ConexBD();
            //prepara sentencia definida sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                miRB.setId(rs.getInt(1));
                miRB.setNombres(rs.getString(2));
                miRB.setContacto(rs.getString(3));
                miRB.setEmail(rs.getString(4));
                miRB.setRol(rs.getString(6));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miRB;
    }
    
    public int insertar(RegistroBeans r){
        //se instancia la clase registro
        
        //se crea la sentencia sql
        String sql= "insert into registro(nombres,contacto,correo,password)"+
                "values(?,?,?,?)";
        
        
        try {
            //se establece la conexion en la bd
            cnx = cn.ConexBD();
            //prepara sentencia definida sql
            ps=cnx.prepareStatement(sql);
            ps.setString(1, r.getNombres());
            ps.setString(2, r.getContacto());
            ps.setString(3, r.getEmail());
            ps.setString(4, r.getPass());
            
            //ejecuta la sentencia sql
            
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            //Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
    
    
    public RegistroBeans validar(String usr, String pass){
        //se instancia la clase registro
        RegistroBeans miRegistro = new RegistroBeans();
        //se crea la sentencia sql
        String sql= "select*from registro where nombres=? and password=?";
        
        try {
            //se establece la conexion en la bd
            cnx =cn.ConexBD();
            //prepara sentencia definida sql
            ps=cnx.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pass);
            //ejecuta la sentencia sql
            rs=ps.executeQuery();
            
            while(rs.next()){
                miRegistro.setId(rs.getInt("id"));
                miRegistro.setNombres(rs.getString("nombres"));
                miRegistro.setContacto(rs.getString("contacto"));
                miRegistro.setEmail(rs.getString("correo"));
                miRegistro.setPass(rs.getString("password"));
                miRegistro.setRol(rs.getString("rol"));
                miRegistro.setEstado(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miRegistro;
    }
    
    public List getAll()
    {
        String sql = "Select * from registro";
        List<RegistroBeans>lista = new ArrayList<>();
        
        try {
            
            cnx = cn.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                RegistroBeans recorreg = new RegistroBeans();
                recorreg.setId(rs.getInt("id"));
                recorreg.setNombres(rs.getString("nombres"));
                recorreg.setContacto(rs.getString("contacto"));
                recorreg.setCorreo(rs.getString("correo")); 
                recorreg.setPass(rs.getString("password"));
                recorreg.setRol(rs.getString("rol"));
                
                lista.add(recorreg);
            }
            } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public List getUsu(int id)
    {
        
        String sql = "Select * from registro where id = " + id;
        List<RegistroBeans>lista = new ArrayList<>();
        
        try {
            
            cnx = cn.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            RegistroBeans recorreg = new RegistroBeans();
            recorreg.setId(rs.getInt("id"));
            recorreg.setNombres(rs.getString("nombres"));
            recorreg.setContacto(rs.getString("contacto"));
            recorreg.setCorreo(rs.getString("correo")); 
            recorreg.setPass(rs.getString("password"));
            recorreg.setRol(rs.getString("rol"));
            
            lista.add(recorreg);
            
        }   catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lista;
    }
    
    // para eliminar un registro
    public boolean eliminar(int id)
    {
        String sql = "delete from registro where id="+id;
        
        try {
            cnx = cn.ConexBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado>0)
            {
                return true;
            }
            
        }   catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //para editar un registro
    public RegistroBeans editar (RegistroBeans miBeans){
        
        String sql = "update registro set nombres = ?, contacto = ?, correo = ?" 
               + " where id = ?";
        
        try {
            cnx = cn.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            ps.setString(1, miBeans.getNombres());
            ps.setString(2, miBeans.getContacto());
            ps.setString(3, miBeans.getCorreo());
            
            ps.setInt(4, miBeans.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return miBeans;
    }
}
