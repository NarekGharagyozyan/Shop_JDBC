<%@ page import="am.myOffice.shopJDBC.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/19/2023
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
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
            display: flex;
            flex-direction: column;
            align-items: center;
            background: #009579;
        }

        .main {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            margin: 30px 0;
            max-width: 60%;
            width: 100%;
        }

        .form {
            padding: 2rem;
            max-width: 400px;
            width: 100%;
            border-radius: 15px;
            background-color: #fff;
        }

        .button {
            color: #fff;
            background: #009579;
            font-size: 1.2rem;
            font-weight: 500;
            letter-spacing: 1px;
            margin-top: 1.7rem;
            cursor: pointer;
            transition: 0.4s;
        }

        .form input{
            height: 60px;
            margin: 0 auto 25px;
            width: 100%;
            padding: 0 15px;
            font-size: 17px;
            border: 1px solid #ddd;
            border-radius: 6px;
            outline: none;
        }
        .form input:focus{
            box-shadow: 0 1px 0 rgba(0,0,0,0.2);
        }
        .welcome {
            color: #fff;
            margin-top: 30px;
        }
        .error {
            color: darkred;
        }

        .table-wrapper{
            box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
            padding: 2px;
        }

        .fl-table {
            border-radius: 5px;
            font-size: 12px;
            font-weight: normal;
            border: none;
            border-collapse: collapse;
            width: 100%;
            max-width: 100%;
            white-space: nowrap;
            background-color: white;
            padding: 2px;
        }

        .fl-table td, .fl-table th {
            text-align: center;
            padding: 8px;
        }

        .fl-table td {
            border-right: 1px solid #f8f8f8;
            font-size: 12px;
            padding: 16px !important;
        }

        .fl-table thead th {
            color: #ffffff;
            background: #324960;
            padding: 12px !important;
        }


        .product_crud {
            max-width: 48%;
            width: 100%;
            justify-content: space-between;
        }

        .product_crud div {
            justify-content: space-between;
        }

        .crud_item {
            background-color: #fff;
            border-radius: 10px;
            padding: 25px 20px;
        }

        a {
            text-decoration: none;
            color: #006653;
        }
    </style>
</head>
<body>
    <h2>Home Page</h2>
    <h2 class="welcome" ><%= (String) request.getAttribute("email") != null ? "welcome dear " + request.getAttribute("email") : ""%></h2>
    <h5 class="error" ><%= (String) request.getAttribute("message") != null ?  request.getAttribute("message") : "" %></h5>

    <%
        List<Product> allProducts = (List<Product>) request.getAttribute("products");
        List<String> columns = (List<String>)request.getAttribute("columns");
    %>

        <div class="main">
            <div class="table-wrapper">
                <table class="fl-table">
                    <thead>
                    <tr>
                        <%
                            for (String column : columns) {
                        %>
                        <th>
                            <%=column%>
                        </th>
                        <%
                            }
                        %>
                    </tr>
                    </thead>
                    <tbody>
                    <%

                        for (Product pr: allProducts) {
                    %>
                    <tr>
                        <td><%= pr.getId() %></td>
                        <td><%= pr.getName() %></td>
                        <td><%= pr.getPrice() %></td>
                        <td><%= pr.getCategory() %></td>
                        <td><%= pr.isExists() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
            <div class="product_crud">
                <div style="display: flex">
                    <a href="CRUDProduct/createProduct.jsp"><div class="crud_item"><span>CREATE</span></div></a>
                    <a href="CRUDProduct/readProduct.jsp"><div class="crud_item"><span>READ</span></div></a>
                    <a href="CRUDProduct/updateProduct.jsp"><div class="crud_item"><span>UPDATE</span></div></a>
                    <a href="CRUDProduct/deleteProduct.jsp"><div class="crud_item"><span>DELETE</span></div></a>
                </div>
            </div>
        </div>




    <div>
        <form class="form" method="post" action="/change">
            <input type="hidden" name="email" value="<%= (String) request.getAttribute("email")%>">
            <input type="password" placeholder="Enter new password" name="newPassword">
            <input type="password" placeholder="Repeat password" name="repeatPassword">
            <input type="submit" class="button" >
        </form>
        <form action="/deleteAccount">
            <input type="hidden" name="email" value="<%= (String) request.getAttribute("email")%>">

            <input class="button" type="submit" value="Delete Account">
        </form>
    </div>

</body>
</html>
