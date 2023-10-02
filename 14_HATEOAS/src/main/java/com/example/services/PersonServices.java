package com.example.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.example.controllers.PersonController;
import com.example.data.vo.v1.PersonVO;
import com.example.exceptions.RequiredObjectIsNullException;
import com.example.exceptions.ResourceNotFoundException;
import com.example.mapper.DozerMapper;
import com.example.model.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	@Autowired
	PersonRepository repository;
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all persons");
				
		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
		persons.stream().forEach(person -> person.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel()));
		return persons;
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("Finding a person");		
				
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());		
		return vo;
	}
	
	public PersonVO create(PersonVO person) {
		
		if(person == null) throw new RequiredObjectIsNullException();
		
		logger.info("creating a person");
		
		var entity = DozerMapper.parseObject(person, Person.class);		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());		
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		if(person == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());		
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("deleting a person");
		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));						
		repository.delete(entity);
	}

}
