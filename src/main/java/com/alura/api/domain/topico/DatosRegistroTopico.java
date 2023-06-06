package com.alura.api.domain.topico;

import com.alura.api.domain.curso.*;
import com.alura.api.domain.usuario.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull StatusTopic status,
        @NotNull @Valid IdRegistroUsuario usuario,
        @NotNull @Valid IdRegistroCurso curso
) {
}