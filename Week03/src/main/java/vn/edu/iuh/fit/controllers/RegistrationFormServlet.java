package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Student;


import java.io.IOException;

@WebServlet("/RegistrationForm")
public class RegistrationFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");

        String[] hobbies = request.getParameterValues("hobbies");

        // Qualification data (2D array)
        String[][] qualifications = {
                { "Class X", request.getParameter("boardClassX"), request.getParameter("percentageClassX"), request.getParameter("yearClassX") },
                { "Class XII", request.getParameter("boardClassXII"), request.getParameter("percentageClassXII"), request.getParameter("yearClassXII") },
                { "Graduation", request.getParameter("boardGraduation"), request.getParameter("percentageGraduation"), request.getParameter("yearGraduation") },
                { "Masters", request.getParameter("boardMasters"), request.getParameter("percentageMasters"), request.getParameter("yearMasters") }
        };

        String courseApplies = request.getParameter("courseApplies");

        // Create Student object
        Student student = new Student(firstName, lastName, dob, email, mobileNumber, gender, address, city, pinCode, state, country, hobbies, qualifications, courseApplies);

        // Set the student object as an attribute to forward to a JSP page
        request.setAttribute("student", student);

        // Forward to a JSP page for display (you will need to create this JSP page)
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayStudent.jsp");
        dispatcher.forward(request, response);
    }
}

