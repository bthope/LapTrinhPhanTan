package en.edu.iuh.fit.controllers;

import en.edu.iuh.fit.entities.DienThoai;
import en.edu.iuh.fit.entities.NhaCungCap;
import en.edu.iuh.fit.services.DienThoaiService;
import en.edu.iuh.fit.services.NhaCungCapService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/AddDienThoaiCtrl")
public class AddDienThoaiCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoai dienThoai = new DienThoai(
                req.getParameter("tenDT"),
                Integer.parseInt(req.getParameter("namSX")),
                req.getParameter("cauHinh")
        );

        NhaCungCap nhaCungCap = NhaCungCapService.getNhaCungCapById(req.getParameter("maNCC"));
        dienThoai.setNhaCungCap(nhaCungCap);

        DienThoaiService.insertDienThoai(dienThoai);

        resp.sendRedirect(req.getContextPath() + "/ViewDienThoaiCtrl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Long> nhaCungCapName = NhaCungCapService.getAllNhaCungCapByName();
        List<NhaCungCap> nhaCungCaps = NhaCungCapService.getAllNhaCungCap();

        req.setAttribute("nhaCungCapName",nhaCungCapName);
        req.setAttribute("nhaCungCaps",nhaCungCaps);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/AddDienThoai.jsp");
        requestDispatcher.forward(req,resp);

    }
}
