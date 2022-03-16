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
                <a class="item-flex" href="../dept/company" >Trang chủ</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Đăng xuất</a>      
            </div>
        </div>
        <div class="h1-container"><h1 class="h1-content">Thêm đơn nợ cho công ty:</h1></div>

        <div>
            <div id="mySidebar" class="sidebar">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                <a href="home">Khách hàng</a>
                <a href="../dept/company">Đối tác</a>

            </div>
            <div id="main">
                <form action="../info/company">
                    <input type="hidden" name="cid" value="${requestScope.cid}"/>
                    <input type="submit" value="Trang trước"/>
                </form>
            </div>
            <div id="main">
                <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  

            </div>
        </div>
        <div class="error">
            <font class="outer-p">
            <h6>${requestScope.errorQuantity!=null?requestScope.errorQuantity:""}</h6>
            <h6>${requestScope.errorDiscount!=null?requestScope.errorDiscount:""}</h6>
            <h6>${requestScope.enternothing!=null?requestScope.enternothing:""}</h6>
            </font>
        
        
        </div>
        <div class="table-owe">
            
            <table border="1" >
                <div>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Mô tả</th>
                        <th>Số Lượng</th>
                        <th>discount(%)</th>
                    </tr>
                </div>
                <form action="add" method="POST">
                    <c:forEach items="${requestScope.products}" var="p">
                        <tr>
                            <td>${p.name}</td>
                            <td>${p.discription}</td>
                            <td><input type="number" name="quantity"/></td>
                            <td><input type="number" name="discount"/></td>
                        <input type="hidden" name="pid" value="${p.id}"/>
                        <input type="hidden" name="cost" value="${p.cost}"/>
                        <input type="hidden" name="name" value="${p.name}"/>
                        
                        </tr>
                    </c:forEach>
                    <tr>
                    <input type="hidden" name="cid" value="${requestScope.cid}"/>
                    <td colspan="4"> 
                        <input type="submit" value="Xác nhận"/>
                    </td>
                    </tr>
                </form>

            </table>


        </div>



    </body>
</html>
