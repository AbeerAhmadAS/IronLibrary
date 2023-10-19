create schema library; 
use library;


-- Insert sample data into Author table
INSERT INTO author (name, email) VALUES
    ('J.K. Rowling', 'jkrowling@email.com'),
    ('George Orwell', 'georgeorwell@email.com'),
    ('Jane Austen', 'janeausten@email.com');

-- Insert book records into the Book table
INSERT INTO book (isbn, title, category, quantity) VALUES
    ('978-0747532743', 'Harry Potter and the Philosopher''s Stone', 'Fantasy', 100),
    ('978-0451524935', '1984', 'Dystopian', 50),
    ('978-0141439518', 'Pride and Prejudice', 'Romance', 75);

   
-- Insert sample data into Issue table
INSERT INTO issue (issue_date, return_date) VALUES
    ('2023-10-10', null),  -- Make sure '1' is a valid bookId
    ('2023-10-12', '2023-09-29'),          -- Make sure '3' is a valid bookId
    ('2023-10-15', '2023-10-29');  -- Make sure '2' is a valid bookId
    
    INSERT INTO student (usn, name) VALUES
    ('USN123', 'John Doe'),
    ('USN456', 'Jane Smith'),
    ('USN789', 'Michael Johnson');
   
   
   select * from student;
  select * from book;
 select * from author;
select * from issue;
