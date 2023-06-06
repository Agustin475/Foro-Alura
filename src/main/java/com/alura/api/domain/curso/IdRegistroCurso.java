package com.alura.api.domain.curso;

import jakarta.validation.constraints.*;

public record IdRegistroCurso ( @NotBlank  @Pattern(regexp = "^\\d+$") String id ){}    //Validando que sea un número