package com.alura.api.domain.topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String status, String fechaCreacion) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus().toString(), topico.getFechaCreacion().toString());
    }
}