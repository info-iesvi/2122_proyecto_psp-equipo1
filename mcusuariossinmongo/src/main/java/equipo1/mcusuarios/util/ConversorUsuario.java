package equipo1.mcusuarios.util;

import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.model.UsuarioVO;

public class ConversorUsuario {
    public static UsuarioDTO convertVOtoDTO(UsuarioVO usuariovo){
        UsuarioDTO usuariodto = new UsuarioDTO();
        usuariodto.setDNI(usuariovo.getDNI());
        usuariodto.setNombre(usuariovo.getNombre());
        usuariodto.setApellidos(usuariovo.getApellidos());
        usuariodto.setUsername(usuariovo.getUsername());
        usuariodto.setCorreo(usuariovo.getCorreo());
        usuariodto.setListaComentarios(usuariovo.getListaComentarios());
        usuariodto.setListaLibrosLeidos(usuariovo.getListaLibrosLeidos());
        return usuariodto;
    }

    public static UsuarioVO convertDTOtoVO(UsuarioDTO usuariodto){
        UsuarioVO usuariovo = new UsuarioVO();
        usuariovo.setDNI(usuariodto.getDNI());
        usuariovo.setNombre(usuariodto.getNombre());
        usuariovo.setApellidos(usuariodto.getApellidos());
        usuariovo.setUsername(usuariodto.getUsername());
        usuariovo.setCorreo(usuariodto.getCorreo());
        usuariovo.setListaComentarios(usuariodto.getListaComentarios());
        usuariovo.setListaLibrosLeidos(usuariodto.getListaLibrosLeidos());
        return usuariovo;
    }
}
