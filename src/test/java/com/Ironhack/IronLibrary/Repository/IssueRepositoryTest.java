package com.Ironhack.IronLibrary.Repository;

import com.Ironhack.IronLibrary.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IssueRepositoryTest {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;

    private Date issueDat = new Date();
    private Date returnDate = new Date();
    private Student student;
    private Book isbn;
    Issue issue;

    @BeforeEach
    public void setUp() {
        student= new Student("USN456");
        studentRepository.save(student);

        isbn= new Book("978-0451524935");
        bookRepository.save(isbn);

        issue = new Issue(2, issueDat, returnDate, student, isbn);
        issueRepository.save(issue);
    }

    @AfterEach
    public void tearDown() {
        issueRepository.delete(issue);
        studentRepository.delete(student);
        bookRepository.delete(isbn);
    }

    @Test
    public void testIssueBookToStudent() {

        // Test valid issue to student
        try {
            Optional<Issue> issuedBook = issueRepository.findByIssueBook(isbn);
            Optional<Issue> issueStudent = issueRepository.findByIssueStudent(student);

            System.out.println(issuedBook.get().getIssueStudent().getUsn());

            assertTrue(issuedBook.isPresent(), "Expected issue to be present");
            assertEquals(issue.getIssueId(), issuedBook.get().getIssueId(), "Retrieved issue does not match expected issue");
        } catch (Exception e) {
            fail("An unexpected exception occurred during testing: " + e.getMessage());
        }

    }



    @Test
    public void testFindListBooksByUsn(){

        // Test finding books by USN
        try {
            List<Issue> issueStudent = issueRepository.findByIssueStudentUsn(student.getUsn());

            assertTrue(issueStudent.stream().allMatch(issue -> issue.getIssueStudent().getUsn().equals(student.getUsn())));
        } catch (Exception e) {
            fail("An unexpected exception occurred during testing: " + e.getMessage());
        }

    }


}