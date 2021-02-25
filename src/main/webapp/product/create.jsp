<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/24/2021
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <center>
        <h2>ADD PRODUCT</h2>
        <a href="/product">BACK</a>
        <table>
            <tbody>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="quantity"></td>
            </tr>
            <tr>
                <td>Color</td>
                <td><input type="text" name="color"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <select type="text" name="category">
                        <c:forEach items='${requestScope["lists"]}' var="category" >
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="create"></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
