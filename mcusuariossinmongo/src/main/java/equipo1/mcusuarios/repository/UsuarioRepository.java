package equipo1.mcusuarios.repository;

import equipo1.mcusuarios.model.UsuarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioVO,String> {
}
