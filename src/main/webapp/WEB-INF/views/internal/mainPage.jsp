<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/common.css"/>" rel="stylesheet"/>
<link href="<c:url value="/css/mainpage.css"/>" rel="stylesheet"/>
<title>Welcome!</title>
</head>
<body>
<div class="whole">
<div id="main-box">
<div id="text-part">
Backgyammonゲームページへようこそ！<br/>
ログインに成功しました<br/>
ゲームの対戦形式を選択して下さい<br/>
</div>
<form action='<c:url value="int/com/start/"/>' method="post">
	<input type="submit" value="コンピューターと対戦"/>
</form>
</div>
</div>
</body>
</html>