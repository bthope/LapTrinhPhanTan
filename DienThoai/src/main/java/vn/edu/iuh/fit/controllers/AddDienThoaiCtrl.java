package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/AddDienThoaiCtrl")
public class AddDienThoaiCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoai dienThoai = new DienThoai(
                req.getParameter("MaDT"),
                req.getParameter("TenDT"),
                Integer.parseInt(req.getParameter("namSX")),
                req.getParameter("cauhinh")
        );

        NhaCungCap nhaCungCap = NhaCungCapService.getNhaCungCapById(req.getParameter("maNCC"));
        dienThoai.setNhaCungCap(nhaCungCap);

        DienThoaiService.insertDienThoai(dienThoai);

        resp.sendRedirect(req.getContextPath() + "/ViewDienThoaiCtrl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> nhaCungCapName = NhaCungCapService.getNhaCungCapByName();
        List<NhaCungCap> nhaCungCaps = NhaCungCapService.getAllNhaCungCap();

        req.setAttribute("nhaCungCaps",nhaCungCaps);
        req.setAttribute("nhaCungCapName", nhaCungCapName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/AddDienThoai.jsp");
        requestDispatcher.forward(req, resp);
    }
}

