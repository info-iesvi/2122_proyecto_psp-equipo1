package equipo1.mcusuarios.repository;

import equipo1.mcusuarios.model.UsuarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/*
Repositorio de la aplicación. En este caso extnederemso del repositorio de MongoDB para poder utilizar sus métodos y clases.
* */
@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioVO,String> {
}
