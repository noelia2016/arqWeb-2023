
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
	public static final String DERBY = "derby";
	public static final String MYSQL = "mysql";

	//private static ConnectionFactory instance = new ConnectionFactory();
	private static ConnectionFactory instance = null;
	private Connection connection;

	/*private ConnectionFactory() {
	}*/

	public static ConnectionFactory getInstance(String motor) {
		if (this.instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
		
	}

	// conectar a la BD
	private ConnectionFactory (String type) {
		
		if (this.connection != null) {
			this.disconnect();
		}
		
		// si eleijo conectarme con DERBY -- base embebida
		if (type.equals(DERBY)) {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				this.connection = DriverManager.getConnection("jdbc:derby:arq_2023;create=true");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// si elijo conectarme a traves de MysSQL
		if (type.equals(MYSQL)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arq_2023", "root", "noelia.2023");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return this.connection;
	}

	// retorna si conecta
	public Connection connection() {
		return this.connection;
	}

	// para desconectarse de la BD
	public void disconnect() {

		// si esta conectado realizo la desconexion
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
