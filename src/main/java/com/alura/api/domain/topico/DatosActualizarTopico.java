package com.alura.api.domain.topico;

import jakarta.validation.constraints.*;

//Es un registro (record) que contiene los datos necesarios para actualizar un tópico
public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, StatusTopic status) {
}