package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.services.GiangVienService;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewGiangVienCtrl")
public class ViewGiangVienCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiangVien> giangViens = GiangVienService.getGiangVien();
        req.setAttribute("listGiangViens", giangViens);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/ViewGiangVien.jsp");
        requestDispatcher.forward(req,resp);
    }
}
