package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.services.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewProductCtrl")
public class ViewProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductService.getProduct();
        System.out.println("Danh sách sản phẩm: " + products); // In danh sách sản phẩm ra console
        req.setAttribute("listProduct", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/ViewProduct.jsp");
        requestDispatcher.forward(req,resp);
    }
}
