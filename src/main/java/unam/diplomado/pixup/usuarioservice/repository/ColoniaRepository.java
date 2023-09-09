package unam.diplomado.pixup.usuarioservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.usuarioservice.domain.Colonia;

public interface ColoniaRepository extends MongoRepository<Colonia, String>{

	List<Colonia> findByCp(String cp);
}
