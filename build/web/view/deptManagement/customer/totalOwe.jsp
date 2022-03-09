<%-- 
    Document   : totalOwe
    Created on : Mar 9, 2022, 5:37:11 PM
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


        <div class="h1-container">
            <h1 class="h1-content">Danh sách đơn nợ tiền của khách hàng: ${requestScope.oneCustomerOwe.get(0).cus.firstName } ${requestScope.oneCustomerOwe.get(0).cus.lastName}</h1>
        </div>
        <div class="formDate">
            <form class="formDate-content" method="POST">
                <input type="hidden" value="${requestScope.cusId}" name="cusId" />
                <input type="date" name="fromDate" value="${requestScope.fromDate}"/>
                <input type="submit" value="Ket Qua"/>
            </form>
            
        </div>
        <div class="table-owe">
                <table border="1" >
                    <div>
                        <tr>
                            <th>Họ</th>
                            <th>Tên</th>
                            <th>Ngày mua</th>
                            <th>Tiền phải trả</th>
                            <th>Tiền đã trả</th>
                            <th>Nợ</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </div>
                    <c:forEach items="${requestScope.oneCustomerOwe}" var="aco">
                        <div>
                            <tr>
                                <td>${aco.cus.firstName}</td>
                                <td>${aco.cus.lastName}</td>
                                <td>${aco.saleHistory.date}</td>
                                <td>${aco.saleHistory.total * 1000} VND</td>
                                <td>${aco.saleHistory.paid * 1000} VND</td>
                                <td>${aco.saleHistory.total * 1000 - aco.saleHistory.paid * 1000} VND</td>

                                <td>
                                    <form action="../info/customer?cusId=${aco.cus.cid}" method="POST">
                                        <input type="submit" value="Chi Tiết" class="buttonHome"/>
                                    </form>
                                </td>

                                <td>
                                    <form action="#" method="POST">
                                        <input type="submit" value="Xóa" class="buttonHome"/>
                                    </form>
                                </td>
                            </tr>
                        </div>            
                    </c:forEach>

                    <tr>
                        <td colspan="8"><div id="pagger"> </div></td>
                    </tr>
                </table>

            

        </div>

        <script>
            paggerTotalOwe('pagger',${requestScope.pageindex},${requestScope.totalpage},${requestScope.cus.cid});
        </script>     

    </body>
</html>
