package iuh.edu.se.baitap01.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Request received at " + new java.util.Date());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Request sent at " + new java.util.Date());
    }

}
