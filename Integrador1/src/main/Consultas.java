package main;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// para configurar los driver de la BD 
		String driver="org.apache.derby.jdbc.EmbeddedDriver";
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e  ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		// donde nos conectamos si no esta la crea a la DB con derby
		String url = "jdbc:derby:MyDerbyDb;create=true";
		
		// nos conectamos a la BD y por si las dudas le damos una exception con try catch
		try {
			Connection conn = DriverManager.getConnection(url);
			String select = "SELECT * FROM persona";
			PreparedStatement ps = conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3));
			}
			//ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* retorna el producto que mas recaudo */
	private static void productoQueMasRecaudo(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String result = "SELECT MAX(fp.cantidad * p.valor) as total,fp.*, p.* FROM `factura_producto` as fp inner join producto as p on fp.idProducto = p.idProducto
		ORDER BY total desc;";
		java.sql.PreparedStatement ps = conn.prepareStatement(result);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

	/* imprime una lista de clientes ordenada por el cual se le facturo mas */
	private static void productoQueMasRecaudo(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String result = "SELECT (fp.cantidad * p.valor) as total,fp.*, p.* , c.*, f.*
		FROM `factura_producto` as fp 
		RIGHT join producto as p on fp.idProducto = p.idProducto 
		left join factura as f on fp.idFactura = f.idFactura
		left join cliente as c on f.idCliente = c.idCliente
		ORDER BY total desc;";
		java.sql.PreparedStatement ps = conn.prepareStatement(result);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

}
