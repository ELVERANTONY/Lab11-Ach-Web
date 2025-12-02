package com.cholan.edu.prj_spring_boot_security_ii.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = "/";

        for (GrantedAuthority auth : authorities) {
            String role = auth.getAuthority();
            if ("ROLE_ADMIN".equals(role)) {
                redirectUrl = "/cursos/list";
                break;
            } else if ("ROLE_USER".equals(role)) {
                redirectUrl = "/cursos/list";
            }
        }

        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
