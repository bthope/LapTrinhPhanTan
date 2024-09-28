package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.services.GiangVienService;

import java.io.IOException;

@WebServlet("/DelGiangVienCtl")
public class DelGiangVienCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GiangVienService.delGiangVien(req.getParameter("maGV"));
        resp.sendRedirect(req.getContextPath() + "/ViewGiangVienCtrl");
    }
}
