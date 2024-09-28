<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        .product-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px;
            text-align: center;
        }
        .product-card img {
            max-width: 100%;
            height: auto;
        }
        .product-title {
            font-weight: bold;
            margin-top: 10px;
        }
        .product-price {
            color: #333;
            margin: 10px 0;
        }
        .product-quantity {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 style="text-align: center;">Danh sách sản phẩm</h2>
    <div class="row">
        <c:forEach items="${listProduct}" var="product">
            <div class="col-sm-4">
                <div class="product-card">
                    <img src="${product.urlImg}" alt="${product.productName}">
                    <div class="product-title">${product.productName}</div>
                    <div class="product-price">Giá: ${product.price}</div>
                    <form action="${pageContext.request.contextPath}/AddProductCtrl" method="POST">
                        <input type="hidden" name="productId" value="${product.productId}">
                        <div class="product-quantity">
                            <input type="number" name="quantity" value="1" min="1" max="${product.quantity}" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm vào giỏ hàng</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
