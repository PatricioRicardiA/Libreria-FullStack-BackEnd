package com.Canardi.LibreriaFullStackBackEnd.Controllers;

import com.Canardi.LibreriaFullStackBackEnd.Entities.Book;
import com.Canardi.LibreriaFullStackBackEnd.Services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/book")
@CrossOrigin("http://localhost:4200/")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        try {
            Book savedBook = bookService.saveBook(book);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping()
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        try {
            Book updatedBook = bookService.updateBook(book);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        Optional<Book> BookById = bookService.getBookById(id);
        if(BookById.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(BookById, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
        Optional<Book> BookById = bookService.getBookById(id);
        if(BookById.isPresent()) {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
