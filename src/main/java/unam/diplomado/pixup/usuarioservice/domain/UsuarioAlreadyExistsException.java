package unam.diplomado.pixup.usuarioservice.domain;

public class UsuarioAlreadyExistsException extends RuntimeException {

	//descriptiva de nogocio
	//mecanismo adecuado para notificar excepciones de negocio
	//identificar el escenario de negocio
	public UsuarioAlreadyExistsException(String email) {
		super("Ya existe un usuario registrado con email: "+ email	);
	}
}
