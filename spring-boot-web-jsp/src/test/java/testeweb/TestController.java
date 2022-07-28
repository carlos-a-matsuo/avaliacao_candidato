package testeweb;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import testweb.carlos.controller.WebController;
import testweb.carlos.dto.Person;
import testweb.carlos.service.JavaBackService;
import testweb.carlos.service.impl.JavaBackServiceImpl;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class TestController {

	@Mock
	private JavaBackService javaBackService = new JavaBackServiceImpl();
	
	@InjectMocks
	private WebController controller = new WebController();

	@Test
	public void add() {

		Person res = null;

		Person person = new Person(1L, "João", "Silva");
		Mockito.when(javaBackService.add(person)).thenReturn(person);

		RedirectAttributes redic;
		redic = Mockito.mock(RedirectAttributes.class);

		// ...
		
		assertTrue(res != null);

	}

	public void list() {

		List<Person> list = null;

		List<Person> persons = new ArrayList<Person>();
		Person person = new Person(1L, "João", "Silva");
		persons.add(person);
		
		Mockito.when(javaBackService.list()).thenReturn(persons);

		list = javaBackService.list();

		// ...
		
		assertTrue(list != null);

	}

	public void update() {

	}

	public void delete() {

	}
}
