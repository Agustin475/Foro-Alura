package com.alura.api.domain.topico;

import com.alura.api.domain.curso.*;
import com.alura.api.domain.usuario.*;
import java.time.*;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        StatusTopic status,
        LocalDateTime fechaCreacion,
        IdRegistroUsuario usuario,
        IdRegistroCurso curso) {
}