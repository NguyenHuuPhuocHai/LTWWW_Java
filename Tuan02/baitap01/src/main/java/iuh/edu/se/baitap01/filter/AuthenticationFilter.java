package iuh.edu.se.baitap01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter extends HttpFilter implements Filter {
    private String configUser;
    private String configPass;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        configUser = filterConfig.getInitParameter("username");
        configPass = filterConfig.getInitParameter("password");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        String loginURI = req.getContextPath() + "/login";
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            if (loginRequest && "POST".equalsIgnoreCase(req.getMethod())) {
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                if (configUser.equals(username) && configPass.equals(password)) {
                    req.getSession().setAttribute("user", username);
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                    return;
                } else {
                    req.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                    return;
                }
            }
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }
    }
}
