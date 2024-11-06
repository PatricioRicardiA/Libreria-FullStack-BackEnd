package com.Canardi.LibreriaFullStackBackEnd.Repositories;

import com.Canardi.LibreriaFullStackBackEnd.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
