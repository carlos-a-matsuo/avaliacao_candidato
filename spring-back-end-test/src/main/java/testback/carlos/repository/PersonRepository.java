package testback.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testback.carlos.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
