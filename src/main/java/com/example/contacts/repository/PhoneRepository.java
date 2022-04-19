package com.example.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contacts.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
	List<Phone> findAllByPersonId(Long id);
}
