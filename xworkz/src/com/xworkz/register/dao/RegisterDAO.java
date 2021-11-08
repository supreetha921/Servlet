package com.xworkz.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.registration.model.RegisterForm;

public class RegisterDAO {
	 public int registration(RegisterForm register) throws ClassNotFoundException {
	        String statement = "INSERT INTO employee" +
	                "  (Name,Qualification,Place,Contact) VALUES " +
	                " (supreetha, BE, Mysore, 8867718150);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workz", "root", "Jobs@2212");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
	            //preparedStatement.setInt(1, 1);
	            preparedStatement.setString(1, register.getName());
	            preparedStatement.setString(2, register.getQualification());
	            preparedStatement.setString(3, register.getPlace());
	            preparedStatement.setString(4, register.getContact());
	            
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}

