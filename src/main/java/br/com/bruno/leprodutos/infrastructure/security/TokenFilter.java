package br.com.bruno.leprodutos.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.DayOfWeek;

@Component
public class TokenFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // só filtra os endpoints que começam com /vendas
        String path = request.getRequestURI();
        if (path.startsWith("/vendas")) {
            String token = request.getHeader("Authorization");

            if (token == null || !token.equalsIgnoreCase("123")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
                response.getWriter().write(""" 
                        {
                            "error": "Token invalido ou ausente"
                        }""");
                return; // bloqueia a requisição
            }
        }

        // se passou, continua o fluxo normal
        filterChain.doFilter(request, response);
    }
}
