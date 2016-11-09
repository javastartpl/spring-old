<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
    <h1>Event registration</h1>
    <form action="register" method="post">
        <input name="firstName" placeholder="first name" /><br />
        <input name="lastName" placeholder="last name" /><br />
        <input type="submit" value="Register" />
    </form>
    <a href="show">Print participants</a>
</body>
</html>