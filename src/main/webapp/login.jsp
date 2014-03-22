<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.background{
	padding-top:120px;
	padding-bottom:120px;
	margin:0px auto;
	background-color:#90EE90;
}
#auth-area{
	top:150px;
	margin:0px auto;
	width:400px;
	padding:80px;
	border:solid black 1px;
	background-color:#FFFACD;
}
.row{
	width:400px;
	margin-top:12px;
	margin-bottom:12px;
}
.label{width:150px;}
.input-area{
	width:250px;
	left:150px;
}
.button{
	position:relative;
	left:200px;
}
</style>
<title>User Login Page</title>
</head>
<body>
<div id="background">
<div id="auth-area">
<form action="j_spring_security_check" method="post">
	<div class="row">
		<label for="userid" class="label">ユーザーID:</label> 
		<input type="text" name="j_username" id="userid" class="input-area"/><br/>
	</div>
	<div class="row">
		<label for="password" class="label">パスワード：</label>　
		<input type="password" name="j_password" id="password" class="input-area"/><br/>
	</div>
	<input type="submit" value="ログイン" class="button"/>
</form>
</div>
</div>
</body>
</html>