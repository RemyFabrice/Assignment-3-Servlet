<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdmissionForm</title>
</head>
<body>

<div align=center>
<h1>STUDENT ADMISSION FORM</h1>
</div>
<form action="AdmissionFormServlet" method="post" enctype="multipart/form-data">
    <!-- Other form fields -->
    <input type="file" name="passwordPicture" accept=".jpg, .png">
    <input type="file" name="certificate" accept=".pdf">
    <input type="submit" value="Submit">
</form>

</body>
</html>