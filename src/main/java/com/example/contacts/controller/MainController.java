package com.example.contacts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.contacts.request.ContactRequest;
import com.example.contacts.response.ContactResponse;
import com.example.contacts.service.MainService;

@RestController
@RequestMapping("/contacts")
public class MainController {
	private MainService mainService;

	public MainController(MainService mainService) {
		this.mainService = mainService;
	}

	@GetMapping
	public List<ContactResponse> getContact(@RequestParam String name) {
		return mainService.getContact(name);
	}
	
	@PostMapping
	public void createContact(@RequestBody List<ContactRequest> newContactList) {
		mainService.createNewContact(newContactList);
	}
}
