package equipo1.comentarios.repository;

import equipo1.comentarios.model.ComentarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/*
Repositorio de la aplicación. En este caso extnederemso del repositorio de MongoDB para poder utilizar sus métodos y clases.
* */
@Repository
public interface ComentarioRepository extends MongoRepository<ComentarioVO,String> {
}
