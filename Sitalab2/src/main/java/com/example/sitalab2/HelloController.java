package com.example.sitalab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView <done>student;
    public TableColumn<done,Integer> StudentID;
    public TableColumn<done,String> FirstName;
    public TableColumn <done,String>LastName;
    public TableColumn <done,String>Address;
    public TextField takeID;
    public TextField takeName;
    public TextField takeLast;
    public TextField takeAddress;

    @FXML
    private Label welcomeText;
    ObservableList<done> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StudentID.setCellValueFactory(new PropertyValueFactory<done,Integer>("StudentID"));
        FirstName.setCellValueFactory(new PropertyValueFactory<done,String>("FirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<done,String>("LastName"));
        Address.setCellValueFactory(new PropertyValueFactory<done,String>("Address"));
        student.setItems(list);


    }

        @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void insert(ActionEvent actionEvent) {


        String FirstName = takeName.getText();
        String LastName = takeLast.getText();
        String Address = takeAddress.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/forlab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `student`( `FirstName`, `LastName`, `Address`) VALUES ('"+takeName+"','"+takeLast+"','"+takeAddress+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void update(ActionEvent actionEvent) {
        String Student = takeID.getText();
        String First = takeName.getText();
        String Last = takeLast.getText();
        String Add = takeAddress.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/forlab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `student` SET `FirstName`='"+First+"',`LastName`='"+Last+"',`Address`='"+Add+"' WHERE sID='"+Student+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(ActionEvent actionEvent) {
        String id = StudentID.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/forlab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `student` WHERE id='"+StudentID+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void view(ActionEvent actionEvent) {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/forlab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int StudentID = resultSet.getInt("StudentID");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Address = resultSet.getString("Address");
                student.getItems().add(new done(StudentID, FirstName, LastName, Address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }


