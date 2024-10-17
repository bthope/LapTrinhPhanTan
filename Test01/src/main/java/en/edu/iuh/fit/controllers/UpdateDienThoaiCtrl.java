package en.edu.iuh.fit.controllers;

import en.edu.iuh.fit.entities.DienThoai;
import en.edu.iuh.fit.entities.NhaCungCap;
import en.edu.iuh.fit.services.DienThoaiService;
import en.edu.iuh.fit.services.NhaCungCapService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateDienThoaiCtrl")
public class UpdateDienThoaiCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DienThoai dienThoai = DienThoaiService.getDienThoaiById(req.getParameter("maDT"));
        dienThoai.setTenDT(req.getParameter("tenDT"));
        dienThoai.setNamSX(Integer.parseInt(req.getParameter("namSX")));
        dienThoai.setCauHinh(req.getParameter("cauHinh"));

        NhaCungCap nhaCungCap = NhaCungCapService.getNhaCungCapById(req.getParameter("maNCC"));
        dienThoai.setNhaCungCap(nhaCungCap);

        DienThoaiService.updateDienThoai(dienThoai);

        resp.sendRedirect(req.getContextPath() + "/ViewDienThoaiCtrl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maDT = req.getParameter("maDT");
        DienThoai dienThoai = DienThoaiService.getDienThoaiById(maDT);

        List<NhaCungCap> nhaCungCaps = NhaCungCapService.getAllNhaCungCap();

        // In ra console để kiểm tra danh sách nhaCungCaps
        nhaCungCaps.forEach(ncc -> System.out.println("NCC: " + ncc.getMaNCC() + " - " + ncc.getTenNCC()));

        req.setAttribute("nhaCungCaps", nhaCungCaps);
        req.setAttribute("selectedNCC", dienThoai.getNhaCungCap().getMaNCC());
        req.setAttribute("dienThoai", dienThoai);

        req.getRequestDispatcher("/WEB-INF/updateDienThoai.jsp").forward(req, resp);
    }

}

