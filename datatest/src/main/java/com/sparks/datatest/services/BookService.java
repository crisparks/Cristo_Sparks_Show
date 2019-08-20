package com.sparks.datatest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparks.datatest.models.book;
import com.sparks.datatest.repositories.BookRepository;


@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public book createBook(book b) {
        return bookRepository.save(b);
    }
    //updates a book
    public book updateBook(book b) {
    	return bookRepository.save(b);
    }
    
    public book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional <book> temp = bookRepository.findById(id);
    	if(temp != null) {
    		temp.get().setTitle(title);
    		temp.get().setDescription(desc);
    		temp.get().setLanguage(lang);
    		temp.get().setNumberOfPages(numOfPages);
    		
    		return temp.get();
    	}
    	return null;
    }
    
    // retrieves a book
    public book findBook(Long id) {
        Optional<book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
}