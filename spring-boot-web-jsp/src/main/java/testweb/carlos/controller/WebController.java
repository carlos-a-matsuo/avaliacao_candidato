package testweb.carlos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import testweb.carlos.dto.Person;
import testweb.carlos.service.JavaBackService;

@Controller
public class WebController {

	@Autowired
	private JavaBackService javaBackService;

	@Value("${welcome.message:test}")
	private String message = "Test";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RedirectView addPerson(@ModelAttribute("person") Person person, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/", true);

		Person res = javaBackService.add(person);

		redirectAttributes.addFlashAttribute("savedPerson", res);
		redirectAttributes.addFlashAttribute("addPersonSuccess", true);
		return redirectView;
	}

	@GetMapping("/list")
	public RedirectView viewPersons(RedirectAttributes redirectAttributes) {

		Person b = new Person("1", "2");

		List<Person> list = new ArrayList<Person>();
		list.add(b);

		list = javaBackService.list();

		final RedirectView redirectView = new RedirectView("/", true);
		redirectAttributes.addFlashAttribute("persons", list);
		redirectAttributes.addFlashAttribute("listPersonSuccess", true);
		return redirectView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RedirectView updatePerson(@ModelAttribute("person") Person person, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/", true);

		Person res = javaBackService.update(person);

		redirectAttributes.addFlashAttribute("updatePerson", res);
		redirectAttributes.addFlashAttribute("updatePersonSuccess", true);
		return redirectView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RedirectView deletePerson(@ModelAttribute("person") Person person, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/", true);

		javaBackService.delete(person);

		//redirectAttributes.addFlashAttribute("savedPerson", null);
		//redirectAttributes.addFlashAttribute("addPersonSuccess", true);
		return redirectView;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public RedirectView find(@ModelAttribute("person") Person person, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/", true);

		Person res = javaBackService.findByCpf(person.getCpf());

		List<Person> list = new ArrayList<Person>();
		list.add(res);
		
		redirectAttributes.addFlashAttribute("list", list);
		redirectAttributes.addFlashAttribute("findPersonSuccess", true);
		return redirectView;
	}
}
