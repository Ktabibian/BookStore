package com.search_site.book_store.service;

import com.search_site.book_store.model.Book;
import com.search_site.book_store.repository.BookRepository;
import com.search_site.book_store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createBook(Long categoryId, Book book) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }

    public ResponseEntity<?> getBookById(Long bookId){
        Book book = bookRepository.findById(bookId).orElse(null);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void updateBook(Long categoryId, Book book){
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public Iterable<Book> findByCategoryId(Long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }

    public Iterable<Book> searchForBooksByName(String query){
        return bookRepository.searchForBooksByName(query);
    }
}
