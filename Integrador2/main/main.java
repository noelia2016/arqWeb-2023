package main;

import DAO.DAOFactory;
import modelo.Estudiante;
import ConnectionFactory;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante estudiante = DAOFactory.getEstudianteDAO(ConnectionFactory.MYSQL).buscar_por_id(1);
		System.out.println(estudiante.toString());
	}

}
