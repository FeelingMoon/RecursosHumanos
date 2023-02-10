package co.edu.unbosque.model;

public interface CandidatosDAO {
	public void ingresar(String nombre, String apellido, int cedula, int edad, String cargos);
	public boolean modificar(String nombre, String apellido, int cedula, int edad, String cargos);
	public void eliminar(int cedula);
	public CandidatosDTO buscar(int cedula);
	public String listar();
}
