package com.Ironhack.IronLibrary.model;

import com.Ironhack.IronLibrary.Repository.BookRepository;
import com.Ironhack.IronLibrary.Repository.IssueRepository;
import com.Ironhack.IronLibrary.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
@Component
public class LibraryMethods {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Issue> issues = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    IssueRepository issueRepository;

    public LibraryMethods() {
    }

    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add a book");
        System.out.println("2. Search book by title");
        System.out.println("3. Search book by category");
        System.out.println("4. Search book by author");
        System.out.println("5. List all books along with author");
        System.out.println("6. Issue book to student");
        System.out.println("7. List books by USN");
        System.out.println("8. Search By Quantity");
        System.out.println("9. Search For Book By ISBN");
        System.out.println("10.Search For Book By ID");
        System.out.println("11.Exit");
        System.out.print("Enter your choice: ");
    }

    // ******** First method ********
    public void addBook(Scanner scanner) {
        System.out.println("Enter book details:");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter author details:");
        System.out.print("Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Email: ");
        String authorEmail = scanner.nextLine();


        Book book = new Book(isbn, title, category, quantity);
        books.add(book);
        Author author = new Author(authorName, authorEmail);
        authors.add(author);
        BookDatabaseManager bookDatabaseManager = new BookDatabaseManager();
        bookDatabaseManager.saveBooksToDatabase(books);
        bookDatabaseManager.saveAuthorToDatabase(authors);

        scanner.nextLine();

    }

    // ************ Second method ***********

    public void searchBookByTitle(Scanner scanner) {
        System.out.print("Enter a book title to search: ");
        String searchTitle = scanner.nextLine();
        Optional<Book> bookOptional = bookRepository.findByTitle(searchTitle);
        try {
            if (bookOptional.isEmpty()) {
                System.out.println("No book found in the specified title: " + searchTitle);
            }else {
                Book validBook = bookOptional.get();
                System.out.println("Book found with the valid title: " + validBook.getTitle());
                    System.out.println("ISBN: " + validBook.getIsbn() + ", Category: " + validBook.getCategory());
                }
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred while testing with a valid title: " + e.getMessage());
        }


    }

    // *********** third method **********

    public void searchBookByCategory(Scanner scanner) {

            System.out.print("Enter category to search: ");
            String validCategory = scanner.nextLine();
            List<Book> books = bookRepository.findByCategory(validCategory);

        try {
            if (books.isEmpty()) {
                System.out.println("No books found in the specified category.");
            } else {
                for (Book book : books) {
                    System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
                }
            }} catch (Exception e) {
            System.err.println("An unexpected exception occurred while testing with a valid title: " + e.getMessage());
        }
    }


        // *************** fourth method **********
    public void searchBookByAuthor(Scanner scanner) {
        System.out.print("Enter the author's name to search for books: ");
        String authorName = scanner.nextLine();
        List<Object[]> bookDetails = bookRepository.findByAuthorName(authorName);
        for (Object[] row : bookDetails) {
            String bookTitle = (String) row[0];
            String bookCategory = (String) row[1];
            Integer quantity = Integer.valueOf(row[2].toString());

            System.out.printf("\n%-40s %-20s %-15s \n", "Book title", "Book Category", "Quantity");

            System.out.printf("%-40s %-20s %-15s \n", bookTitle,bookCategory,quantity);
        }

       /* try {
            for (Book book : books) {
                if (book.getAuthor().getName().equals(authorName)) {
                    booksByAuthor.add(book);
                }
            }

            if (!booksByAuthor.isEmpty()) {
                System.out.println("Books by author " + authorName + ":");
                for (Book book : booksByAuthor) {
                    System.out.println("Title: " + book.getTitle() + ", ISBN: " + book.getIsbn());
                }
            } else {
                System.out.println("No books found by author " + authorName);
                   }
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred while testing with a valid title: " + e.getMessage());
        }

        */

    }

    // ********** fifth method ***********
    public void listAllBooksAlongWithAuthor() {
        // You can declare a variable that is called "newBooks" or "storagedBooks" or somethings like that.
        List<Book> dbBooks = bookRepository.findAll();
        System.out.println(dbBooks);
        for (Book book : books) {
            BookDatabaseManager bookDatabaseManager= new BookDatabaseManager();
            bookDatabaseManager.databaseDisplayBook();
        }
    }

    // *********** Sixth method *************
    public void issueBookToStudent(Scanner scanner) {

            List<String> issues = new ArrayList<>();
            issues.add("Enter usn: ");
            issues.add("Enter name: ");
            issues.add("Enter book ISBN: ");
            List<String> response = new ArrayList<>();
            scanner = new Scanner(System.in);
            for (String issue: issues){
                System.out.print(issue);
                response.add(scanner.nextLine());
            }

            Student newStudent = new Student(response.get(0),response.get(1));
            studentRepository.save(newStudent);

            Optional<Book> bookOptional = bookRepository.findByIsbn(response.get(2));


            Date issueDate = new Date();
            long oneDays = 24 * 60 * 60 * 1000L;
            long sevenDays = 7 * oneDays;
            Date returnDate = new Date(issueDate.getTime() + sevenDays);

            Issue issue = new Issue(issueDate, returnDate, newStudent, bookOptional.get());
            issueRepository.save(issue);
            System.out.println("Book issued. Return date: " + returnDate);
        }

        // ********** Seventh method **************

    public void ListBooksByUsn(Scanner scanner){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter usn: ");
            String usn = input.nextLine();
            List<Object[]> bookDetails = issueRepository.findBooksByStudentUsn(usn);
            for (Object[] row : bookDetails) {
                String bookTitle = (String) row[0];
                String studentName = (String) row[1];
                String returnDate =  row[2].toString();

                System.out.printf("\n%-20s %-20s %-15s \n", "Book title", "student name", "return date");

                System.out.printf("%-20s %-20s %-15s \n", bookTitle,studentName,returnDate);


            }

        }

    //***************** Bonus 1 ********************
    public void searchBooksByQuantity(Scanner scanner) {
        System.out.print("Enter quantity to search: ");
        int searchQuantity = scanner.nextInt();
        try {
        List<Book> bookList = bookRepository.findByQuantity(searchQuantity);
        for (Book book : bookList) {
            System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
             }

        } catch (Exception e) {
            System.err.println("An unexpected exception occurred while searching by quantity: " + e.getMessage());
        }
        scanner.nextLine();
    }

    //***************** Bonus 2 *********************

    public void searchBookByISBN(Scanner scanner) {
        System.out.print("Enter the ISBN to search for a book: ");
        String searchISBN = scanner.nextLine();
        Optional<Book> bookOptional = bookRepository.findByIsbn(searchISBN);

        if (bookOptional.isPresent()) {
            Book foundBook = bookOptional.get();
            System.out.println("Book found: ");
            System.out.println("Title: " + foundBook.getTitle());
            System.out.println("Category: " + foundBook.getCategory());
            System.out.println("Quantity: " + foundBook.getQuantity());
        } else {
            System.out.println("No book found with the entered ISBN: " + searchISBN);
        }
    }

    //***************** Bonus 3 *********************
    public void searchBookById(Scanner scanner) {
        System.out.print("Enter the book ID to search for a book: ");
        Integer searchBookId = scanner.nextInt();
        scanner.nextLine();

        Optional<Book> bookOptional = bookRepository.findById(searchBookId);

        if (bookOptional.isPresent()) {
            Book foundBook = bookOptional.get();
            System.out.println("Book found: ");
            System.out.println("Title: " + foundBook.getTitle());
            System.out.println("Category: " + foundBook.getCategory());
            System.out.println("Quantity: " + foundBook.getQuantity());
        } else {
            System.out.println("No book found with the entered ID: " + searchBookId);
        }
    }


}
