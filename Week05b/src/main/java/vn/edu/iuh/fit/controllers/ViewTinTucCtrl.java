package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entitties.TinTuc;
import vn.edu.iuh.fit.services.DanhMucService;
import vn.edu.iuh.fit.services.TinTucService;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewTinTucCtrl")
public class ViewTinTucCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TinTuc> tinTucs = TinTucService.getTinTuc();
        List<String> danhMucId = DanhMucService.getDanhMucId();


        req.setAttribute("listTinTucs", tinTucs);
        req.setAttribute("danhMucId", danhMucId);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/ViewTinTuc.jsp");
        requestDispatcher.forward(req,resp);
    }
}
