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
function fn_save(){
	if(!validate()){
		return;
	}
	var frm = document.noticeForm;
	frm.submit();
}

function validate() {
	var frm = document.noticeForm;
	
	if(frm.bo_seq_no.value==""){
		alert("아이디는 필수사항입니다.");
		return false;
	}
	
	if(frm.bo_type.value==""){
		alert("글타입 필수사항입니다.");
		return false;
	}
	
	if(frm.bo_title.value==""){
		alert("글 제목을 입력하세요");
		return false;
	}
	
	if(frm.bo_content.value==""){
		alert("글 내용은 필수사항입니다.");
		return false;
	}
	return true;
}
</script>
<title>회원 가입</title>
</head>
<body>

<h3>회원 가입 창</h3>


<form id="noticeForm" name="noticeForm" action="noticeInsert" method="post"><!-- 폼테그 안에 있어야만 데이터 날라감 -->
<table class="table table-bordered">
<tr>
<td>글 번호</td>
<td><input type="text" name="bo_seq_no" value=""/>
</td>
</tr>
	
<tr>
<td>글 타입</td>
<td><input type="text" name="bo_type" value=""/>
</td>
</tr>

<tr>
<td>글 제목</td>
<td><input type="text" name="bo_title" value=""/>
</td>
</tr>


<tr>
<td>글 내용</td>
<td><input type="text" name="bo_content" value=""/>
</td>
</tr>

<tr>
<td>작성자</td>
<td><input type="hidden" name="bo_writer" value=""/>
	&nbsp; #{bo_writer} 
</td>
</tr>

<tr>
<td colspan="20">
<input type="button" class = "btn btn-info" value="목록" onclick="location.href='noticeList'">
<input type="button" class = "btn btn-info" value="가입" onclick="fn_save()">
<input type="reset" class = "btn btn-info" value="취소" onclick="location.href='noticeList'">
</td>
</tr>


</table>
</form>


</body>
</html>