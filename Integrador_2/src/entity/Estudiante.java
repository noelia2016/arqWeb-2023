package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nombre;

	private String apellido;

	private Integer nro_doc;

	private Integer edad;

	private String genero;

	private String ciudad_reside;

	
	public Estudiante() {
		super();
	}

	public Estudiante( String nombre, String apellido, int nro_doc, int edad, String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_doc = nro_doc;
		this.edad = edad;
		this.ciudad_reside = ciudad_reside;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	} 

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNroDoc() {
		return nro_doc;
	}

	public void setNroDoc(int nro_doc) {
		this.nro_doc = nro_doc;
	}

	public Equipo getCiudadReside() {
		return ciudad_reside;
	}

	public void setCiudadReside(Equipo ciudad) {
		this.ciudad_reside = ciudad;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nro_doc=" + nro_doc
				+ ", ciudad residente=" + ciudad_reside + "]";
	}

}

