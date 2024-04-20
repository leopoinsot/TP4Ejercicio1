package ar.unrn.model;

public class RegistroApi implements ServicioRegistros {
	private ParticipanteDAO participanteDAO;

	public RegistroApi(ParticipanteDAO participanteDAO){
		this.participanteDAO = participanteDAO;
	}
	@Override
	public void InscribirParticipante(String nombre, String numeroTelefono, String nombreRegion){
		var telefono = new Telefono(numeroTelefono);
		var region = new Region(nombreRegion);
		var participante = new Participante(nombre,telefono,region);
		participanteDAO.agregarParticipante(participante);
	}
}
