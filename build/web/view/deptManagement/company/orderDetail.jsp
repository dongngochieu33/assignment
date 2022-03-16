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
        <link href="../../css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/main.js" type="text/javascript"></script>
       
    </head>
    <body class="body-home">

        <div class="contain-flex"> 
            <div class="item-right">
                <a class="item-flex" href="../../dept/company" ">Trang chủ</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout2()">Đăng xuất</a>      
            </div>
        </div>
        <div class="h1-container"><h1 class="h1-content">Chi tiết đơn hàng</h1></div>

        <div>
            <div id="mySidebar" class="sidebar">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                <a href="../../dept/home">Khách hàng</a>
                <a href="../../dept/company">Đối tác</a>

            </div>
            
             <div id="main">
                <form action="../company">
                    <input type="hidden" name="cid" value="${requestScope.cid}"/>
                    <input type="submit" value="Trang trước"/>
                </form>
            </div>
            <div id="main">
                <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  

            </div>
        </div>
        
        <div class="formDate">

        </div>
        <div class="table-owe">
            <table border="1" >
                <div>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Mô tả sản phẩm</th>
                        <th>Giá</th>
                        <th>Chiết khấu</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                    </tr>
                </div>
           
                <c:forEach items="${requestScope.orderDetail}" var="od">
                    <div>
                        <tr>
                            <td>${od.product.name}</td>
                            <td>${od.product.discription}</td>
                            <td>${od.product.cost}</td>
                            <td>${od.discount}</td>
                            <td>${od.quantity}</td>
                            <td>${od.total}  kVND</td>
                        </tr>
                    </div>              
                </c:forEach>
                <tr>
                    <td colspan="7"><div id="pagger"> </div></td>
                </tr>

            </table>


        </div>
        <script>
            paggerTotalDetailCompanyOwe('pagger',${requestScope.pageindex},${requestScope.totalpage},${requestScope.orderSaleId});
        </script> 
    </body>
</html>
