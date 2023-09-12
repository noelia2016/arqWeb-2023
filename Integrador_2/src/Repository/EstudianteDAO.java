package DAO;

import java.util.List;

import modelo.Estudiante;

public interface EstudianteDAO {

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Estudiante estudiante);

	public Estudiante buscar_por_id(int id);

	public List<Estudiante> listar();
}
