package com.alura.api.infra.security;

import io.swagger.v3.oas.annotations.enums.*;
import io.swagger.v3.oas.annotations.security.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.*;



@Configuration
@SecurityScheme(  // Configuracion fuente https://www.baeldung.com/openapi-jwt-authentication
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@EnableWebSecurity
public class SecurityConfigurations {

    private SecurityFilter securityFilter;

    public SecurityConfigurations(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Configuración de la cadena de filtros de seguridad HTTP
        return httpSecurity.csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .requestMatchers(HttpMethod.POST, "/login").permitAll()                // Permitir la ruta "/login" para todos
                .requestMatchers(AUTH_WHITELIST).permitAll()                                    // Permitir las rutas de la lista AUTH_WHITELIST para todos
                .anyRequest().authenticated()                                                   // Requerir autenticación para todas las demás rutas
                .and()
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)    // Agregar el filtro de seguridad personalizado antes del filtro de autenticación por usuario y contraseña
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        // Obtener el administrador de autenticación de la configuración de autenticación
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        // Utilizar el codificador BCrypt para las contraseñas
        return new BCryptPasswordEncoder();
    }

    private static final String[] AUTH_WHITELIST = {
            "/api/v1/aut/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };
}