//package com.Ironhack.IronLibrary.Components;
//
//import com.Ironhack.IronLibrary.Repository.AuthorRepository;
//import com.Ironhack.IronLibrary.Repository.BookRepository;
//import com.Ironhack.IronLibrary.Repository.IssueRepository;
//import com.Ironhack.IronLibrary.Repository.StudentRepository;
//import com.Ironhack.IronLibrary.model.Author;
//import com.Ironhack.IronLibrary.model.Book;
//import com.Ironhack.IronLibrary.model.BookDatabaseManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Scanner;
//
//@Component
//public class Library {
//
//        private  BookRepository bookRepository;
//        private AuthorRepository authorRepository;
//        private StudentRepository studentRepository;
//        private IssueRepository issueRepository;
//
//        @Autowired
//        public void LibraryCommands(BookRepository bookRepository, AuthorRepository authorRepository, StudentRepository studentRepository, IssueRepository issueRepository) {
//            this.bookRepository = bookRepository;
//            this.authorRepository = authorRepository;
//            this.studentRepository = studentRepository;
//            this.issueRepository = issueRepository;
//        }
//
//
//
//    public void addBook(Scanner scanner) {
//        System.out.println("Enter book details:");
//        System.out.print("ISBN: ");
//        String isbn = scanner.nextLine();
//        System.out.print("Title: ");
//        String title = scanner.nextLine();
//        System.out.print("Category: ");
//        String category = scanner.nextLine();
//        System.out.print("Quantity: ");
//        int quantity = scanner.nextInt();
//        scanner.nextLine(); // Consume newline character
//
//        System.out.println("Enter author details:");
//        System.out.print("Name: ");
//        String authorName = scanner.nextLine();
//        System.out.print("Email: ");
//        String authorEmail = scanner.nextLine();
//
//
//        Book book = new Book(isbn, title, category, quantity);
//        books.add(book);
//        Author author = new Author(authorName, authorName);
//        authors.add(author);
//        BookDatabaseManager bookDatabaseManager = new BookDatabaseManager();
//        bookDatabaseManager.saveBooksToDatabase(books);
//        bookDatabaseManager.saveAuthorToDatabase(authors);
//
//        scanner.nextLine();
//    }
//
//    public void searchBookByCategory(String category) {
//            // Implement the logic to search for books by category
//            // You can use the bookRepository to find books by category
//        }
//
//        public void searchBookByAuthor(String authorName) {
//            // Implement the logic to search for books by author name
//            // You can use the bookRepository to find books by author name
//        }
//
//        public void listAllBooksAlongWithAuthor() {
//            // Implement the logic to list all books along with their authors
//            // You can use the bookRepository to fetch books and their authors
//        }
//
//        public void issueBookToStudent(String usn, String isbn) {
//            // Implement the logic to issue a book to a student
//            // You can use the studentRepository and bookRepository to find students and books
//            // Create an Issue entity to represent the book issuance and save it using issueRepository
//        }
//
//        public void listBooksByUsn(String usn) {
//            // Implement the logic to list books issued to a student by their USN
//            // You can use the issueRepository to find issued books by student USN
//        }
//
//        public void listBooksToBeReturnedToday() {
//            // Implement the logic to list books that are to be returned today
//            // You can use the issueRepository to find issued books with return dates matching today
//        }
//    }
//
//
//
