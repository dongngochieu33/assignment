<%-- 
    Document   : company
    Created on : Mar 9, 2022, 4:05:58 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.CompanysOwe"%>
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
                <a class="item-flex" href="../dept/company" ">Trang chủ</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Đăng xuất</a>      
            </div>
        </div>
        <div class="h1-container"><h1 class="h1-content">Danh sách đối tác đang thiếu nợ</h1></div>
        
            <div>
                <div id="mySidebar" class="sidebar">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                    <a href="../dept/home">Khách hàng</a>
                    <a href="../dept/company">Đối tác</a>

                </div>
                <div id="main">
                <form action="../dept/company">
                    <input type="hidden"/>
                    <input type="submit" value="Trang trước"/>
                </form>
            </div>
                <div id="main">
                    <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  
                    
                </div>
            </div>
       
                <div class="table-owe">
                    <table border="1" >
                        <div>
                            <tr>
                                <th>Công ty</th>
                                <th>Email</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ</th>
                            </tr>
                        </div>
                        <tr>
                            <td>${requestScope.company.name}</td>
                            <td><a href="mailto: ${requestScope.company.email}">${requestScope.company.email}</a></td>
                            <td>${requestScope.company.phoneNumber}</td>
                            <td>${requestScope.company.address}</td>
                        </tr>
                        
                    </table>


                </div>
            

           
    </body>
</html>
