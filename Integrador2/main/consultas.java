package main;

import DAO.DAOFactory;
import modelo.Estudiante;
import ConnectionFactory;

public class Consultas {

    /**
     * CONSULTAS A RESPONDER
     * Implementar consultas para:
        a) dar de alta un estudiante
        b) matricular un estudiante en una carrera
        c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        d) recuperar un estudiante, en base a su número de libreta universitaria.
        e) recuperar todos los estudiantes, en base a su género.
        f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.

        3) Generar un reporte de las carreras, que para cada carrera incluya información de los 
        inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        los años de manera cronológ
     */

    /** Inserta un nuevo estudiante */
	public static altaEstudiante (String nombre, String apellido, String Ciudad Int edad, String genero) {
		// TODO Auto-generated method stub
        consulta = "INSERT INTO `estudiante`(`nro_libreta`, `nombre`, `apellido`, `edad`, `genero`, `dni`, `ciudad`) VALUES (?,?,?,?,?,?,?)";
    }

    /** Listar estudiantes */
	public static obtenerEstudiantes () {

		// crea la entidad
        EntityManagerFactory emp= Persistence.createEntityManagerFactory("Integrador2");
		EntityManager em = emp.createEntityManager();

		/** lista todos los estudiantes */
		String jpql = "SELECT * FROM estudiante ORDER BY apellido, nombre ASC";
		Query q1 = em.createQuery(jpql);
		List<Estudiante> resultados = q1.getResultList();
		for (Estudiante e: resultados){
			System.out.println(e.getApellido(), e.getNombre());
		}

		em.close();
		emf.close();

    }

    /** Matriculo un estudiante */
	public static matricularEstudiante (Int nro_libreta, Int carrera, Int antiguedad, Boolean graduado) {
		// TODO Auto-generated method stub
        consulta = createQuery("INSERT INTO `inscripto`(`nro_libreta_estudiante`, `carrera`, `antiguedad`, `graduado`) VALUES (?,?,?,?)".setParameter(nro_libreta,carrera, antiguedad,graduado).getRsultList());
    }


    /** Busco el estudiante por su numero de estudiante */
	public static obtenerEstudiantePorNroLibreta (nroEstudiante) {

		// crea la entidad
        EntityManagerFactory emp= Persistence.createEntityManagerFactory("Integrador2");
		EntityManager em = emp.createEntityManager();

		/** lista todos los estudiantes */
		String jpql = "SELECT * FROM estudiante WHERE nro_libreta = ?";
		Query q1 = em.createQuery(jpql);
        q1.setParameter(1, nroEstudiante);
		List<Estudiante> resultados = q1.getResultList();
		for (Estudiante p: resultados){
			System.out.println(e.getApellido(), e.getNombre());
		}

		em.close();
		emf.close();

    }


    /** Busco todos los estudiantes en base a su genero */
	public static obtenerEstudiantesPorGenero (genero) {

		// crea la entidad
        EntityManagerFactory emp= Persistence.createEntityManagerFactory("Integrador2");
		EntityManager em = emp.createEntityManager();

		/** lista todos los estudiantes */
		String jpql2 = "SELECT * FROM estudiante WHERE genero = ?";
		Query q1 = em.createQuery(jpql2);
        q1.setParameter(1, genero);
		List<Estudiante> resultados = q1.getResultList();
		for (Estudiante p: resultados){
			System.out.println(e.getApellido(), e.getNombre());
		}

		em.close();
		emf.close();

    }


    /** f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos. */
	public static obtenerEstudiantesInscriptos () {

		/** lista todos los estudiantes */
		String jpql2 = "SELECT COUNT(i.id_carrera) as cant, e.*, i.*, c.* FROM estudiante e 
                        INNER JOIN inscripto i on e.nro_libreta = i.nro_libreta_estudiante
                        INNER JOIN carrera c on c.id_carrera = i.id_carrera
                        ORDER BY cant DESC, e.apellido, e.nombre ASC";
		Query q1 = em.createQuery(jpql2);
	    return resultados = q1.getResultList();

    }

    /** f) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia */
	public static obtenerEstudiantesInscriptos (carrera, ciudad) {

		/** lista todos los estudiantes */
		String jpql2 = "SELECT COUNT(i.id_carrera) as cant, e.*, i.*, c.* FROM estudiante e 
                        INNER JOIN inscripto i on e.nro_libreta = i.nro_libreta_estudiante
                        INNER JOIN carrera c on c.id_carrera = i.id_carrera
                        WHERE i.id_carrera = ? and e.ciudad_residencia like ?;
                        ORDER BY cant DESC, e.apellido, e.nombre ASC";
		Query q1 = em.createQuery(jpql2);
        q1.setParameter(1, carrera);
        q1.setParameter(2, ciudad);
	    return resultados = q1.getResultList();

    }

    /** f) Generar un reporte de las carreras, que para cada carrera incluya información de los 
        inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        los años de manera cronológica */
	public static obtenerEstudiantesInscriptos (carrera, ciudad) {

		/** lista todos los estudiantes */
		String jpql2 = "SELECT COUNT(i.id_carrera) as cant, e.*, i.*, c.* FROM estudiante e 
                        INNER JOIN inscripto i on e.nro_libreta = i.nro_libreta_estudiante
                        INNER JOIN carrera c on c.id_carrera = i.id_carrera
                        ORDER BY c.nombre ASC, e.apellido, e.nombre ASC";
		Query q1 = em.createQuery(jpql2);
        q1.setParameter(1, carrera);
        q1.setParameter(2, ciudad);
	    resultados = q1.getResultList();

        List<Estudiante> resultados = q1.getResultList();
		for (Estudiante e: resultados){
			System.out.println(e.getApellido(), e.getNombre());
		}

		em.close();
		emf.close();

    }


}
