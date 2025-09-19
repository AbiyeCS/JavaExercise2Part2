package org.example.javaexercise2part2.Service;

import jakarta.annotation.PostConstruct;
import org.example.javaexercise2part2.Repository.BookRepository;
import org.example.javaexercise2part2.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initaliseSampleData(){
        if(bookRepository.count() == 0){
            List<Book> allBooks = Arrays.asList(
                    new Book("Harry Potter", "J.K Rowling", 550),
                    new Book("Percy Jackson", "Rick Riordan", 300),
                    new Book("The Midnight Library", "Matt Haig", 288),
                    new Book("Where the Crawdads Sing", "Delia Owens", 370),
                    new Book("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", 400),
                    new Book("Educated", "Tara Westover", 334),
                    new Book("The Silent Patient", "Alex Michaelides", 336),
                    new Book("Atomic Habits", "James Clear", 320),
                    new Book("The Invisible Man", "H.G. Wells", 162),
                    new Book("Dune", "Frank Herbert", 688),
                    new Book("The Alchemist", "Paulo Coelho", 163),
                    new Book("1984", "George Orwell", 328)

            );
            bookRepository.saveAll(allBooks);
            System.out.println("Book Data initialised");
        }
    }

    public List<Book> findByAuthor(String author){
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findPagesGreaterThan(int pages){
        return bookRepository.findByPagesGreaterThan(pages);
    }

    public Book findByBookName(String name){
       Optional<Book> wantedBook = bookRepository.findByBookName(name);
       return wantedBook.get();
    }

}
