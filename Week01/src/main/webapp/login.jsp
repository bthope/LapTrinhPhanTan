<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form method="post" action="/login-servlet">
    <label>Tên người dùng</label> <br>
    <input type="text" name="username" id="username" required> <br>

    <label>Mật khẩu</label> <br>
    <input type="password" name="password" id="password" required> <br>

    <button type="submit">Đăng nhập</button>
</form>
<br>
<a href="index.jsp">Quay lại Trang chủ</a>
</body>
</html>
