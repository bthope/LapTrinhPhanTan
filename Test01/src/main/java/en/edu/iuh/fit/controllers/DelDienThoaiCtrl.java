package en.edu.iuh.fit.controllers;

import en.edu.iuh.fit.services.DienThoaiService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DelDienThoaiCtrl")
public class DelDienThoaiCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoaiService.delDienThoai(req.getParameter("maDT"));

        resp.sendRedirect(req.getContextPath() + "/ViewDienThoaiCtrl");
    }
}
