package equipo1.comentarios.service.impl;

import equipo1.comentarios.model.ComentarioDTO;
import equipo1.comentarios.model.ComentarioVO;
import equipo1.comentarios.repository.ComentarioRepository;
import equipo1.comentarios.service.ComentarioService;
import equipo1.comentarios.util.ConversorComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    private ComentarioRepository libroRepository;
    public static List<ComentarioDTO> listaLibros = null;
    /*
    De nuevo nos encontramos con el método de obtención de todos los comentarios (en formato plano o VO)
    que se encuentren en nuestra base de datos MongoDB. Como la obtención es de tipo VO,
    estos son recogidos en una lista de elementos de este tipo pero a la hora de trabajar con ellos
    necesitamos convertirlos a DTO (Para ello he creado una clase Conversor que nos ofrezca la utilidad
    de alternar entre un tipo de objeto y otro). Como podemos comprobar, al proceder con la captura
    de datos se devolverá en todo caso una lista de usuarios DTO dentro de un ResponseEntity
    con el código OK, ya que siempre se devolverá una lista, tenga o no elementos.
    * */
    @Override
    public ResponseEntity<List<ComentarioDTO>> getAll() {
        List<ComentarioDTO> listaLibrosDTO = new ArrayList<>();
        List<ComentarioVO> listaLibrosVO = libroRepository.findAll();
        for(ComentarioVO lvo : listaLibrosVO){
            listaLibrosDTO.add(ConversorComentario.convertVOtoDTO(lvo));
        }
        return new ResponseEntity<List<ComentarioDTO>>(listaLibrosDTO, HttpStatus.OK);
    }
    /*
    Método para la inserción de nuevos comentarios en la base de datos. Recordemos
     que para la inserción en Base de datos tenemos que usar objetos de tipo VO,
     por lo que primeramente procederemos a comprobar si ya existe dicho usuario en la base
     de datos, evitando inconsistencias de datos o duplicidad. En caso de que NO exista en la
     base de datos procederemos a almacenarlo, pero como lo que estamos recibiendo como parámetro
     es un DTO tendremos que convertirlo en VO gracias a nuestra clase Conversor. Como siempre dependiendo
     del éxito o fracaso de nuestro intento de inserción procederemos a devolver un ResponseEntity con un tipo de código y otro.
    * */
    @Override
    public ResponseEntity<ComentarioDTO> create(ComentarioDTO comentariodto) {
        try{
            ComentarioVO comentariovo = ConversorComentario.convertDTOtoVO(comentariodto);
            libroRepository.insert(comentariovo);
            return new ResponseEntity<ComentarioDTO>(comentariodto,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ComentarioDTO>(comentariodto,HttpStatus.NOT_FOUND);
        }
    }
    /*
    Método para obtener un comentario concreto almacenado en la base de datos.
    Para ello primero verificaremos si existe algún comentario con ese identificador mediante el
    método findByID, que nos ofrece nuestro repositorio MongoDB. En caso de que lo encuentre
    nos devuelve un tipo de dato Optional. Si nos lo ha devuelto (Lo cual comprobamos con el método
    isPresent) obtenemos el tipo de dato VO mediante método get y devolvemos un
    ResponseEntity con el usuario en su versión DTO y un código OK. En
    caso opuesto se devolverá un usuario vacío y código Not Found.
    * */
    @Override
    public ResponseEntity<ComentarioDTO> get(String isbn) {
        ComentarioVO cvo = new ComentarioVO();
        Optional<ComentarioVO> optional = libroRepository.findById(isbn);
        if(optional.isPresent()){
            cvo = optional.get();
            return new ResponseEntity<ComentarioDTO>(ConversorComentario.convertVOtoDTO(cvo),HttpStatus.OK);
        }
        return new ResponseEntity<ComentarioDTO>(ConversorComentario.convertVOtoDTO(cvo),HttpStatus.NOT_FOUND);
    }
    /*
   Método para la modificación de un comentario de la base de datos a partir de su id.
   Para ello comprobamos previamente que exista el usuario en la base de datos y ,
   en caso afirmativo, lo obtenemos como Optional y procedemos a insertar en su
   lugar los datos nuevos. Esto lo hacemos simplemente con el método save del repositorio de mongo,
   ya que aunque sea el mismo método utilizado para insertar nuevos elementos, si su identificador
   coincide en vez de insertar lo que hará es modificar los datos diferentes al estado previo.
   Como siempre dependo del resultado se devuelve aun ResponseEntity con un código u otro.
   * */
    @Override
    public ResponseEntity<ComentarioDTO> modify(String id, ComentarioDTO comentariodto) {
        ComentarioVO cvo = new ComentarioVO();
        Optional<ComentarioVO> optional = libroRepository.findById(id);
        if(optional.isPresent()){
            cvo = optional.get();
            ComentarioVO datosNuevos = ConversorComentario.convertDTOtoVO(comentariodto);
            libroRepository.save(datosNuevos);
            return new ResponseEntity<ComentarioDTO>(ConversorComentario.convertVOtoDTO(datosNuevos),HttpStatus.OK);
        }else{
            return new ResponseEntity<ComentarioDTO>(ConversorComentario.convertVOtoDTO(cvo),HttpStatus.NOT_FOUND);
        }
    }
    /*
    Método para el borrado de comentarios en nuestra base de datos.
    Para ello utilizamos el id del comentario y comprobamos previamente esi ese usuario
    existente en base de datos. Si existe obtenemos un Optional presente, por lo que procederemos
    a borrar el elemento. Como siempre la devolución consta de un ResponseEntity con los datos y el código correspondiente.
    * */
    @Override
    public ResponseEntity<String> delete(String id) {
        ComentarioVO cvo = new ComentarioVO();
        Optional<ComentarioVO> optional = libroRepository.findById(id);
        if(optional.isPresent()){
            libroRepository.deleteById(id);
            return new ResponseEntity<String>("Comentario eliminado",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Comentario no encontrado",HttpStatus.NOT_FOUND);
        }
    }
}
