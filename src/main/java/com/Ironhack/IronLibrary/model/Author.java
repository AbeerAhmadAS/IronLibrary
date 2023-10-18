package com.Ironhack.IronLibrary.model;

import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;
    private String name;
    private String email;
    @OneToOne(mappedBy = "author")
    private Book authorBook;


    public Author() {
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Author(String name, String email, Book authorBook) {
        this.name = name;
        this.email = email;
        this.authorBook = authorBook;
    }

    public Author(String authorName, String authorEmail, String authorBook) {
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthorId(Integer author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(Book authorBook) {
        this.authorBook = authorBook;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
//                ", authorBook=" + authorBook +
                '}';
    }
}
