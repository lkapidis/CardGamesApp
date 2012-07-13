<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%
	String name1 = request.getParameter("name1");
	String name2 = request.getParameter("name2");
	String name3 = request.getParameter("name3");
	String name4 = request.getParameter("name4");
	String name5 = request.getParameter("name5");
	String name6 = request.getParameter("name6");
%>
<%=name1 +" "+ name2 +" "+ name3 +" "+ name4 +" "+ name5 +" "+ name6 %>
</body>
</html>