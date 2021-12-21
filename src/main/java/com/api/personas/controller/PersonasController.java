package com.api.personas.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.personas.entity.Personas;
import com.api.personas.repository.PersonasRepository;

@RestController
public class PersonasController extends MasterController {

	private static final Logger log = LoggerFactory.getLogger(PersonasController.class);

	@Autowired
	private PersonasRepository personasRepository;

	@GetMapping(path = "/api/personas", produces = "application/json")
	public ResponseEntity listPersonas() {
		return ResponseEntity.ok(personasRepository.findAll());
	}

	@PostMapping(path = "/api/personas", consumes = "application/json", produces = "application/json")
	public ResponseEntity savePersona(@Validated @RequestBody Personas persona) {
		Optional<Personas> obj = personasRepository.findById(persona.getDni());
		if (!obj.isPresent()) {
			return almacenarPersona(persona);
		}
		return error("error al almacenar la persona, la persona ya existe ");
	}

	@PutMapping(path = "/api/personas/{dni}", consumes = "application/json", produces = "application/json")
	public ResponseEntity updatePersona(@PathVariable(value = "dni") String dni, @Validated @RequestBody Personas persona) {
		Optional<Personas> obj = personasRepository.findById(dni);
		if (obj.isPresent()) {
			return almacenarPersona(persona);
		}
		return error("error al almacenar la persona, la persona no existe ");
	}

	@DeleteMapping(path = "/api/personas/{dni}", consumes = "application/json", produces = "application/json")
	public ResponseEntity deletePersona(@Validated @PathVariable(value = "dni") String dni) {
		try {
			Optional<Personas> obj = personasRepository.findById(dni);
			if (obj.isPresent()) {
				personasRepository.delete(obj.get());
				return info("Persona eliminada con exito");
			}
			return error("error no existe la persona con DNI ::" + dni);
		} catch (Exception e) {
			log.error(getRawError(e));
			return error("error al eliminar la persona");
		}
	}

	private ResponseEntity almacenarPersona(Personas persona) {
		try {
			personasRepository.save(persona);
			return info("Persona almacenada con exito");
		} catch (Exception e) {
			log.error(getRawError(e));
			return error("error al almacenar la persona");
		}
	}
}
