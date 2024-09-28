package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.services.TinTucService;

import java.io.IOException;

@WebServlet("/DelTinTucCtrl")
public class DelTinTucCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TinTucService.delTinTuc(req.getParameter("maTT"));

        resp.sendRedirect(req.getContextPath() + "/ViewTinTucCtrl");
    }
}
