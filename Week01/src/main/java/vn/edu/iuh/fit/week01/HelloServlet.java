package vn.edu.iuh.fit.week01;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortbio = request.getParameter("shortbio");

        String html = "<html>"
                + "<head><title>Result Page</title></head>"
                + "<body>"
                + "First Name: " + firstname + "<br>"
                + "Last Name: " + lastname + "<br>"
                + "Username: " + username + "<br>"
                + "Email: " + email + "<br>"
                + "Facebook URL: " + facebook + "<br>"
                + "Short Bio: " + shortbio + "<br>"
                + "</body></html>";
        out.println(html);
    }

    public void destroy() {
    }
}
