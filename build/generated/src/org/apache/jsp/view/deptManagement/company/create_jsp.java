package org.apache.jsp.view.deptManagement.company;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.CompanysOwe;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <link href=\"../../../css/loginCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../../../js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"body-home\">\n");
      out.write("        <div class=\"contain-flex\"> \n");
      out.write("            <div class=\"item-right\">\n");
      out.write("                <a class=\"item-flex\" href=\"../dept/company\" \">Home</a>      \n");
      out.write("            </div>\n");
      out.write("            <div class=\"item-right\">\n");
      out.write("                <a class=\"item-flex\" href=\"#\" onclick=\"logout()\">Log out</a>      \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"h1-container\"><h1 class=\"h1-content\">Danh sách đối tác đang thiếu nợ</h1></div>\n");
      out.write("        \n");
      out.write("            <div>\n");
      out.write("                <div id=\"mySidebar\" class=\"sidebar\">\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">×</a>\n");
      out.write("                    <a href=\"home\">Khách hàng</a>\n");
      out.write("                    <a href=\"../dept/company\">Đối tác</a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"main\">\n");
      out.write("                    <button class=\"openbtn\" onclick=\"openNav()\">☰ Tùy Chọn</button>  \n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("                <div class=\"table-owe\">\n");
      out.write("                    <table border=\"1\" >\n");
      out.write("                        <div>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Công ty</th>\n");
      out.write("                                <th>Tiền chưa thanh toán</th>\n");
      out.write("                                <th></th>\n");
      out.write("                                <th></th>\n");
      out.write("                            </tr>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        \n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("\n");
      out.write("           \n");
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
