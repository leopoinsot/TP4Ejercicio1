package ar.unrn.model;

import ar.unrn.database.ParticipanteDAOJDBC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ar.unrn.ui.RegistroParticipante;

public class RegistroApiTest {

	@Test
	public void InscribirParticipante() {
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
				registroApi.InscribirParticipante("Leonel", "2920304565", "China");
			}
		};
		ventanaRegistroParticipante.agregarParticipante();
		assertTrue(participanteDAOJDBC.obtenerIsAgrego());
	}
}