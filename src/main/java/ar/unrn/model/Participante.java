package ar.unrn.model;
public class Participante {
	private String nombre;
	private Telefono telefono;
	private Region region;

	public Participante(String nombre, Telefono telefono, Region region){
		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
	}
	public String obtenerNombre(){
		return nombre;
	}
	public String obtenerTelefono(){
		return telefono.obtenerNombre();
	}
	public String obtenerRegion(){
		return region.obtenerNombre();
	}
}
