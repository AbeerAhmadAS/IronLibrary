package com.Ironhack.IronLibrary.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Integer issueId;

    @Temporal(TemporalType.DATE) // Specify DATE type
    @Column(name = "issue_date")
    private Date issueDate;

    @Temporal(TemporalType.DATE) // Specify DATE type
    @Column(name = "return_date")
    private Date returnDate;

    @OneToOne
//    @PrimaryKeyJoinColumn(name = "usn")
    private Student issueStudent;

    @OneToOne
//    @PrimaryKeyJoinColumn(name = "isbn")
    private Book issueBook;

    public Issue() {

    }

    public Issue(Integer issueId, Date issueDate, Date returnDate, Student issueStudent, Book issueBook) {
        this.issueId = issueId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issueStudent = issueStudent;
        this.issueBook = issueBook;
    }

    public Issue(Date issueDate, Date returnDate, Student newStudent, Book book) {
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", issueStudent=" + issueStudent +
                ", issueBook=" + issueBook +
                '}';
    }
}