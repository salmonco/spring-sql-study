/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.107
 * Generated at: 2023-02-03 09:12:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("\t<title>Login</title>\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div style=\"max-width: 800px; margin: 0 auto\">\n");
      out.write("        <h2>?????????</h2>\n");
      out.write("        <div style=\"display: flex; flex-direction: column; align-items: center\">\n");
      out.write("            <input type=\"text\" id=\"studentId\" placeholder=\"??????\" style=\"width: 250px; margin-bottom: 10px;\">\n");
      out.write("            <button type=\"button\" id=\"fnLoginBtn\" style=\"width: 250px;\">?????????</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        //????????? ?????? ??????\n");
      out.write("        function fnLogin() {\n");
      out.write("             $.ajax({\n");
      out.write("                type: \"POST\",\n");
      out.write("                url: \"/loginProc\",\n");
      out.write("                cache: false,\n");
      out.write("                data: {\n");
      out.write("                    STUDENT_ID: $(\"#studentId\").val()\n");
      out.write("                },\n");
      out.write("                datatype: \"JSON\",\n");
      out.write("                success: function (obj) {\n");
      out.write("                    //alert(\"obj=\"+JSON.stringify(obj));\n");
      out.write("                    fnLoginSuccess();\n");
      out.write("                },\n");
      out.write("                error: function (xhr, status, error) {\n");
      out.write("                    console.log(\"ERROR!!!\");\n");
      out.write("                },\n");
      out.write("                complete : function (xhr, status, error) {\n");
      out.write("                    console.log(\"complete!!!\");\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("    \n");
      out.write("        function fnLoginSuccess() {\n");
      out.write("        \tlocation.href = \"/enrolmentList\"; \n");
      out.write("       }\n");
      out.write("       \n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $(\"#fnLoginBtn\").click(function(){\n");
      out.write("            \tfnLogin();\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
