package en.edu.iuh.fit.controllers;

import en.edu.iuh.fit.entities.DienThoai;
import en.edu.iuh.fit.services.DienThoaiService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewDienThoaiCtrl")
public class ViewDienThoaiCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DienThoai> dienThoais = DienThoaiService.getAllDienThoai();

        req.setAttribute("dienThoais",dienThoais);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/ViewDienThoai.jsp");
        requestDispatcher.forward(req,resp);
    }
}
