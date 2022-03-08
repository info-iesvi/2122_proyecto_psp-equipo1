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
    public static List<UsuarioDTO> listaUsuarios = null;

    /*
    De nuevo nos encontramos con el método de obtención de todos los usuarios (en formato plano o VO)
    que se encuentren en nuestra base de datos MongoDB. Como la obtención es de tipo VO,
    estos son recogidos en una lista de elementos de este tipo pero a la hora de trabajar con ellos
    necesitamos convertirlos a DTO (Para ello he creado una clase Conversor que nos ofrezca la utilidad
    de alternar entre un tipo de objeto y otro). Como podemos comprobar, al proceder con la captura
    de datos se devolverá en todo caso una lista de usuarios DTO dentro de un ResponseEntity
    con el código OK, ya que siempre se devolverá una lista, tenga o no elementos.
    * */
    @Override
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();
        List<UsuarioVO> listaUsuariosVO = usuarioRepository.findAll();
        for(UsuarioVO uvo : listaUsuariosVO){
            listaUsuariosDTO.add(ConversorUsuario.convertVOtoDTO(uvo));
        }
        return new ResponseEntity<List<UsuarioDTO>>(listaUsuariosDTO, HttpStatus.OK);
    }

    /*
    Método para la inserción de nuevos usuarios en la base de datos. Recordemos
     que para la inserción en Base de datos tenemos que usar objetos de tipo VO,
     por lo que primeramente procederemos a comprobar si ya existe dicho usuario en la base
     de datos, evitando inconsistencias de datos o duplicidad. En caso de que NO exista en la
     base de datos procederemos a almacenarlo, pero como lo que estamos recibiendo como parámetro
     es un DTO tendremos que convertirlo en VO gracias a nuestra clase Conversor. Como siempre dependiendo
     del éxito o fracaso de nuestro intento de inserción procederemos a devolver un ResponseEntity con un tipo de código y otro.
    * */
    @Override
    public ResponseEntity<UsuarioDTO> create(UsuarioDTO usuariodto) {
        UsuarioVO uvo = new UsuarioVO();
        Optional<UsuarioVO> optional = usuarioRepository.findById(ConversorUsuario.convertDTOtoVO(usuariodto).getDNI());
        if(optional.isPresent()){
            //Se ha encontrado, no puede almacenarse
            return new ResponseEntity<UsuarioDTO>(ConversorUsuario.convertVOtoDTO(uvo),HttpStatus.NOT_FOUND);
        }else{
            //Puede almacenarse
            uvo = usuarioRepository.save(ConversorUsuario.convertDTOtoVO(usuariodto));
            return new ResponseEntity<UsuarioDTO>(ConversorUsuario.convertVOtoDTO(uvo),HttpStatus.OK);
        }
    }
    /*
    Método para obtener un usuario concreto almacenado en la base de datos.
    Para ello primero verificaremos si existe algún usuario con ese identificador mediante el
    método findByID, que nos ofrece nuestro repositorio MongoDB. En caso de que lo encuentre
    nos devuelve un tipo de dato Optional. Si nos lo ha devuelto (Lo cual comprobamos con el método
    isPresent) obtenemos el tipo de dato VO mediante método get y devolvemos un
    ResponseEntity con el usuario en su versión DTO y un código OK. En
    caso opuesto se devolverá un usuario vacío y código Not Found.
    * */
    @Override
    public ResponseEntity<UsuarioDTO> get(String dni) {
        UsuarioVO uvo = new UsuarioVO();
        Optional<UsuarioVO> optional = usuarioRepository.findById(dni);
        if(optional.isPresent()){
            uvo = optional.get();
            return new ResponseEntity<UsuarioDTO>(ConversorUsuario.convertVOtoDTO(uvo),HttpStatus.OK);
        }
        return new ResponseEntity<UsuarioDTO>(ConversorUsuario.convertVOtoDTO(uvo),HttpStatus.NOT_FOUND);
    }
    /*
    Método para la modificación de un usuario de la base de datos a partir de su DNI.
    Para ello comprobamos previamente que exista el usuario en la base de datos y ,
    en caso afirmativo, lo obtenemos como Optional y procedemos a insertar en su
    lugar los datos nuevos. Esto lo hacemos simplemente con el método save del repositorio de mongo,
    ya que aunque sea el mismo método utilizado para insertar nuevos elementos, si su identificador
    coincide en vez de insertar lo que hará es modificar los datos diferentes al estado previo.
    Como siempre dependo del resultado se devuelve aun ResponseEntity con un código u otro.
    * */
    @Override
    public ResponseEntity<UsuarioDTO> modify(String dni, UsuarioDTO usuariodto) {
        UsuarioVO uvo = new UsuarioVO();
        Optional<UsuarioVO> optional = usuarioRepository.findById(dni);
        if(optional.isPresent()){
            uvo = optional.get();
            UsuarioVO datosNuevos = ConversorUsuario.convertDTOtoVO(usuariodto);
            usuarioRepository.save(datosNuevos);
            return new ResponseEntity<UsuarioDTO>(ConversorUsuario.convertVOtoDTO(datosNuevos),HttpStatus.OK);
        }else{
            return new ResponseEntity<UsuarioDTO>(ConversorUsuario.convertVOtoDTO(uvo),HttpStatus.NOT_FOUND);
        }
    }
    /*
    Método para el borrado de usuarios en nuestra base de datos.
    Para ello utilizamos el DNI del usuario y comprobamos previamente esi ese usuario
    existente en base de datos. Si existe obtenemos un Optional presente, por lo que procederemos
    a borrar el elemento. Como siempre la devolución consta de un ResponseEntity con los datos y el código correspondiente.
    * */
    @Override
    public ResponseEntity<String> delete(String dni) {
        UsuarioVO uvo = new UsuarioVO();
        Optional<UsuarioVO> optional = usuarioRepository.findById(dni);
        if(optional.isPresent()){
            usuarioRepository.deleteById(dni);
            return new ResponseEntity<String>("Usuario eliminado",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Usuario no encontrado",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public boolean login(String userName, String clave) {
        List<UsuarioVO> lista = usuarioRepository.findAll();
        for(UsuarioVO uvo : lista){
            if(uvo.getUsername().equals(userName) && uvo.getClave().equals(clave)){
                return true;
            }
        }
        return false;
    }
}
