package com.search_site.book_store.repository;

import com.search_site.book_store.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "select * from book where name LIKE concat('%',:query,'%')", nativeQuery = true)
    Iterable<Book> searchForBooksByName(String query);

    Iterable<Book> findByCategoryId(Long categoryId);
}
