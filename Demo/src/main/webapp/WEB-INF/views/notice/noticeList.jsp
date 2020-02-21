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


<title>게시판</title>
</head>
<body>

	<h3>게시판 리스트</h3>

	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>게시글 형태</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>삭제 여부</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${!empty noticeList}">
			<c:forEach var="notice" items="${noticeList}" >
				<tr>
					<td>${notice.bo_seq_no}</td>
					<td>${notice.bo_type}</td>
					<td><a href="noticeView?bo_seq_no=${notice.bo_seq_no}">${notice.bo_title}</a></td>
					<td>${notice.bo_writer}</td>
					<td>${notice.bo_hit_cnt}</td>
					<td>${notice.bo_del_yn}</td>
				</tr>
				</c:forEach>
			</c:if>

			<c:if test = "${empty noticeList}">
			<tr>
				<td colspan="5">검색된 결과가 없습니다.</td>
			</tr>
			</c:if>
			
			
		</tbody>

	</table>
	<p align="right" inputmode="button" class="btn btn-sm btn-info" value="글 등록" onclick="location.href='noticeInsert'">글 등록</p>

<%-- <!-- 페이지 네비게이션 -->
<div align="center">
<ul class="pagination">
${pagingUtil.pageHtml}
</ul><!-- 넘거바없는 리스트 -->

</div> --%>

</body>
</html>