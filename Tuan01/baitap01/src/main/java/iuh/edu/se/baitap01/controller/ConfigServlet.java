package iuh.edu.se.baitap01.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigServlet extends HttpServlet {
    private String userMail;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userMail = config.getInitParameter("userMail");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        ServletContext context = getServletContext();
        String userName = context.getInitParameter("userName");

        out.println("<html><body>");
        out.println("<h1>User Name (context-param): " + userName + "</h1>");
        out.println("<h2>User Mail (init-param): " + userMail + "</h2>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("userName");
        String mail = req.getParameter("userMail");

        out.println("<html><body>");
        out.println("<h1>Thông tin nhận được từ form:</h1>");
        out.println("<p>User Name: " + name + "</p>");
        out.println("<p>User Mail: " + mail + "</p>");
        out.println("</body></html>");
    }

}
