<%@page import="org.leonidas.CardGames.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Poker Game!</title>
</head>
<body>
<%!TexasGame tg ; %>
<%
List<TexasPlayer> players = (List<TexasPlayer>)application.getAttribute("players");

tg = new TexasGame(players);
 %>
The winner of this round is : <%=tg.findWinner().get(0) %>

</body>
</html>