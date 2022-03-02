package equipo1.libros.controller;

import equipo1.libros.model.LibroDTO;
import equipo1.libros.model.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
/*
Interfaz que establece los métodos a implementar por el controlador.
* */
@CrossOrigin
public interface LibroAPI {
    ResponseEntity<List<LibroDTO>> getAll();
    ResponseEntity<LibroDTO> create(LibroDTO librodto);
    ResponseEntity<LibroDTO> get(String isbn);
    ResponseEntity<LibroDTO> modify(String isbn, LibroDTO librodto);
    ResponseEntity<String> delete(String isbn);
    ResponseEntity senRequest(Request request);
}
