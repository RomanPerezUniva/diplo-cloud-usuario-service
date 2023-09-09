package unam.diplomado.pixup.usuarioservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.usuarioservice.domain.TipoDomicilio;

public interface TipoDomicilioRepository extends MongoRepository<TipoDomicilio, String>{

}
