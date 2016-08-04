<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<title>Login Page</title>
<body>
<body>
	<h3>Login with Username and Password to access to view, insert, delete url.</h3>
	<form name="login" action="login" method="post">
		User ID:<input type='text' id='username' name='username' /><br>
		Password:<input type='password' id='password' name='password' /><br>
		<input name="submit" type="submit" value="Login" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>