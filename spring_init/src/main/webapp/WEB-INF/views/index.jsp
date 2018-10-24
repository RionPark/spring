<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
Login  
</h1>
<form method="post" action="/login">
	uiId : <input type="text" name="uiId" value="test"><br>
	uiPwd : <input type="password" name="uiPwd" value="test"><br>
	uiName : <input type="text" name="uiName" value="test"><br>
	<button>로그인</button>
</form>
</body>
</html>
