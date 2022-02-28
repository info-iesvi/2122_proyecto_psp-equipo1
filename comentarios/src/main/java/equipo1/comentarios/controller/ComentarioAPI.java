package equipo1.comentarios.controller;

import equipo1.comentarios.model.ComentarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
/*
Interfaz que establece los métodos a implementar por el controlador.
* */
@CrossOrigin
public interface ComentarioAPI {
    ResponseEntity<List<ComentarioDTO>> getAll();
    ResponseEntity<ComentarioDTO> create(ComentarioDTO comentariodto);
    ResponseEntity<ComentarioDTO> get(String id);
    ResponseEntity<ComentarioDTO> modify(String isbn, ComentarioDTO comentariodto);
    ResponseEntity<String> delete(String id);

}
