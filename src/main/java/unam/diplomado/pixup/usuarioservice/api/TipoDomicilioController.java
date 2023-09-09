package unam.diplomado.pixup.usuarioservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuarioservice.domain.TipoDomicilio;
import unam.diplomado.pixup.usuarioservice.repository.TipoDomicilioRepository;

@RestController
@RequestMapping(path = "tiposDomicilio" , produces = "application/json")
@CrossOrigin(origins = "*")
public class TipoDomicilioController {
	
	@Autowired
	private TipoDomicilioRepository tipoDomicilioRepository;
	
	@GetMapping
	public List<TipoDomicilio> getAll(){
		return tipoDomicilioRepository.findAll();
	}

}
