<%-- 
    Document   : saleDetail
    Created on : Mar 10, 2022, 10:32:10 AM
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
        <link href="../../css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/main.js" type="text/javascript"></script>
        <%! float tong = 0;  %>
    </head>
    <body class="body-home">
    
         <div class="contain-flex"> 
            <div class="item-right">
                <a class="item-flex" href="../../dept/home" ">Home</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Log out</a>      
            </div>
        </div>
        

        <div class="h1-container">
            <h1 class="h1-content">Chi tiết đơn hàng</h1>
        </div>

        <div class="table-owe">
            <table border="1" >
                <div>
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Chi tiết</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Chiết khấu</th>
                        <th>Thành Tiền</th>



                    </tr>
                </div>
                <c:forEach items="${requestScope.saleDetail}" var="sd">
                    <div>
                        <tr>
                            <td>${sd.pro.name}</td>
                            <td>${sd.pro.discription}</td>
                            <td>${sd.pro.price*1000} VND</td>
                            <td>${sd.quantity} </td>
                            <td>${sd.discount} %</td>
                            <td>${1000*(sd.quantity*sd.pro.price - sd.pro.price*sd.discount)} VND</td>
                        </tr>
                    </div>       
                    
                </c:forEach>
                        
<!--                        <tr>
                            <td colspan="5">Tổng tiền</td>
                            <td id="tong"></td>
                        </tr>-->
                <tr>
                    <td colspan="6"><div id="pagger"> </div></td>
                </tr>
            </table>



        </div>

        <script>
            paggerSaleDetail('pagger',${requestScope.pageindex},${requestScope.totalpage},${requestScope.saleHistoryId});
        </script>     

    </body>
</html>
