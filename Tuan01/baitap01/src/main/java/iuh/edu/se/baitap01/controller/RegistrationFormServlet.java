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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String facebook = request.getParameter("facebook");
        String gender = request.getParameter("gender");
        String shortbio = request.getParameter("shortbio");

        String[] hobbies = request.getParameterValues("hobbies");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Registration Result</title></head>");
        out.println("<body>");
        out.println("<h2>Registration Result</h2>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Facebook: " + facebook + "</p>");
        out.println("<p>Gender: " + gender + "</p>");

        out.print("<p>Hobbies: ");
        if (hobbies != null) {
            for (String h : hobbies) {
                out.print(h + " ");
            }
        }
        out.println("</p>");

        out.println("<p>Short Bio: " + shortbio + "</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
