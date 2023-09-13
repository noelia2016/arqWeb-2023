package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.*;
import ConnectionFactory;
import entity.Equipo;
import entity.Jugador;
// hay que importar las entity que tenemos en el archivo de persitence.xml
import probando.integrador.Modelo.Estudiante;

public class main {

	public static void main(String[] args) {

		// me conecto 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		// Insertar carrera
		Carrera carrera_1 = new Carrera ("La super vagancia papa", 4, "Cresta");
		em.persist(carrera_1);
		
		// Insertar Estudiante
		Estudiante estudiante = new Estudiante ("Ana Lia", "Carrizo", 33, "F", "San Cayetano");
		em.persist(estudiante_1);
		
		Estudiante estudiante_2 = new Estudiante ("Bartolito", "Bertoni", 39, "M", "San Telmo");
		em.persist(estudiante_2);
		
		// Obtener estudiante
		Estudiante estudiante_select = em.find(Estudiante.class, 1);
		System.out.println(estudiante_select.toString());
		
		// Query JPQL
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
		estudiantes.forEach(j -> System.out.println(j.toString()));
		
		em.getTransaction().commit();
		em.close();
		emf.close();		


	}

}
