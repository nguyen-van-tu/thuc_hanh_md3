<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/24/2021
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<button><a href="/product?action=create">Create New Product</a></button><br><br>

<table border="1px" style="width: 50% ; height: 200px" >
    <tr style="background-color: yellow">
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Color</td>
        <td>Description</td>
        <td>Category</td>
        <td>Xóa</td>
        <td>Sửa</td>
    </tr>
    <c:forEach items="${p}" var="product">
        <tr>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getColor()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getCategoryName()}</td>
            <td style="background-color: red"><a href="/product?action=edit&id=${product.getId()}">Edit</a></td>
            <td style="background-color: red"><a href="/product?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
