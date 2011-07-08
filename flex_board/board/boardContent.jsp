<?xml version='1.0' encoding='UTF-8'?>
<%@ page contentType='application/xml;charset=utf-8'%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import='com.board.model.*'%>
<%@ page import='com.board.dao.BoardDao'%>
<%
	String seq = request.getParameter("seq");
	String bname = request.getParameter("bname");
	Map map = new HashMap();
	map.put("seq",seq);
	map.put("bname",bname);
	BoardDao dao = BoardDao.getInstance();
	dao.updateHit(map);
	String result = dao.list(map);
%>
<withflex>
	<%=result%>
</withflex>