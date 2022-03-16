<%-- 
    Document   : home
    Created on : Mar 3, 2022, 3:16:23 PM
    Author     : ADMIN
--%>

<%@page import="model.CustomersOwe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="js/main.js" type="text/javascript"></script>


    </head>
    <body class="body-home">
        <div class="contain-flex"> 
            <div class="item-right">
                <a class="item-flex" href="dept/home" ">Trang chủ</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logoutdenied()">Đăng xuất</a>      
            </div>
        </div>
        <div class="h1-container"><h1 class="h1-content error">Bạn không được cấp quyền truy cập vào mục này, vui lòng quay trở lại trang chủ!</h1></div>
        
            <div>
                <div id="mySidebar" class="sidebar">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                    <a href="dept/home">Khách hàng</a>
                    <a href="dept/company">Đối tác</a>

                </div>

                <div id="main">
                    <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  
                    
                </div>
            </div>
           
       
    </body>
</html>
