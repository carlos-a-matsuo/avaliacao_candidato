package testweb.carlos.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import testweb.carlos.dto.Person;
import testweb.carlos.service.JavaBackService;

@Service
public class JavaBackServiceImpl implements JavaBackService {

	private RestTemplate restTemplate;

	public JavaBackServiceImpl() {

	}

	@Autowired
	public JavaBackServiceImpl(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@Override
	public List<Person> list() {

		String resourceUrl = "http://localhost:8081/list";

		ResponseEntity<Person[]> response = restTemplate.getForEntity(resourceUrl, Person[].class);

		Person[] books = response.getBody();

		return Arrays.asList(books);
	}

	@Override
	public Person add(Person person) {

		String resourceUrl = "http://localhost:8081/add";

		HttpEntity<Person> request = new HttpEntity<>(person);
		Person personAdded = restTemplate.postForObject(resourceUrl, request, Person.class);

		return personAdded;

	}

	@Override
	public Person update(Person person) {

		String resourceUrl = "http://localhost:8081/update/";

		HttpEntity<Person> request = new HttpEntity<>(person);

		return restTemplate.exchange(resourceUrl + person.getCpf(), HttpMethod.PUT, request, Person.class).getBody();

	}

	@Override
	public void delete(Person person) {

		String resourceUrl = "http://localhost:8081/delete/";

		restTemplate.delete(resourceUrl + person.getCpf());
	}

	@Override
	public Person findByCpf(Long cpf) {
		String resourceUrl = "http://localhost:8081/find/";
		ResponseEntity<Person> response = restTemplate.getForEntity(resourceUrl + cpf, Person.class);

		Person person = response.getBody();

		return person;
	}

}
