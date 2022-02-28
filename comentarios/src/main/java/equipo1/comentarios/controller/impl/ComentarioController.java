package equipo1.comentarios.controller.impl;

import equipo1.comentarios.controller.ComentarioAPI;
import equipo1.comentarios.model.ComentarioDTO;
import equipo1.comentarios.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comentario")
public class ComentarioController implements ComentarioAPI {
    @Autowired
    ComentarioService comentarioService;
    @Override
    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> getAll() {
        return comentarioService.getAll();
    }

    @Override
    @PostMapping
    public ResponseEntity<ComentarioDTO> create(@RequestBody ComentarioDTO librodto) {
        return comentarioService.create(librodto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> get(@PathVariable String id) {
        return comentarioService.get(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> modify(@PathVariable String id, @RequestBody ComentarioDTO comentariodto) {
        return comentarioService.modify(id,comentariodto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return comentarioService.delete(id);
    }
}
