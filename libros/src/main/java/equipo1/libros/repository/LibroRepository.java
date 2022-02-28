package equipo1.libros.repository;

import equipo1.libros.model.LibroVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/*
Repositorio de la aplicación. En este caso extenderemos del repositorio de MongoDB para poder utilizar sus métodos y clases.
* */
@Repository
public interface LibroRepository extends MongoRepository<LibroVO,String> {
}
