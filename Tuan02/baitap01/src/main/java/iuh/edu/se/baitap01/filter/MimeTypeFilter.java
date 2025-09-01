package iuh.edu.se.baitap01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MimeTypeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        String mimeType = request.getServletContext().getMimeType(uri);

        System.out.println("Requested URI: " + uri);
        System.out.println("Detected MimeType: " + mimeType);


        if (uri.endsWith(".html") || uri.endsWith(".htm")) {
            servletResponse.setContentType("text/html; charset=UTF-8");
        } else if (uri.endsWith(".css")) {
            servletResponse.setContentType("text/css; charset=UTF-8");
        } else if (uri.endsWith(".js")) {
            servletResponse.setContentType("application/javascript; charset=UTF-8");
        } else if (uri.endsWith(".jpg") || uri.endsWith(".jpeg")) {
            servletResponse.setContentType("image/jpeg");
        } else if (uri.endsWith(".png")) {
            servletResponse.setContentType("image/png");
        } else if (uri.endsWith(".json")) {
            servletResponse.setContentType("application/json; charset=UTF-8");
        } else if (uri.endsWith("/hello-servlet") || uri.endsWith("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else{
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    "Unsupported MIME type: " + mimeType);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
