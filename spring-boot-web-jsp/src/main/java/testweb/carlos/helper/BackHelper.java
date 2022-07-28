package testweb.carlos.helper;

import org.springframework.web.client.RestTemplate;

import testweb.carlos.dto.Person;

public class BackHelper {

	public void add() {
		RestTemplate restTemplate = new RestTemplate();

		//HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
		//Foo foo = restTemplate.postForObject(fooResourceUrl, request, Foo.class);
	}
	
	public void list() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/spring-rest/foos";
		
		//ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		//Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

		Person book = restTemplate.getForObject(resourceUrl + "/1", Person.class);
	}

}
