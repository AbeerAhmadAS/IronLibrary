package com.Ironhack.IronLibrary.Repository;

import com.Ironhack.IronLibrary.model.Author;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Ironhack.IronLibrary.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    Author author;
    Book book1 , book2;



    @BeforeEach
    public void setUp() {
        author = new Author("Mohammad", "example@gmail.com");
        authorRepository.save(author);
        book1= new Book(1,"1235-0988","The world","Facta",null,2);
        book2= new Book(2,"1234-0988","natural","Fact",author,6);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
    @AfterEach
    public void tearDown() {
        bookRepository.delete(book1);
        bookRepository.delete(book2);
    }

@Test //2 Done
    public void findByTitle() {
        String validTitle = "Harry Potter and the Philosopher's Stone";
        String invalidTitle = "Invalid Title";
        // Test valid title
        try {
            Optional<Book> bookOptionalValid = bookRepository.findByTitle(validTitle);
            assertTrue(bookOptionalValid.isPresent());
            assertEquals(validTitle, bookOptionalValid.get().getTitle());
        } catch (Exception e) {
            // Handle unexpected exception
            fail("An unexpected exception occurred while testing with a valid title: " + e.getMessage());
        }
        // Test invalid title
        try {
            Optional<Book> bookOptionalInvalid = bookRepository.findByTitle(invalidTitle);
            assertFalse(bookOptionalInvalid.isPresent());
        } catch (Exception e) {
            // Handle unexpected exception
            fail("An unexpected exception occurred while testing with an invalid title: " + e.getMessage());
        }
    }
    @Test    // 3 Done
    void findByCategory() {
        // Test valid category 1
        String validCategory = "Fantasy";
        List<Book> fantasyBooks = bookRepository.findByCategory(validCategory);
        assertEquals(1, fantasyBooks.size());

        // Test valid category 2
        String validCategory2 = "Dystopian";
        List<Book> dystopianBooks = bookRepository.findByCategory(validCategory2);
        assertEquals(1, dystopianBooks.size());

        // Test invalid category
        String invalidCategory = "Nonexistent Category";
        List<Book> nonexistentCategoryBooks = bookRepository.findByCategory(invalidCategory);
        assertTrue(nonexistentCategoryBooks.isEmpty());
    }



    @Test //4 Done
    public void findByName(){
        String name = "Mohammad";
        try {
            Optional<Author> authorOptional = authorRepository.findByName(name);
            assertTrue(authorOptional.isPresent());
            System.out.println(authorOptional.get());
            assertEquals(name, authorOptional.get().getName());
        } catch (NoSuchElementException e) {
            fail("Author not found: " + e.getMessage());
        } catch (Exception e) {
//            fail
            System.out.printf("Unexpected exception occurred: " + e.getMessage());
        }
    }



    @Test // 5 Done
    public void findAll_bookWithAuthor_bookList() {
        try {
            List<Book> bookList = bookRepository.findAll();
            System.out.println(bookList);
            assertEquals(6, bookList.size());
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testFindByQuantity() // Bonus Done
    {
        try{
            Optional<Book> bookOptional = bookRepository.findByQuantity(2);
            assertTrue(bookOptional.isPresent());
        }catch (EmptyResultDataAccessException e){
            fail("Expected Book not found");
        }
    }


    @Test      // Bonus Done
    void findByIsbn() {
        String isbn = "1235-0988";
        try{
            Optional<Book> bookOptional = bookRepository.findByIsbn(isbn);
            if (bookOptional.isPresent()) {
                assertEquals("1235-0988", bookOptional.get().getIsbn());
                System.out.println(bookOptional);
            } else {
                fail("Book with ISBN " + isbn + " not found");
            }
        }catch (Exception e){
            fail("An exception occurred" + e.getMessage());
        }
    }



    @Test      // Bonus Done
    public void findById(){
        try {
            Optional<Book> bookOptional = bookRepository.findById(book1.getId());
            assertTrue(bookOptional.isPresent());
            System.out.println(bookOptional.get());
            assertEquals(2, bookOptional.get().getQuantity());
        } catch (Exception e) {
            fail("An unexpected exception occurred during testing: " + e.getMessage());
        }
    }



    // ------------------------------ Under Test
    @Test
    void findByTitle_2() {String searchTitle = "The world";
        Optional<Book> book;
        try {
            book = bookRepository.findByTitle(searchTitle);
        } catch (IncorrectResultSizeDataAccessException ex) {
            book = Optional.empty();
        }
        assertTrue(book.isPresent());
        assertEquals(searchTitle, book.get().getTitle());
    }

}