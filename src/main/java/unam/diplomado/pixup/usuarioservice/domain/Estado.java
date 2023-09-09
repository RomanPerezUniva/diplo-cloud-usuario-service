package unam.diplomado.pixup.usuarioservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="estados")
public class Estado {

	@Id
	private String id;
	private String nombre;
	
	
	
}
