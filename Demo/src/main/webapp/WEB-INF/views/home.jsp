<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	로그인이 되었습니다. <span>로그인 사용자 : ${LOGIN_USER.mem_name}</span>
</h1>
<ul>
<c:if test="${empty LOGIN_USER}">
<p><a href="loginForm">로그인</a></p>
</c:if>

<c:if test="${!empty LOGIN_USER}">
<p><a href="logout">로그아웃</a></p>
</c:if>

<c:forEach var="member" items="${memberList}" >
	<p>${member}</p>
</c:forEach>

<li><a href="${pageContext.request.contextPath}/member/loginForm">로그인</a></li>
<li><a href="${pageContext.request.contextPath}/member/memberList">회원목록</a></li>
<li><a href="${pageContext.request.contextPath}/board/boardList">게시판</a></li>
</ul>



</body>
</html>
