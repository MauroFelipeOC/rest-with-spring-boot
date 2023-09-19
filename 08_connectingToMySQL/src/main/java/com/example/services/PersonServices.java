package com.example.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private static final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		logger.info("Finding all persons");
				
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding a person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao");
		person.setLastName("Sicrano");
		person.setAddress("Oxford");
		person.setGender("Male");
				
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
	}
	
	public Person create(Person person) {
		
		logger.info("creating a person");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("updating a person");
		
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("deleting a person");
		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
						
		repository.delete(entity);
	}

}
