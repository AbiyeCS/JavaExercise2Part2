package org.example.javaexercise2part2.ServiceTestWithMocks;

import org.example.javaexercise2part2.Repository.BookRepository;
import org.example.javaexercise2part2.Service.BookService;
import org.example.javaexercise2part2.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookServiceTestWithMocks {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;

    @Test
    void shouldBeAbleToFindByAuthor(){
        List<Book> books = List.of(
                new Book("Harry Potter", "J.K Rowling", 550)
        );
        when(bookRepository.findBooksByAuthor("J.K Rowling")).thenReturn(books);

        List<Book> expectedBooks = bookService.findByAuthor("J.K Rowling");

        assertThat(expectedBooks.get(0).getBookName()).isEqualTo("Harry Potter");
        assertThat(expectedBooks.get(0).getPages()).isEqualTo(550);
    }
}
