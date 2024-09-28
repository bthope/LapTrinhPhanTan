<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        .product-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-top: 20px;
        }
        .product-card img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }
        .product-title {
            font-size: 1.5rem;
            font-weight: bold;
            margin-top: 10px;
        }
        .product-price {
            color: #333;
            margin: 10px 0;
        }
        .total-price {
            font-weight: bold;
            color: #d9534f; /* Màu đỏ cho tổng giá */
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Chi tiết sản phẩm</h2>
    <div class="product-card">
        <img src="${productDetail.product.urlImg}" alt="${productDetail.product.productName}">
        <div class="product-title">${productDetail.product.productName}</div>
        <div class="product-price">Giá: ${productDetail.product.price} VNĐ</div>
        <div>Số lượng đã thêm: ${productDetail.quantity}</div>
        <div class="total-price">Tổng: ${productDetail.total} VNĐ</div>
        <a href="${pageContext.request.contextPath}/ViewProductCtrl" class="btn btn-primary">Quay lại danh sách sản phẩm</a>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
