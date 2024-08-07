package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.services.AccountServices;

import java.io.IOException;

import static java.lang.Byte.parseByte;

@WebServlet("/AddAccountCtrl")
public class AddAccountCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account(
                req.getParameter("id").toString(),
                req.getParameter("name").toString(),
                req.getParameter("pwd").toString(),
                req.getParameter("email").toString(),
                req.getParameter("phone").toString(),
                parseByte(req.getParameter("status").toString(), 10)
        );

        AccountServices.insertAccount(account);
        resp.sendRedirect(req.getContextPath() + "/ViewAccountCtrl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
