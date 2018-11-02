package io.pivotal.concoursepushbutton;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenWebInterceptor implements Filter {

    @Autowired
    private TokenService tokenService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (pathEquals(request, "") || pathEquals(request, "/")) {
            if (tokenService.getBearerToken() == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("/token/get");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public boolean pathEquals(HttpServletRequest request, String path) {
        return request.getServletPath().equals(path);
    }
}
