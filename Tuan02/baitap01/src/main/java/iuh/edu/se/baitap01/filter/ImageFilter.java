package iuh.edu.se.baitap01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;

public class ImageFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI().toLowerCase();

        if(uri.endsWith(".jpg") || uri.endsWith(".jpeg")){
            response.setContentType("image/jpeg");
        }else if(uri.endsWith(".png") || uri.endsWith(".gif")){
            response.setContentType("image/png");
        }

        System.out.println("ImageFilter: serving " + uri + "with Content-Type: " + response.getContentType());

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("ImageFilter: destroy");
    }
}
