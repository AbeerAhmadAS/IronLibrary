package com.Ironhack.IronLibrary.model;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
@Component
public class BookDatabaseManager {

    String url = "jdbc:mysql://localhost:3306/library?createDatabaseIfNotExist=true&serverTimezone=UTC";
    String username = "root";
    String password = "ironhack";
    public void saveBooksToDatabase(List<Book> books) {
        // Database connection details
        this.url=url;
        this.password=password;
        this.username=username;

        // SQL query to insert book information into the database
        String insertQuery1 = "INSERT INTO  book (isbn, title, category, quantity) VALUES (?, ?, ?, ?)";

        try (Connection connection1 = DriverManager.getConnection(url, username, password);
             PreparedStatement statement1 = connection1.prepareStatement(insertQuery1)) {

            // Iterate over the list of books
            for (Book book : books) {
                // Set the parameter values for the prepared statement
                statement1.setString(1, book.getIsbn());
                statement1.setString(2, book.getTitle());
                statement1.setString(3, book.getCategory());
                statement1.setInt(4, book.getQuantity());

                // Execute the insert query
                statement1.executeUpdate();
            }

            System.out.println("Books added successfully and saved to the database!");
            System.out.println("----------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("Error saving books to the database: " + e.getMessage());
        }
    }
    public void saveAuthorToDatabase(List<Author> authors) {
        // Database connection details
        this.url = url;
        this.password = password;
        this.username = username;

        // SQL query to insert book information into the database
        String insertQuery2 = "INSERT INTO author (name, email) VALUES (?, ?)";

        try (Connection connection2 = DriverManager.getConnection(url, username, password);
             PreparedStatement statement2 = connection2.prepareStatement(insertQuery2)) {

            // Iterate over the list of books
            for (Author author : authors) {
                // Set the parameter values for the prepared statement
                statement2.setString(1, author.getName());
                statement2.setString(2, author.getEmail());
                //statement.setString(3, author.getAuthorBook().getTitle());

                // Execute the insert query
                statement2.executeUpdate();
            }

            System.out.println("Author added successfully and saved to the database!");
            System.out.println("----------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("Error saving Author to the database: " + e.getMessage());
        }

    }public void databaseDisplayBook() {


        // Database connection parameters
        this.url = url;
        this.password = password;
        this.username = username;

        // SQL query to retrieve data
        String query = "SELECT * FROM book";

        try {
            Connection connection3 = DriverManager.getConnection(url, username, password);
            Statement statement3 = connection3.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(query);
            while (resultSet3.next()) {

                Integer column0Value = resultSet3.getInt("id");
                Integer column1Value = resultSet3.getInt("category");
                String column2Value = resultSet3.getString("isbn");
                String column3Value = resultSet3.getString("quantity");
                Integer column4Value = resultSet3.getInt("title");
                Integer column5Value = resultSet3.getInt("author_id");

                System.out.println(column0Value + column1Value + column2Value + column3Value + column4Value + column5Value);
                }


            resultSet3.close();
            statement3.close();
            connection3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }}