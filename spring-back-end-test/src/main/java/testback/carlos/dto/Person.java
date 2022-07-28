package testback.carlos.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long cpf;
	private String name;
	private String lastName;

	public Person() {
	}

	public Person(Long cpf, String name, String lastName) {
		this.cpf = cpf;
		this.name = name;
		this.lastName = lastName;
	}

	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Book{" + "cpf=" + cpf + ", name='" + name + '\'' + ", lastName='" + lastName + '}';
	}

}
