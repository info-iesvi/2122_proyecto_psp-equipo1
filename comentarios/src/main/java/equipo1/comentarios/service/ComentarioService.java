package equipo1.comentarios.service;

import equipo1.comentarios.model.ComentarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
/*
Interfaz que establece los métodos a implementar por el servicio.
* */
public interface ComentarioService {
    ResponseEntity<List<ComentarioDTO>> getAll();
    ResponseEntity<ComentarioDTO> create(ComentarioDTO comentariodto);
    ResponseEntity<ComentarioDTO> get(String id);
    ResponseEntity<ComentarioDTO> modify(String id, ComentarioDTO comentariodto);
    ResponseEntity<String> delete(String id);
}
