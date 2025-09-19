package org.example.javaexercise2part2.ServiceTest;

import org.example.javaexercise2part2.Service.BookService;
import org.example.javaexercise2part2.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void shouldFindByAuthor(){

        List<Book> books = bookService.findByAuthor("Rick Riordan");

        assertThat(books.get(0).getBookName()).isEqualTo("Percy Jackson");
    }

    @Test
    void shouldFindPagesGreaterThan(){

        List<Book> books = bookService.findPagesGreaterThan(350);

        assertThat(books.size()).isEqualTo(4);
    }

    @Test
    void shouldFindByBookName(){

        Book books = bookService.findByBookName("Harry Potter");
        assertThat(books.getAuthor()).isEqualTo("J.K Rowling");
        assertThat(books.getPages()).isEqualTo(550);
    }


}
