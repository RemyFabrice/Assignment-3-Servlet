<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
<div align=center>
<h1>STUDENT SIGNUP</h1>
</div>
<form action=SignUpServlet method=post>
<table>
<tr><td>Enter Email:</td><td><input type=email name=txtEmail></td></tr>
<tr><td>Enter password:</td><td><input type=password name=txtPwd></td></tr>
<tr><td>><input type=submit value=SignUp></td><td><input type=reset></td></tr>
</table>
</form>
</body>
</html>