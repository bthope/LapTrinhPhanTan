<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Your Cart</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style>
    .cart-item {
      border: 1px solid #ddd;
      padding: 15px;
      margin: 10px 0;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .cart-item-title {
      font-weight: bold;
    }
    .cart-item-price {
      color: #333;
      margin: 5px 0;
    }
    .cart-item-quantity {
      margin-bottom: 5px;
    }
    .order-total {
      font-weight: bold;
      margin-top: 20px;
      text-align: right;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Your Cart</h2>
  <div class="row">
    <c:forEach items="${cartBean.cartItemBeans}" var="item">
      <div class="col-sm-12">
        <div class="cart-item">
          <div>
            <div class="cart-item-title">Product: ${item.partNumber}</div>
            <div class="cart-item-description">${item.description}</div>
            <div class="cart-item-price">Unit Price: ${item.unitCost}</div>
            <div class="cart-item-quantity">Quantity: ${item.quantity}</div>
            <div class="cart-item-total">Total Cost: ${item.totalCost}</div>
          </div>
          <div>
            <form action="${pageContext.request.contextPath}/CartBeanCtrl" method="post" style="display:inline;">
              <input type="hidden" name="cartItemId" value="${item.cartItemBean_id}">
              <input type="number" name="quantity" value="${item.quantity}" min="1" class="form-control" style="width: 80px; display:inline;">
              <input type="hidden" name="action" value="update">
              <button type="submit" class="btn btn-secondary">Update</button>
            </form>
            <form action="${pageContext.request.contextPath}/CartBeanCtrl" method="post" style="display:inline;">
              <input type="hidden" name="cartItemId" value="${item.cartItemBean_id}">
              <input type="hidden" name="action" value="delete">
              <button type="submit" class="btn btn-danger">Delete</button>
            </form>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>

  <div class="order-total">
    Order Total: ${cartBean.orderTotal}
  </div>
</div>
</body>
</html>
