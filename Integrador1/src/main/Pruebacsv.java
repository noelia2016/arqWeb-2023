package main;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Pruebacsv {

    public static void main(String[] args) {
        String csvFilePath = "productos.csv";
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));
            int i=1;
            for (CSVRecord row : parser) {
                
                try {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)");

                    statement.setInt(1, i);
                    statement.setString(2, row.get("nombre"));
                    statement.setFloat(3, Float.parseFloat(row.get("valor")));
                    i++;
                    statement.executeUpdate();
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            

            connection.close();
            parser.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}


