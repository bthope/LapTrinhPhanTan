package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entitties.DanhMuc;
import vn.edu.iuh.fit.entitties.TinTuc;
import vn.edu.iuh.fit.services.DanhMucService;
import vn.edu.iuh.fit.services.TinTucService;

import java.io.IOException;

@WebServlet("/AddTinTucCtrl")
public class AddTinTucCtrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TinTuc tinTuc = new TinTuc(
                req.getParameter("maTT"),
                req.getParameter("tieuDe"),
                req.getParameter("noiDungTT")
        );

        DanhMuc danhMuc = DanhMucService.getDanhMucById(req.getParameter("maDM"));

        tinTuc.setDanhMuc(danhMuc);


        TinTucService.insertTinTuc(tinTuc);
        resp.sendRedirect(req.getContextPath() + "/ViewTinTucCtrl");
    }
}
