package com.Ironhack.IronLibrary.Repository;

import com.Ironhack.IronLibrary.model.Author;
import com.Ironhack.IronLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findAll();
    Optional<Book> findByTitle(String title);
    List<Book> findByCategory(String category);
    Optional<Book> findByQuantity(Integer quantity);

    List<Book> findByAuthorName(String name);
    Optional<Book> findByIsbn(String isbn);


 //   List<Book> findAllByAuthor(Author author);
    //  List<Book> findBooksByIssueStudentUsn(String usn);
}
