package equipo1.libros.util;

import equipo1.libros.model.LibroDTO;
import equipo1.libros.model.LibroVO;

public class ConversorLibro {
    public static LibroDTO convertVOtoDTO(LibroVO librovo){
        LibroDTO librodto = new LibroDTO();
        librodto.setISBN(librovo.getISBN());
        librodto.setTitulo(librovo.getTitulo());
        librodto.setAutor(librovo.getAutor());
        librodto.setDescripcion(librovo.getDescripcion());
        librodto.setImagen(librovo.getImagen());
        librodto.setFechaCreacion(librovo.getFechaCreacion());
        librodto.setFechaCreacion(librovo.getFechaInsercion());
        librodto.setValoracion(librovo.getValoracion());
        return librodto;
    }

    public static LibroVO convertDTOtoVO(LibroDTO librodto){
        LibroVO librovo = new LibroVO();
        librovo.setISBN(librodto.getISBN());
        librovo.setTitulo(librodto.getTitulo());
        librovo.setAutor(librodto.getAutor());
        librovo.setDescripcion(librodto.getDescripcion());
        librovo.setImagen(librodto.getImagen());
        librovo.setFechaCreacion(librodto.getFechaCreacion());
        librovo.setFechaCreacion(librodto.getFechaInsercion());
        librovo.setValoracion(librodto.getValoracion());
        return librovo;
    }
}
