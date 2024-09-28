package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.ProductDetail;
import vn.edu.iuh.fit.services.ProductDetailService;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewProductDetailCtrl")
public class ViewProductDetailCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy thông tin sản phẩm chi tiết từ giỏ hàng
        List<ProductDetail> productDetail = ProductDetailService.getProductDetail();

        req.setAttribute("productDetail", productDetail);
        req.getRequestDispatcher("/WEB-INF/ViewProductDetail.jsp").forward(req, resp);
    }
}
