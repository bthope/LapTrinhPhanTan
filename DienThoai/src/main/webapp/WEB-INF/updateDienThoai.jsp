<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cập Nhật Điện Thoại</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa; /* Nền sáng */
        }
        .container {
            margin-top: 50px; /* Khoảng cách phía trên */
            padding: 30px; /* Padding bên trong */
            background-color: #ffffff; /* Nền trắng */
            border-radius: 8px; /* Bo tròn các góc */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Hiệu ứng đổ bóng */
        }
        h2 {
            text-align: center; /* Căn giữa tiêu đề */
            color: #333; /* Màu chữ tiêu đề */
            margin-bottom: 30px; /* Khoảng cách phía dưới tiêu đề */
        }
        .btn {
            width: 100%; /* Chiều rộng 100% cho nút */
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Cập Nhật Thông Tin Điện Thoại</h2>
    <form action="/UpdateDienThoaiCtrl" method="post">
        <input type="hidden" name="maDT" value="${dienThoai.maDT}">

        <div class="form-group">
            <label for="tenDT">Tên Điện Thoại:</label>
            <input type="text" class="form-control" id="tenDT" name="tenDT" value="${dienThoai.tenDT}" required>
        </div>

        <div class="form-group">
            <label for="namSX">Năm Sản Xuất:</label>
            <input type="text" class="form-control" id="namSX" name="namSX" value="${dienThoai.namSX}" required>
        </div>

        <div class="form-group">
            <label for="cauhinh">Cấu Hình:</label>
            <input type="text" class="form-control" id="cauhinh" name="cauhinh" value="${dienThoai.cauhinh}" required>
        </div>

        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="/ViewDienThoaiCtrl" class="btn btn-default">Hủy</a>
    </form>
</div>
</body>
</html>
