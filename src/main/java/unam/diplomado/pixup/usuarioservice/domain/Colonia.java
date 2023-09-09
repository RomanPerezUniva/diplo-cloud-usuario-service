package unam.diplomado.pixup.usuarioservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "colonias")
public class Colonia {

	@Id
	private String id;
	private String nombre;
	private String cp;
	
	
	@DBRef
	private Municipio municipio;
}
