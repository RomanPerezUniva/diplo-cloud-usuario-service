package unam.diplomado.pixup.usuarioservice.api;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuarioservice.domain.Colonia;
import unam.diplomado.pixup.usuarioservice.repository.ColoniaRepository;

@RestController
@RequestMapping (path = "colonias", produces = "application/json")
@CrossOrigin(origins = "*")
public class ColoniaController {
	
	@Autowired
	private ColoniaRepository coloniaRepository;
	
	@GetMapping("{id}")
	public ResponseEntity<Colonia> coloniaPorId(@PathVariable("id") String id){
		Optional<Colonia> colonia = coloniaRepository.findById(id);
		if(colonia.isPresent()) {
			return new ResponseEntity<>(colonia.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public Collection<Colonia> coloniaPorCp(@RequestParam(required = true) String cp){
		return coloniaRepository.findByCp(cp);
	}

}
