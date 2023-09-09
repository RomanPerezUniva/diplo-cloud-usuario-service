package unam.diplomado.pixup.usuarioservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuarioservice.domain.Usuario;
import unam.diplomado.pixup.usuarioservice.dto.RegistroUsuarioRequest;
import unam.diplomado.pixup.usuarioservice.service.UsuarioService;

@RestController
public class UsuarioController  implements UsuarioApi{

	@Autowired
	private UsuarioService usuarioService;
	
		
	@Override
	public Usuario registrarUsuario(RegistroUsuarioRequest request) {
		// valida emay y guarda, lo que defini en el DTO
		return usuarioService.registrarUsuario(request.getUsuario(), request.getDomicilio());
	}

}
