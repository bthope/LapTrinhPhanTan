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
import vn.edu.iuh.fit.services.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddProductCtrl")
public class AddProductCtrl extends HttpServlet {
    private List<CartItemBean> cartItems = new ArrayList<>();
    private double orderTotal = 0.0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

            cartItems.add(cartItem);
            orderTotal += totalCost;
        }

        // Tạo đối tượng CartBean và lưu vào session
        CartBean cartBean = new CartBean(orderTotal, cartItems, null);
        CartBeanService.insertCartBean(cartBean);

        req.getSession().setAttribute("cartBean", cartBean);

        // Chuyển hướng sang trang ViewCartBean.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/ViewCartBean.jsp");
        dispatcher.forward(req, resp);

    }
}
