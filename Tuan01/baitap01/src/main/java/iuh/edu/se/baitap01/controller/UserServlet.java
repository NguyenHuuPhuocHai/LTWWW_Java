package iuh.edu.se.baitap01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.edu.se.baitap01.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        User user = new User("Hải", "Nguyễn", "PhuocHai", "hai@gmail.com");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
