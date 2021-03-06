package equipo1.mcusuarios.service;

import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.model.UsuarioVO;
import org.springframework.http.ResponseEntity;

import java.util.List;
/*
Interfaz donde definimos los métodos que debe implementar el servicio.
* */
public interface UsuarioService {
    ResponseEntity<List<UsuarioDTO>> getAll();
    ResponseEntity<UsuarioDTO> create(UsuarioDTO usuariodto);
    ResponseEntity<UsuarioDTO> get(String dni);
    ResponseEntity<UsuarioDTO> modify(String dni,UsuarioDTO usuariodto);
    ResponseEntity<String> delete(String dni);
}
