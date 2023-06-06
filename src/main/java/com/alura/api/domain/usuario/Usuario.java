package com.alura.api.domain.usuario;

import com.alura.api.domain.topico.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import java.util.*;


@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Topico> topicos;

    public Usuario(){
        this.topicos = new ArrayList<>();
    }

    public Usuario(IdRegistroUsuario usuario) {
        this.id = Long.valueOf(usuario.id());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // Retorna una lista con una autoridad simple "ROLE_USER"
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {

        // Retorna el email del usuario como nombre de usuario
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        // La cuenta del usuario no expira
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        // La cuenta del usuario no está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        // Las credenciales del usuario no expiran
        return true;
    }

    @Override
    public boolean isEnabled() {

        // El usuario está habilitado
        return true;
    }
}