<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 11/14/2023
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<h1 class="text-center">Thêm mới sản phẩm</h1>
<div class="container">
    <form action="<%=request.getContextPath()%>/ProductServlet" method="post" enctype="multipart/form-data" class="row g-3" style="max-width: 40rem ;margin: 0 auto">
        <div class="col-12">
            <label for="id" class="form-label">Product Id</label>
            <input type="text" name="id" readonly class="form-control" id="id" value="${pro.id}">
        </div>
        <div class="col-12">
            <label for="name" class="form-label">Product Name</label>
            <input type="text" name="name"  value="${pro.name}" class="form-control" id="name">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Product description</label>
            <textarea class="form-control" name="description" id="description" rows="3"> ${pro.description}</textarea>
        </div>
        <div class="col-md-6">
            <label for="price" class="form-label">Price</label>
            <input type="number" min="0" class="form-control" id="price" name="price"  value="${pro.price}">
        </div>
        <div class="col-md-6">
            <label for="stock" class="form-label">Stock</label>
            <input type="number" min="0" class="form-control" id="stock" name="stock"  value="${pro.stock}">
        </div>
        <div class="col-md-6">
            <label for="image" class="form-label">Image</label>
            <img width="100" height="100" style="object-fit: cover" src="<%=request.getContextPath()%>/uploads/${pro.imageUrl}" alt="#">
            <input type="hidden" name="imageUrl"  value="${pro.imageUrl}">
            <input type="file" class="form-control" id="image" name="image">
        </div>
        <div class="col-12 text-center">
            <input type="submit" class="btn btn-primary" name="action" value="UPDATE">
        </div>
    </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
