package iuh.edu.se.baitap01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationFormServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Lấy dữ liệu từ form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String facebook = request.getParameter("facebook");
            String shortBio = request.getParameter("shortBio");

            // In ra HTML kết quả
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Thông tin bạn đã nhập:</h2>");
            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Email:</b> " + email + "</p>");
            out.println("<p><b>Facebook:</b> " + facebook + "</p>");
            out.println("<p><b>Short Bio:</b> " + shortBio + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
