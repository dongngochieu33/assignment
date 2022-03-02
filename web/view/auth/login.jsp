<%-- 
    Document   : login
    Created on : Mar 2, 2022, 9:44:18 PM
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
        <link href="css/loginCss.css" rel="stylesheet" type="text/css"/>
        <script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="contain-flex">      
            <div class="item-right">
                <a class="item-flex" href="#" onclick="login()">Log in</a>      
            </div>
        </div>
    <c:if test="${requestScope.loginFailed != null}">
        <script>
            login();
        </script>
    </c:if>

    <div class="form-container" id="form-container">
        <form action="login" method="POST" class="form">
            <div class="form-row-center">
                <h1 class="Web-name">Debt Management</h1>
            </div>
            <div class="form-row">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-input" name="username" id="username" />
            </div>
            <div class="form-row">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-input" name="password" id="password" />
            </div>
            <div class="form-row">
                <input type="submit" value="Login" class="login">
            </div>
            <c:if test="${requestScope.loginFailed != null}">
                <script>
                    login();
                </script>
                <p class="error">${requestScope.loginFailed}</p>
            </c:if>
        </form>
    </div>

</body>
</html>
