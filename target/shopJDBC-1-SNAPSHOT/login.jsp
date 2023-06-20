<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/20/2023
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        input {
            padding: 10px ;
            margin-bottom: 10px;
        }

        .button {
            padding: 10px 30px;
            cursor: pointer !important;
        }
    </style>
</head>
<body>
    <div class="lr">
        <h1>Login</h1>
        <form method="post" action="/login">
            <input type="email" placeholder="email" name="email">
            <input type="password" placeholder="password" name="password"></br>
            <input class="button" type="submit" value="login">
        </form>
    </div>
</body>
</html>
