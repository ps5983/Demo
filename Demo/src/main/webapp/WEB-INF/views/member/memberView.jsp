<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>


<title>회원 상세정보</title>
</head>
<body>
	<h3>회원 상세정보</h3>

<form id="memberEdit" name="memberEdit" action="memberUpdate" method="post">
	<table class="table table-striped table-bordered">
		<tbody>

			<tr>
				<td>아이디</td>
				<td>${member.mem_id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.mem_name}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${member.mem_phone}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.mem_email}</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td>${member.reg_date}</td>
			</tr>
			<tr>
			</tr>
		</tbody>
		<tr>
<td colspan="20">
<input type="button" class = "btn btn-sm btn-info" value="회원 목록으로" onclick="location.href='memberList'">
<input type="button" class = "btn btn-sm btn-info" value="수정하기" onclick="location.href='memberEdit?mem_id=${member.mem_id}'">
<input type="button" class = "btn btn-sm btn-info" value="삭제하기" onclick="location.href='memberList'">
</td>
</tr>
	</table>
	</form>
	<%-- <p inputmode="button" class="btn btn-sm btn-info" value="회원 목록으로" onclick="location.href='memberList'?mem_id=${member.mem_id}">회원 목록으로</p>
	<p inputmode="button" class="btn btn-sm btn-info" value="수정하기" onclick="location.href='memberEdit'?mem_id=${member.mem_id}">수정하기</p>
	<p inputmode="button" class="btn btn-sm btn-info" value="삭제하기" onclick="location.href='memberList'">회원 목록으로</p>
 --%>
</body>
</html>	