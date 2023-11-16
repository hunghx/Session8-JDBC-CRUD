<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<form action="" method="post" enctype="multipart/form-data">
  <input type="file" name="" id="" multiple>
</form>
<a href="<%=request.getContextPath()%>/ProductServlet?action=GETALL">Hello Servlet</a>
</body>
</html>