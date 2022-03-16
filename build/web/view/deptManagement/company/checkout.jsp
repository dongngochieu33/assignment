<%-- 
    Document   : company
    Created on : Mar 9, 2022, 4:05:58 PM
    Author     : ADMIN
--%>

<%@page import="java.lang.Integer"%>
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
        <%! float tong = 0;%>
        <%
            tong = 0;
            ArrayList<Integer> quantitys = (ArrayList<Integer>) request.getAttribute("quantitys");
            ArrayList<Float> costs = (ArrayList<Float>) request.getAttribute("costs");
            ArrayList<Float> discounts = (ArrayList<Float>) request.getAttribute("discounts");
            for (int i = 0; i < quantitys.size(); i++) {
                tong += quantitys.get(i) * costs.get(i) * (1 - discounts.get(i) * 0.01);
            }
        %>
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
        <div class="h1-container"><h1 class="h1-content">Thêm đơn nợ cho công ty:</h1></div>

        <div>
            <div id="mySidebar" class="sidebar">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                <a href="home">Khách hàng</a>
                <a href="../dept/company">Đối tác</a>

            </div>
                        <div id="main">
                            <form action="add" method="GET">
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
            <!-- for error -->
            </font>


        </div>
         <div class="error">
            <font class="outer-p">
            <h6>${requestScope.maturityDate_error!=null?requestScope.maturityDate_error:""}</h6>
            <h6>${requestScope.paid_error!=null?requestScope.paid_error:""}</h6>
  
            </font>
        
        
        </div>
        <div class="table-owe">

            <table border="1" >
                <div>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Giá</th>
                        <th>Số Lượng</th>
                        <th>Discount(%)</th>
                        <th>Thành tiền</th>
                    </tr>
                </div>
                <form action="checkout" method="POST">

                    <c:forEach begin="0" end="${requestScope.pids.size()-1}"var="i">
                        <tr>
                            <td>${requestScope.names.get(i)}</td>
                            <td>${requestScope.costs.get(i)} kVND</td>
                            <td>${requestScope.quantitys.get(i)}</td>
                            <td>${requestScope.discounts.get(i)}</td>
                            <td>${requestScope.quantitys.get(i)*requestScope.costs.get(i)*(1-requestScope.discounts.get(i)/100)} kVND</td>
                        <input type="hidden" value="${requestScope.pids.get(i)}" name="pid"/>
                        <input type="hidden" value="${requestScope.quantitys.get(i)}" name="quantity"/>
                        <input type="hidden" value="${requestScope.discounts.get(i)}" name="discount"/>
                        <input type="hidden" value="${requestScope.names.get(i)}" name="name"/>
                        <input type="hidden" value="${requestScope.costs.get(i)}" name="cost"/>

                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4">Tổng Tiền</td>
                        <td colspan="1"><%=tong + " kVND"%></td>

                    </tr>

            </table>
        </div>
        <div class="Box-end">
            <div class="Box-end-content">
                <table class="add" >
                    <tr>
                        <td> Số tiền đã thanh toán(kVND)</td>
                        <td><input type="text" name="paid" value="${requestScope.paid != null ?requestScope.paid:""}"/> </td>
                    </tr>
                    <tr>
                        <td>Hạn thanh toán </td>
                        <td><input type="date" name="maturityDate" value="${requestScope.maturityDate != null ?requestScope.maturityDate:""}"/></td>
                    </tr>
                    <tr><td colspan="3"><input type="submit" value="Lưu"/></td></tr>
                </table>
                <input type="hidden" value="<%=tong%>" name="total"/>
                <input type="hidden" value="${requestScope.cid}" name="cid"/>
                </form>
            </div>
        </div>


    </body>
</html>
