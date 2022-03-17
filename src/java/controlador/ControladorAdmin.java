/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAO;
import beans.RegistroBeans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aprendiz
 */
@WebServlet(name = "ControladorAdmin", urlPatterns = {"/ControladorAdmin"})
public class ControladorAdmin extends HttpServlet {
    RegistroDAO miRDAO = new RegistroDAO();
    RegistroBeans miRB = new RegistroBeans();
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
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("action");
        
        if (op.equals("Ppal")) {
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        }
        
        if (op.equals("Admin")) {
            switch(opc) {
                case "eliminar":
                    idUsr = Integer.parseInt(request.getParameter("id"));
                    miRDAO.eliminar(idUsr);
                    request.getRequestDispatcher("adminPpal.jsp").forward(request, response);
                    break;
                
                case "insertar":
                    
                    // cpy yu paste del RegistroControl para agreagar un registro
                    
                    if (request.getParameter("txtNombres").toString().length()>0 && request.getParameter("txtContacto").toString().length()>0 
                    && request.getParameter("txtCorreo").toString().length()>0 && request.getParameter("txtPassword").toString().length()>0) 
                    {

                    String nom = request.getParameter("txtNombres");
                    String cont = request.getParameter("txtContacto");
                    String email = request.getParameter("txtCorreo");
                    String pass = request.getParameter("txtPassword");

                    miRB.setNombres(nom);
                    miRB.setContacto(cont);
                    miRB.setEmail(email);
                    miRB.setPass(pass);

                    miRDAO.insertar(miRB);

                    response.sendRedirect("adminPpal.jsp");
                    break;
                }
                else{
                        response.sendRedirect("fallido.jsp");
                        break;
                    }
                    
                case "carga":
                    idUsr = Integer.parseInt(request.getParameter("id"));
                    miRB = miRDAO.cargar(idUsr);
                    request.setAttribute("usuario", miRB);
                    request.getRequestDispatcher("adminPpal.jsp").forward(request, response);
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
                    
                    request.getRequestDispatcher("adminPpal.jsp").forward(request, response);
                    
                    break;
                    
                    
                default:
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
