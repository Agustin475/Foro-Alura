package com.alura.api.domain.usuario;

import jakarta.validation.constraints.*;
public record IdRegistroUsuario(
        @NotBlank
        @Pattern(regexp = "^\\d+$")
        String id                       //Validando que sea un número
) {
}