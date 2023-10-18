package com.Ironhack.IronLibrary.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String isbn;
    private String title;
    private String category;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Integer quantity;

    public Book() {
    }

    // Used with findByTitle and findByCategory
    public Book(String isbn, String title, String category, Integer quantity) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.quantity = quantity;
    }

    public Book(Integer id, String isbn, String title, String category, Author author, Integer quantity) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String authorBook) {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author=" + author +
                ", quantity=" + quantity +
                '}';
    }
}
