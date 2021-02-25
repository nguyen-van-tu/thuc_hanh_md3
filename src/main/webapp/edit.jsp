<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/24/2021
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${product.getName()}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="name" value="${product.getPrice()}"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="name" value="${product.getQuantity()}"></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input type="text" name="name" value="${product.getColor()}"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="name" value="${product.getDescription()}"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="name" value="${product.getCategoryID()}"></td>
        </tr>

        <tr>
            <td><input type="submit" value="edit"></td>
        </tr>
    </table>

</form>
</body>
</html>
