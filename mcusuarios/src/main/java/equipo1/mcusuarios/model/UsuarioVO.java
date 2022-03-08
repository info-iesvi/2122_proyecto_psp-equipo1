package equipo1.mcusuarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioVO {
    @Id
    String DNI;
    String nombre;
    String apellidos;
    String Username;
    String clave;
    String correo;
    List<String> listaComentarios;
    List<String> listaLibrosLeidos;
}
