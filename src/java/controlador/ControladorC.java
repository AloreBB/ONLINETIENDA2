/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAOCat;
import beans.RegistroBeansCat;

import beans.RegistroBeansP;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author patricia
 */
@WebServlet(name = "ControladorC", urlPatterns = {"/ControladorC"})
public class ControladorC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    RegistroBeansCat miRegisBCat = new RegistroBeansCat();
    RegistroDAOCat miRegisDCat = new RegistroDAOCat();
    int idCat;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("action");

        if (op.equals("Ppal")) {
            request.getRequestDispatcher("productos_cat.jsp").forward(request, response);

        }
        if (op.equals("Categoria")) {
            switch (opc) {

                case "mostrar":
                    request.getRequestDispatcher("productos_cat.jsp").forward(request, response);
                    break;
                    
                case "insertar":

                    //idPro = Integer.parseInt(request.getParameter("id"));
                    String nombreC = request.getParameter("txtNombreCat");

                    miRegisBCat.setNombre(nombreC);
                    

                    miRegisDCat.insertarCat(miRegisBCat);

                    request.getRequestDispatcher("productos_cat.jsp").forward(request, response);
                    break;
                    
                default:
                    throw new AssertionError();
    
                case "eliminar":
                    
                    idCat = Integer.parseInt(request.getParameter("id"));

                    miRegisDCat.eliminarCat(idCat);  
                    request.getRequestDispatcher("productos_cat.jsp").forward(request, response);
                    break;

                case "cargar":
                    idCat = Integer.parseInt(request.getParameter("id"));
                    RegistroBeansCat miRegisBCat_P = miRegisDCat.cargar(idCat);
                    request.setAttribute("Categoria", miRegisBCat_P);
                    request.getRequestDispatcher("productos_cat.jsp").forward(request, response);
                    break;


                case "modificar":

                    //idPro = Integer.parseInt(request.getParameter("id"));
                    String nombreCat = request.getParameter("txtNombreCat");

                    miRegisBCat.setNombre(nombreCat);
                    miRegisBCat.setId(idCat);

                    miRegisDCat.modificar(miRegisBCat);

                    request.getRequestDispatcher("productos_cat.jsp").forward(request, response);

                    break;
                    
                
                

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
        processRequest(request, response);
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
        processRequest(request, response);
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
