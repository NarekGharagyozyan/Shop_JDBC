<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/19/2023
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <style>
    .product_crud {
      margin: 60px auto;
      max-width: 40%;
      width: 100%;
    }

    .product_crud div {
      justify-content: space-between;
    }

    .crud_item {
      border: 1px solid #222;
      padding: 25px 20px;
    }

    /* Import Google font - Poppins */
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
    *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }
    body{
      min-height: 100vh;
      width: 100%;
      flex-direction: column;
      display: flex;
      justify-content: center;
      align-items: center;
      background: #009579;
    }
    .container{
      max-width: 430px;
      width: 100%;
      background: #fff;
      border-radius: 7px;
      box-shadow: 0 5px 10px rgba(0,0,0,0.3);
    }
    .container .form{
      padding: 2rem;
    }
    .form header{
      font-size: 2rem;
      font-weight: 500;
      text-align: center;
      margin-bottom: 1.5rem;
    }
    .form input{
      height: 60px;
      width: 100%;
      padding: 0 15px;
      font-size: 17px;
      margin-bottom: 1.3rem;
      border: 1px solid #ddd;
      border-radius: 6px;
      outline: none;
    }
    .form input:focus{
      box-shadow: 0 1px 0 rgba(0,0,0,0.2);
    }
    .form a{
      font-size: 16px;
      color: #009579;
      text-decoration: none;
    }
    .form a:hover{
      text-decoration: underline;
    }
    .form input.button{
      color: #fff;
      background: #009579;
      font-size: 1.2rem;
      font-weight: 500;
      letter-spacing: 1px;
      margin-top: 1.7rem;
      cursor: pointer;
      transition: 0.4s;
    }
    .form input.button:hover{
      background: #006653;
    }
    .signup{
      font-size: 17px;
      text-align: center;
    }
    .signup label{
      color: #009579;
      cursor: pointer;
    }
    .signup label:hover{
      text-decoration: underline;
    }

  </style>
</head>
<body>

  <%--<div class="main">
    &lt;%&ndash;<div class="lr">
      <h1>Login</h1>
      <form method="post" action="/login">
        <input type="text" placeholder="email" name="email">
        <input type="password" placeholder="password" name="password"></br>
        <input class="button" type="submit" value="login">
      </form>
    </div>&ndash;%&gt;
    <div>
      <a class="button" href="login.jsp">Login</a>
      <a class="button" href="register.jsp">Register</a>
    </div>
    &lt;%&ndash;<div class="lr">
      <h1>Register</h1>
      <form method="post" action="/register">
        <input type="text" placeholder="name" name="name">
        <input type="text" placeholder="lastname" name="lastname"></br>
        <input type="text" placeholder="balance" name="balance">
        <input type="email" placeholder="email" name="email"></br>
        <input type="password" placeholder="password" name="password">
        <input type="text" placeholder="age" name="age"></br>
        <input type="submit" value="register">
      </form>
    </div>&ndash;%&gt;
  </div>
  <div class="product_crud">
    <h1>Product CRUD</h1>
    <div style="display: flex">
      <a href="CRUDProduct/createProduct.html"><div class="crud_item"><span>CREATE</span></div></a>
      <a href="CRUDProduct/readProduct.jsp"><div class="crud_item"><span>READ</span></div></a>
      <a href="CRUDProduct/updateProduct.jsp"><div class="crud_item"><span>UPDATE</span></div></a>
      <a href="CRUDProduct/deleteProduct.jsp"><div class="crud_item"><span>DELETE</span></div></a>
    </div>
  </div>--%>

  <%= (String) request.getAttribute("message") != null ?  request.getAttribute("message") : "" %>
  <%= (String) request.getAttribute("product") != null ?  request.getAttribute("product") : "" %>

  <div class="container">
    <div class="login form">
      <header>Login</header>
      <form method="post" action="/login">
        <input type="email" placeholder="Enter your email" name="email">
        <input type="password" placeholder="Enter your password" name="password">
        <input type="submit" class="button" value="login">
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
         <a href="register.jsp">Signup</a>
        </span>
      </div>
    </div>
  </div>
  <%--<div class="product_crud">
    <h3>Product CRUD</h3>
    <div style="display: flex">
      <a href="CRUDProduct/createProduct.html"><div class="crud_item"><span>CREATE</span></div></a>
      <a href="CRUDProduct/readProduct.jsp"><div class="crud_item"><span>READ</span></div></a>
      <a href="CRUDProduct/updateProduct.jsp"><div class="crud_item"><span>UPDATE</span></div></a>
      <a href="CRUDProduct/deleteProduct.jsp"><div class="crud_item"><span>DELETE</span></div></a>
    </div>
  </div>--%>

</body>
</html>
