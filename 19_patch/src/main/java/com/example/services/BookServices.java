package com.example.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controllers.BookController;
import com.example.data.vo.v1.BookVO;
import com.example.exceptions.ResourceNotFoundException;
import com.example.mapper.DozerMapper;
import com.example.model.Book;
import com.example.repositories.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	private BookRepository repository; 

	public List<BookVO> findAll() {
		var entities = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
		entities.forEach(book -> book.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel()));
		return entities;
	}

	public BookVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		var book = DozerMapper.parseObject(entity, BookVO.class);
		book.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		return book;
	}

	public BookVO create(BookVO book) {
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		return DozerMapper.parseObject(repository.save(entity), BookVO.class);
	}

	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		repository.delete(entity);
	}
}
