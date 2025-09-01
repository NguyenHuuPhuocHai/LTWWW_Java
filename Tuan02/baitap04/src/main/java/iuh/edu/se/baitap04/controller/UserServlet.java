package iuh.edu.se.baitap04.controller;

import com.google.gson.Gson;
import iuh.edu.se.baitap04.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = new User(1, "Nguyen Huu Phuoc Hai", "21018551.hai@student.iuh.edu.vn");

        Gson gson = new Gson();
        String json = gson.toJson(user);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
