/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAOP;
import beans.Carrito;
import beans.RegistroBeansP;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.Location;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alore
 */
public class ControladorCar extends HttpServlet {
    RegistroBeansP beansP = new RegistroBeansP();
    RegistroDAOP rDAOP = new RegistroDAOP();
    List<Carrito> listaCarrito = new ArrayList<>();
    
    List<RegistroBeansP> productos = new ArrayList<>();
    int idUsr;
    
    int item;
    double totalPagar = 0.0;
    int cantidad=1;
    
    int idP =0;
    Carrito car;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String action = request.getParameter("action");
        productos = rDAOP.listar();
        
        switch(action){
            
            case "Comprar":
                totalPagar = 0.0;
                int idP = Integer.parseInt(request.getParameter("id"));
                beansP = rDAOP.listarId(idP);
                item=+1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setIdProducto(beansP.getId());
                car.setNombres(beansP.getNombre());
                car.setDescripcion(beansP.getDescripcion());
                car.setPrecioCompra(beansP.getCosto());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*beansP.getCosto());
                listaCarrito.add(car);
                
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar +listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                
                break;
            
            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idP = Integer.parseInt(request.getParameter("id"));
                beansP = rDAOP.listarId(idP);
                if (listaCarrito.size()>0) {
                    
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idP == listaCarrito.get(i).getIdProducto()) {
                            pos=i;
                        }
                    }
                    // Dentro de este if se hace la suma del total en productos agregados. Siendo el mismo producto
                    if (idP == listaCarrito.get(pos).getIdProducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad()+cantidad;
                        double subTotal = listaCarrito.get(pos).getPrecioCompra()*cantidad; 
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subTotal);
                    }
                    else{
                        item = item +1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(beansP.getId());
                        car.setNombres(beansP.getNombre());
                        car.setDescripcion(beansP.getDescripcion());
                        car.setPrecioCompra(beansP.getCosto());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*beansP.getCosto());
                        listaCarrito.add(car);
                    }
                
                }
                else {
                    item+=1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(beansP.getId());
                    car.setNombres(beansP.getNombre());
                    car.setDescripcion(beansP.getDescripcion());
                    car.setPrecioCompra(beansP.getCosto());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad*beansP.getCosto());
                    listaCarrito.add(car);
                }
                
                
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
                break;
                
            case "Carrito":
                totalPagar=0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar +listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
                
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto()==idproducto) {
                        listaCarrito.remove(i);
                    }
                }
                // volvemos a cargar la lista de productos
                
                break;
                
            case "ActualizarCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdProducto() == idpro) {
                        listaCarrito.get(i).setCantidad(cant);
                        double st = listaCarrito.get(i).getPrecioCompra()*cant;
                        listaCarrito.get(i).setSubTotal(st);
                    }
                }
                
                break;
                
            default:
                    
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
