package com.Ironhack.IronLibrary.Repository;

import com.Ironhack.IronLibrary.model.Author;
import com.Ironhack.IronLibrary.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;


    Book book = new Book("1234-5678-9", "The world", "History", 2);
    Author author = new Author("Mohammad", "example@gmail.com",book);

    @BeforeEach
    public void setUp() {authorRepository.save(author);}
    @AfterEach
    public void tearDown(){ authorRepository.delete(author);}

    @Test
    public void findByName(){
        String name = "Mohammad";
        Optional<Author> authorOptional = authorRepository.findByName(name);
        assertTrue(authorOptional.isPresent());
        System.out.println(authorOptional.get());
        assertEquals(name, authorOptional.get().getName());
    }
}

  /*  @Test
    public void findAuthorById(){
        Optional<Author> authorOptional = authorRepository.findById(1);
        System.out.println(authorOptional.get());
        assertEquals(1, authorOptional.get().getAuthor_id());
    } */