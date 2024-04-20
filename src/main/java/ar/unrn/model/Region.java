package ar.unrn.model;

public class Region {
	private String nombre;

	public Region(String nombre)throws RuntimeException{
		verificarNombre(nombre);
		this.nombre = nombre;
	}

	public String obtenerNombre(){
		return nombre;
	}

	private void verificarNombre(String nombre) throws RuntimeException{
		if (nombre.equals("")) {
			throw new RuntimeException("Debe cargar un nombre");
		}
		if (!nombre.equals("China") && !nombre.equals("US") && !
				nombre.equals("Europa")) {
			throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
		}
	}
}
