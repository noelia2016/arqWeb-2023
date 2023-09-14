package modelos;

import javax.persistence.*;

@Entity
public class Inscripto {

	@Id

	@Column(name = "id_estudiante")
	private int nro_libreta;

	@ManyToOne
	@JoinColumn(name = "ID_Departamento")
	private Carrera carrera;

	@Column
	private int antiguedad;

	@Column
	private boolean graduado;

	public Inscripto() {
		super();
	}

	public Inscripto(int nro_libreta, Carrera carrera, int antiguedad, boolean graduado) {
		this.nro_libreta = nro_libreta;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	@Override
	public String toString() {
		return "Inscripto [nro_libreta_estudiante=" + nro_libreta +
				", id_carrera=" + carrera
				+ ", antiguedad=" + antiguedad + ", graduado=" + graduado + "]";
	}

}
