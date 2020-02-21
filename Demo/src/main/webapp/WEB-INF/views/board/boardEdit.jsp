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
	
	var frm = document.boardForm;
	
	frm.submit();
	
}
function validate(){
	var frm = document.boardForm;
	
	if(frm.bo_title.value == ""){
		alert("제목을 입럭하세요");
		return false;
	}
	if(frm.bo_content.value == ""){
		alert("내용을 입럭하세요");
		return false;
	}

	return true;
}

</script>
<title>Insert title here</title>
</head>


<body>

<h3>글 수정하기</h3>

<form class="form" name="boardForm" action="boardInsert" method="post">
<input type="hidden" name="bo_type" value="${board.bo_type}">
<input type="hidden" name="bo_seq_no" value="${board.bo_seq_no}">
<table class="table table-boarded">

<tr>
<td width="15%">제목</td>
<td><input class="form-control" type="text" name="bo_title" value="${board.bo_title}"/> </td>
</tr>
<tr>
<td colspan="2"><textarea rows = "10" class="form-control" type="text" name="bo_content"${board.bo_content}></textarea> </td>
</tr>
<tr>
<td colspan="2">
<input class="btn btn-success" type="button" value="목록" onclick="location.href = 'boardList'"/>
<input class="btn btn-success" type="button" value="수정" onclick="fn_save()"/>
<input class="btn btn-success" type="reset" value="취소"/>
 </td>
</tr>



</table>



</form>
</body>
</html>