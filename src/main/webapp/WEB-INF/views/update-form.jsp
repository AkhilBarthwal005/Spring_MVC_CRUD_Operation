<%--
  Created by IntelliJ IDEA.
  User: Anjali Pandey
  Date: 30-08-2022
  Time: 05:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="text-center mt-3 mb-4">
        <h1>Fill the form to Update Product</h1>
    </div>
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <form action="${pageContext.request.contextPath}/product-added" method="post">
                <input type="hidden" name="id" value="${product.id}" id="id"/>
                <div class="mb-3">
                    <label for="name" class="form-label">Product Name</label>
                    <input type="text" class="form-control" placeholder="Enter the product Name here" id="name" name="name" value="${product.name}">
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Product Description</label>
                    <textarea id="description" class="form-control" name="description" placeholder="Enter the product Description" rows="6" cols="10" style="resize: none">${product.description}</textarea>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Price</label>
                    <input type="text" class="form-control" placeholder="Enter the product Price here" id="price" value="${product.price}" name="price" aria-describedby="emailHelp">
                </div>
                <div class="text-center mb-3">
                    <%--                            pageContext.request.contextPath is used to redirect it to / (Home page)--%>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-outline-success">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</body>
</html>
