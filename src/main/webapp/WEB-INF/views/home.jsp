<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
</head>
<body>
Hi, <%= session.getAttribute("username") %><br>
Your SessionId : <%= session.getId() %><br>
<br>Cellphone Data Management<br>
<h6>To delete cellphone model data : type "/delete/{modelId}</h6><br>
<h6>To view cellphone model data : type "/view/{modelId}</h6><br>
<h6>To insert cellphone model data : </h6><a href="gotoinsert">Goto Insert Page</a><br>
<form action="logout" method="post">
	<input type="submit" value="Logout" />
</form>
</body>
</html>