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
        <link href="../css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="../js/main.js" type="text/javascript"></script>


    </head>
    <body class="body-home">
        <div class="contain-flex"> 
            <div class="item-right">
                <a class="item-flex" href="../dept/home" ">Home</a>      
            </div>
            <div class="item-right">
                <a class="item-flex" href="#" onclick="logout()">Log out</a>      
            </div>
        </div>
        <div class="h1-container"><h1 class="h1-content">Danh sách khách hàng nợ tiền</h1></div>
        
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
                    <div class="formDate-content">
                        <%! float tong = 0;%>
                        <%for (CustomersOwe c : (ArrayList<CustomersOwe>) request.getAttribute("allCustomersOwe")) {
                                tong += c.getOwnMoney();
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
                                
                                <th>Tên</th>
                                <th>Xóm &nbsp
                                    <form action="home" method="POST" id="searchForm">
                                        <select name="addressid"  onchange="submitForm();">
                                            <option value="-1">Tất cả</option>
                                            <c:forEach items="${requestScope.allAddress}" var="ad">
                                                <option value="${ad.id}" ${(requestScope.addressid == ad.id)?"selected":""}  >${ad.xom}</option>
                                            </c:forEach>
                                        </select>
                                    </form>
                                </th>
                                <th>Nợ</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </div>
                        <c:forEach items="${requestScope.allCustomersOwe}" var="aco">
                            <div>
                                <tr>
                                    <td><a href="../info/infocustomer?id=${aco.cus.cid}" class="customer">${aco.cus.firstName}</a> <a href="../info/infocustomer?id=${aco.cus.cid}" class="customer">${aco.cus.lastName}</a></td>
                                    <td>${aco.add.xom}</td>
                                    <td>

                                        ${(aco.ownMoney)}k VND

                                    </td>
                                    <td>
                                        <form action="../info/customer" method="POST">
                                            <input type="hidden" name="cusId" value="${aco.cus.cid}"/>
                                            <input type="hidden" name="cusName" value="${aco.cus.firstName} ${aco.cus.lastName}"/>
                                            <input type="submit" value="Chi Tiết" class="buttonHome"/>
                                        </form>
                                    </td>

                                    <td>

                                        <form action="../pay/manyorder" method="POST" id="deleteSaleHistory">
                                            <input type="hidden" value="${aco.cus.cid}" name="cid"/>
                                            <input type="submit" value="Xóa" class="buttonHome" onclick="deleteAllOrder('deleteSaleHistory')"/>
                                        </form>
                                    </td>
                                </tr>
                            </div>              
                        </c:forEach>

                        <tr>
                            <td colspan="6"><div id="pagger"> </div></td>
                        </tr>
                    </table>


                </div>
            

 


        <script>
            paggerHome('pagger',${requestScope.pageindex},${requestScope.totalpage},${requestScope.addressid});
        </script>
    </body>
</html>
