
//https://www.javaguides.net/2018/10/jdbc-statement-create-table-example.html


// https://www.javaguides.net/2018/10/jdbc-statement-create-table-example.html




/**
 * Select Statement JDBC Example
 * @author Alexander Solano de la Cruz
 * Matricula AB5972
 */
 
 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Create Statement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class CreateStatementExample {
	
	   public static void main(String[] args throws SQLException {
	        CreateStatementExample createTableExample = new CreateStatementExample();
	        createTableExample.createTable();
	   }// end of main method

    private static final String createTableSQL = "create table Users1(\r\n" + "  id  int(3) primary key,\r\n" + "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +  "  password varchar(20)\r\n" + "  );";

 
    
    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/mysql_database?useSSL=false", "root", "Admin");

            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
	
    public static void printSQLException(SQLException ex) {
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