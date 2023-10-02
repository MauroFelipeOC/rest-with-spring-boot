package com.example.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Book;
import com.example.repositories.BookRepository;
import com.example.services.BookServices;
import com.example.unittests.mapper.mocks.MockBook;

@ExtendWith(MockitoExtension.class)
class BookServicesTest {
	
	private MockBook input;
	
	@InjectMocks
	private BookServices service;
	
	@Mock
	private BookRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		input = new MockBook();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		int numberOfMocks = 10;
		List<Book> mockedBooks = input.mockEntityList(numberOfMocks);
		when(repository.findAll()).thenReturn(mockedBooks);
		
		var books = service.findAll();
		
		assertNotNull(books);
		assertEquals(books.size(), numberOfMocks);
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
