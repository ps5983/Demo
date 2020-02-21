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


<title>게시글 정보</title>
</head>
<body>
	<h3>게시글 정보</h3>

<form id="noticeEdit" name="noticeEdit" action="noticeUpdate" method="post">
	<table class="table table-striped table-bordered" align="center" border="1">
		<tbody>

			<tr>
				<td align="center" width="120">글 번호</td>
				<td align="center" width="300">${notice.bo_seq_no}</td>
				<td align="center" width="120">글 타입</td>
				<td align="center" width="120">${notice.bo_type}</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td >${notice.bo_title}</td>
				
			</tr>
			<tr>
				<td>글 내용</td>
				<td >${notice.bo_content}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td >${notice.bo_writer}</td>
				<td>조회수</td>
				<td>${notice.bo_hit_cnt}</td>
			</tr>
			<tr>
			</tr>
		</tbody>
		<tr>
<td colspan="20">
<input type="button" class = "btn btn-sm btn-info" value="회원 목록으로" onclick="location.href='noticeList'">
<input type="button" class = "btn btn-sm btn-info" value="수정하기" onclick="location.href='noticeEdit?bo_seq_no=${notice.bo_seq_no}'">
<input type="button" class = "btn btn-sm btn-info" value="삭제하기" onclick="location.href='noticeList'">
</td>
</tr>
	</table>
	</form>
	<%-- <p inputmode="button" class="btn btn-sm btn-info" value="회원 목록으로" onclick="location.href='noticeList'?mem_id=${notice.mem_id}">회원 목록으로</p>
	<p inputmode="button" class="btn btn-sm btn-info" value="수정하기" onclick="location.href='noticeEdit'?mem_id=${notice.mem_id}">수정하기</p>
	<p inputmode="button" class="btn btn-sm btn-info" value="삭제하기" onclick="location.href='noticeList'">회원 목록으로</p>
 --%>
</body>
</html>	