package equipo1.mcusuarios.service.impl;

import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.model.UsuarioVO;
import equipo1.mcusuarios.repository.UsuarioRepository;
import equipo1.mcusuarios.service.UsuarioService;
import equipo1.mcusuarios.util.ConversorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public static List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();

    /*
    Como podemos ver en este primer método estamos obteniendo la lista de usuarios almacenados en memoria,
    la cual se encuentra declarada como variable estática dentro de la propia clase, por lo que será accesible para el resto.
    El método nos devuelve un ResponseEntity con los datos y un estado OK, ya que independientemente de que la lista se encuentre con elementos o no,
     la resolución será satisfactoria. Si lo probamos con Postman obtendremos el siguiente resultado,
     al no existir ningún tipo de dato insertado aún en memoria.

    * */
    @Override
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> listaUsuariosDTOMemoria = listaUsuarios;
        return new ResponseEntity<List<UsuarioDTO>>(listaUsuariosDTOMemoria, HttpStatus.OK);
    }

    /*
    Método que nos va a permitir insertar nuevos usuarios en la lista.
    Para ello haremos uso del método add y devolveremos un ResponseEntity, como previamente hemos hecho:
    * */
    @Override
    public ResponseEntity<UsuarioDTO> create(UsuarioDTO usuariodto) {
        listaUsuarios.add(usuariodto);
        return new ResponseEntity<UsuarioDTO>(usuariodto, HttpStatus.OK);
    }

    /*
    Método para la obtención concreta de usuarios a partir de un identificador,
    siendo en este caso la clave primaria de la entidad el DNI del usuario.
    Del mismo modo que ocurre con el método anterior se devuelve un ResponseEntity
    con los datos y el tipo de código de respuesta. Para distinguir entre uno y otro se procede a recorrer la lista
    de usuarios para encontrar si existe una coincidencia entre el DNI del usuario pasado y algún usuario de dentro
    de la lista. En caso afirmativo, el estado de respuesta es OK y los datos son recogidos.
    En caso contrario el código es Not Found y los datos serán NULL.
    * */
    @Override
    public ResponseEntity<UsuarioDTO> get(String dni) {
        UsuarioDTO dto = new UsuarioDTO();
        boolean encontrado = false;
        for(UsuarioDTO udto : listaUsuarios){
            if(udto.getDNI().equalsIgnoreCase(dni)){
                dto = udto;
                encontrado = true;
            }
        }
        if(encontrado){
            return new ResponseEntity<UsuarioDTO>(dto,HttpStatus.OK);
        }else{
            return new ResponseEntity<UsuarioDTO>(dto,HttpStatus.NOT_FOUND);
        }
    }

    /*
    Método en el que modificaremos un elemento existente en la lista en base al DNI pasado por parámetros.
    Para ello primero comprobamos que existe dicho usuario en la lista. Si existe removemos el viejo
    y agregamos el nuevo en su lugar. Dependiendo de si se ha producido o no la modificación,
    nuestra variable booleana nos llevará a un ResponseEntity con un código u otro:
    * */
    @Override
    public ResponseEntity<UsuarioDTO> modify(String dni, UsuarioDTO usuariodto) {
        UsuarioDTO dto = new UsuarioDTO();
        boolean encontrado = false;
        for(UsuarioDTO udto : listaUsuarios){
            if(udto.getDNI().equalsIgnoreCase(dni)){
                listaUsuarios.remove(udto);
                listaUsuarios.add(usuariodto);
                dto = usuariodto;
                encontrado = true;
            }
        }
        if(encontrado){
            return new ResponseEntity<UsuarioDTO>(dto,HttpStatus.OK);
        }else{
            return new ResponseEntity<UsuarioDTO>(dto,HttpStatus.NOT_FOUND);
        }
    }

    /*
    Método para eliminar objetos de usuario de la lista. Para ello simplemente se recibe el
    DNI del usuario de modo que al recorrer la lista, si se encuentra un usuario con dicho DNI se notifica
    al programa con una variable booleana y se procede al borrado. En este caso como es un método
    de eliminación no queremos que devuelva un ResponseEntity con datos de objetos modelados, sino
    directamente un String con el mensaje propio a mostrar:
    * */
    @Override
    public ResponseEntity<String> delete(String dni) {
        UsuarioDTO dto = new UsuarioDTO();
        boolean encontrado = false;
        for(UsuarioDTO udto : listaUsuarios){
            if(udto.getDNI().equalsIgnoreCase(dni)){
                dto = udto;
                encontrado = true;
            }
        }
        if(encontrado){
            listaUsuarios.remove(dto);
            return new ResponseEntity<String>("Usuario eliminado",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Usuario no eliminado",HttpStatus.NOT_FOUND);
        }

    }
}
