package ar.unrn.model;

import java.sql.SQLException;

public interface ServicioRegistros {
	void InscribirParticipante(String nombre, String numeroTelefono, String nombreRegion);
}