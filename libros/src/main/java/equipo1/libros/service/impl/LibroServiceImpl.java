package equipo1.libros.service.impl;

import equipo1.libros.model.LibroDTO;
import equipo1.libros.model.LibroVO;
import equipo1.libros.repository.LibroRepository;
import equipo1.libros.service.LibroService;
import equipo1.libros.util.ConversorLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;
    public static List<LibroDTO> listaLibros = null;
    /*
    Nos encontramos con el método de obtención de todos los libros (en formato plano o VO)
    que se encuentren en nuestra base de datos MongoDB. Como la obtención es de tipo VO,
    estos son recogidos en una lista de elementos de este tipo pero a la hora de trabajar con ellos
    necesitamos convertirlos a DTO (Para ello he creado una clase Conversor que nos ofrezca la utilidad
    de alternar entre un tipo de objeto y otro). Como podemos comprobar, al proceder con la captura
    de datos se devolverá en todo caso una lista de usuarios DTO dentro de un ResponseEntity
    con el código OK, ya que siempre se devolverá una lista, tenga o no elementos.
    * */
    @Override
    public ResponseEntity<List<LibroDTO>> getAll() {
        List<LibroDTO> listaLibrosDTO = new ArrayList<>();
        List<LibroVO> listaLibrosVO = libroRepository.findAll();
        for(LibroVO lvo : listaLibrosVO){
            listaLibrosDTO.add(ConversorLibro.convertVOtoDTO(lvo));
        }
        return new ResponseEntity<List<LibroDTO>>(listaLibrosDTO, HttpStatus.OK);
    }
    /*
    Método para la inserción de nuevos libros en la base de datos. Recordemos
     que para la inserción en Base de datos tenemos que usar objetos de tipo VO,
     por lo que primeramente procederemos a comprobar si ya existe dicho libro en la base
     de datos, evitando inconsistencias de datos o duplicidad. En caso de que NO exista en la
     base de datos procederemos a almacenarlo, pero como lo que estamos recibiendo como parámetro
     es un DTO tendremos que convertirlo en VO gracias a nuestra clase Conversor. Como siempre dependiendo
     del éxito o fracaso de nuestro intento de inserción procederemos a devolver un ResponseEntity con un tipo de código y otro.
    * */
    @Override
    public ResponseEntity<LibroDTO> create(LibroDTO librodto) {
        try{
            LibroVO librovo = ConversorLibro.convertDTOtoVO(librodto);
            libroRepository.insert(librovo);
            return new ResponseEntity<LibroDTO>(librodto,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<LibroDTO>(librodto,HttpStatus.NOT_FOUND);
        }
    }
    /*
    Método para obtener un libro concreto almacenado en la base de datos.
    Para ello primero verificaremos si existe algún libro con ese identificador mediante el
    método findByID, que nos ofrece nuestro repositorio MongoDB. En caso de que lo encuentre
    nos devuelve un tipo de dato Optional. Si nos lo ha devuelto (Lo cual comprobamos con el método
    isPresent) obtenemos el tipo de dato VO mediante método get y devolvemos un
    ResponseEntity con el usuario en su versión DTO y un código OK. En
    caso opuesto se devolverá un libro vacío y código Not Found.
    * */
    @Override
    public ResponseEntity<LibroDTO> get(String isbn) {
        LibroVO lvo = new LibroVO();
        Optional<LibroVO> optional = libroRepository.findById(isbn);
        if(optional.isPresent()){
            lvo = optional.get();
            return new ResponseEntity<LibroDTO>(ConversorLibro.convertVOtoDTO(lvo),HttpStatus.OK);
        }
        return new ResponseEntity<LibroDTO>(ConversorLibro.convertVOtoDTO(lvo),HttpStatus.NOT_FOUND);
    }
    /*
    Método para la modificación de un libro de la base de datos a partir de su ISBN.
    Para ello comprobamos previamente que exista el usuario en la base de datos y ,
    en caso afirmativo, lo obtenemos como Optional y procedemos a insertar en su
    lugar los datos nuevos. Esto lo hacemos simplemente con el método save del repositorio de mongo,
    ya que aunque sea el mismo método utilizado para insertar nuevos elementos, si su identificador
    coincide en vez de insertar lo que hará es modificar los datos diferentes al estado previo.
    Como siempre dependo del resultado se devuelve un ResponseEntity con un código u otro.
    * */
    @Override
    public ResponseEntity<LibroDTO> modify(String isbn, LibroDTO librodto) {
        LibroVO lvo = new LibroVO();
        Optional<LibroVO> optional = libroRepository.findById(isbn);
        if(optional.isPresent()){
            lvo = optional.get();
            LibroVO datosNuevos = ConversorLibro.convertDTOtoVO(librodto);
            libroRepository.save(datosNuevos);
            return new ResponseEntity<LibroDTO>(ConversorLibro.convertVOtoDTO(datosNuevos),HttpStatus.OK);
        }else{
            return new ResponseEntity<LibroDTO>(ConversorLibro.convertVOtoDTO(lvo),HttpStatus.NOT_FOUND);
        }
    }
    /*
    Método para el borrado de libros en nuestra base de datos.
    Para ello utilizamos el DNI del usuario y comprobamos previamente si ese usuario
    existente en base de datos. Si existe obtenemos un Optional presente, por lo que procederemos
    a borrar el elemento. Como siempre la devolución consta de un ResponseEntity con los datos y el código correspondiente.
    * */
    @Override
    public ResponseEntity<String> delete(String isbn) {
        LibroVO lvo = new LibroVO();
        Optional<LibroVO> optional = libroRepository.findById(isbn);
        if(optional.isPresent()){
            libroRepository.deleteById(isbn);
            return new ResponseEntity<String>("Libro eliminado",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Libro no encontrado",HttpStatus.NOT_FOUND);
        }
    }
}
