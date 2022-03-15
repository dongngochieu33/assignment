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
        <%!int denhan = 0;%>
    </head>
    <body class="body-home">

        <div class="contain-flex"> 
            <div class="item-right">
                <a class="item-flex" href="../dept/company" ">Home</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Log out</a>      
            </div>
        </div>
        <div class="h1-container"><h1 class="h1-content">Danh đơn hành chưa thanh toán với công ty: ${requestScope.cname}</h1></div>

        <div>
            <div id="mySidebar" class="sidebar">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                <a href="../dept/home">Khách hàng</a>
                <a href="../dept/company">Đối tác</a>

            </div>

            <div id="main">
                <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  

            </div>
        </div>
        <div class="formDate">

            <div class="formDate-content">
                <form action="company"  method="POST">
                    <input type="hidden" value="${requestScope.cid}" name="cid" />
                    <input type="hidden" name="cname" value="${requestScope.cname}"/>
                    <input type="date" name="fromDate" value="${requestScope.fromDate}"/>
                    <input type="submit" value="Ket Qua"/>
                </form>


            </div>


        </div>
        <div class="formDate">

        </div>
        <div class="table-owe">
            <table border="1" >
                <div>
                    <tr>
                        <th>Ngày nhận hàng</th>
                        <th>Ngày đến hạn trả</th>
                        <th>Số tiền hàng</th>
                        <th>Số tiền đã trả</th>
                        <th>Số tiền còn thiếu</th>
                        <th></th>
                        <th></th>
                    </tr>
                </div>
                <%denhan = 0;%>
                <c:forEach items="${requestScope.companyOwes}" var="co">
                    <div>
                        <c:if test="${co.maturityDate <= requestScope.now}"><%denhan += 1;%></c:if>
                        <tr style="<c:if test="${co.maturityDate <= requestScope.now}">color: red;</c:if>">
                            <td>${co.orderDate}</td>
                            <td>${co.maturityDate}</td>
                            <td>${co.total} kVND</td>
                            <td>${co.paid} kVND</td>
                            <td>${co.total - co.paid} kVND</td>


                            <td>
                                <form action="company/detail" method="POST">
                                    <input type="hidden" value="${co.id}" name="orderSaleId"/>
                                    <input type="submit" value="Chi Tiết" class="buttonHome"/>
                                </form>
                            </td>

                            <td>

                                <form action="../pay/ordercompany" method="POST" id="deleteOrderHistory">
                                    <input type="hidden" value="${requestScope.cid}" name="cid" />
                                    <input type="hidden" value="${co.id}" name="orderSaleId"/>
                                     <input type="hidden" value="${co.total}" name="total"/>
                                     <input type="button" value="Xóa" class="buttonHome" onclick="deleteAllOrderHistory('deleteOrderHistory')"/>
                                </form>
                            </td>
                        </tr>

                    </div>              
                </c:forEach>
                <tr>
                    <td colspan="7"><div id="pagger"> </div></td>
                </tr>

            </table>


        </div>
        <script>
            paggerTotalCompanyOwe('pagger',${requestScope.pageindex},${requestScope.totalpage},${requestScope.cid}, '${requestScope.cname}', '${requestScope.fromDate}');
        </script> 
    </body>
</html>
