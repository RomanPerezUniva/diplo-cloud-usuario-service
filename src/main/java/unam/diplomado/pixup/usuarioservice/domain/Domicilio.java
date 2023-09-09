package unam.diplomado.pixup.usuarioservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//Esclavo no tiene coleccion, todo en la bd se va a guardar como tipo usuario y tiene un arreglo de tipo domicilio
public class Domicilio { //no existe Id
	@NotBlank(message = "No puede ser blanco")
	@Size(min = 3, max = 30, message = "Calle debe contener entre {min} y {max}")
	private String calle;
	@NotBlank(message = "No puede ser blanco")
	@Size(min = 1, max = 30, message = "Numero Exterior debe contener entre {min} y {max}")
	private String numExterior;
	private String numInterior;
	
}
