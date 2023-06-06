package com.alura.api.domain.topico;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    // Método para buscar tópicos activos con paginación
    Page<Topico> findByActivoTrue(Pageable paginacion);

}