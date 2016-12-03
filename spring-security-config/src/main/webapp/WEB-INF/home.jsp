<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>Hello Security Example</title>
</head>
<body>
    <h1><%= request.getAttribute("helloMessage") %></h1>
</body>
</html>