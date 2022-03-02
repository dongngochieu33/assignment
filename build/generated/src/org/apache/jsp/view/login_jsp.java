package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../css/loginCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    <div class=\"contain-flex\">      \n");
      out.write("        <div class=\"item-right\">\n");
      out.write("            <a class=\"item-flex\" href=\"#\" onclick=\"login()\">Log in</a>      \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"form-container\" id=\"form-container\">\n");
      out.write("        <form action=\"\" class=\"form\">\n");
      out.write("            <div class=\"form-row-center\">\n");
      out.write("               <h1 class=\"Web-name\">Debt Management</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <label for=\"username\" class=\"form-label\">Username</label>\n");
      out.write("                <input type=\"text\" class=\"form-input\" name=\"username\" id=\"username\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <label for=\"password\" class=\"form-label\">Password</label>\n");
      out.write("                <input type=\"password\" class=\"form-input\" name=\"password\" id=\"password\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <input type=\"submit\" value=\"Login\" class=\"login\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
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
