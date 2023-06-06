package com.alura.api.domain.topico;


import com.alura.api.domain.curso.Curso;
import com.alura.api.domain.respuesta.Respuesta;
import com.alura.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private StatusTopic status;

    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "topico_id")
    private List<Respuesta> respuestas;

    @PrePersist
    public void prePersist(){
        this.fechaCreacion = LocalDateTime.now();
    }

    public Topico() {
        this.respuestas = new ArrayList<>();
        this.status = StatusTopic.NO_RESPONDIDO;
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.status = datosRegistroTopico.status();
        this.usuario = new Usuario(datosRegistroTopico.usuario());
        this.curso = new Curso(datosRegistroTopico.curso());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        // Actualizar el título del tópico si se proporciona un nuevo título
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }

        // Actualizar el mensaje del tópico si se proporciona un nuevo mensaje
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }

        // Actualizar el estado del tópico si se proporciona un nuevo estado
        if (datosActualizarTopico.status() != null){
            this.status = datosActualizarTopico.status();
        }
    }

    public void desactivarTopico() {
        // Desactivar el tópico estableciendo el flag "activo" a false
        this.activo = false;
    }
}