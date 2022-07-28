package testback.carlos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testback.carlos.dto.Person;
import testback.carlos.error.PersonNotFoundException;
import testback.carlos.repository.PersonRepository;
import testback.carlos.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public Person newPerson(Person newPerson) {
		return repository.save(newPerson);
	}

	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person findOne(Long cpf) {
		return repository.findById(cpf).orElseThrow(() -> new PersonNotFoundException(cpf));
	}

	@Override
	public Person saveOrUpdate(Person newPerson, Long cpf) {
		return repository.findById(cpf).map(x -> {
			x.setName(newPerson.getName());
			x.setLastName(newPerson.getLastName());
			return repository.save(x);
		}).orElseGet(() -> {
			newPerson.setCpf(cpf);
			return repository.save(newPerson);
		});
	}

	@Override
	public void deletePerson(Long id) {
		repository.deleteById(id);
	}

}
