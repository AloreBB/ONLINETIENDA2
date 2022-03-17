package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.RegistroBeansP;
import java.util.ListIterator;
import DAO.RegistroDAOP;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/commons/cdn.jsp");
    _jspx_dependants.add("/commons/cabecera.jsp");
    _jspx_dependants.add("/commons/pie.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/global.css\" type=\"text/css\">\n");
      out.write("        <title>Tienda</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<nav class=\"navbar navbar-expand-md bg-dark navbar-dark\">\n");
      out.write("  <!-- Brand -->\n");
      out.write("  <a class=\"navbar-brand\" href=\"index.jsp\">D compras bb</a>\n");
      out.write("\n");
      out.write("  <!-- Toggler/collapsibe Button -->\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("\n");
      out.write("  <!-- Navbar links -->\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n");
      out.write("    <ul class=\"navbar-nav\">\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"\">Inicio</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Acerca</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Contactos</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"registro.jsp\">Registro</a>\n");
      out.write("      </li>\n");
      out.write("       <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"logueo.jsp\">Login <i class=\"bi bi-person-fill\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-person-fill\" viewBox=\"0 0 16 16\">\n");
      out.write("  <path d=\"M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z\"/>\n");
      out.write("</svg></i></a>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  <a href=\"carrito.jsp\" aria-label=\"\" class=\"nav-a nav-a-2 nav-progressive-attribute\" id=\"nav-cart\">\n");
      out.write("    <div id=\"nav-cart-count-container\">\n");
      out.write("      <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"50\" height=\"50\" fill=\"white\" class=\"bi bi-cart3\" viewBox=\"0 0 16 16\">\n");
      out.write("    <path d=\"M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z\"/>\n");
      out.write("    </svg>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"nav-cart-text-container\" class=\" nav-progressive-attribute\">\n");
      out.write("      <span aria-hidden=\"true\" class=\"nav-line-1\">\n");
      out.write("        \n");
      out.write("      </span>\n");
      out.write("      <span aria-hidden=\"true\" class=\"nav-line-2\">\n");
      out.write("          <b style=\"color: white\">Carrito</b>\n");
      out.write("        <span class=\"nav-icon nav-arrow\"></span>\n");
      out.write("      </span>\n");
      out.write("    </div>\n");
      out.write("  </a>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("</nav>");
      out.write("\n");
      out.write("        \n");
      out.write("        <!--\n");
      out.write("        <div class=\"col-sm-3 sidebar-col\">\n");
      out.write("            <//%@include file=\"commons/Sidebar.jsp\" %>\n");
      out.write("        </div>\n");
      out.write("        -->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");

                    List lista = new RegistroDAOP().getAll();
                    ListIterator list = lista.listIterator();
                    
                    while(list.hasNext())
                            {
                                RegistroBeansP recorreg = (RegistroBeansP)list.next();
                            
                    //RegistroBeansP RES = (RegistroBeansP) list.next();

                
      out.write("\n");
      out.write("                <div class=\"col-sm-4\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <label>");
      out.print( recorreg.getNombre());
      out.write("</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <i>$.");
      out.print( recorreg.getCosto());
      out.write("</i>\n");
      out.write("                            <img src=\"ControladorIMG?id=");
      out.print( recorreg.getId());
      out.write("\" width=\"200\" height=\"180\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-footer text center\">\n");
      out.write("                            <label>");
      out.print( recorreg.getDescripcion());
      out.write("</label>\n");
      out.write("                            <div>\n");
      out.write("                                <a href=\"\" class=\"btn-outline-info\">Agregar Carrito</a>\n");
      out.write("                                <a href=\"\" class=\"btn btn-danger\"></a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                    </div>\n");
      out.write("                            ");

                                }
                                
      out.write("\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <script src=\"./tienda.js\"></script>\n");
      out.write("    </body>\n");
      out.write("    ");
      out.write("\n");
      out.write("<footer class=\"footer\" >\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-4\">Derechos Reservado</div>\n");
      out.write("        <div class=\"col-sm-6\">Kevin Jovy</div>\n");
      out.write("        <div class=\"col-sm-2\">Página de compras</div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("    \n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
