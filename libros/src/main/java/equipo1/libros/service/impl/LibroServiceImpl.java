package equipo1.libros.service.impl;

import equipo1.libros.model.LibroDTO;
import equipo1.libros.model.LibroVO;
import equipo1.libros.model.Request;
import equipo1.libros.repository.LibroRepository;
import equipo1.libros.service.LibroService;
import equipo1.libros.util.ConversorLibro;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.Writer;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
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

    @Override
    public boolean SendRequest(Request request) {
       HiloRequest hilo = new HiloRequest(request);
       hilo.start();
       return true;
    }
}

class HiloRequest extends Thread{
    Request request;
    public HiloRequest(Request request){
        super();
        this.request = request;
    }

    public void run(){
        AuthenticatingSMTPClient clienteAutentificado = new AuthenticatingSMTPClient();
        //Establecemos los datos de usuario
        String servidor = "smtp.gmail.com";
        String usuario = "readmepsp@gmail.com";
        String clave = "readme1234";
        int puerto = 587;  //Puerto que se utiliza para TSL/STARTTSL
        String remitente = "miguelvidaldeblanca@gmail.com";
        try{
            int respuesta;
            //Intentamos crear una KEY, esta es necesaria para estabelcer un canal seguro
            KeyManagerFactory fabricaKey = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            fabricaKey.init(null,null);
            KeyManager manejador = fabricaKey.getKeyManagers()[0];
            //Nos conectamos al servidor SMTP
            clienteAutentificado.connect(servidor,puerto);
            System.out.println("1 - "+clienteAutentificado.getReplyString());
            //Enviamos el comando EHLO. Esto e scompletamente necesario!!!!
            clienteAutentificado.ehlo(servidor);
            System.out.println("2 - "+clienteAutentificado.getReplyString());

            // MODO NO IMPLICITO - NECESITA NEGOCIAR TLS
            //Esto se hace ejecutando el comando execTLS y comprobando si es true
            if(clienteAutentificado.execTLS()) {
                System.out.println("3 - " + clienteAutentificado.getReplyString());
                //Nos autentificamos ante el servdiro
                if (clienteAutentificado.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, usuario, clave)) {
                    System.out.println("4 - " + clienteAutentificado.getReplyString());
                    String destinatario1 = request.getEmail();
                    String asunto = "Sugerencia Readmine";

                    //Creamos nuestra cabecera
                    SimpleSMTPHeader cabeceraSimple = new SimpleSMTPHeader(remitente, destinatario1, asunto);
                    clienteAutentificado.setSender(usuario);
                    clienteAutentificado.addRecipient(destinatario1);
                    System.out.println("5 - " + clienteAutentificado.getReplyString());
                    //Creamos neustro Writer para datas y lo enviamos:
                    Writer writer = clienteAutentificado.sendMessageData();
                    if (writer == null) {
                        System.out.println("Fallo al enviar DATA");
                        System.exit(1);
                    }
                    writer.write(cabeceraSimple.toString());
                    String mensaje = "Buenas, hemos recibido tu siguiente sugerencia: " + request.getMessage() + "\nMuchas gracias por apoyar nuestro blog, estamos trabajando para que ese libro llegue al blog.";
                    writer.write(mensaje);
                    writer.close();
                    System.out.println("6 - " + clienteAutentificado.getReplyString());
                    boolean exito = clienteAutentificado.completePendingCommand();
                    System.out.println("7 - " + clienteAutentificado.getReplyString());
                    if (!exito) {
                        System.out.println("No se ha podido completar la transacción.");
                        System.exit(1);
                    } else {
                        System.out.println("Mensaje enviado con éxito.");
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }
}
