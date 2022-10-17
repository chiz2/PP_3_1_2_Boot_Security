package ru.kata.spring.boot_security.demo.configs;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomUrlLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        // Запишем, чтобы попрощаться
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            request.getSession().setAttribute("Authentication-Name", authentication.getName());
        }

        super.onLogoutSuccess(request, response, authentication);
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}