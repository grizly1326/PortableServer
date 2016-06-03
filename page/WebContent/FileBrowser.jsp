<%@ page import="com.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
	<div id="top">
		<a href="./Music.jsp"><div id="back">Go Back to Music</div></a>
		<div id="name">HI: <%= GeneralInfo.printName() %></div>
		<a href="SaveFileDestination"><div id="back">Save</div></a>
	</div>
	<div id="main">
		<%=MediaList.printDir()%>
	</div>
	<div id="bottom">
		<div id="Server">
			Server: <%=ProfileList.errorcode() %>
		</div>
		<div id="User">
			User: <%=MainMenu.errorcode() %>
		</div>
	</div>
</body>
</html>