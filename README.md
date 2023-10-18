# Library Management System 
<a name="readme-top"></a>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
          <li><a href="#Features">Features</a></li>
          <li><a href="#Additional-Commands">Additional Commands</a></li>
          <li><a href="#Code-Structure">Code Structure</a></li>
          <li><a href="#How-the-Application-Works">How the Application Works</a></li>
          <li><a href="#Menu-Options">Menu Options</a></li>
          <li><a href="#UML">UML</a></li>
         </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="# Contributors">Contributors</a></li>
 
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project


Welcome to the IronLibrary application's Data Layer, where we model complex relationships between books, authors, students, and issues. IronLibrary is a Library Management System designed to help manage and acquire data about the books being used by students. In this application, you'll explore how to model complex relationships in a data-driven environment, handle various book-related actions, and interact with a MySQL database.

<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- GETTING STARTED -->
## Getting Started

## Features

The Library Management System provides the following features:
-	Add a book: This action is responsible of adding a book and its author in the system. The user will be prompted to enter the details of both the book and the author in the following format:
-	Search book by title: This action is responsible for searching a book by title.
-	Search book by category: This action is responsible for searching a book by category.
-	Search book by author: This action is responsible for searching a book by author name.
-	List all books along with author: This action is responsible for listing all the books available and there corresponding authors.
-	Issue book to student: This action is responsible for creating a student and issuing him/her the specified book. The date issued represent the current date and the return date should be after 7 days.
-	List books by usn: This action is responsible for listing all books rented by the specified student.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Additional_Commands

Add more options that can help display more information such as List books to be returned today, etc.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Code_Structure

## Classes
In IronLibrary, four main classes play a crucial role: Author, Book, Student, and Issue.

### Book Class
The Book class represents a book in our library. It has the following attributes:

- isbn: International Standard Book Number (a unique identifier)
- title: Title of the book
- category: Category of the book
- quantity: Number of copies available
### Author Class
The Author class represents an author of a book. It includes:

- authorId: An auto-incremented unique identifier
- name: Author's name
- email: Author's email
- authorBook: A One-to-One relationship with a Book
### Issue Class
The Issue class handles book issuance to students. It contains:

- issueId: An auto-incremented unique identifier
- issueDate: Date of issuance
- returnDate: Date of expected return
- issueStudent: A One-to-One relationship with a Student
- issueBook: A One-to-One relationship with a Book
### Student Class
The Student class represents a student. It consists of:

- usn: Universal Student Number (a unique identifier)
- name: Student's name


<p align="right">(<a href="#readme-top">back to top</a>)</p>

  
# How the Application Works
Upon launching IronLibrary, users are presented with a menu that provides various options for managing the library. Users can input a number corresponding to their chosen action, such as adding a book, searching for a book, issuing a book to a student, and more. After completing an action, the menu is automatically redisplayed for further interaction.


### The code is organized into three main classes:
- The Teacher, Course, and Student classes represent the core entities in the school management system. They contain attributes and methods to manage teachers, courses, and students.
- The CommandMenu class handles the graphical user interface and provides methods for user interaction.
- The Main class is the entry point for the application. It initializes and manages teacher, course, and student data and launches the user interface.



<p align="right">(<a href="#readme-top">back to top</a>)</p>



 # Menu Options
- Add a Book: Add a book and its author to the system.
- Search Book by Title: Search for a book by its title.
- Search Book by Category: Search for a book by its category.
- Search Book by Author: Search for a book by the author's name.
- List All Books Along with Author: List all available books and their corresponding authors.
- Issue Book to Student: Issue a book to a student, including issuance and return dates.
- List Books by USN (Student Identifier): List books issued to a specific student based on their USN.
- Search By Quantuty :Search for a book by its Quantuty.
- Search For Book By ISBN :Search for a book by its ISBN.
- Search For Book By ID :Search for a book by its ID.
- Exit: Exit the application.



<p align="right">(<a href="#readme-top">back to top</a>)</p>



# Actions
- Add a Book: This action allows users to add a book and its author to the library system. Users provide details for both the book and the author.

- Search Book by Title: Users can search for a book by its title, and the application returns relevant information about the book(s) matching the title.

- Search Book by Category: Users can search for a book by its category, and the application displays matching book(s) information.

- Search Book by Author: This action helps users find books by searching for the author's name. The application returns books authored by the specified author.

- List All Books Along with Author: Users can see a comprehensive list of all books in the library, including details about the respective authors.

- Issue Book to Student: Users can issue a book to a student. The system records the issuance date and sets a return date (typically seven days in the future).

- List Books by USN (Student Identifier): This action lists books issued to a specific student based on their USN.

- Search Book by Quantuty: Users can search for a book by its Quantuty, and the application returns relevant information about the book(s) matching the Quantuty.

- Search Book by ISBN: Users can search for a book by its ISBN, and the application returns relevant information about the book(s) matching the ISBN.

- Search Book by ID: Users can search for a book by ID, and the application returns relevant information about the book(s) matching the ID.



<p align="right">(<a href="#readme-top">back to top</a>)</p>





## Usage

### Demo

To see a USE CASE DIADRAM of the project, you can download the Photo from [here](https://drive.google.com/file/d/1MUf46vEhNAo1C0uyYRGKh29ZNtl5VUHF/view?usp=sharing).


<p align="right">(<a href="#readme-top">back to top</a>)</p>






<!-- Team members -->
## Contributors
- [Abeer Ahmad](https://github.com/AbeerAhmadAS)
- [Huda Ayoub](https://github.com/HUDAAYOUB)
- [Thuraya ALfahmi](https://github.com/ThurayaAlfahmi)
- [Yumna Alansari](https://github.com/YumnaAlansari)
- [Salihah Alotaibi](https://github.com/salihahOtaibi)
- [Afaf Abdullah](https://github.com/afaf99)

 
<p align="right">(<a href="#readme-top">back to top</a>)</p>

