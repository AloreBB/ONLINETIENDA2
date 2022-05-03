/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAOP;

import beans.RegistroBeansP;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author 
 */
@MultipartConfig
@WebServlet(name = "ControladorP", urlPatterns = {"/ControladorP"})
public class ControladorP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    RegistroBeansP miRegisB = new RegistroBeansP();
    RegistroDAOP miRegisD = new RegistroDAOP();
    int idPro;
    Part foto;
    InputStream inputStream;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("action");

        if (op.equals("Ppal")) {
            request.getRequestDispatcher("productos.jsp").forward(request, response);

        }   
        if (op.equals("Producto")) {
            switch (opc) {

                case "mostrar":
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                    
                case "insertar":

                    //idPro = Integer.parseInt(request.getParameter("id"));
                    
                    if (request.getParameter("txtNom").length()>0 && request.getParameter("txtCost").length()>0 
                    && request.getParameter("txtCant").length()>0 && request.getParameter("txtDesc").length()>0
                    && request.getParameter("cat").length()>0 && request.getPart("foto").getSize()>0 ) 
                    {
                    
                    String nombre = request.getParameter("txtNom");
                    foto = request.getPart("foto");
                    float costo = Float.parseFloat(request.getParameter("txtCost"));
                    int cantidad = Integer.parseInt(request.getParameter("txtCant"));
                    String desc = request.getParameter("txtDesc");
                    int cat = Integer.parseInt(request.getParameter("cat"));
                    inputStream = foto.getInputStream();
                    
                    miRegisB.setNombre(nombre);
                    miRegisB.setFoto(inputStream);
                    miRegisB.setCosto(costo);
                    miRegisB.setCantidad(cantidad);
                    miRegisB.setDescripcion(desc);
                    miRegisB.setCategoria(cat);

                    miRegisD.insertarP(miRegisB);

                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                    }else{
                        response.sendRedirect("productos.jsp");
                        break;
                    }
                case "eliminar":
                    idPro = Integer.parseInt(request.getParameter("id"));

                    miRegisD.eliminar(idPro);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;

                case "carga":
                    idPro = Integer.parseInt(request.getParameter("id"));
                    RegistroBeansP MiregisB_P = miRegisD.cargar(idPro);
                    request.setAttribute("Producto", MiregisB_P);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;


                case "modificar":
                    
                    //idPro = Integer.parseInt(request.getParameter("id"));
                    String nombre2 = request.getParameter("txtNom");
                    foto = request.getPart("imagen");
                    float costo2 = Float.parseFloat(request.getParameter("txtCost"));
                    int cantidad2 = Integer.parseInt(request.getParameter("txtCant"));
                    String desc2 = request.getParameter("txtDesc");
                    int categoria2 = Integer.parseInt(request.getParameter("categoria"));
                    inputStream = foto.getInputStream();
                    
                    miRegisB.setCosto(costo2);
                    miRegisB.setFoto(inputStream);
                    miRegisB.setCantidad(cantidad2);
                    miRegisB.setDescripcion(desc2);
                    miRegisB.setCategoria(categoria2);
                    miRegisB.setId(idPro);
                    
                    miRegisD.modificar(miRegisB);   
                    
                    request.getRequestDispatcher("productos.jsp").forward(request, response);

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
