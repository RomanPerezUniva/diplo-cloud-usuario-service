package unam.diplomado.pixup.usuarioservice.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

//Recordar documentos semi y estrusturados no les importa la normalizacion.
@Data
@NoArgsConstructor
@Document(collection = "usuarios")//maestro se convierte en una coleccion
public class Usuario {

	@Id //identificador unico en mongo para cada uno de los documentos que inserta
	private String id;
	@NotBlank(message = "Nombre no puede ser blanco")
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String password;
	@NotBlank(message = "Nombre no puede ser blanco")
	private String email;
	private String rfc;
	private Collection<Domicilio> domicilios=new LinkedHashSet<>(); //lo pone de manera interna como coleccion independiente, tiene jsons de tipo domicilio
	
}
