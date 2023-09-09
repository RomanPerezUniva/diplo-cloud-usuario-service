package unam.diplomado.pixup.usuarioservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuarioservice.domain.Estado;
import unam.diplomado.pixup.usuarioservice.repository.EstadoRepository;
import unam.diplomado.pixup.usuarioservice.service.EstadoService;

@RestController
@RequestMapping(path="api/estados", produces = "application/json")
@CrossOrigin(origins = "*")
public class EstadoController {
	//operaciones
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public List<Estado> obtenerEstados(){
		return estadoRepository.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Estado crearEstado(@RequestBody Estado estado) {
		//TODO:201 creado
		//TODO:Comento un compañero que no permite repetidos y habria que validar
		//Utilizar Anotacion @ResponseStatus controlar ejecucions http
		
		return estadoRepository.save(estado);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable ("id") String id) {
		 Optional<Estado> estado= estadoRepository.findById(id);
		 if(estado.isPresent()) {
			 return new ResponseEntity<>(estado.get(), HttpStatus.OK);
			 
		 }
		 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path = "{id}", consumes = "application/json")
	public ResponseEntity<Estado> actualizarEstado(@PathVariable ("id") String id, @RequestBody Estado estado) {
		//TODO:uso de ResponseEntity  OK, entidad de tipo respuesta que me encapsula el estado
		Estado estadoActualizado= estadoService.actualizarEstado(id, estado);
		if(estadoActualizado != null) {
			//ResponseEntity<Estado>  es opcional, asume el tipo
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarEstado(@PathVariable("id") String id) {
		//TODO: esperaria un 204 no content
		
		estadoRepository.deleteById(id);
	}

}
