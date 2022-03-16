<%-- 
    Document   : info
    Created on : Mar 13, 2022, 2:29:58 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="../js/main.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body class="body-home">
        <div class="contain-flex"> 
            <div class="item-right">
                <a class="item-flex" href="../dept/home" >Trang chủ</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Đăng xuất</a>      
            </div>
        </div>
         <div class="h1-container">
            <h1 class="h1-content">Thông tin của khách hàng: ${requestScope.cusInfo.firstName} ${requestScope.cusInfo.lastName} </h1>
            
        </div>
            <div>
                <div id="mySidebar" class="sidebar">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                    <a href="../dept/home">Khách hàng</a>
                    <a href="../dept/company">Đối tác</a>

                </div>
                <form action="../dept/home">
                    <input type="hidden"/>
                    <input type="submit" value="Trang trước"/>
                </form>
                <div id="main">
                    <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  
                    
                </div>
            </div>
           
        <div class="table-owe">
            <table border="1" >
                <div>
                    <tr>
                        <th>Họ</th>
                        <th>Tên</th>
                        <th>Số điện thoại</th>
                        <th>Xóm</th>
                        <th>Giới tính</th>

                    </tr>
                    <tr>
                        <td>${requestScope.cusInfo.firstName}</td>
                        <td> ${requestScope.cusInfo.lastName}</td>
                        <td> ${requestScope.cusInfo.phoneNumber}</td>
                        <td> ${requestScope.cusInfo.address.xom}</td>
                        <td>
                            <c:if test="${requestScope.cusInfo.gender}">Nam</c:if>
                            <c:if test="${!requestScope.cusInfo.gender}">Nữ</c:if>
                        </td>
                           
                    </tr>
                </div>
                
               
            </table>
    </body>
</html>
