package equipo1.mcusuarios.controller.impl;

import equipo1.mcusuarios.controller.UsuarioAPI;
import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.model.UsuarioVO;
import equipo1.mcusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController implements UsuarioAPI {

    @Autowired
    UsuarioService usuarioService;

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return usuarioService.getAll();
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuariodto) {
        return usuarioService.create(usuariodto);
    }

    @Override
    @GetMapping("/{dni}")
    public ResponseEntity<UsuarioDTO> get(@PathVariable String dni) {
        return usuarioService.get(dni);
    }

    @Override
    @PutMapping("/{dni}")
    public ResponseEntity<UsuarioDTO> modify(@PathVariable String dni, @RequestBody UsuarioDTO usuariodto) {
        return usuarioService.modify(dni,usuariodto);
    }
    @Override
    @DeleteMapping("/{dni}")
    public ResponseEntity<String> delete(@PathVariable String dni) {
        return usuarioService.delete(dni);
    }
}
