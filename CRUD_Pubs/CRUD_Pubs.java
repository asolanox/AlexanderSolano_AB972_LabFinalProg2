
//  CRUD CON LA BASE DE DATOS MICROSOFT Pubs
/*
Laboratorio de Programacion 2
LAB Final
Autor: Alexander Solano de la Cruz
Matricula: AB5972

Prof. Lic. Silverio DelOrbe Abad
*/
import java.sql.statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.statement;
import java.util.ArrayList;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.sql.ResultSetMetaData;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.DriverManager;


import java.sql.ResultSetMetaData;
import java.sql.Connection;


import java.sql.SQLException;

import java.sql.DatabaseMetaData;

import java.util.List;
import java.util.stream.Collectors;


import java.sql.SQLType;
import java.sql.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class CRUD_Pubs {
    public static void main(String[] args) throws SQLException {
		
		//******************OPERACIONES DE CONEXION A BASE DE DATOS ********
		
        // Cargar el  MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establecer la coneccion
        String url = "jdbc:mysql://localhost/pubs";
        String user = "root";
        String password = "Admin";
        Connection conn = DriverManager.getConnection(url, user, password);

        // Crear una statement
        Statement stmt = conn.createStatement();
	
		//****************MENU  DE CONSUMO DE OPERACIONES CRUD ************
		
	


        Scanner scanner = new Scanner(System.in);
		
		 System.out.println("************ CRUD CON LA BASE DE DATOS MICROSOFT Pubs  ************/n");

        while(true) {
            System.out.println("CRUD Menu:/n");
            System.out.println("1. Create_Crear");
            System.out.println("2. Read_Leer todos los publishers ");
			System.out.println("3. Read_Leer un especifico publisher ");
			
            System.out.println("4. Actualizar_Update");
            System.out.println("5. Eliminar_Delete");
            System.out.println("6. Salida_Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Create
                    CREATE();
                    break;
                case 2:
                    // Read all publishers
                    READ_ALL();
                    break;
					
				 case 3:
                    // Read a specific publisher
                    READ_ONE();
                    break;
					
                case 4:
                    // Update
                    UPDATE();
                    break;
                case 5:
                    // Delete
                    DELETE();
                    break;
                case 6:
					// Exit
					EXIT();
                    System.out.println("Exiting...");
                    return;
                
	
                default:
                        System.out.println("Invalida opcion. Por favor, seleccione una opcion valida.");
						
					} // end of switch menu
				} // end of while
				
				
				} // end of class main 
	
				
	//*********************OPERACIONES DEL CRUD ***********************

      /*
    public static void CREATE() {
        // Implement create operation
		// CREATE - Insert a new publisher
        String createPub = "INSERT INTO publishers (pub_id, pub_name) VALUES ('12345', 'New Publisher')";
        stmt.executeUpdate(createPub);
		
		 // READ - Retrieve the new publisher
        rs = stmt.executeQuery("SELECT * FROM publishers WHERE pub_id = '12345'");
        rs.next();
        System.out.println("New publisher: " + rs.getString("pub_name"));
		
    } // end of method CREATE
	*/

    public static void READ_ALL() {
        // Implement read operation
		
		 // READ - Retrieve all publishers
        ResultSet rs = stmt.executeQuery("SELECT * FROM publishers");
        while (rs.next()) {
           
            System.out.println(rs.getString("pub_id") + " - " + rs.getString("pub_name"));
        }
 
    } // end of READ method

    public static void UPDATE() {
        // Implement update operation
		
		// UPDATE - Update the new publisher's name
        String updatePub = "UPDATE publishers SET pub_name = 'New Name' WHERE pub_id = '12345'";
        stmt.executeUpdate(updatePub);
		
        // READ - Retrieve the updated publisher
        String updatePubId = "12345";
        if(updatePubId.matches("\\d+")){
            updatePubId = "'"+updatePubId+"'";
        }
        ResultSet rs = stmt.executeQuery("SELECT * FROM publishers WHERE pub_id = "+updatePubId);
        rs.next();

    } // end of method UPDATE


    public static void DELETE() {
        // Implement delete operation
		
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite id del publisher a eliminar_Enter the publisher id to delete:");
			String pubId = scanner.next();

			try {
				// Connect to database
				Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("DELETE FROM publishers WHERE pub_id = '" + pubId + "'");
				System.out.println("Publisher deleted successfully!");
			} catch (SQLException e) {
				System.out.println("Error deleting publisher: " + e.getMessage());
			}
		} // end of method delete
		
		
		
	    public static void READ_ALL() {
        // READ - Retrieve all publishers
        System.out.println("Todo los publishers_All Publishers:");
        ResultSet rs = stmt.executeQuery("SELECT * FROM publishers");
        while (rs.next()) {
            System.out.println(rs.getString("pub_id") + " - " + rs.getString("pub_name"));
			}
		}// end of READ_ALL method
		
		
		public static void READ_ONE() {
        // READ - Retrieve a specific publisher
        String readPubId = "READ_ONE";
        if(readPubId.matches("\\d+")){
            readPubId = "'"+readPubId+"'";
        }
        rs = stmt.executeQuery("SELECT * FROM publishers WHERE pub_id = "+readPubId);
        if(rs.next()){
            System.out.println("Publisher: " + rs.getString("pub_name"));
        } else {
            System.out.println("Publisher NO encontrado_Publisher not found.");
			}
		}// end of methot READ_ONE
		
       //*************************************************************
		

		
	
		//*****************OPERACIONES DE CERRADO DE CONEXION Y STATEMENT*******************

       // Closing the statement and connection
	   
	     public static void EXIT() {
        // Implement delete operation
        try {
            if (stmt != null) { stmt.close(); }
            if (conn != null) { conn.close(); }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
			} // end of catch
		 } // End of EXIT operations method closing statement and oonnection

		
	
} // end of class CRUD_Pubs
	   
	 //************************************************************************************************
	

/*	//CODIGO JAVA DE YOU.COM
	 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    private static final String URL = "jdbc:mysql://localhost:3306/pubs";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Insertar un registro en la tabla
            insertRecord(connection, "John Doe", "john.doe@example.com");

            // Actualizar un registro en la tabla
            updateRecord(connection, 1, "Jane Smith", "jane.smith@example.com");

            // Eliminar un registro de la tabla
            deleteRecord(connection, 2);

            // Consultar todos los registros de la tabla
            selectAllRecords(connection);

            // Cerrar la conexión con la base de datos
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }// end of catch
    } // end of method main

    private static void insertRecord(Connection connection, String name, String email) throws SQLException {
        String sql = "INSERT INTO employees (name, email) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.executeUpdate();
        System.out.println("Registro insertado correctamente");
    } // end of method insertRecord

    private static void updateRecord(Connection connection, int id, String name, String email) throws SQLException {
        String sql = "UPDATE employees SET name = ?, email = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setInt(3, id);
        statement.executeUpdate();
        System.out.println("Registro actualizado correctamente");
    } // end of method updateRecord

    private static void deleteRecord(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        System.out.println("Registro eliminado correctamente");
    } // end of method deleteRecord

    private static void selectAllRecords(Connection connection) throws SQLException {
        String sql = "SELECT * FROM employees";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
        } // end of while
    } // end of method selectAllRecords
} // end of class CRUD


*/