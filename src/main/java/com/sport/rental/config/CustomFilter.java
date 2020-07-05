package com.sport.rental.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.rental.repository.UserRepository;

@WebFilter("/*")
public class CustomFilter implements Filter {

    @Autowired
    UserRepository userRepository;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String session = (String) req.getSession().getAttribute("email");
        String role = (String) req.getSession().getAttribute("role");
        String requestUri = req.getRequestURI();

        if (
                session != null && role != null ||
                        requestUri.endsWith(".css") ||
                        requestUri.endsWith(".png") ||
                        requestUri.endsWith(".jss") ||
                        requestUri.endsWith(".jpg") ||
                        requestUri.endsWith("login") ||
                        requestUri.endsWith("register")
        ) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login"));
        }
    }

    @Override
    public void destroy() {

    }
}
