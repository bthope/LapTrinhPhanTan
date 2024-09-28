<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BANG
  Date: 9/28/2024
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Giang Vien</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Faculty</th>
                    <th scope="col">FullName</th>
                    <th scope="col">Research Area</th>
                    <th scope="col">Telephone Number</th>
                    <th scope="col"></th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listGiangViens}" var="giangvien">
                    <tr>
                        <td>${giangvien.maGV}</td>
                        <td>${giangvien.tenGV}</td>
                        <td>${giangvien.linhVuNghienCuu}</td>
                        <td>${giangvien.soDT}</td>
                        <td>
                            <a href="/DelGiangVienCtl?maGV=${giangvien.maGV}"><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <form action="/AddGiangVienCtrl" method="get">
                        <td><input style="width: 100px" type="text" name="maGV"></td>
                        <td><input style="width: 100px" type="text" name="tenGV"></td>
                        <td><input style="width: 200px" type="text" name="linhVuNghienCuu"></td>
                        <td><input style="width: 100px" type="text" name="soDT"></td>
                        <td>
                            <input class="btn-success" type="submit" value="Create">
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
