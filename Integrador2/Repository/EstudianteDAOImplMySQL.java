package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.Estudiante;

public class EstudianteDAOImplMySQL implements EstudianteDAO {
	private EntityManager em;

	public EstudianteDAOImplMySQL(EntityManager em) {
		this.em = em;
	}

	public Estudiante buscar_por_id(int id_Estudiante) {

		Estudiante Estudiante = em.find(Estudiante.class, id_Estudiante);

		return Estudiante;
	}

	@Override
	public void insertar(Estudiante Estudiante) {
		// código para insertar un Estudiante en la base de datos
	}

	@Override
	public void actualizar(Estudiante Estudiante) {
		// código para actualizar un Estudiante en la base de datos
	}

	@Override
	public void eliminar(Estudiante Estudiante) {
		// código para eliminar un Estudiante de la base de datos
	}

	@Override
	public List<Estudiante> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<Estudiante> listar() { // código para listar todos los
	 * Estudiantees de la base de datos return null; }
	 */
}
