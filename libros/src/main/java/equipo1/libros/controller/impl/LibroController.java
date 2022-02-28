package equipo1.libros.controller.impl;

import equipo1.libros.controller.LibroAPI;
import equipo1.libros.model.LibroDTO;
import equipo1.libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libros")
public class LibroController implements LibroAPI {
    @Autowired
    LibroService libroService;
    @Override
    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAll() {
        return libroService.getAll();
    }

    @Override
    @PostMapping
    public ResponseEntity<LibroDTO> create(@RequestBody LibroDTO librodto) {
        return libroService.create(librodto);
    }

    @Override
    @GetMapping("/{isbn}")
    public ResponseEntity<LibroDTO> get(@PathVariable String isbn) {
        return libroService.get(isbn);
    }

    @Override
    @PutMapping("/{isbn}")
    public ResponseEntity<LibroDTO> modify(@PathVariable String isbn, @RequestBody LibroDTO librodto) {
        return libroService.modify(isbn,librodto);
    }

    @Override
    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> delete(@PathVariable String isbn) {
        return libroService.delete(isbn);
    }
}
