package unam.diplomado.pixup.usuarioservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.usuarioservice.domain.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	//busqueda por email unico, dinamica
	Optional<Usuario> findByEmail(String email);

}
