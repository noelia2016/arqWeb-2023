package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Integrador {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		// Para utilizar CVS y leer archivos
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
				FileReader("archivos/productos.csv"));
				for(CSVRecord row: parser) {
				System.out.println(row.get("idProducto"));
				System.out.println(row.get("nombre"));
				System.out.println(row.get("valor"));
				}

	}

}
