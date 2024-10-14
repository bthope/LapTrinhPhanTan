package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.DienThoai;
import vn.edu.iuh.fit.entities.NhaCungCap;
import vn.edu.iuh.fit.services.DienThoaiService;
import vn.edu.iuh.fit.services.NhaCungCapService;

import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateDienThoaiCtrl")
public class UpdateDienThoaiCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy mã điện thoại từ yêu cầu
        String maDT = req.getParameter("maDT");
        // Lấy thông tin điện thoại dựa trên mã
        DienThoai dienThoai = DienThoaiService.getDienThoaiById(maDT);
        req.setAttribute("dienThoai", dienThoai);
        // Chuyển đến trang cập nhật
        req.getRequestDispatcher("/WEB-INF/updateDienThoai.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Cập nhật thông tin điện thoại
        DienThoai dienThoai = DienThoaiService.getDienThoaiById(req.getParameter("maDT"));
        dienThoai.setTenDT(req.getParameter("tenDT"));
        dienThoai.setNamSX(Integer.parseInt(req.getParameter("namSX")));
        dienThoai.setCauhinh(req.getParameter("cauhinh"));
        // Cập nhật điện thoại
        DienThoaiService.UpdateDienThoai(dienThoai);
        resp.sendRedirect(req.getContextPath() + "/ViewDienThoaiCtrl");
    }
}


