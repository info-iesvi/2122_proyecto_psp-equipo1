# PROYECTO READMINE

#### Equipo 1 - 2ªDAM - Curso 2021/2022
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/logoReadMine.png)
#### Desarrollado por Ángel de la Fuente Jiménez & Miguel Ángel Vidal de Blanca

## ÍNDICE:

 - INTRODUCCIÓN
 - DESCRIPCIÓN
 - REQUISITOS DEL SISTEMA:
 - REQUISITOS NO FUNCIONALES
 - REQUISITOS FUNCIONALES
 - REQUISITOS DE INFORMACIÓN
 - CODIFICACIÓN DE MICROSERVICIO DE USUARIO EN MEMORIA
 - CODIFICACIÓN DE MICROSERVICIO DE USUARIO EN MONGO
 - CODIFICACIÓN DE MICROSERVICIO DE CHAT WEB E IMPLEMENTACIÓN EN REACT
 - CODIFICACIÓN DE MICROSERVICIO DE LIBRO EN MONGO
 - CODIFICACIÓN DE MICROSERVICIO DE COMENTARIO EN MONGO

## INTRODUCCIÓN:
El Equipo 1 busca ofrecer una plataforma cómoda y segura para promover y facilitar el buen hábito lector de modo que se adapte a nuevos usuarios con ganas de conocer nuevos mundos, historias, relatos, asi como personas con quien compartirlos. Buscamos ofrecer un buen catálogo de entradas comentadas por nuestros usuarios y un acceso a chats en vivo.

## DESCRIPCIÓN:
Buscamos ofrecer una plataforma online accesible desde navegador que permita la creación de nuevos usuarios y acceso a de estos al servicio. Dentro de éste tendrá a su disposición el acceso a un “catálogo” de entradas de libros y, al acceder, tendrá acceso automático a un chat en vivo sobre dicho libro así como comentarios en la entrada referida a este.

## REQUISITOS DEL SISTEMA:

El sistema tiene una serie de requisitos funcionales, no funcionales y de información:

### REQUISITOS NO FUNCIONALES:

| Requisito | Descripción |
| ------ | ------ |
| Accesible desde navegador | Debe funcionar en Firefox y Chrome. |
| Lenguaje programación | Se utilizará Java para su desarrollo. Podrán utilizarse otros lenguajes de soporte para el desarrollo Frontend, como Javascript. |
| Base de datos NoSQL | Se debe utilizar MongoDB. |
| Arquitectura de microservicios | El programa debe ser estructurado e implementado como microservicio. Preferiblemente dockerizado. |
| SO Linux - Ubuntu 20.04 | Debe ser ejecutable y funcional al iniciarse desde un SO Linux, concretamente Ubuntu 20.04 |

### REQUISITOS FUNCIONALES:

| Requisito | Identificador | Descripción |
| ------ | ------ | ------ |
| Crear usuario | RFU_1 | Se necesita insertar usuarios en el servicio, almacenando la información establecida en el  RI_1. |
| Modificar usuario | RFU_2 | Se necesita modificar datos de usuarios que ya se encuentren en el servicio, almacenando la nueva información establecida en el  RI_1. |
| Eliminar usuario | RFU_3 | Se necesita eliminar usuarios que ya se encuentren en el servicio, eliminandolo o estableciendo como inactivo  |
| Obtener usuarios | RFU_4 | Se necesita obtener datos de usuarios almacenados en el servicio, recogiendo la información establecida en el  RI_1 en forma de lista de usuarios. |
| Obtener usuario por su identificador | RFU_5 | Se necesita obtener datos de usuarios almacenados en el servicio, recogiendo la información establecida en el  RI_1 (usuario) a partir de un identificador. |
| Crear libro | RFL_1 | Se necesita insertar libros en el servicio, almacenando la información establecida en el  RI_2. |
| Modificar libro | RFL_2 | Se necesita insertar libros en el servicio, almacenando la información establecida en el  RI_2. |
| Eliminar libro | RFL_3 | Se necesita eliminar libros que ya se encuentren en el servicio, eliminandolo o estableciendo como inactivo. |
| Obtener libros | RFL_4 | Se necesita obtener datos de libros almacenados en el servicio, recogiendo la información establecida en el  RI_2 en forma de lista de libros. |
| Obtener libro por su identificador | RFL_5 | Se necesita obtener datos de libros almacenados en el servicio, recogiendo la información establecida en el  RI_2 (libro) a partir de un identificador. |
| Escribir en chat | RFCH_1 | Se necesita enviar información en forma de mensaje desde el chat, de modo que llegue a todos los que se encuentre en el chat, en ese momento. |
| Crear comentario | RFCO_1 | Se necesita insertar comentarios en el servicio, almacenando la información establecida en el  RI_3. |
| Modificar comentario | RFCO_2 | Se necesita modificar datos de comentarios que ya se encuentren en el servicio, almacenando la nueva información establecida en el  RI_3. |
| Eliminar comentario | RFCO_3 | Se necesita eliminar comentarios que ya se encuentren en el servicio, eliminandolo o estableciendo como inactivo. |
| Obtener comentarios | RFCO_4 | Se necesita obtener datos de comentarios almacenados en el servicio, recogiendo la información establecida en el  RI_3 en forma de lista de comentarios. |

## REQUISITO DE INFORMACIÓN:

| Requisito | Identificador | Descripción |
| ------ | ------ | ------ |
| Usuario | RI_1 | Se compone de los siguientes campos: - String Nombre - String Apellidos - String Username - String DNI - String correo - String clave - List<Comentario> listaComentarios - List<Libro> listaLibrosLeidos |
| Libro | RI_2 | Se compone de los siguientes campos: - String Titulo - String autor - String ISBN - LocalDate fechaCreacion - LocalDate fechaInsercion - String imagen - String Descripcion - float valoracion |
| Comentario | RI_3 | Se compone de los siguientes campos: - LocalDate fecha - String DNIautor - String contenido. |

## CASOS DE USO:

| Caso | Identificador | Descripción | Actor |
| ------ | ------ | ------ | ------ |
| Crear usuario | CUU_1 | El sistema debe recibir información de un usuario nuevo para insertarlo. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema inserta usuario y notifica.| Usuario
| Modificar usuario | CUU_2 | El sistema debe recibir información nueva de un usuario existente para modificar sus datos. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema modifica usuario y notifica.| Usuario
| Eliminar usuario | CUU_3 | El sistema debe recibir una petición de eliminación y el identificador de un usuario existente para eliminarlo. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema elimina usuario y notifica.| Usuario
| Obtener usuarios | CUU_4 | El sistema debe obtener todos los datos de usuarios existentes en el sistema. Pasos a seguir: - Usuario pide todos los usuarios - Sistema los recoge y notifica| Usuario
| Obtener usuario por su identificador | CUU_5 | El sistema debe recibir un identificador de usuario para obtener sus datos. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema obtiene al usuario y notifica.| Usuario
| Crear libro | CUL_1 | El sistema debe recibir información de un libro nuevo para insertarlo. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema inserta libro y notifica.| Usuario
| Modificar libro | CUL_2 | El sistema debe recibir información nueva de un libro existente para modificar sus datos. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema modifica libro y notifica.| Usuario
| Eliminar libro | CUL_3 | El sistema debe recibir una petición de eliminación y el identificador de un libro existente para eliminarlo. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema elimina libro y notifica.| Usuario
| Obtener libros | CUL_4 | El sistema debe obtener todos los datos de libros existentes en el sistema. Pasos a seguir: - Usuario pide todos los libros - Sistema los recoge y notifica| Usuario
| Obtener libro por su identificador | CUL_5 | El sistema debe recibir un identificador de libro para obtener sus datos. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema obtiene datos del libro y notifica.| Usuario
| Escribir en chat | CUCH_1 | El sistema debe recibir un mensaje de un usuario para insertarlo en el chat. Pasos a seguir: - Usuario envia mensaje - Sistema lo recoge y lo inserta en el chat de modo que llegue a todos los que se encuentren en dicho grupo de chat. - Tras ello notifica| Usuario
| Crear comentario | CUCO_1 | El sistema debe recibir información de un comentario nuevo para insertarlo. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de comentario. - Sistema inserta comentario y notifica.| Usuario
| Modificar comentario | CUCO_2 | El sistema debe recibir información nueva de un comentario existente para modificar sus datos. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de comentario. - Sistema modifica comentario y notifica.| Usuario
| Eliminar comentario | CUCO_3 | El sistema debe recibir una petición de eliminación y el identificador de un comentario existente para eliminarlo. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de comentario. - Sistema elimina comentario y notifica.| Usuario
| Obtener comentarios | CUCO_4 | El sistema debe obtener todos los datos de comentarios existentes en el sistema. Pasos a seguir: - Usuario pide todos los comentarios - Sistema los recoge y notifica| Usuario
 
 ### DIAGRAMA DE CLASES:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/Diagrama%20de%20clase.drawio%20(1).png)
 
 ### DIAGRAMA DE ENTIDAD-RELACIÓN:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/Diagrama%20Entidad-Relaci%C3%B3n%20Readmine%20DIA.png)
 
 ### GUI:
 
 ## CREAR USUARIO:
 
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/CreaUsuario.png)
 
 ## LOGIN:
 
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/Login.png)
 
 ## BIBLIOTECA:

![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/BibliotecaEquipo1.png)
 
 ## ENTRADA DE LIBRO:
 
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/EntradaLibro.png)
 
 ## CHAT:
 
 ![Texto alternativo]()
 
 ## CODIFICACIÓN DE MICROSERVICIO DE USUARIO EN MEMORIA
 
 ### GETALL
 
 Como podemos ver en este primer método estamos obteniendo la lista de usuarios almacenados en memoria, la cual se encuentra declarada como variable estática dentro de la propia clase, por lo que será accesible para el resto. El método nos devuelve un ResponseEntity con los datos y un estado OK, ya que independientemente de que la lista se encuentre con elementos o no, la resolución será satisfactoria.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/GetAllUsuario.PNG)
 
 Si lo probamos con Postman obtendremos el siguiente resultado, al no existir ningún tipo de dato insertado aún en memoria.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetAllUsuarioPostman.PNG)
 
 ### GET
 
 Método para la obtención concreta de usuarios a partir de un identificador, siendo en este caso la clave primaria de la entidad el DNI del usuario. Del mismo modo que ocurre con el método anterior se devuelve un ResponseEntity con los datos y el tipo de código de respuesta. Para distinguir entre uno y otro se procede a recorrer la lista de usuarios para encontrar si existe una coincidencia entre el DNI del usuario pasado y algún usuario de dentro de la lista. En caso afirmativo, el estado de respuesta es OK y los datos son recogidos. En caso contrario el código es Not Found y los datos serán NULL.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MentodoGetUsuario.PNG)
 
 Procedamos a probarlo en Postman:
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetUsuarioPostman.PNG)
 
 ### CREATE
 
 Método que nos va a permitir insertar nuevos usuarios en la lista. Para ello haremos uso del método add y devolveremos un ResponseEntity, como previamente hemos hecho:
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoCreateUsuario.PNG)
 
 La prueba en Postman consigue con éxito la adhesión del elemento nuevo en la lísta.
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaCreateUsuarioPostman.PNG)
 
 Como ya existen elementos en la lista, podemos ver los resultados también  el el muestreo de todos los elementos de la lista, es decir el método GetAll que ya hemos explicado:
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetAllUsuarioMongoTrasDeletePostman.PNG)
 
 ### MODIFY
 
 Método en el que modificaremos un elemento existente en la lista en base al DNI pasado por parámetros. Para ello primero comprobamos que existe dicho usuario en la lista. Si existe removemos el viejo y agregamos el nuevo en su lugar. Dependiendo de si se ha producido o no la modificación, nuestra variable booleana nos llevará a un ResponseEntity con un código u otro:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoModifyUsuario.PNG)
 
 Ahora vamos a realizar algunas comprobaciones con Postman:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaModifyUsuarioPostman.PNG)
 
 Como podemos ver se ha modificado el usuario correcto, con los datos nuevos (Su nombre). Ahora vamos a proceder a buscarlo a partir de su DNI:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetDelUsuarioModificadoPostman.PNG)
 
 Como podemos comprobar los cambios también son visibles y recuperables desde este método, ahora que existen datos que mostrar.
 
 ### DELETE
 
 Método para eliminar objetos de usuario de la lista. Para ello simplemente se recibe el DNI del usuario de modo que al recorrer la lista, si se encuentra un usuario con dicho DNI se notifica al programa con una variable booleana y se procede al borrado. En este caso como es un método de eliminación no queremos que devuelva un ResponseEntity con datos de objetos modelados, sino directamente un String con el mensaje propio a mostrar:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoDeleteUsuario.PNG)
 
 Procedamos finalmente con la prueba:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaDeleteUsuarioPostman.PNG)
 
 ## CODIFICACIÓN DE MICROSERVICIO DE USUARIO EN MONGO
 
 ### GETALL
 
 De nuevo nos encontramos con el método de obtención de todos los usuarios (en formato plano o VO) que se encuentren en nuestra base de datos MongoDB. Como la obtención es de tipo VO, estos son recogidos en una lista de elementos de este tipo pero a la hora de trabajar con ellos necesitamos convertirlos a DTO (Para ello he creado una clase Conversor que nos ofrezca la utilidad de alternar entre un tipo de objeto y otro).
 
 Como podemos comprobar, al proceder con la captura de datos se devolverá en todo caso una lista de usuarios DTO dentro de un ResponseEntity con el código OK, ya que siempre se devolverá una lista, tenga o no elementos.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoGetAllUsuarioMongo.PNG)
 
 Al igual que hicimos con la codificación del programa en Memoria vamos a proceder con las pruebas en Postman. Como podemos comprobar se nos devuelven los datos correctamente (Ha encontrado datos debido a que mientras programaba le microservicio he realizado inserciones):
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetAllUsuarioMongoPostman.PNG)
 
 ### GET
 
 Método para obtener un usuario concreto almacenado en la base de datos. Para ello primero verificaremos si existe algún usuario con ese identificador mediante el método findByID, que nos ofrece nuestro repositorio MongoDB. En caso de que lo encuentre nos devuelve un tipo de dato Optional. Si nos lo ha devuelto (Lo cual comprobamos con el método isPresent) obtenemos el tipo de dato VO mediante método get y devolvemos un ResponseEntity con el usuario en su versión DTO y un código OK. En caso opuesto se devolverá un usuario vacío y código Not Found.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoGetUsuarioMongo.PNG)
 
Como siempre procedemos con las pruebas en Postman:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetUsuarioMongoPostman.PNG)
 
 ### CREATE
 
 Método para la inserción de nuevos usuarios en la base de datos. Recordemos que para la inserción en Base de datos tenemos que usar objetos de tipo VO, por lo que primeramente procederemos a comprobar si ya existe dicho usuario en la base de datos, evitando inconsistencias de datos o duplicidad. En caso de que NO exista en la base de datos procederemos a almacenarlo, pero como lo que estamos recibiendo como parámetro es un DTO tendremos que convertirlo en VO gracias a nuestra clase Conversor. Como siempre dependiendo del éxito o fracaso de nuestro intento de inserción procederemos a devolver un ResponseEntity con un tipo de código y otro.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoCreateUsuarioMongo.PNG)
 
 Procedemos con las pruebas en Postman:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaCreateUsuarioMongoPostman.PNG)
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetAllTrasCreateUsuarioMongoPostman.PNG)
 
 ### DELETE
 
 Método para el borrado de usuarios en nuestra base de datos. Para ello utilizamos el DNI del usuario y comprobamos previamente esi ese usuario existente en base de datos. Si existe obtenemos un Optional presente, por lo que procederemos a borrar el elemento. Como siempre la devolución consta de un ResponseEntity con los datos y el código correspondiente.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoDeleteMongo.PNG)
 
 Procedemos a realizar las pruebas en Postman:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaDeleteUsuarioMongoPostman.PNG)
 
 Como podemos ver, al buscar por el DNI del usuario borrado obtenemos el código de error Not Found y un usuario vacío.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaDeleteUsuarioMongoNullPostman.PNG)
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetAllUsuarioMongoTrasDeletePostman.PNG)
 
 ### MODIFY
 
 Método para la modificación de un usuario de la base de datos a partir de su DNI. Para ello comprobamos previamente que exista el usuario en la base de datos y , en caso afirmativo, lo obtenemos como Optional y procedemos a insertar en su lugar los datos nuevos. Esto lo hacemos simplemente con el método save del repositorio de mongo, ya que aunque sea el mismo método utilizado para insertar nuevos elementos, si su identificador coincide en vez de insertar lo que hará es modificar los datos diferentes al estado previo. Como siempre dependo del resultado se devuelve aun ResponseEntity con un código u otro.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/MetodoModifyUsuarioMongo.PNG)
 
 Procedemos con las últimas comprobaciones de Postman:
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaModifyUsuarioMongoPostman.PNG)
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/PruebaGetUsuarioMongoTrasModifyPostman.PNG)
 
 ## CODIFICACIÓN DE MICROSERVICIO DE CHAT WEB E IMPLEMENTACIÓN EN REACT:
 
Para la implementación del chat hemos establecido un microservicio con Spring que se enlaza directamente con las peticiones realizadas desde REACT mediante JavaScript. El microservicio tiene la siguiente estructura:
 
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/arquitecturaChat.png)
 
  - Config: Directorio que contiene la clase WebSocketConfig, la cual es una clase de configuración de Spring con el siguiente contenido:
 
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat1.png)
 
Lo primero que encontramos es una anotación de configuración, la cual indica a Spring que la clase se debe utilizar como un componente de configuración del sistema. Posteriormente encontramos la anotación @EnableWebSocketMessageBroker, la sirve para indicar que la mensajería mediante nuestro WebSocket se va a habilitar.

Para que funcione esta habilitación deberemos hacer que nuestro archivo de configuración implemente la interfaz WebSockerMessageBrokerConfigurer, el cual nos va a obligar a implementar dos métodos necesarios de configuración:
 
   * registerStompEndpoints, que es el que establece el punto de salida de mensajes a registrar y de atención de peticiones (En nuestro caso nos interesa que se vincule con un punto de salida compatible con JavaScript, por lo que usaremos además el método “withSockJS”). Es importante destacar que la ruta mapeada es “ws”,  ya que la veremos más adelante en REACT para el establecimiento de la conexión y la creación del socket del cliente mediante JavaScript.
 
Documentación de referencia: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/socket/config/annotation/EnableWebSocketMessageBroker.html
 
   * configureMessageBroker, el cual sirve para configurar los prefijos de localización u origen de las peticiones. Mínimo deberemos habilitar el Broker Simple.

 - Controller: Directorio que contiene la clase ChatController. Esta clase es la que se encarga de recibir las peticiones desde nuestra interfaz en REACT.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat2.PNG)
 
Para recibir un mensaje (mediante la anotación @MessageMaping) y devolverlo a un destino concreto (mediante la anotación @SendTo). Actualmente se encuentra preparado para recibir mensajes desde la ruta “message” y devolverlos a la sala de chat general (ésta es precisamente la que nos interesa, porque la idea es que la sala de chat sea general para nuestro libro, no enviando mensajes privados). Además en esta clase se ha establecido un método recMessage privado, para que no llegue la respuesta a todo el chat general sino solo al usuario concreto con el que se mantiene la conversación.

En ambos casos se utiliza la anotación @Payload para la recepción del mensaje, devolviendo un objeto de la clase mensaje que posteriormente se trata en REACT, pero eso lo veremos más adelante.

 - Model: En este directorio se define una clase Message, que define los atributos que debe tener el mensaje:
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat3.PNG)
 
 Y posteriormente se define un ENUM denominado Status, que indica el estado que tendrá cada mensaje en su recepción y envío, con estos valores:
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat4.PNG)
 
Donde JOIN hace referencia a la adhesión de un nuevo cliente al chat, MESSAGE indica que el mensaje se está enviado o devolviendo y LEAVE indica que el cliente ha abandonado el chat.

A continuación vamos a ver cómo se gestiona desde REACT el servicio de CHAT.
Lo primero que hay que destacar es que para toda la gestión del chat se ha creado un componente denominado chat-component:
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat5.PNG)
 
 En el encontraremos lo siguiente:
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat6.PNG)
 
En primer lugar declaramos un cliente de stomp y lo establecemos en nulo para dale valor al ejecutar el método connect(). Posteriormente veremos que este es el cliente de socket javascript que va a permitir vincularnos con nuestro servicio de chat en Java para hacer peticiones hacia “ws”, que es la ruta mapeada que ya pudimos ver anteriormente en el servicio.

Posteriormente tenemos declaración de constantes para el mapeo, tanto valores concretos como los datos de estado del usuario, los cuales son rellenados mediante el método useEffect, que es un método similar en funcionamiento a componentDidMount de REACT (Función que se ejecuta a la hora de cargar el componente) pero orientado a ser usado en componentes de tipo función, las cuales no permiten el uso de componentDidMount.

Método connect. Como hemos comentado brevemente con anterioridad, este método es el que se encarga de declarar un socket y darle el valor devuelto por el servicio, creando el socket del cliente y estableciendo el valor a nuestro cliente de Socket Stomp de  javascript. Como podemos ver la conexión recibe 3 valores:
Valores extras de la conexión. como no queremos indicar ninguno estableceremos las llaves simples.
Método a ejecutar en caso de éxito en la conexión. En nuestro caso ese método será onConnected.
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat7.PNG)
 
Si nos fijamos se encarga de darle valor a UserData y establece la conexión en TRUE, permitiéndonos acceder al chat concreto. Para el acceso se ofrecen dos vertientes, la publica (que es la que nos interesa) y la privada (para hablar con usuarios concretos), manejadas ambas con el método suscribe.
Método a ejecutar en caso de error en la conexión. En nuestro caso será el método onError.
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat8.PNG)

Los siguientes método a destacar son estos dos:
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat9.PNG)

userJoin: Como podemos deducir éste método se encarga de enviar al servicio un mensaje de petición de acceso al sistema de chat, de modo que envía tanto los datos del usuario que se encuentra conectado como el estados correspondiente del ENUM que ya comentamos en su momento, en este caso con el valor JOIN.

onMessageReceived: Método que se encarga de recibir y manejar los mensajes enviados al char público, pero para ello lo que hace es recibir los datos de la anotación Payload que ya vimos en el servicio. Esta nos interesa porque identifica el estado del mensaje (Los estado recordemos que se definen en el ENUM del servicio). Si el estado es JOIN quiere decir que el usuario se está uniendo al chat, por lo que enviaremos al servicio los datos del usuario. Si por el contrario el estado es MESSAGE querremos decir que el usuario ya se encuentra unido, por lo que lo que se manejan serán los mensajes escritos. Existe un método exactamente igual para la gestión de mensajes privados, que se denomina onPrivateMessgae, pero el funcionamiento es igual solo que no orientado a enviar mensajes al chat general, por lo que no merece mayor explicación dado que no se le ha dado uso actualmente.

Los siguientes dos métodos se encargan de manejar los mensajes y de enviar los valores de estos:

   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat10.PNG)
 
handleMessage: Es un método que recibe el valor del elemento destacado, que es precisamente el input de escritura y mensajes que se encuentran en el chat. Este método se ejecuta cada vez que cambia el valor del campo, de modo que se mantenga siempre actualizado.
sendValue: Cuando ya queramos enviar el mensaje al servicio comprobaremos que el socket del cliente existe y en caso afirmativo enviaremos el mensaje con los datos del usuario y el estado correspondiente.

Con esto ya tendríamos el chat de modo funcional. Simplemente a la hora de ejecutar el método return de nuestro componente función de REACT para mostrar datos por pantalla deberemos comprobar si el usuario está conectado:

   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat11.PNG)
 
En caso afirmativo mostraremos la sala de chat con su cajas de texto y su botón de enviar mensajes y listado de usuarios conectados a la sala. En caso negativo se mostrará un pseudocomponente que se encargue de manejar la conexión del usuario para permitirle el acceso al chat:

 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat12.PNG)

Si nos fijamos concretamente lo que maneja este método registrerUser, el cual ejecutará directamente el método connect que ya explicamos anteriormente.
 
 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat13.PNG)

A continuación vamos a hacer una pequeña muestra visual de ejecución. Lo primero que tendremos al acceder al programa es un catálogo de libros, el cual se obtiene mediante el microservicio de libros y el componente book-list.component. Una vez dentro pulsaremos sobre el botón del chat:

 ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat14.PNG)

Nos pedirá introducir nuestro usuario para acceder al chat.
 
  ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat15.PNG)
 
Con ello accederemos al chat y aparecerá nuestro nombre de usuario:
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat16.PNG)
 
Ahora haremos lo mismo con otro usuario a que llamaremos “Pepesito” y enviará un mensaje a nuestro usuario principal:
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat17.PNG)
 
   ![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/chat18.PNG)
