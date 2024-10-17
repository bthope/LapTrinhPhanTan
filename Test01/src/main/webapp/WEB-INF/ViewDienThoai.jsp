<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BANG
  Date: 10/15/2024
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Dien Thoai</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
        <div class="header text-center">
            <img src="https://cdnv2.tgdd.vn/mwg-static/tgdd/Banner/7c/5c/7c5c96fcd17567b9e98bd0ae4bd240d4.jpg" class="img-responsive" alt="Banner" style="margin: 20px auto">
        </div>

        <nav class="navbar navbar-default">
            <div class="container-fluid text-center">
                <ul class="nav navbar-nav center-block">
                    <li><a href="/ViewDienThoaiCtrl">Danh Sách Điện Thoại</a></li>
                    <li><a href="/AddDienThoaiCtrl">Thêm Điện Thoại Mới</a></li>
                    <li><a href="#">Quản Lý Thông Tin</a></li>
                </ul>
            </div>
        </nav>

        <div class="content" style="margin: 20px 0;">
            <h2 class="text-center">Danh sách điện thoại</h2>
            <table class="table table-bordered table-hover text-center">
                <thead class="table-hover text-center">
                    <tr class="text-center">
                        <th scope="col">Mã điện thoại</th>
                        <th scope="col">Tên điện thoại</th>
                        <th scope="col">Năm sản xuất</th>
                        <th scope="col">Cấu hình</th>
                        <th scope="col">Tên nhà cung cấp</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dienThoais}" var="dienthoai">
                        <tr>
                            <td>${dienthoai.maDT}</td>
                            <td>${dienthoai.tenDT}</td>
                            <td>${dienthoai.namSX}</td>
                            <td>${dienthoai.cauHinh}</td>
                            <td>${dienthoai.nhaCungCap.tenNCC}</td>
                            <td>
                                <a href="/DelDienThoaiCtrl?maDT=${dienthoai.maDT}"><i class="fas fa-trash-alt"></i></a>
                            </td>
                            <td>
                                <a href="/UpdateDienThoaiCtrl?maDT=${dienthoai.maDT}"><i class="fas fa-edit"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="footer text-center">
            <b>Lê Hữu Bằng - 20049601 - DHKTPM16A</b>
        </div>
    </div>
</body>
</html>
