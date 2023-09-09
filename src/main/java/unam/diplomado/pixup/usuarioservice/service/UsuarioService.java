package unam.diplomado.pixup.usuarioservice.service;

import unam.diplomado.pixup.usuarioservice.domain.Domicilio;
import unam.diplomado.pixup.usuarioservice.domain.Usuario;

public interface UsuarioService {

	Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);
}
