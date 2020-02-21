<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Type" content="text/html";> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function fn_search(page) {
	var frm = document.searchForm;
	
	if(frm.searchType.value != "")
		if(frm.searchWord.value ==""){
			alert("검색어를 입력하세요");
			return;
		}
}

frm.currentPage.value =page;
frm.submit();


</script>


<title>Insert title here</title>
</head>


<body>
<h3>글 리스트</h3>


<div>
<form class="form-inline" name="searchForm" action="boardList" method="post">
	<input type="hidden" name="currentPage">
	
	<select class="form-control" name="searchType">
		<option value="1">전체</option>
		<option value="2">내용</option>
		<option value="3">제목 + 내용</option>
		<option value="4">작성자</option>
	
	</select> 
	<input type="text" class="form-control" name="searchWord"/>
	<input type="button" class="btn btn-primary" value="검색" onclick="fn_search(1)"/>

</form>
</div>


<div align="right">
<input class="btn btn-success" type="button" value="글쓰기" onclick="location.href='boardForm'"/>
</div>

<table class="table table-boarded table-striped table-hover">
<thead>
<tr>
<th>글 번호</th>
<th style="width: 50%">제목</th>
<th>작성자</th>
<th>조회수</th>
<th>작성일자</th>
</tr>
</thead>
<tbody>

<c:if test="${not empty boardList}">
<c:forEach var="board" items="${boardList}">
<tr>
<td>${board.bo_seq_no}</td>
<td><a href="boardView/${board.bo_seq_no}">${board.bo_content}</a></td>
<td>${board.bo_writer}</td>
<td>${board.bo_hit_cnt}</td>
<td>${board.reg_date}</td>
</tr>
</c:forEach>
</c:if>
<c:if test="${empty boardList}">
<tr>
<td colspan="5"></td>
</tr>
</c:if>
</tbody>

</table>

<div align="center">
	<ul class="pagination">
			${pagingUtil.pageHtml}
	</ul>
</div>



</body>
</html>