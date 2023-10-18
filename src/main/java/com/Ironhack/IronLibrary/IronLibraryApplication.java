package com.Ironhack.IronLibrary;

//import com.Ironhack.IronLibrary.model.LibraryMethods;
import com.Ironhack.IronLibrary.Repository.AuthorRepository;
import com.Ironhack.IronLibrary.model.Author;
import com.Ironhack.IronLibrary.model.Book;
import com.Ironhack.IronLibrary.model.LibraryMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class IronLibraryApplication implements CommandLineRunner {
@Autowired
LibraryMethods libraryMethods;
	public static void main(String[] args) {

		SpringApplication.run(IronLibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			libraryMethods.displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					libraryMethods.addBook(scanner);
					break;
				case 2:
					libraryMethods.searchBookByTitle(scanner);
					break;
				case 3:
					libraryMethods.searchBookByCategory(scanner);
					break;
				case 4:
					libraryMethods.searchBookByAuthor(scanner);
					break;
				case 5:
					libraryMethods.listAllBooksAlongWithAuthor();
					break;
				case 6:
					libraryMethods.issueBookToStudent(scanner);
					break;
				case 7:
					libraryMethods.ListBooksByUsn(scanner);
					break;
				case 8:
					libraryMethods.searchBooksByQuantity(scanner);
					break;
				case 9:
					libraryMethods.searchBookByISBN(scanner);
					break;
				case 10:
					libraryMethods.searchBookById(scanner);
					break;
				case 11:
					System.out.println("Exiting the application...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					//1break;
			}
		} while (choice != 11);


	}
}
