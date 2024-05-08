package ar.unrn.model;

public class RegistroApi implements ServicioRegistros {
	private ParticipanteDAO participanteDAO;

	public RegistroApi(ParticipanteDAO participanteDAO){
		this.participanteDAO = participanteDAO;
	}
	@Override
	public void InscribirParticipante(String nombre, String numeroTelefono, String nombreRegion) {
		try { //debo atrapar la excepcion lanzada para poder testear
			var region = new Region(nombreRegion);
			var telefono = new Telefono(numeroTelefono);
			var participante = new Participante(nombre, telefono, region);
			participanteDAO.agregarParticipante(participante);
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}

	}
}
