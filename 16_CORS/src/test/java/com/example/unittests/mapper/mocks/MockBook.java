package com.example.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.data.vo.v1.BookVO;
import com.example.model.Book;

public class MockBook {
	
	public List<Book> mockEntityList(int numberOfMocks) {
		List<Book> entities = new ArrayList<>();
		
		for (long i = 0; i < numberOfMocks; i++) {
            entities.add(mockEntity(i));
        }
		
		return entities;
	}
	
	public List<BookVO> mockVOList(int numberOfMocks) {
		List<BookVO> entities = new ArrayList<>();
		
		for (long i = 0; i < numberOfMocks; i++) {
            entities.add(mockVO(i));
        }
		
		return entities;
	}
	
	public Book mockEntity(Long number) {
		Book book = new Book();
		book.setAuthor("Author name " + number);
		book.setId(number);
		book.setLaunchDate(new Date());
		book.setPrice(100 + number);
		book.setTitle("Book title " + number);
		return book; 
	}
	
	public BookVO mockVO(Long number) {
		BookVO book = new BookVO();
		book.setAuthor("Author name " + number);
		book.setKey(number);
		book.setLaunchDate(new Date());
		book.setPrice(100 + number);
		book.setTitle("Book title " + number);
		return book; 
	}

}
