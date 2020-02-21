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
function fn_search(page){
	var frm = document.searchForm;
	
	frm.currentPage.value = page;
	if(frm.searchType.value != ""){
		if(frm.searchWord.value == ""){
			alert("검색어를 입력하세요.");
			return;
			
		}
		
	}
	alert(frm.searchWord.value);
	frm.submit();
	
}
</script>

<title>회원정보리스트</title>
</head>
<body>

	<h3>회원 목록</h3>


<form class="form-inline" name="searchForm" method="post" action="memberList">
<input type="hidden" name="currentPage"/>

<div class="form-group">
	<select name="searchType" class="form-control">
		<option value="">전체</option>
		<option value="id" ${param.searchType == 'id' ? "selected" : ""}>아이디</option>
		<option value="name" ${param.searchType == 'name' ? "selected" : ""}>이름</option>
	
	</select>
</div>

<div class="form-group">
<input type="text" name="searchWord" class="form-control" value="${param.searchWord}">
</div>

<div class="form-group">
<input type="button" class="form-control btn-sm btn-info" value="검색" onclick="fn_search(1)">
</div>


</form>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>가입일자</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${!empty memberList}">
			<c:forEach var="member" items="${memberList}" >
				<tr>
					<td>${member.mem_id}</td>
					<td><a href="memberView?mem_id=${member.mem_id}">${member.mem_name}</a></td>
					<td>${member.mem_phone}</td>
					<td>${member.mem_email}</td>
					<td>${member.reg_date}</td>
				</tr>
				</c:forEach>
			</c:if>

			<c:if test = "${empty memberList}">
			<tr>
				<td colspan="5">검색된 결과가 없습니다.</td>
			</tr>
			</c:if>
			
			
		</tbody>

	</table>
	<p align="right" inputmode="button" class="btn btn-sm btn-info" value="회원가입" onclick="location.href='memberForm'">회원가입</p>

<!-- 페이지 네비게이션 -->
<div align="center">
<ul class="pagination">
${pagingUtil.pageHtml}
</ul><!-- 넘거바없는 리스트 -->

</div>

</body>
</html>