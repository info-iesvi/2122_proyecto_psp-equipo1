# PROYECTO READMINE

#### Equipo 1 - 2ªDAM - Curso 2021/2022
![Texto alternativo](https://github.com/info-iesvi/2122_proyecto_psp-equipo1/blob/doc/logoReadMine.png)
#### Desarrollado por Ángel de la Fuente Jiménez & Miguel Ángel Vidal de Blanca

## ÍNDICE:

 - INTRODUCCIÓN
 - DESCRIPCIÓN
 - REQUESITOS DEL SISTEMA:
 - REQUESITOS NO FUNCIONALES
 - REQUESITOS FUNCIONALES
 - REQUESITOS DE INFORMACIÓN

## INTRODUCCIÓN:
El Equipo 1 busca ofrecer una plataforma cómoda y segura para promover y facilitar el buen hábito lector de modo que se adapte a nuevos usuarios con ganas de conocer nuevos mundos, historias, relatos, asi como personas con quien compartirlos. Buscamos ofrecer un buen catálogo de entradas comentadas por nuestros usuarios y un acceso a chats en vivo.

## DESCRIPCIÓN:
Buscamos ofrecer una plataforma online accesible desde navegador que permita la creación de nuevos usuarios y acceso a de estos al servicio. Dentro de éste tendrá a su disposición el acceso a un “catálogo” de entradas de libros y, al acceder, tendrá acceso automático a un chat en vivo sobre dicho libro así como comentarios en la entrada referida a este.

## REQUESITOS DEL SISTEMA:

El sistema tiene una serie de requisitos funcionales, no funcionales y de información:

### REQUESITOS NO FUNCIONALES:

| Requesito | Descripción |
| ------ | ------ |
| Accesible desde navegador | Debe funcionar en Firefox y Chrome. |
| Lenguaje programación | Se utilizará Java para su desarrollo. Podrán utilizarse otros lenguajes de soporte para el desarrollo Frontend, como Javascript. |
| Base de datos NoSQL | Se debe utilizar MongoDB. |
| Arquitectura de microservicios | El programa debe ser estructurado e implementado como microservicio. Preferiblemente dockerizado. |
| SO Linux - Ubuntu 20.04 | Debe ser ejecutable y funcional al iniciarse desde un SO Linux, concretamente Ubuntu 20.04 |

### REQUISITOS FUNCIONALES:

| Requesito | Identificador | Descripción |
| ------ | ------ | ------ |
| Crear usuario | RFU_1 | Se necesita insertar usuarios en el servicio, almacenando la información establecida en el  RI_1. |
| Modificar usuario | RFU_2 | Se necesita modificar datos de usuarios que ya se encuentren en el servicio, almacenando la nueva información establecida en el  RI_1. |
| Eliminar usuario | RFU_3 | Se necesita eliminar usuarios que ya se encuentren en el servicio, eliminandolo o estableciendo como inactivo  |
| Obtener usuarios | RFU_4 | Se necesita obtener datos de usuarios almacenados en el servicio, recogiendo la información establecida en el  RI_1 en forma de lista de objetos de usuario. |
| Obtener usuario por su identificador | RFU_5 | Se necesita obtener datos de usuarios almacenados en el servicio, recogiendo la información establecida en el  RI_1 en forma de objeto de usuario a partir de un identificador. |
| Crear libro | RFL_1 | Se necesita insertar libros en el servicio, almacenando la información establecida en el  RI_2. |
| Modificar libro | RFL_2 | Se necesita insertar libros en el servicio, almacenando la información establecida en el  RI_2. |
| Eliminar libro | RFL_3 | Se necesita eliminar libros que ya se encuentren en el servicio, eliminandolo o estableciendo como inactivo. |
| Obtener libros | RFL_4 | Se necesita obtener datos de libros almacenados en el servicio, recogiendo la información establecida en el  RI_2 en forma de lista de objetos de libro. |
| Obtener libro por su identificador | RFL_5 | Se necesita obtener datos de libros almacenados en el servicio, recogiendo la información establecida en el  RI_2 en forma de objeto de libro a partir de un identificador. |
| Escribir en chat | RFCH_1 | Se necesita enviar información en forma de mensaje desde el chat, de modo que llegue a todos los que se encuentre en el chat, en ese momento. |
| Crear comentario | RFCO_1 | Se necesita insertar comentarios en el servicio, almacenando la información establecida en el  RI_3. |
| Modificar comentario | RFCO_2 | Se necesita modificar datos de comentarios que ya se encuentren en el servicio, almacenando la nueva información establecida en el  RI_3. |
| Eliminar comentario | RFCO_3 | Se necesita eliminar comentarios que ya se encuentren en el servicio, eliminandolo o estableciendo como inactivo. |
| Obtener comentarios | RFCO_4 | Se necesita obtener datos de comentarios almacenados en el servicio, recogiendo la información establecida en el  RI_3 en forma de lista de objetos de comentario. |

## REQUESITO DE INFORMACIÓN:

| Requesito | Identificador | Descripción |
| ------ | ------ | ------ |
| Usuario | RI_1 | Se compone de los siguientes campos: - String Nombre - String Apellidos - String Username - String DNI - String correo - String clave - List<Comentario> listaComentarios - List<Libro> listaLibrosLeidos |
| Libro | RI_2 | Se compone de los siguientes campos: - String Titulo - String autor - String ISBN - LocalDate fechaCreacion - LocalDate fechaInsercion - String imagen - String Descripcion - float valoracion |
| Comentario | RI_3 | Se compone de los siguientes campos: - LocalDate fecha - String DNIautor - String contenido. |

## CASOS DE USO:

| Caso | Identificador | Descripción |
| ------ | ------ | ------ |
| Crear usuario | CUU_1 | El sistema debe recibir información de un usuario nuevo para insertarlo. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema inserta usuario y notifica.|
| Modificar usuario | CUU_2 | El sistema debe recibir información nueva de un usuario existente para modificar sus datos. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema modifica usuario y notifica.|
| Eliminar usuario | CUU_3 | El sistema debe recibir una petición de eliminación y el identificador de un usuario existente para eliminarlo. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema elimina usuario y notifica.|
| Obtener usuarios | CUU_4 | El sistema debe obtener todos los datos de usuarios existentes en el sistema. Pasos a seguir: - Usuario pide todos los usuarios - Sistema los recoge y notifica|
| Obtener usuario por su identificador | CUU_5 | El sistema debe recibir un identificador de usuario para obtener sus datos. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de usuario. - Sistema obtiene al usuario y notifica.|
| Crear libro | CUL_1 | El sistema debe recibir información de un libro nuevo para insertarlo. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema inserta libro y notifica.|
| Modificar libro | CUL_2 | El sistema debe recibir información nueva de un libro existente para modificar sus datos. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema modifica libro y notifica.|
| Eliminar libro | CUL_3 | El sistema debe recibir una petición de eliminación y el identificador de un libro existente para eliminarlo. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema elimina libro y notifica.|
| Obtener libros | CUL_4 | El sistema debe obtener todos los datos de libros existentes en el sistema. Pasos a seguir: - Usuario pide todos los libros - Sistema los recoge y notifica|
| Obtener libro por su identificador | CUL_5 | El sistema debe recibir un identificador de libro para obtener sus datos. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de libro. - Sistema obtiene datos del libro y notifica.|
| Escribir en chat | CUCH_1 | El sistema debe recibir un mensaje de un usuario para insertarlo en el chat. Pasos a seguir: - Usuario envia mensaje - Sistema lo recoge y lo inserta en el chat de modo que llegue a todos los que se encuentren en dicho grupo de chat. - Tras ello notifica|
| Crear comentario | CUCO_1 | El sistema debe recibir información de un comentario nuevo para insertarlo. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de comentario. - Sistema inserta comentario y notifica.|
| Modificar comentario | CUCO_2 | El sistema debe recibir información nueva de un comentario existente para modificar sus datos. Pasos a seguir: - Usuario inserta información. - Sistema recoge información - Sistema comprueba identificador de comentario. - Sistema modifica comentario y notifica.|
| Eliminar comentario | CUCO_3 | El sistema debe recibir una petición de eliminación y el identificador de un comentario existente para eliminarlo. Pasos a seguir: - Usuario inserta identificador. - Sistema recoge información - Sistema comprueba identificador de comentario. - Sistema elimina comentario y notifica.|
| Obtener comentarios | CUCO_4 | El sistema debe obtener todos los datos de comentarios existentes en el sistema. Pasos a seguir: - Usuario pide todos los comentarios - Sistema los recoge y notifica|



