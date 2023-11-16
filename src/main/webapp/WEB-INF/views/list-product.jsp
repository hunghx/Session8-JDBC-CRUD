<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 11/14/2023
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<h1>Danh sách sp</h1>
<c:set var="formater" value='<%=NumberFormat.getCurrencyInstance(new Locale("vi","VN"))%>' scope="page"></c:set>

<a href="<%=request.getContextPath()%>/ProductServlet?action=ADD">Add new Product</a>
<%-- bảng danh sách sp --%>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Image</th>
        <th scope="col">Price</th>
        <th scope="col" colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.name}</td>
            <td><img width="100" height="100" style="object-fit: cover" src="uploads/${p.imageUrl}" alt="#"></td>
            <td>${formater.format(p.price)}</td>
            <td><a class="btn btn-info" href="<%=request.getContextPath()%>/ProductServlet?action=ADD">Details</a></td>
            <td><a class="btn btn-warning" href="<%=request.getContextPath()%>/ProductServlet?action=EDIT&id=${p.id}">Edit</a></td>
            <td><a class="btn btn-danger" onclick="return confirm('bạn chắc chắn muốn xóa không?')" href="<%=request.getContextPath()%>/ProductServlet?action=ADD">Delete</a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
