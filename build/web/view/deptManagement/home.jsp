<%-- 
    Document   : home
    Created on : Mar 3, 2022, 3:16:23 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="../css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="../js/main.js" type="text/javascript"></script>
    </head>
    <body class="body-home">
         <div class="contain-flex">      
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Log out</a>      
            </div>
        </div>
        <div>
            <table border="1">
                <div>
                    <tr>
                        <td>Họ</td>
                        <td>Tên</td>
                        <td>Xóm</td>
                        <td>Nợ</td>
                        <td></td>
                        <td></td>
                    </tr>
                </div>
                <c:forEach items="${requestScope.allCustomersOwe}" var="aco">
                    <div>
                    <tr>
                        <td>${aco.cus.firstName}</td>
                        <td>${aco.cus.lastName}</td>
                        <td>${aco.add.xom}</td>
                        <td>${aco.ownMoney * 1000} VND</td>
                        <td><a href="customer/detail">Chi Tiết</a></td>
                        <td><a href="#">Xóa</a></td>
                    </tr>
                </div>              
                </c:forEach>
                
                
            </table>
            
            
        </div>
    </body>
</html>
