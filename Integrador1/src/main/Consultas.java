/*

package main;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

	// retorna el producto que mas recaudo 
	private static void productoQueMasRecaudo(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String result = "SELECT MAX(fp.cantidad * p.valor) as total,fp.*, p.* FROM `factura_producto` as fp inner join producto as p on fp.idProducto = p.idProducto
		ORDER BY total desc;";
		java.sql.PreparedStatement ps = conn.prepareStatement(result);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

	// imprime una lista de clientes ordenada por el cual se le facturo mas 
	private static void listadoDeClientesXMayorFacturacion(Connection conn) throws SQLException {
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
*/