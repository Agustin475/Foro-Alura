package com.alura.api.infra.security;

import com.alura.api.domain.usuario.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class AutenticationService implements UserDetailsService {
    private UsuarioRepository usuarioRespository;
    @Autowired
    public AutenticationService(UsuarioRepository usuarioRespository) {
        this.usuarioRespository = usuarioRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Busca los detalles del usuario por su email utilizando el repositorio de usuarios
        return usuarioRespository.findByEmail(email);
    }
}