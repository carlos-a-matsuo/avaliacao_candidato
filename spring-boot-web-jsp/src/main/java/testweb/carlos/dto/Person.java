package testweb.carlos.dto;

import java.io.Serializable;

public class Person implements Serializable {

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
		return "Book{" + "id=" + cpf + ", name='" + name + '\'' + ", lastName='" + lastName + '}';
	}

}
