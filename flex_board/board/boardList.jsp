<?xml version='1.0' encoding='UTF-8'?>
<%@ page contentType='application/xml;charset=utf-8'%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import='com.board.dao.BoardDao'%>
<%
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
%>

<withflex>
	<currentPage><%=cPage%></currentPage>
	<totalRowCount><%=totalCount%></totalRowCount>
	<%=result%>
</withflex>