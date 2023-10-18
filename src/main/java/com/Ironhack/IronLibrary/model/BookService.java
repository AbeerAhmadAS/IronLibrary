package com.Ironhack.IronLibrary.model;


import com.Ironhack.IronLibrary.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(String isbn, String title, String category, Integer quantity) {

        Book book = new Book(isbn, title, category, quantity);
        bookRepository.save(book);
    }
}