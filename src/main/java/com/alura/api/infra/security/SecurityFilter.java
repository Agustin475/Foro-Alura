package com.alura.api.infra.security;

import com.alura.api.domain.usuario.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.web.filter.*;
import java.io.*;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    public SecurityFilter(TokenService tokenService, UsuarioRepository usuarioRepository){
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Obtener el encabezado "Authorization" de la solicitud
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null){

            // Si se encuentra el encabezado de autorización, extraer el token
            var token = authHeader.replace("Bearer ", "");

            // Obtener el sujeto (email) del token
            var subject = tokenService.getSubject(token);


            if (subject != null){
                // Si el sujeto no es nulo, el token es válido
                // Buscar el usuario por su email en el repositorio de usuarios
                var usuario = usuarioRepository.findByEmail(subject);

                // Crear una autenticación con el usuario y sus autoridades
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

                // Establecer la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}