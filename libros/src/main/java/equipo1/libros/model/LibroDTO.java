package equipo1.libros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    @Id
    String ISBN;
    String titulo;
    String autor;
    LocalDate fechaCreacion;
    LocalDate fechaInsercion;
    String imagen;
    String descripcion;
    float valoracion;
}
