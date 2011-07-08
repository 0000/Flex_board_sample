<?xml version='1.0' encoding='UTF-8'?>
<%@ page contentType='application/xml;charset=utf-8'%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import='com.board.model.BoardVo'%>
<%@ page import='com.board.dao.BoardDao'%>
<%
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
	
	
	%>

<withflex>
	<%=result%>
</withflex>