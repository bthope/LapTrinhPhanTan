package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.services.LogServices;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Date date = new Date();

        // Kiểm tra null cho timeIn
        Object timeInObj = session.getAttribute("timeIn");
        if (timeInObj == null) {
            // Xử lý khi timeIn không tồn tại trong session
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(timeInObj.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Kiểm tra null cho account_Id
        Object accountIdObj = session.getAttribute("account_Id");
        if (accountIdObj == null) {
            // Xử lý khi account_Id không tồn tại trong session
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }

        Log log = new Log(
                accountIdObj.toString(),
                new Timestamp(parsedDate.getTime()),
                new Timestamp(date.getTime()),
                ""
        );

        LogServices.insertLog(log);
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("action");
        System.out.println(str);
    }
}
