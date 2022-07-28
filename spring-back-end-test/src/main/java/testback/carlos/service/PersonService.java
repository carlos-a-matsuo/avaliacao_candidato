package testback.carlos.service;

import java.util.List;

import testback.carlos.dto.Person;

public interface PersonService {

	Person newPerson(Person newPerson);

	List<Person> findAll();

	Person findOne(Long id);

	Person saveOrUpdate(Person newPerson, Long id);

	void deletePerson(Long id);
}
