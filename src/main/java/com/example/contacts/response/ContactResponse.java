package com.example.contacts.response;

import java.util.List;

public class ContactResponse {
	private String name;
	private String lastname;
	private List<String> phones;

	public ContactResponse() {
	}

	public ContactResponse(String name, String lastname, List<String> phones) {
		this.name = name;
		this.lastname = lastname;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

}
