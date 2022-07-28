package testback.carlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import testback.carlos.dto.Person;
import testback.carlos.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	// ADD
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	Person newPerson(@RequestBody Person newPerson) {
		return personService.newPerson(newPerson);
	}

	// LIST
	@GetMapping("/list")
	List<Person> findAll() {
		return personService.findAll();
	}

	// FIND BY CPF
	@GetMapping("/find/{cpf}")
	Person findOne(@PathVariable Long cpf) {
		return personService.findOne(cpf);
	}

	// UPDATE
	@PutMapping("/update/{id}")
	Person saveOrUpdate(@RequestBody Person newPerson, @PathVariable Long id) {
		return personService.saveOrUpdate(newPerson, id);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}

}
