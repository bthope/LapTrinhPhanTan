package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.services.GiangVienService;

import java.io.IOException;

@WebServlet("/AddGiangVienCtrl")
public class AddGiangVienCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GiangVien giangVien = new GiangVien(
                req.getParameter("maGV").toString(),
                req.getParameter("tenGV").toString(),
                req.getParameter("linhVuNghienCuu").toString(),
                req.getParameter("soDT").toString()
        );

        GiangVienService.insertGiangVien(giangVien);
        resp.sendRedirect(req.getContextPath() + "/ViewGiangVienCtrl");
    }
}
