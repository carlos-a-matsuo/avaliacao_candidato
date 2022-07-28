package testback.carlos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import testback.carlos.dto.Person;
import testback.carlos.repository.PersonRepository;

@SpringBootApplication
public class StartPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartPersonApplication.class, args);
	}

	@Profile("test")
	@Bean
	CommandLineRunner initDatabase(PersonRepository repository) {
		return args -> {
			repository.save(new Person("Start 1", "Start 1"));
			repository.save(new Person("Start 2", "Start 2"));
			repository.save(new Person("Start 3", "Start 3"));
		};
	}
}