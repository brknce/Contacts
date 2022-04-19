package com.example.contacts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.contacts.entity.Person;
import com.example.contacts.entity.Phone;
import com.example.contacts.repository.PersonRepository;
import com.example.contacts.repository.PhoneRepository;
import com.example.contacts.request.ContactRequest;
import com.example.contacts.response.ContactResponse;

@Service
public class MainService {

	private PersonRepository personRepository;
	private PhoneRepository phoneRepository;

	public MainService(PersonRepository personRepository, PhoneRepository phoneRepository) {
		this.personRepository = personRepository;
		this.phoneRepository = phoneRepository;
	}

	public void createNewContact(List<ContactRequest> newContactList) {
		for (ContactRequest newContact : newContactList) {
			String name = newContact.getName();
			String lastname = newContact.getLastname();
			String phone = newContact.getPhone();

			Person person = personRepository.findByNameAndLastname(name, lastname).orElse(null);

			if (person != null) {
				List<Phone> phones = phoneRepository.findAllByPersonId(person.getId());
				if (!phones.stream().map(p -> p.getPhone()).collect(Collectors.toList()).contains(phone)) {
					phoneRepository.save(new Phone(person, phone));
				}
			} else {
				Person pr = new Person(name, lastname);
				Phone ph = new Phone(pr, phone);
				personRepository.save(pr);
				phoneRepository.save(ph);
			}
		}

	}

	public List<ContactResponse> getContact(String name) {
		List<ContactResponse> contactResponseList = new ArrayList<ContactResponse>();
		List<Person> personList = personRepository.findAllByName(name);
		for (Person person : personList) {
			List<String> phoneList = phoneRepository.findAllByPersonId(person.getId()).stream().map(p -> p.getPhone())
					.collect(Collectors.toList());
			contactResponseList.add(new ContactResponse(person.getName(), person.getLastname(), phoneList));
		}
		return contactResponseList;
	}

}
