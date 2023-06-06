package com.alura.api.domain.usuario;

import org.springframework.data.jpa.repository.*;
import org.springframework.security.core.userdetails.*;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    // Busca un usuario por su nombre
    Usuario findByNombre(String nombre);

    // Busca los detalles de usuario por su email
    UserDetails findByEmail(String email);

}