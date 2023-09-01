package main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// import main.ConnectionFactory;
import main.modelos.Producto;


public class ProductoDAOImpleMySQL implements ProductoDAO {
	private Connection connection;

	public ProductoDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		
		try {
			String table = "CREATE OR REPLACE TABLE Producto (idProducto INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(500), valor FLOAT, PRIMARY KEY(idProducto))";
			PreparedStatement stmt = this.connection.prepareStatement(table);
			// para crear la tabla en la BD
			stmt.executeUpdate(table);
			// ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Producto Producto) {
		
		try {
			String insertar="INSERT IGNORE INTO Producto (nombre, valor) VALUES (?,?)";
			PreparedStatement prepared = connection.prepareStatement(insertar);
			prepared.setString(1,Producto.getNombre());
			prepared.setFloat(2,Producto.getValor());
			prepared.executeUpdate();
			prepared.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void actualizar(Producto Producto) {
		// código para actualizar un Producto en la base de datos
	}

	@Override
	public void eliminar(Producto Producto) {
		// código para eliminar un Producto de la base de datos
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		String select="SELECT * FROM Producto";
			try (Statement pre = this.connection.createStatement()) {
				ResultSet resultado=pre.executeQuery(select);

				
				
				while (resultado.next()){
					System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3));
				}
				// this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		return null;
	}

	

	
}
