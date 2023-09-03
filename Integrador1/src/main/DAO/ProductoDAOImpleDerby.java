package main.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import main.modelos.Producto;

public class ProductoDAOImpleDerby implements ProductoDAO {
    
    private Connection connection;

    public ProductoDAOImpleDerby(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear_tabla() {
        try {
            String table = "CREATE TABLE Producto (idProducto INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre VARCHAR(500), valor DOUBLE, PRIMARY KEY(idProducto))";
            PreparedStatement stmt = this.connection.prepareStatement(table);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Producto producto) {
        try {
            String insertar = "INSERT INTO Producto (nombre, valor) VALUES (?, ?)";
            PreparedStatement prepared = connection.prepareStatement(insertar);
            prepared.setString(1, producto.getNombre());
            prepared.setDouble(2, producto.getValor());
            prepared.executeUpdate();
            prepared.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Producto producto) {
        // Código para actualizar un producto en la base de datos
        // Implementa la lógica de actualización aquí
    }

    @Override
    public void eliminar(Producto producto) {
        // Código para eliminar un producto de la base de datos
        // Implementa la lógica de eliminación aquí
    }

    @Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		String select = "SELECT * FROM Producto";
		try (Statement pre = this.connection.createStatement()) {
			ResultSet resultado = pre.executeQuery(select);

			while (resultado.next()) {
				System.out.println(resultado.getInt(1) + " " + resultado.getString(2) + " " + resultado.getString(3));
			}
			// this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
