package co.edu.unbosque.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CandidatosDTO implements Serializable {

	private String nombre;
	private String apellido;
	private int cedula;
	private int edad;
	private String cargos;

	public CandidatosDTO(String nombre, String apellido, int cedula, int edad, String cargos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.cargos = cargos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCargos() {
		return cargos;
	}

	public void setCargos(String cargos) {
		this.cargos = cargos;
	}

	@Override
	public String toString() {
		return ">>>---------<<<\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nCedula: " + getCedula()
				+ "\nEdad: " + getEdad() + "\nCargo: " + getCargos();
	}
}