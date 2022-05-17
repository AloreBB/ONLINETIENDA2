/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAO;
import beans.RegistroBeans;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aprendiz
 */
//@WebServlet(name = "ValidarLogueo", urlPatterns = {"/ValidarLogueo"})
public class ValidarLogueo extends HttpServlet {
    
    RegistroBeans miRegis = new RegistroBeans();
    RegistroDAO miRegisDAO = new RegistroDAO();

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
        String acc = request.getParameter("accion");
        String op = request.getParameter("menu");
        //evento cuando presiona boton ingresar
        if (acc.equals("Ingresar")) {
            
            // recibe los parametros de usuario y passwors
            String usr = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            
            
                // Enviar parametros a Registro para validar con RegistoDAO
            miRegis = miRegisDAO.validar(usr, pass);
            
            
            if(miRegis.getNombres() != null){
                
                //request.getRequestDispatcher("ControladorAdmin?menu=Ppal").forward(request, response);
                
                //request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                if(miRegis.getRol().equals("admin")) {
                   //response.sendRedirect("admin.jsp");
                   request.getSession().setAttribute("admin", miRegis);
                   request.getRequestDispatcher("ControladorAdmin?menu=Ppal").forward(request, response);
                }
                else if (miRegis.getRol().equals("usuario"))
                {
                    //response.sendRedirect("usuarios.jsp");
                    //RegistroBeans o = new RegistroBeans();
                    request.getSession().setAttribute("Usu", miRegis);
                    request.getRequestDispatcher("ControladorUsu?menu=Ppal").forward(request, response);
                }
                else {
                    request.getRequestDispatcher("fallido.jsp").forward(request, response);
                }
                
            }
            else 
                {
                request.getRequestDispatcher("logueo.jsp").forward(request, response);
            }
            
        }
        // Cuando presione logout cerrara sesion por ende el bean se reinicia
        else if (acc.equals("Salir"))
        {
            miRegis = new RegistroBeans("", "", "", "", 0);
            request.getSession().setAttribute("Usu", miRegis);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
