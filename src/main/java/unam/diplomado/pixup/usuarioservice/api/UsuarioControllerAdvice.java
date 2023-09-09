package unam.diplomado.pixup.usuarioservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import unam.diplomado.pixup.usuarioservice.domain.UsuarioAlreadyExistsException;

//Es el manejador de excepciones para usuario controller

@RestControllerAdvice
public class UsuarioControllerAdvice {
	
	//*manejador de excepciones, para arrojar una excepcion de negocio donde yo lo tomo con ese advice que esta escuchando ese tipo de escepciones,
	//pasos : sucede, la toma , la transforma en codigo http adecuado para el escenario ej: conflict 409 (es un conficto de sincronizacion de entidades-valores)
	//Y como cuerpo del mensaje nos manda la descripcion del error.
	@ExceptionHandler(UsuarioAlreadyExistsException.class)//1) estas excepciones de negocio las transforma a : 
	//codigo hhtpo
	//*Se espera que si mando a ejecutar un request con el email existente ya no debe de mandarnos un error 500 internal server error sino un 409
	//manda "Ya existe un usuario registrado con email: urielhdezorozco156@yahoo.com.mx"
	@ResponseStatus(HttpStatus.CONFLICT) //2)las transforman a codigos http correctos para informar el error 
	private String usuarioAlreadyExistsHandler( //3) aqui estamos mandando una cadena que tiene un valor (no json)
			UsuarioAlreadyExistsException exception) {
		return exception.getMessage(); //4) Donde le mandamos el mensaje de la excepcion
	}
	
	//400 cuando el framework detecta
	 //* Se espera que si le mando un mal request por ejemplo sin nombre  (nombre:"")
	//manda "Existen errores de validacion en el payload"
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) //Mandamos un codigo 400
	private String validatorHandler( //
			MethodArgumentNotValidException exception) {
		return "Existen errores de validacion en el payload"; //4) y tienen la oportunidad de generar el mensaje que quieran.
	}
	

}
