/*
package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import DAO.DAOFactory;
import ConnectionFactory;


public class Integrador {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		DAOFactory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
		DAOFactory.getProductoDAO(ConnectionFactory.DERBY).crear_tabla();
		
		// Para utilizar CVS y leer archivos

		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("C:\\Users\\noeli\\eclipse-workspace-ARQUITECTURA\\Integrador\\arqWeb-2023\\Integrador1\\archivos\\productos.csv"));
		for(CSVRecord row: parser) {
			// aca solamente lo muestra en consola deberiamos hacer el insert para cada modelo
			System.out.println(row.get("idProducto"));
			System.out.println(row.get("nombre"));
			System.out.println(row.get("valor"));
		}

		// tiene que hacerlo tambien por cliente, factura y factura_producto

	}

}
*/