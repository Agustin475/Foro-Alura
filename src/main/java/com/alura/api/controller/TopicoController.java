package com.alura.api.controller;


import com.alura.api.domain.curso.IdRegistroCurso;
import com.alura.api.domain.topico.*;
import com.alura.api.domain.usuario.IdRegistroUsuario;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.models.OpenAPI;
import jakarta.transaction.*;
import jakarta.validation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private TopicoRepository topicoRepository;
    public TopicoController(TopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){

        // Registrar un nuevo tópico y guardar en la base de datos
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));

        // Crear el objeto de respuesta con los datos del tópico registrado
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(),
                new IdRegistroUsuario(topico.getUsuario().getId().toString()),
                new IdRegistroCurso(topico.getCurso().getId().toString()));

        // Construir la URI para el tópico registrado
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        // Devolver una respuesta HTTP 201 Created con la URI y los datos del tópico registrado en el cuerpo de la respuesta
        return ResponseEntity.created(uri).body(datosRespuestaTopico);

    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5, sort = "id") Pageable paginacion){
        //return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){

        // Obtener una referencia al tópico utilizando el ID proporcionado
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());

        // Actualizar los datos del tópico con los datos proporcionados
        topico.actualizarDatos(datosActualizarTopico);

        // Devolver una respuesta HTTP 200 OK con los datos actualizados del tópico en el cuerpo de la respuesta
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(),
                new IdRegistroUsuario(topico.getUsuario().getId().toString()),
                new IdRegistroCurso(topico.getCurso().getId().toString())));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){

        // Obtener una referencia al tópico utilizando el ID proporcionado
        Topico topico = topicoRepository.getReferenceById(id);

        // Desactivar el tópico
        topico.desactivarTopico();

        // Devolver una respuesta HTTP 204 No Content
        return ResponseEntity.noContent().build();
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){

        // Obtener una referencia al tópico utilizando el ID proporcionado
        Topico topico = topicoRepository.getReferenceById(id);

        // Crear el objeto de respuesta con los datos del tópico
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(),
                new IdRegistroUsuario(topico.getUsuario().getId().toString()),
                new IdRegistroCurso(topico.getCurso().getId().toString()));

        // Devolver una respuesta HTTP 200 OK con los datos del tópico en el cuerpo de la respuesta
        return ResponseEntity.ok(datosRespuestaTopico);
    }



}

