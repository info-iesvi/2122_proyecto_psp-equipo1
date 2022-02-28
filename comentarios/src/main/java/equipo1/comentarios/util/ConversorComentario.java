package equipo1.comentarios.util;

import equipo1.comentarios.model.ComentarioDTO;
import equipo1.comentarios.model.ComentarioVO;

public class ConversorComentario {
    public static ComentarioDTO convertVOtoDTO(ComentarioVO comentariovo){
        ComentarioDTO comentariodto = new ComentarioDTO();
        comentariodto.setId(comentariovo.getId());
        comentariodto.setFecha(comentariovo.getFecha());
        comentariodto.setContenido(comentariovo.getContenido());
        comentariodto.setAutor(comentariovo.getAutor());
        comentariodto.setIsbnLibro(comentariovo.getIsbnLibro());
        return comentariodto;
    }

    public static ComentarioVO convertDTOtoVO(ComentarioDTO comentariodto){
        ComentarioVO comentariovo = new ComentarioVO();
        comentariovo.setId(comentariodto.getId());
        comentariovo.setFecha(comentariodto.getFecha());
        comentariovo.setContenido(comentariodto.getContenido());
        comentariovo.setAutor(comentariodto.getAutor());
        comentariovo.setIsbnLibro(comentariodto.getIsbnLibro());
        return comentariovo;
    }
}
