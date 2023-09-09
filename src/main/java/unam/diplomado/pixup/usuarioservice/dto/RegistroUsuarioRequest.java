package unam.diplomado.pixup.usuarioservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.usuarioservice.domain.Domicilio;
import unam.diplomado.pixup.usuarioservice.domain.Usuario;

//encapsula usuario y domicilio
@Data
@NoArgsConstructor
public class RegistroUsuarioRequest {
	//objt contiene los objetos que yo necesito
	//composiciones de objeto de dominio para transmitir informacion
	@NotNull
	@Valid
	private Usuario usuario;
	@NotNull
	@Valid
	private Domicilio domicilio;
	
}
