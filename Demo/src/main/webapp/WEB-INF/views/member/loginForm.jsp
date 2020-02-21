<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Type" content="text/html";> -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>

<script type="text/javascript">
	function fn_login() {
		var frm = document.loginForm;

		if (frm.mem_id.value == "") {
			alert("아이디를 입력하세요");
			return;
		}
		if (frm.mem_pwd.value == "") {
			alert("비밀번호를 입력하세요");
			return;
		}
		frm.submit();

	}
</script>



<title>login</title>
</head>
<body>

	<div class="card" style="width: 400px; margin: auto">
		<div class="card-heading">
			<!-- 서버에서 루트로 경로잡았으면 아래코드 신경안서도되지만 루트가아니라면 컨택스트패스 꼭써줘야함 -->
			로그인<span style="float: right;"><a
				href="${pageContext.request.contextPath}/">Home</a></span>
		</div>
		<div class="card-body">
			<form class="form-horizontal" name="loginForm" action="login"
				method="post">

				<div class="form-group">
					<input class="form-control" type="text" name="mem_id" value=""
						placeholder="아이디" />
				</div>

				<div class="form-group">
					<input class="form-control" type="password" name="mem_pwd" value=""
						placeholder="비밀번호" />
				</div>

				<div class="form-group">
					<input class="btn btn-success" type="button" value="로그인"
						onclick="fn_login()" />
				</div>
			</form>
		</div>

	</div>
</body>
</html>