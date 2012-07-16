<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="pokergame.jsp" method="post">
	Select : <input type="radio" name="action" value="call"/>call<br>
			 <input type="radio" name="action" value="raise" />raise
			 	<input type="text" name="raiseAmount" value="raiseAmount" />chips<br>
			 <input type="radio" name="action" value="fold" />fold<br>
	<br><input type="submit" />
</form>

</body>
</html>