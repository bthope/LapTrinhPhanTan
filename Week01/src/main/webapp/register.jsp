<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h1>Đăng ký</h1>
<form method="get" action="/hello-servlet" name="registrationForm">
    <label>Họ và tên</label> <br>
    <label>Họ</label>
    <input type="text" name="firstname" id="firstname">
    <label>Tên</label>
    <input type="text" name="lastname" id="lastname"> <br>

    <label>Tên người dùng</label> <br>
    <input type="text" name="username" id="username"> <br>

    <label>E-mail</label> <br>
    <input type="email" name="email" id="email"> <br>

    <label>Mật khẩu</label> <br>
    <input type="password" name="password" id="password"> <br>

    <label>Facebook</label> <br>
    <input type="text" name="facebook" id="facebook"> <br>
    <p>Nhập URL trang cá nhân Facebook của bạn</p>

    <label>Tiểu sử ngắn</label>
    <textarea name="shortbio"></textarea>
    <p>Nhập một tiểu sử ngắn gọn</p>

    <button type="submit">Đăng ký</button>
</form>
<br>
<a href="index.jsp">Quay lại Trang chủ</a>
</body>
</html>
