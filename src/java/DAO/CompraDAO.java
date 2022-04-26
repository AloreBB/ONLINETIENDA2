/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Carrito;
import beans.Compra;
import conexionBD.ConexBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alore
 */
public class CompraDAO {
    
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado = 0;
        
    public int GenerarCompra(Compra compra){
        String sql = "insert into compras(idCliente, idPago, FechaCompras, Monto, Estado) values (?,?,?,?,?)";
        try {
            int idCompras;
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            ps.setInt(1, compra.getCliente().getId());
            ps.setInt(2, compra.getIdpago());
            ps.setString(3, compra.getFecha());
            ps.setDouble(4, compra.getMonto());
            ps.setString(5, compra.getEstado());
            
            resultado = ps.executeUpdate();
            
            sql = "Select @@IDENTITY AS idCompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idCompras = rs.getInt("idCompras");
            rs.close();
            
            for (Carrito detalle : compra.getDetallecompras()) {
                sql = "insert info detalle_compras(idProducto, idCompras, Cantidad, PrecioCompra) values(?,?,?,?)";
                ps = cnx.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());
                ps.setInt(2, idCompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                resultado = ps.executeUpdate();
                
            }
        } catch (Exception e) {
        }
        
        return resultado;
    }
}
