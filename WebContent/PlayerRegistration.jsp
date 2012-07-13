<%@page import="org.leonidas.CardGames.*" import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to poker Game</title>
</head>
<body>
<h3>Player Registration</h3><br>
<%! TexasGameRegistration r; %>
<%! List<TexasPlayer> texasPlayers = new ArrayList<TexasPlayer>(); 
int count=0;
%>
<%

application.setAttribute("players", texasPlayers);
r = new TexasGameRegistration(texasPlayers);
String name = request.getParameter("name");
String chipsStack = request.getParameter("chipsStack");
String spot = request.getParameter("spot");


r.registerPlayer(name, Integer.parseInt(chipsStack), Integer.parseInt(spot));
application.setAttribute("counter", count++);
%><br>
<br><%= name+" "+chipsStack+" "+ spot %>
<br><%= texasPlayers.get(0).getName() %>
<br><%= texasPlayers.get(1).getName() %>
<br><%= texasPlayers.get(2).getName() %>
<br><%= texasPlayers.get(3).getName() %>
<br><%= texasPlayers.get(4).getName() %>
<br><%= texasPlayers.get(5).getName() %>
<%if(count>1) {
	response.sendRedirect("pokergame.jsp");
}
%>

</body>
</html>