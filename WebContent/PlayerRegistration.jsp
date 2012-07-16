<%@page import="org.leonidas.CardGames.bl.*"%>
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

<%! List<TexasPlayer> texasPlayers = new ArrayList<TexasPlayer>(); 
int count=0;
InitGame initGame= new InitGame();
%>
<%
TexasPlayer tp;
application.setAttribute("players", texasPlayers);

String name = request.getParameter("name");
String chipsStack = request.getParameter("chipsStack");
String spot = request.getParameter("spot");

tp = initGame.registerPlayers(texasPlayers, name, Integer.parseInt(chipsStack), Integer.parseInt(spot));
session.setAttribute("player", tp);

%><br>

<br><%= texasPlayers.get(0).getName() %>
<br><%= texasPlayers.get(1).getName() %>
<br><%= texasPlayers.get(2).getName() %>
<br><%= texasPlayers.get(3).getName() %>
<br><%= texasPlayers.get(4).getName() %>
<br><%= texasPlayers.get(5).getName() %>
<%if(initGame.startGame()) {
	response.sendRedirect("pokergame.jsp");
}
%>

</body>
</html>