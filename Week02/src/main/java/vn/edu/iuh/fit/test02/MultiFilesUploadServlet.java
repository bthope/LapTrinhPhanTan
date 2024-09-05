package vn.edu.iuh.fit.test02;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(name = "MultiFilesUploadServlet", urlPatterns = "/upload")
@MultipartConfig // Thêm annotation này để servlet có thể xử lý multipart requests
public class MultiFilesUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kiểm tra xem yêu cầu có phải là multipart content không
        if (request.getContentType() != null && request.getContentType().startsWith("multipart/form-data")) {
            // Thư mục lưu trữ hình ảnh
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

            // Tạo thư mục nếu chưa tồn tại
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                // Lấy danh sách các phần (parts) từ yêu cầu
                Collection<Part> parts = request.getParts();
                for (Part part : parts) {
                    String fileName = extractFileName(part);
                    if (fileName != null && !fileName.isEmpty()) {
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        part.write(storeFile.getAbsolutePath()); // Lưu file vào thư mục
                    }
                }
                request.setAttribute("message", "Upload has been done successfully!");
            } catch (Exception ex) {
                request.setAttribute("message", "There was an error: " + ex.getMessage());
                ex.printStackTrace();
            }

            // Chuyển hướng đến trang thông báo
            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
        } else {
            response.getWriter().println("Request does not support multipart content!");
        }
    }

    // Trích xuất tên tệp từ phần (part) của yêu cầu
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("Content-Disposition");
        for (String content : contentDisposition.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
