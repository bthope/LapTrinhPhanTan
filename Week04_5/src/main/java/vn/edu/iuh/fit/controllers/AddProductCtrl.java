package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.entities.ProductDetail;
import vn.edu.iuh.fit.services.ProductDetailService;
import vn.edu.iuh.fit.services.ProductService;

import java.io.IOException;

@WebServlet("/AddProductCtrl")
public class AddProductCtrl  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        // Tạo đối tượng ProductDetail và thêm vào giỏ hàng
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(ProductService.getProductById(productId));
        productDetail.setQuantity(quantity); // Đặt số lượng
        productDetail.setTotal(productDetail.getProduct().getPrice() * quantity);

        // Thêm sản phẩm vào giỏ hàng (giả sử có một dịch vụ quản lý giỏ hàng)
        ProductDetailService.insertProductDetail(productDetail);

        // Chuyển hướng đến ViewProductDetail.jsp
        req.setAttribute("productDetail", productDetail);
        req.getRequestDispatcher("/WEB-INF/ViewProductDetail.jsp").forward(req, resp);
    }

}
