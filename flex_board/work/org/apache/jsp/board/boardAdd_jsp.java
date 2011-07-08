package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.board.model.BoardVo;
import com.board.dao.BoardDao;

public final class boardAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("utf-8");
	String tseq = request.getParameter("seq");
	String tgroup = request.getParameter("groups");
	String tstep = request.getParameter("step");
	String tlevel = request.getParameter("level");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String pwd = request.getParameter("pwd");
	String bname = request.getParameter("bname");
	int group = 0;
	int step = 0;
	int level = 0;
	String result = "failure";
	BoardDao dao = BoardDao.getInstance();
	synchronized(request){
		int seq = dao.getMaxSeq()+1;
		if(tseq == null || tseq.length() ==0){
			group = seq;
			step = 0;
			level = 0;
		} else {
			group = Integer.parseInt(tgroup);
			step = Integer.parseInt(tstep)+1;
			Map map = new HashMap();
			map.put("groups",Integer.parseInt(tgroup));
			map.put("step",Integer.parseInt(tstep));
			dao.updateStep(map);
			level = Integer.parseInt(tlevel) + 1;
		}
		
		BoardVo vo = new BoardVo();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setBname(bname);
		vo.setSeq(seq);
		vo.setGroups(group);
		vo.setStep(step);
		vo.setLevel(level);
		
		dao.insert(vo);
		//return value
		result="success";	
	}
	
	
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("<withflex>\r\n");
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
