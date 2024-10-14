    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--
      Created by IntelliJ IDEA.
      User: BANG
      Date: 10/14/2024
      Time: 4:14 PM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Them Dien Thoai Moi</title>
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
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li><a href="/ViewDienThoaiCtrl">Danh sách điện thoại</a></li>
                    <li><a href="/AddDienThoaiCtrl">Thêm điện thoại mới</a></li>
                    <li><a href="#">Cập nhật điện thoại mới</a></li>
                </ul>
            </div>
        </nav>

        <div class="content">
            <h2 class="text-center">Danh Sách Điện Thoại</h2>
            <table class="table table-bordered table-hover">
                <thead class="table-hover">
                <tr>
                    <th scope="col">Mã điện thoại</th>
                    <th scope="col">Tên điện thoại</th>
                    <th scope="col">Năm sản xuất</th>
                    <th scope="col">Cấu hình</th>
                    <th scope="col">Tên nhà cung cấp</th>
                </tr>
                </thead>
                <form method="post" action="${pageContext.request.contextPath}/AddDienThoaiCtrl">
                    <td><input style="width: 100px" type="text" name="MaDT"></td>
                    <td><input style="width: 200px" type="text" name="TenDT"></td>
                    <td><input style="width: 100px" type="text" name="namSX"></td>
                    <td><input style="width: 200px" type="text" name="cauhinh"></td>
                    <td>
                        <select style="width: 100px" name="maNCC">
                            <c:forEach items="${nhaCungCapName}" var="nhacungcap">
                                <option value="${nhacungcap}">${nhacungcap}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input class="btn-success" type="submit" value="Create"></input>
                    </td>
                </form>


            </table>
        </div>

        <div class="footer text-center" style="margin: 20px 0;">
            <b>Lê Hữu Bằng - 20049601 - DHKTPM16A</b>
        </div>
    </div>
    </body>
    </html>
