package vn.edu.iuh.fit.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.enitty.Product;
import vn.edu.iuh.fit.repository.ProductDao;
import vn.edu.iuh.fit.services.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewProductCtrl")
public class ViewProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductService.getProduct();
        req.setAttribute("listProducts", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/viewProduct.jsp");
        requestDispatcher.forward(req,resp);
    }
}
