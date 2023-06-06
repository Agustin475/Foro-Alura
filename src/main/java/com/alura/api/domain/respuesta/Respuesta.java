package com.alura.api.domain.respuesta;

import com.alura.api.domain.topico.*;
import com.alura.api.domain.usuario.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity(name = "Respuesta")         // Anotación para indicar que esta clase es una entidad JPA llamada "Respuesta"
@Table(name = "respuestas")         // Especifica la tabla de base de datos asociada a esta entidad llamada "respuestas"
@Getter                             // Anotación de Lombok para generar automáticamente los métodos getter para los campos de la clase
@NoArgsConstructor                  // Anotación de Lombok para generar automáticamente un constructor sin argumentos
@AllArgsConstructor                 // Anotación de Lombok para generar automáticamente un constructor con todos los argumentos
@EqualsAndHashCode(of = "id")       // Anotación de Lombok para generar automáticamente los métodos equals y hashCode basados en el campo "id"
public class Respuesta {

    @Id                                                        // Indica que el campo "id" es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)        // Configura la generación automática de valores para la clave primaria
    private Long id;
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)                         // Establece una relación de muchos a uno con la entidad Topico
    private Topico topico;

    @Column(name = "fecha_creacion")                           // Especifica el nombre de la columna en la base de datos asociada al campo "fechaCreacion"
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)                         // Establece una relación de muchos a uno con la entidad Usuario
    private Usuario usuario;

    private Boolean solucion;

    @PrePersist                                     // Anotación para indicar que el método debe ejecutarse antes de que la entidad sea persistida
    public void prePersist(){
        this.fechaCreacion = LocalDateTime.now();
        this.solucion = false;
    }

}