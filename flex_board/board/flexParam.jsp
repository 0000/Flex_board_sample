<%@ page pageEncoding='euc-kr' %>
<pre>
	boardList.jsp(리스트 출력 페이지) => showCount, cPage ,bname
	boardAdd.jsp(새글 입력 페이지) =>  writer, title, content, pwd, bname
	boardAdd.jsp(답글 입력 페이지) =>   writer, title, content, pwd,  bname, 
									 (원본글)seq,(원본글)groups, (원본글)step, (원본글)level
	boardContent.jsp(상세페이지)	=> seq , bname
	boardUpdate.jsp(수정페이지) => seq, writer, title, content, pwd, bname
								수정후 boardContent.jsp로 이동해야 한다.
	boardDelete.jsp(삭제페이지) => seq, bname
								삭제후 boardList.jsp로 이동
</pre>