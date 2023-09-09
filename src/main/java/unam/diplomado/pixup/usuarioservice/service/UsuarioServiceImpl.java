package unam.diplomado.pixup.usuarioservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.usuarioservice.domain.Domicilio;
import unam.diplomado.pixup.usuarioservice.domain.Usuario;
import unam.diplomado.pixup.usuarioservice.domain.UsuarioAlreadyExistsException;
import unam.diplomado.pixup.usuarioservice.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Logs aplicacion en produccion, 12 factores
	
	private static final Logger LOG = 
			LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Override
	public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
		//validacion usuario existente
		Optional< Usuario> usuarioExistente =
				usuarioRepository.findByEmail(usuario.getEmail());
		//execpcion del negocio van en el dominio
		if(usuarioExistente.isPresent()) {
			throw new UsuarioAlreadyExistsException(usuario.getEmail()); //descriptivo//lanzar runtime exception 
		}
		//guardar usuario, domicilio vive en usuario aqui todavia estan separados
		usuario.getDomicilios().add(domicilio);// aqui todavia estan separados
		usuarioRepository.save(usuario);
		
		LOG.info("usuario registrado" + usuario);
		
		return usuario;
	}
	
	

}
