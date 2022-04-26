
package beans;

import java.util.List;

public class Compra {
    private int id;
    private RegistroBeansUsua cliente;
    private int idpago;
    private String fecha;
    private double monto;
    private String estado;
    
    private List<Carrito> detallecompras;

    public Compra() {
    }

    public Compra( RegistroBeansUsua cliente, int idpago, String fecha, double monto, String estado, List<Carrito> detallecompras) {
        this.cliente = cliente;
        this.idpago = idpago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.detallecompras = detallecompras;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(RegistroBeansUsua cliente) {
        this.cliente = cliente;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDetallecompras(List<Carrito> detallecompras) {
        this.detallecompras = detallecompras;
    }

    public int getId() {
        return id;
    }

    public RegistroBeansUsua getCliente() {
        return cliente;
    }

    public int getIdpago() {
        return idpago;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public List<Carrito> getDetallecompras() {
        return detallecompras;
    }
    
    
}
