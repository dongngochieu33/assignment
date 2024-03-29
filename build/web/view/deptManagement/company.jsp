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
                    <a href="home">Khách hàng</a>
                    <a href="../dept/company">Đối tác</a>

                </div>

                <div id="main">
                    <button class="openbtn" onclick="openNav()">☰ Tùy Chọn</button>  
                    
                </div>
            </div>
        <div class="formDate">
                    <div class="formDate-content-cus">
                        <%! double tong = 0;%>
                        <%for (CompanysOwe c : (ArrayList<CompanysOwe>) request.getAttribute("allCompanyOwe")) {
                                tong += c.getOweMoney();
                            }
                        %>
                        <%="Tổng tiền khách hàng nợ: " + tong + "k VND"%>
                        <%tong = 0; %>
                    </div>
                </div>
                <div class="table-owe">
                    <table border="1" >
                        <div>
                            <tr>
                                <th>Công ty</th>
                                <th>Tiền chưa thanh toán</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </div>
                        <c:forEach items="${requestScope.allCompanyOwe}" var="aco">
                            <div>
                                <tr>
                                    
                                    <td><a href="../info/infocompany?id=${aco.company.id}" class="customer">${aco.company.name}</a></td>
                                    <td>${aco.oweMoney} k VND </td>
                                    
                                    <td>
                                        <form action="../info/company" method="POST">
                                            <input type="hidden" name="cid" value="${aco.company.id}"/>
                                            <input type="hidden" name="cname" value="${aco.company.name}"/>
                                            <input type="submit" value="Chi Tiết" class="buttonHome"/>
                                        </form>
                                    </td>

                                    <td>

                                        <form action="../pay/manyordercompany" method="POST" id="CompanyOrder${aco.company.id}">
                                            <input type="hidden" value="${aco.company.id}" name="cid"/>
                                            <input type="button" value="Xóa" class="buttonHome" onclick=" deleteAllOrderCompany('CompanyOrder${aco.company.id}','${aco.company.name}')"/>
                                        </form>
                                    </td>
                                </tr>
                            </div>              
                        </c:forEach>

                        
                    </table>


                </div>
            

           
    </body>
</html>
