<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/20/2023
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Product</title>
    <style>
        input {
            padding: 10px ;
            margin-bottom: 10px;
        }

        .button {
            padding: 10px 30px;
        }
    </style>
</head>
<body>

<h1>Create Product</h1>
<h5 class="error" ><%= (String) request.getAttribute("message") != null ?  request.getAttribute("message") : "" %></h5>
<form method="post" action="/createProduct">
    <input type="text" placeholder="name" name="name">
    <input type="text" placeholder="price" name="price"></br>
    <input type="text" placeholder="category" name="category">
    <input type="text" placeholder="is exist?" name="isexists"></br>
    <input type="submit" class="button">
</form>

</body>
</html>