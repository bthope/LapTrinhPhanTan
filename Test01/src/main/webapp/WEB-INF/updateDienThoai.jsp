<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cập Nhật Điện Thoại</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2 class="text-center">Cập Nhật Thông Tin Điện Thoại</h2>
    <form action="/UpdateDienThoaiCtrl" method="post">

        <input type="hidden" name="maDT" value="${dienThoai.maDT}">


        <div class="form-group">
            <label for="tenDT">Tên Điện Thoại</label>
            <input type="text" class="form-control" id="tenDT" name="tenDT" value="${dienThoai.tenDT}">
        </div>

        <div class="form-group">
            <label for="namSX">Năm Sản Xuất</label>
            <input type="text" class="form-control" id="namSX" name="namSX" value="${dienThoai.namSX}">
        </div>

        <div class="form-group">
            <label for="cauHinh">Cấu Hình</label>
            <input type="text" class="form-control" id="cauHinh" name="cauHinh" value="${dienThoai.cauHinh}">
        </div>

        <div class="form-group">
            <label for="maNCC">Nhà Cung Cấp</label>
            <select class="form-control" name="maNCC" id="maNCC" required>
                <c:forEach items="${nhaCungCaps}" var="nhacungcap">
                    <option value="${nhacungcap.maNCC}" ${nhacungcap.maNCC == selectedNCC ? 'selected' : ''}>
                            ${nhacungcap.maNCC} - ${nhacungcap.tenNCC}
                    </option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <a href="/ViewDienThoaiCtrl" class="btn btn-default">Hủy</a>

    </form>
</div>
</body>
</html>
