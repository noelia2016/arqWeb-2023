package DAO;

import javax.persistence.EntityManager;
import util.ConnectionFactory;

public class DAOFactory {

	public DAOFactory() {
	}

	public static EstudianteDAO getEstudianteDAO(String type) {
		if (type.equals(ConnectionFactory.MYSQL)) {
			EntityManager em = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new EstudianteDAOImplMySQL(em);
		} else if (type.equals(ConnectionFactory.DERBY)) {
			// Aca deberia implementar DERBY
			EntityManager em = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
			return new EstudianteDAOImplMySQL(em);
		} else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	// otros métodos para obtener instancias de DAOs
}

