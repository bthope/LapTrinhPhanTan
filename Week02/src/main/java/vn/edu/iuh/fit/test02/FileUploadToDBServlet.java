package vn.edu.iuh.fit.test02;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadToDB")
@MultipartConfig(maxFileSize = 16177215) // 16MB
public class FileUploadToDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        InputStream inputStream = null;

        // Lấy file từ form
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // Kiểm tra loại MIME của file
            String fileType = filePart.getContentType();

            // Chỉ cho phép file có loại MIME là png hoặc jpg
            if (!fileType.equals("image/png") && !fileType.equals("image/jpeg")) {
                request.setAttribute("Message", "Only PNG and JPG images are allowed.");
                getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                return;
            }

            // Lấy input stream của file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null;
        String message = null;

        try {
            // Kết nối đến database
            conn = DatabaseConnection.getConnection();

            // Câu lệnh SQL để insert vào bảng contacts
            String sql = "INSERT INTO contacts (first_name, last_name, photo) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            if (inputStream != null) {
                // Gán input stream của file vào câu lệnh SQL
                statement.setBlob(3, inputStream);
            }

            // Thực thi câu lệnh SQL
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (Exception ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Set thông báo và chuyển đến trang kết quả
            request.setAttribute("Message", message);
            System.out.println("File type: " + filePart.getContentType());
            System.out.println("File size: " + filePart.getSize());
            getServletContext().getRequestDispatcher("/messageDB.jsp").forward(request, response);
        }
    }
}
