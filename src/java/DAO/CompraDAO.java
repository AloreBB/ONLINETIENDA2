
package DAO;

import beans.Carrito;
import beans.Compra;
import conexionBD.ConexBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {
    
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
        
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
            
            ps.executeUpdate();
            
            sql = "Select @@IDENTITY AS idCompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idCompras = rs.getInt("idCompras");
            rs.close();
            
            for (Carrito detalle : compra.getDetallecompras()) {
                sql = "insert into detalle_compras(idProducto, idCompras, Cantidad, PrecioCompra) values(?,?,?,?)";
                ps = cnx.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());
                ps.setInt(2, idCompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                r = ps.executeUpdate();
                
            }
        } catch (Exception e) {
        }
        
        return r;
    }
}
