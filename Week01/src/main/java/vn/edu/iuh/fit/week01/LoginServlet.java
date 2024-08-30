package vn.edu.iuh.fit.week01;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    private static final String USERNAME = "Le Huu Bang";
    private static final String PASSWORD = "20049601";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Thay vì chuyển hướng, hiển thị thông báo đăng nhập thành công
            out.println("<html><body>");
            out.println("<h2>Đăng nhập thành công!</h2>");
            out.println("<p>Chào mừng, " + username + "!</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Tên người dùng hoặc mật khẩu không hợp lệ</h2>");
            out.println("<a href='login.jsp'>Thử lại</a>");
            out.println("</body></html>");
        }
    }
}
