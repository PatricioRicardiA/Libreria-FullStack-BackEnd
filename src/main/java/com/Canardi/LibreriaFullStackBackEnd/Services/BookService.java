package com.Canardi.LibreriaFullStackBackEnd.Services;

import com.Canardi.LibreriaFullStackBackEnd.Entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book saveBook(Book book);

    Book updateBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    void deleteBook (Long id);

}
