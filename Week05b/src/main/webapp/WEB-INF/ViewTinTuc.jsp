<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: BANG
  Date: 9/28/2024
  Time: 2:32 PM
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Tin Tuc</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <!-- Header with an image -->
    <div class="header text-center">
        <img src="https://cdn0.fahasa.com/media/wysiwyg/Thang-09-2024/AlphaBooks_Silver_Header_1263x60.jpg" class="img-responsive" alt="Banner" style="margin: 20px auto;">
    </div>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li><a href="#">Danh sách tin tức</a></li>
                <li><a href="#">Thêm tin tức mới</a></li>
                <li><a href="#">Chức năng quản lý</a></li>
            </ul>
        </div>
    </nav>

    <!-- Content Section -->
    <div class="content">
        <h2 class="text-center">Danh Sách Tin Tức</h2>
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Mã Tin Tức</th>
                <th scope="col">Tiêu Đề</th>
                <th scope="col">Nội Dung Tin Tức</th>
                <th scope="col">Danh Mục</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listTinTucs}" var="tintuc">
                <tr>
                    <td>${tintuc.maTT}</td>
                    <td>${tintuc.tieuDe}</td>
                    <td>${tintuc.noiDungTT}</td>
                    <td>${tintuc.danhMuc.maDM}</td>
                    <td>
                        <a href="/DelTinTucCtrl?maTT=${tintuc.maTT}"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

            <form method="post" action="/AddTinTucCtrl">
                <td><input style="width: 100px" type="text" name="maTT"></td>
                <td><input style="width: 200px" type="text" name="tieuDe"></td>
                <td><input style="width: 200px" type="text" name="noiDungTT"></td>
                <td>
                    <select style="width: 100px"  name="maDM">
                       <c:forEach items="${danhMucId}" var="danhmuc">
                           <option value="${danhmuc}">${danhmuc}</option>
                       </c:forEach>
                    </select>
                </td>

                <td>
                    <input class="btn-success" type="submit" value="Create"></input>
                </td>
            </form>
        </table>
    </div>

    <!-- Footer Section -->
    <div class="footer text-center" style="margin: 20px 0;">
        <b>Lê Hữu Bằng - 20049601 - DHKTPM16A</b>
    </div>
</div>
</body>
</html>
