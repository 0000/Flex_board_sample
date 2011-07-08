package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.HashMap;
import com.board.dao.BoardDao;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("application/xml;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version='1.0' encoding='UTF-8'?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String strShowCount = request.getParameter("showCount");
	String cPage = request.getParameter("cPage");
	String bname = request.getParameter("bname");
	Map map = new HashMap();
	int showCount = 10;
	int totalCount = 1;
	if (strShowCount != null && strShowCount.length() > 0) {
		showCount = Integer.parseInt(strShowCount);
	}
	
	// int length = showCount;
	int currentPage = 1;
	if (cPage != null && cPage.length() > 0) {
		currentPage = Integer.parseInt(cPage);
	}
	
	//get notice list
	int start = 0;
	if (cPage != null && cPage.length() > 0) {
		start = 0 + (Integer.parseInt(cPage)-1) * showCount;
	}
	int end = showCount;	
	map.put("start", start);
	map.put("end", end);
	map.put("bname",bname);
	BoardDao dao = BoardDao.getInstance();
	String result = dao.list(map);
	cPage = String.valueOf(currentPage);
	totalCount = dao.getRowCount(map);	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<withflex>\r\n");
      out.write("\t<currentPage>");
      out.print(cPage);
      out.write("</currentPage>\r\n");
      out.write("\t<totalRowCount>");
      out.print(totalCount);
      out.write("</totalRowCount>\r\n");
      out.write("\t");
      out.print(result);
      out.write("\r\n");
      out.write("</withflex>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
