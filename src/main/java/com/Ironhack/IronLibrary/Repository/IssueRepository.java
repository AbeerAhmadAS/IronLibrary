
package com.Ironhack.IronLibrary.Repository;


import com.Ironhack.IronLibrary.model.Book;
import com.Ironhack.IronLibrary.model.Issue;
import com.Ironhack.IronLibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

    @Repository
    public interface IssueRepository extends JpaRepository<Issue, Integer>{

        Optional<Issue> findByIssueStudent(Student student);
        Optional<Issue> findByIssueBook(Book book);
        List<Issue> findByIssueStudentUsn (String usn);
        @Query(value = "SELECT b.title, s.name, i.return_date\n" +
                "from issue as i \n" +
                "join book as b on i.issue_book_id =b.isbn \n" +
                "join student s on i.issue_student_usn =s.usn where s.usn = :usn",nativeQuery = true)
        List<Object[]> findBooksByStudentUsn(@Param("usn") String usn
        );

    }

