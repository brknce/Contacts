package com.example.contacts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contacts.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByNameAndLastname(String name, String lastname);

	List<Person> findAllByName(String name);

}
