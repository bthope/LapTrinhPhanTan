package vn.edu.iuh.fit.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.enitty.CartBean;
import vn.edu.iuh.fit.enitty.CartItemBean;
import vn.edu.iuh.fit.enitty.Product;
import vn.edu.iuh.fit.services.CartBeanService;
import vn.edu.iuh.fit.services.CartItemBeanService;
import vn.edu.iuh.fit.services.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/CartBeanCtrl")
public class CartBeanCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartBean> cartBeans = CartBeanService.getCartBean();
        req.setAttribute("cartBeans", cartBeans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/ViewCartBean.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("update".equals(action)) {
            // Update product in cart
            String cartItemId = req.getParameter("cartItemId");
            int newQuantity = Integer.parseInt(req.getParameter("quantity"));

            CartItemBean cartItem = CartItemBeanService.getCartItemById(cartItemId);
            if (cartItem != null) {
                Product product = ProductService.getProduct().stream()
                        .filter(p -> p.getProduct_id().equals(cartItem.getCartItemBean_id()))
                        .findFirst()
                        .orElse(null);

                if (product != null && newQuantity > 0 && newQuantity <= product.getQuantity()) {
                    cartItem.setQuantity(newQuantity);
                    cartItem.setTotalCost(cartItem.getUnitCost() * newQuantity);
                    CartItemBeanService.insertCartItemBean(cartItem);
                }
            }

        } else if ("delete".equals(action)) {
            // Delete product from cart
            String cartItemId = req.getParameter("cartItemId");
            CartItemBeanService.delCartItemBean(cartItemId);
        } else {
            // Add product to cart
            String productId = req.getParameter("productId");
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            Product product = ProductService.getProduct().stream()
                    .filter(p -> p.getProduct_id().equals(productId))
                    .findFirst()
                    .orElse(null);

            if (product != null && quantity > 0 && quantity <= product.getQuantity()) {
                double totalCost = product.getPrice() * quantity;

                CartItemBean cartItem = new CartItemBean();
                cartItem.setCartItemBean_id(productId);
                cartItem.setPartNumber(product.getModel());
                cartItem.setDescription(product.getDescription());
                cartItem.setUnitCost(product.getPrice());
                cartItem.setQuantity(quantity);
                cartItem.setTotalCost(totalCost);

                // Insert into cart service
                CartBeanService.insertCartBean(cartItem.getCartBean());
            }
        }

        // Redirect back to cart view
        resp.sendRedirect(req.getContextPath() + "/CartBeanCtrl");
    }
}

