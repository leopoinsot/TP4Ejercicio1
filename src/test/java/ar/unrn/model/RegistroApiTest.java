package ar.unrn.model;

import ar.unrn.database.ParticipanteDAOJDBC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ar.unrn.ui.RegistroParticipante;

public class RegistroApiTest {

	@Test
	public void InscribirParticipanteTest() {
		var participanteDAOJDBC = new ParticipanteDAOJDBC(){
			private boolean isAgrego;
			public void agregarParticipante(Participante participante){
				isAgrego = true;
			}
			public boolean obtenerIsAgrego(){
				return isAgrego;
			}
		};
		var registroApi = new RegistroApi(participanteDAOJDBC);

		var ventanaRegistroParticipante = new RegistroParticipante(registroApi){
			public void agregarParticipante(){
				var participante = new Participante("leonel", new Telefono("2920304565"), new Region("China"));
				registroApi.InscribirParticipante(participante.obtenerNombre(), participante.obtenerTelefono(), participante.obtenerRegion()); //Es solo para mejorar el coverage (Los get son solo para agregar en la base de datos (esta justificado)
			}
		};
		ventanaRegistroParticipante.agregarParticipante();
		assertTrue(participanteDAOJDBC.obtenerIsAgrego());
	}

	@Test
	public void InscribirParticipanteConRegionNoValidaTest() {
		var participanteDAOJDBC = new ParticipanteDAOJDBC() {
			private boolean isAgrego;

			public void agregarParticipante(Participante participante) {
				isAgrego = true;
			}

			public boolean obtenerIsAgrego() {
				return isAgrego;
			}
		};
		var registroApi = new RegistroApi(participanteDAOJDBC);
		assertThrows(RuntimeException.class, () -> registroApi.InscribirParticipante("Leonel", "2920304565", "japon"));
	}
}