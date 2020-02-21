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

<title>Insert title here</title>
</head>


<body>

<h3>글보기</h3>

<table class="table table-boarded">

<tr>
<td width="15%">제목</td>
<td>${board.bo_title}</td>
</tr>

<tr>
<td width="15%">작성자</td>
<td>${board.bo_writer_name}</td>
</tr>

<tr>
<td width="15%">조회수</td>
<td>${board.bo_hit_cnt}</td>
</tr>


<tr>
<td width="15%">작성일자</td>
<td>${board.reg_date}</td>
</tr>

<tr>
<td colspan="2" style="white-space: pre-wrap;">${board.bo_content}</td>
</tr>


<tr>
<td colspan="2">
<input class="btn btn-success" type="button" value="목록" onclick="location.href = '${pageContext.request.contentType}/board/boardList'"/><!-- 주소창 파라미터안쓰고 /형태썻기때문에 절대 경로로 넣어줘야 정상적으로 리스트로 넘어감 -->

<c:if test="${board.bo_writer == LOGIN_USER.mem_id}">
<input class="btn btn-success" type="button" value="저장" onclick="location.href = '${pageContext.request.contentType}/board/boardEdit?bo_seq_no=${board.bo_seq_no}'"/>
<input class="btn btn-success" type="button" value="삭제" onclick="location.href = '${pageContext.request.contentType}/board/boardDelete?bo_seq_no=${board.bo_seq_no}'"/>
</c:if>
</td>
</tr>

</table>

</body>
</html>