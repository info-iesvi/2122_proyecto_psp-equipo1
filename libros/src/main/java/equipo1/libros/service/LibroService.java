package equipo1.libros.service;

import equipo1.libros.model.LibroDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibroService {
    ResponseEntity<List<LibroDTO>> getAll();
    ResponseEntity<LibroDTO> create(LibroDTO librodto);
    ResponseEntity<LibroDTO> get(String isbn);
    ResponseEntity<LibroDTO> modify(String isbn, LibroDTO librodto);
    ResponseEntity<String> delete(String isbn);
}
