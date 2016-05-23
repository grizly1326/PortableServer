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
		<h5 class="main">HI: <%= Hello.printName() %></h5>
	</div>
	<div id="main">
		<form class="register" method="post" action="RegisterServlet">
			First name: <input type="text" name="fname"/><br>
			Last name: <input type="text" name="lname"/><br>
			E-mail: <input type="text" name="email"/><br>
			<input type="submit" value="Register"/>
		</form>
	</div>
	<div id="bottom">
		<div id="Server">
			Server: <%=List.errorcode() %>
		</div>
		<div id="User">
			User: <%=List.errorcode() %>
		</div>
	</div>
</body>
</html>