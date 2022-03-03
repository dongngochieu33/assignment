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
    <body class="body-login">

        <div class="contain-flex">      
            <div class="item-right">
                <a class="item-flex" href="#" onclick="login()">Đăng nhập</a>      
            </div>
        </div>
         <div id="slogan"><h1>Tra Tien Day</h1></div>
    <c:if test="${requestScope.loginFailed != null}">
        <script>
            login();
        </script>
    </c:if>
        
    <div class="form-container" id="form-container">
        <form action="login" method="POST" class="form">
            <div class="form-row-center">
                <h1 class="Web-name">Quản lý nợ</h1>
            </div>
            <div class="form-row">
                <label for="username" class="form-label">Tài khoản</label>
                <input type="text" class="form-input" name="username" id="username" />
            </div>
            <div class="form-row">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-input" name="password" id="password" />
            </div>
            <div class="form-row">
                <input type="submit" value="Đăng nhập" class="login">
            </div>
            <c:if test="${requestScope.loginFailed != null}">
                <script>
                    login();
                </script>
                <p class="error">${requestScope.loginFailed}</p>
            </c:if>
        </form>
    </div>
        <div class="feature-layout">
        <div class="feature-item first-item">
            <h2 class="feature-h2">Tại sao nên dùng trang web này?</h2>
            <p class="feature-p">Chúng tôi cung cấp công nghệ tính toán tự động chính xác hàng đầu thế giới. 
            Giúp bạn dễ dàng quản lý các nguồn tiền của mình</p>
        </div >
        <div class="feature-item second-item">
            <h2 class="feature-h2">Có phải trả phí để sử dụng dịch vụ không?</h2>
            <p class="feature-p">Câu trả lời là hoàn toàn miễn phí</p>
        </div>
        <div class="feature-item third-item">
            <h2 class="feature-h2">Cách để tôi có tài khoản riêng cho mình</h2>
            <p class="feature-p">Hãy liên hệ tới email:<a href="mailto: hieudnhe153007@fptt.edu.vn">hieudnhe153007@fptt.edu.vn</a>  để quản trị viên cấp tài khoản cho bạn</p>
        </div>

    </div>

</body>
</html>
