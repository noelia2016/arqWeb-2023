package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.*;
import ConnectionFactory;
// hay que importar las entity que tenemos en el archivo de persitence.xml
import probando.integrador.Modelo.Estudiante;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositoryFactory.getInstance(RepositoryFactory.MYSQL);

		Estudiante estudiante = new Estudiante (3423, "Anacleto", "Carrizo", 33, "F", "San Cayetano");
		Estudiante e1 = RepositoryFactory.get_repositorio_estudiante().save(estudiante);

		Carrera carrera = new Carrera ("La super vagancia papa", 4, "Cresta");
		Carrera est = RepositoryFactory.get_repositorio_carrera().save(c1);


	}

}
