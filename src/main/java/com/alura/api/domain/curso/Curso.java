package com.alura.api.domain.curso;

import com.alura.api.domain.topico.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity(name = "Curso")         // Anotación para indicar que esta clase es una entidad JPA llamada "Curso"
@Table(name = "cursos")         // Especifica la tabla de base de datos asociada a esta entidad llamada "cursos"
@Getter                         // Anotación de Lombok para generar automáticamente los métodos getter para los campos de la clase
@AllArgsConstructor             // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos de la clase
@EqualsAndHashCode(of = "id")   // Anotación de Lombok para generar automáticamente los métodos equals() y hashCode() basados en el campo "id"
public class Curso {

    @Id                                                    // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Configura la generación automática del valor para la clave primaria utilizando una estrategia de identidad
    private Long id;
    private String nombre;
    private String categoria;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)     // Indica una relación de uno a muchos con la entidad "Topico". FetchType.LAZY indica que la carga de los tópicos se realiza de forma perezosa.
    @JoinColumn(name = "curso_id")                                    // Especifica la columna en la tabla "Topico" que se utilizará como clave extranjera para la relación con el curso
    private List<Topico> topicos;

    public Curso(){
        this.topicos = new ArrayList<>();
    }

    public Curso(IdRegistroCurso curso) {
        this.id = Long.valueOf(curso.id());
    }
}