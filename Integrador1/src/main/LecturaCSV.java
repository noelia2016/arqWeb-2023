package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

public class LecturaCSV {

	public static void main (String [] Args) throws IOException {

		/**  conexion de la BD */
		String driver="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			// CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("productos.csv"));
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
		| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri="jdbc:mysql://localhost:3306/midb";
        /** fin de conexion de la BD */

		try {

			Connection miConeccion=DriverManager.getConnection(uri,"arq_2023","Bp)U[.!9LBZo8QY3");
			miConeccion.setAutoCommit(false);
			String[]  tablas = ['producto', 'cliente', 'factura', 'factura_producto'];

			// lee los 4 cvs que tenemos para cargar la BD
			for (String tablas : nombre) {
				
				// ruta donde esta el archivo por leer
				Reader reader = new FileReader("C:/xampp/htdocs/Proyectos/arqWeb-2023/Integrador1/archivos/" + nombre + "s.csv");

				// lee el archivo elegido
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
				for (CSVRecord csvRecord : csvParser) {

					// se preparan los datos que se leen del archivo para poder insertarlo
					String idString = (csvRecord.get(0)); // Por índice

					// se obtiene el id de la misma
					Integer numeroInteger = Integer.valueOf(idString); 
					int id = numeroInteger.intValue();

					switch (nombre) {
						
						case 'producto':
							// el nombre del producto
							String nombre = csvRecord.get("nombre"); // Por nombre de columna

							// valor del producto
							String valorString = csvRecord.get("valor"); // Por nombre de columna
							Float valor= Float.parseFloat(valorString);
							// System.out.println("Id: " + id+" "+ nombre +" "+valor);

							// por cada fila leida se inserta en la BD
							PreparedStatement statement = miConeccion.prepareStatement("INSERT INTO producto (idProducto,nombre, valor) VALUES (?, ?,?)");
							statement.setInt(1, id );
							statement.setString(2, nombre);
							statement.setFloat(3, valor);
						case 'cliente':
							// el nombre del producto
							String nombre = csvRecord.get("nombre"); // Por nombre de columna
							// valor del producto
							String email = csvRecord.get("email"); // Por nombre de columna

							// por cada fila leida se inserta en la BD
							PreparedStatement statement = miConeccion.prepareStatement("INSERT INTO cliente (idCliente,nombre, email) VALUES (?, ?,?)");
							statement.setInt(1, id );
							statement.setString(2, nombre);
							statement.setFloat(3, email);
						case 'factura':
							// el nombre del producto
							Int idCliente = csvRecord.get("idCliente"); // Por nombre de columna

							// por cada fila leida se inserta en la BD
							PreparedStatement statement = miConeccion.prepareStatement("INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)");
							statement.setInt(1, id );
							statement.setInt(2, idCliente);
						case 'factura_producto':

							// id del producto
							Int idProducto = csvRecord.get("idProducto"); // Por nombre de columna

							// cantidad facturada del producto
							Int cantidad = csvRecord.get("cantidad"); // Por nombre de columna

							// por cada fila leida se inserta en la BD
							PreparedStatement statement = miConeccion.prepareStatement("INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)");
							statement.setInt(1, id );
							statement.setInt(2, idProducto);
							statement.setInt(3, cantidad);

					}
					
					statement.executeUpdate();
					statement.close();
					// hace el commit para que se guarden los datos en la tabla
					miConeccion.commit();
				} // fin del iterador recorriendo el archivo

				// se cierra la conexion
				miConeccion.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // fin del recorrido de archivos
	}

}