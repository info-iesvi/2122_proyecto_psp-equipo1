package equipo1.mcusuarios.controller;

import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.model.UsuarioVO;
import org.springframework.http.ResponseEntity;

import java.util.List;
/*
Interfaz que establece los métodos a implementar por el controlador.
* */
public interface UsuarioAPI {
    ResponseEntity<List<UsuarioDTO>> getAll();
    ResponseEntity<UsuarioDTO> create(UsuarioDTO usuariodto);
    ResponseEntity<UsuarioDTO> get(String dni);
    ResponseEntity<UsuarioDTO> modify( String dni, UsuarioDTO tutorial);
    ResponseEntity<String> delete(String dni);
}
