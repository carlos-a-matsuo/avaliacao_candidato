package testweb.carlos.service;

import java.util.List;

import testweb.carlos.dto.*;

public interface JavaBackService {

	public Person add(Person book);
	
	public List<Person> list();

	public Person update(Person person);
	
	public void delete(Person person);
	
	public Person findByCpf(Long cpf);
}
