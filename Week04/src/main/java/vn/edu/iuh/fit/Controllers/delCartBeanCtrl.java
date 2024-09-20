package vn.edu.iuh.fit.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.services.CartItemBeanService;

import java.io.IOException;

@WebServlet("/DelCartBeanCtrl")
public class delCartBeanCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartItemId = req.getParameter("cartItemId");
        CartItemBeanService.delCartItemBean(cartItemId);
        resp.sendRedirect(req.getContextPath()+ "/CartBeanCtrl");
    }
}
