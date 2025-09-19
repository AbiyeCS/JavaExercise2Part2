package org.example.javaexercise2part2.Repository;

import org.example.javaexercise2part2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookName(String name);
    List<Book> findBooksByAuthor(String author);
    List<Book> findByPagesGreaterThan(int pages);
}
