package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.GestorBD;
import java.util.Collection;
import java.util.ArrayList;
import Model.Dispositivo;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" pageEncoding=\"EUC-KR\">\n");
      out.write("\n");
      out.write("    <title>Index Page</title>\n");
      out.write("    <!-- Google font -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,500,700\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/bootstrap.min.css\"/>\n");
      out.write("\n");
      out.write("    <!-- Font Awesome Icon -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1> CRUD - Dispositivos</h1>\n");
      out.write("            <a class=\"btn btn-success\" href=\"");
      out.print(request.getContextPath());
      out.write("/newDevice.jsp\"> Agregar</a>\n");
      out.write("                <br> <br>\n");
      out.write("                 ");

                Collection<Dispositivo> dispositivo = new ArrayList<>();
                GestorBD gestor = new GestorBD();
                Collection<Dispositivo> disp = null;
                
      out.write("\n");
      out.write("                <table>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                         \n");
      out.write("                        <div class=\"col-md-4\"> \n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtBuscar\" placeholder=\"Buscar...\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-1\" align=\"center\"> \n");
      out.write("                            <input type=\"submit\" class=\"form-control\" value=\"buscar\"/>\n");
      out.write("                        </div>\n");
      out.write("                </div>\n");
      out.write("            </table>\n");
      out.write("            <br>\n");
      out.write("             ");

                String aux = request.getParameter("txtBuscar");
                dispositivo = gestor.getDevs(aux);
                if (aux != null) {
                    disp = dispositivo;
                } else {
                    disp = dispositivo;
                }
            
      out.write("\n");
      out.write("          <!--  <p> Número de disp registrados: <b> ");
      out.print( disp.size());
      out.write(" </b></p> -->\n");
      out.write("            <div class=\"table-responsive\"> \n");
      out.write("                <table  cellpadding=\"5\" class=\"table table-striped table-hover \">\n");
      out.write("                    <tr>\n");
      out.write("                        <td> ID </td>\n");
      out.write("                        <td> Nombre</td>\n");
      out.write("                        <td> Descripcion</td>\n");
      out.write("                        <td> Modelo </td>\n");
      out.write("                        <td> Marca </td>\n");
      out.write("                        <td> Precio </td>\n");
      out.write("                        <td> Color</td>\n");
      out.write("                        <td colspan=\"2\" align=\"center\"> Acciones</td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                     ");

                        if (disp.size() == 0) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"9\" align=\"center\"> Por el momento no hay dispositivos registrados.</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                    } else {
                        for (Dispositivo d : disp) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(d.getId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(d.getNombre());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(d.getDescripcion());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(d.getModelo());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(d.getMarca());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(d.getPrecio());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(d.getColor());
      out.write("</td>\n");
      out.write("                        <td><a href=\"editDevice.jsp?id=");
      out.print( d.getId());
      out.write("\"> Modificar </a></td>\n");
      out.write("                        <td><a href=\"deleteDev?id=");
      out.print( d.getId());
      out.write("\"> Eliminar</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
                        }
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("                  ");
 disp.clear();
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
