<?xml version='1.0' encoding='UTF-8'?>
<%@ page contentType='application/xml;charset=utf-8'%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import='com.board.model.BoardVo'%>
<%@ page import='com.board.dao.BoardDao'%>
<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");	
	String bname = request.getParameter("bname");
	String result = "failure";
	BoardDao dao = BoardDao.getInstance();
	dao.delete(Integer.parseInt(seq));
	result="success";
%>
<withflex>
	<%=result%>
</withflex>