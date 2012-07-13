<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to poker Game</title>
</head>
<body>
<h3>Welcome to poker Game</h3>
Please Enter Your Details:
<form action="PlayerRegistration.jsp" method="post">
	Name : <input type="text" name="name" value="name"/><br>
	Enter Your Chip Stack:<input type="text" name="chipsStack" value="ChipsStack" /><br>
	Spot:<input type="text" name="spot" value="spot" /><br>
	<br><input type="submit" />
</form>

</body>
</html>