package com.Ironhack.IronLibrary.Repository;

import com.Ironhack.IronLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findByTitle(String title);
    List<Book> findByCategory(String category);
    List<Book> findByQuantity(Integer quantity);
    @Query(value = "SELECT b.title, b.category, b.quantity " +
            "FROM book AS b " +
            "JOIN author AS a ON b.author_id = a.author_id " +
            "WHERE a.name = :name", nativeQuery = true)
    List<Object[]> findByAuthorName(@Param("name") String name);

    Optional<Book> findByIsbn(String isbn);

}
