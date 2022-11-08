package com.search_site.book_store.controller;

import com.search_site.book_store.model.Book;
import com.search_site.book_store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable (value = "categoryId") Long categoryId, @RequestBody Book book) {
        bookService.createBook(categoryId, book);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public Iterable<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBook(@PathVariable (value = "categoryId") Long categoryId, @RequestBody Book book){
        bookService.updateBook(categoryId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Book> findByCategoryId(@PathVariable Long categoryId){
        return bookService.findByCategoryId(categoryId);
    }

    @GetMapping("/searchbooks")
    public Iterable<Book> searchForBooksByName(@RequestParam ("query") String query){
        return bookService.searchForBooksByName(query);
    }
}
