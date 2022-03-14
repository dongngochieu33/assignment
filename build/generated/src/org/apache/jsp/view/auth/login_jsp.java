package org.apache.jsp.view.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/loginCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"body-login\">\n");
      out.write("\n");
      out.write("        <div class=\"contain-flex-home\">      \n");
      out.write("            <div class=\"item-right\">\n");
      out.write("                <a class=\"item-flex\" href=\"#\" onclick=\"login()\">Đăng nhập</a>      \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("         <div id=\"slogan\"><h1>Tra Tien Day</h1></div>\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        \n");
      out.write("    <div class=\"form-container\" id=\"form-container\">\n");
      out.write("        <form action=\"login\" method=\"POST\" class=\"form\">\n");
      out.write("            <div class=\"form-row-center\">\n");
      out.write("                <h1 class=\"Web-name\">Quản lý nợ</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <label for=\"username\" class=\"form-label\">Tài khoản</label>\n");
      out.write("                <input type=\"text\" class=\"form-input\" name=\"username\" id=\"username\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <label for=\"password\" class=\"form-label\">Mật khẩu</label>\n");
      out.write("                <input type=\"password\" class=\"form-input\" name=\"password\" id=\"password\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <input type=\"submit\" value=\"Đăng nhập\" class=\"login\">\n");
      out.write("            </div>\n");
      out.write("            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("        <div class=\"feature-layout\">\n");
      out.write("        <div class=\"feature-item first-item\">\n");
      out.write("            <h2 class=\"feature-h2\">Tại sao nên dùng trang web này?</h2>\n");
      out.write("            <p class=\"feature-p\">Chúng tôi cung cấp công nghệ tính toán tự động chính xác hàng đầu thế giới. \n");
      out.write("            Giúp bạn dễ dàng quản lý các nguồn tiền của mình</p>\n");
      out.write("        </div >\n");
      out.write("        <div class=\"feature-item second-item\">\n");
      out.write("            <h2 class=\"feature-h2\">Có phải trả phí để sử dụng dịch vụ không?</h2>\n");
      out.write("            <p class=\"feature-p\">Câu trả lời là hoàn toàn miễn phí</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"feature-item third-item\">\n");
      out.write("            <h2 class=\"feature-h2\">Cách để tôi có tài khoản riêng cho mình</h2>\n");
      out.write("            <p class=\"feature-p\">Hãy liên hệ tới email:<a href=\"mailto: hieudnhe153007@fptt.edu.vn\">hieudnhe153007@fptt.edu.vn</a>  để quản trị viên cấp tài khoản cho bạn</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.loginFailed != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <script>\n");
        out.write("            login();\n");
        out.write("        </script>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.loginFailed != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <script>\n");
        out.write("                    login();\n");
        out.write("                </script>\n");
        out.write("                <p class=\"error\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.loginFailed}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
