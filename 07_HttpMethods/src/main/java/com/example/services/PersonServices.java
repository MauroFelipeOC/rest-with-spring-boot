package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonServices {
	
	private static final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		logger.info("Finding all persons");
		
		List<Person> persons = new ArrayList<>();
		
		for (int i = 1; i <= 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person findById(String id) {
		
		logger.info("Finding a person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao");
		person.setLastName("Sicrano");
		person.setAddress("Oxford");
		person.setGender("Male");
				
		return person;
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("First name " + i);
		person.setLastName("Last  name " + i);
		person.setAddress("Address" + i);
		person.setGender("Male");
				
		return person;		
	}

	public Person create(Person person) {
		
		logger.info("creating a person");
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("updating a person");
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("deleting a person");
	}

}
