package com.alura.api.controller;

import com.alura.api.domain.usuario.*;
import com.alura.api.infra.security.*;
import jakarta.validation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){

        // Crear un objeto Authentication con las credenciales proporcionadas
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(),
                                   datosAutenticacionUsuario.password());
        // Autenticar al usuario utilizando el authenticationManager
        var usuarioAutendicado  = authenticationManager.authenticate(authToken);

        // Generar un token JWT utilizando el tokenService y el principal de la autenticación
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutendicado.getPrincipal());

        // Devolver una respuesta HTTP 200 OK con el token JWT en el cuerpo de la respuesta
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}

