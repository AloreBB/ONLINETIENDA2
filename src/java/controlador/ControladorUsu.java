/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAO;
import DAO.RegistroDAOP;
import beans.Carrito;
import beans.RegistroBeans;
import beans.RegistroBeansP;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aprendiz
 */
@WebServlet(name = "ControladorUsu", urlPatterns = {"/ControladorUsu"})
public class ControladorUsu extends HttpServlet {
    RegistroDAO miRDAO = new RegistroDAO();
    
    RegistroDAOP rDAOP = new RegistroDAOP();
    
    RegistroBeans miRB = new RegistroBeans();
    
    RegistroBeansP beansP = new RegistroBeansP();
    
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad=1;
    
    List<RegistroBeansP> productos = new ArrayList<>();
    int idUsr;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("action");
        productos = rDAOP.listar();
        
        if (op.equals("Ppal")) {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        
        if (op.equals("Usuario")) {
        switch(opc) {
                
            case "home":
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "carga":
                idUsr = Integer.parseInt(request.getParameter("id"));
                miRB = miRDAO.cargar(idUsr);
                request.setAttribute("usuario", miRB);
                request.getRequestDispatcher("usuariosPpal.jsp").forward(request, response);
                break;

            case "modificar":

                String nom2 = request.getParameter("txtNombres");
                String cont2 = request.getParameter("txtContacto");
                String correo2 = request.getParameter("txtCorreo");
                String pass2 = request.getParameter("txtPassword");

                miRB.setNombres(nom2);
                miRB.setContacto(cont2);
                miRB.setEmail(correo2);
                miRB.setPass(pass2);

                miRB.setId(idUsr);
                miRDAO.modificar(miRB);
                request.setAttribute("Usu", miRB);
                request.getRequestDispatcher("usuariosPpal.jsp").forward(request, response);

                break;

            case "AgregarCarrito":
                /*
                int idP = Integer.parseInt(request.getParameter("id"));
                beansP = rDAOP.listarId(idP);
                item=+1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setIdProducto(beansP.getId());
                car.setNombres(beansP.getNombre());
                car.setDescripcion(beansP.getDescripcion());
                car.setPrecioCompra(beansP.getCosto());
                car.setCantidad(beansP.getCantidad());
                car.setSubTotal(cantidad*beansP.getCosto());
                listaCarrito.add(car);
                
                request.setAttribute("contador", listaCarrito.size());
                */
                request.getRequestDispatcher("exito.jsp").forward(request, response);


                //rDAOP.insertarP(RES);
                //rDAOP.insertarP(r);

                break;


            default:
                /*
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                */
                throw new AssertionError();
                
            }
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
            Logger.getLogger(ControladorUsu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorUsu.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorUsu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorUsu.class.getName()).log(Level.SEVERE, null, ex);
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
