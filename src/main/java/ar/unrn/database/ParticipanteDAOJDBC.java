package ar.unrn.database;

import ar.unrn.model.Participante;
import ar.unrn.model.ParticipanteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteDAOJDBC implements ParticipanteDAO {
	String url = "jdbc:mysql://localhost:3306/registroparticipantetp4ejercicio1objetos2";
	String username = "LeonelAriel";

	String password = "villa2015";
	private Connection dbConn;
	private PreparedStatement st;
	@Override
	public void agregarParticipante(Participante participante) throws RuntimeException {
		try {
			dbConn = DriverManager.getConnection(url, username, password);
			st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
			st.setString(1, participante.obtenerNombre());
			st.setString(2, participante.obtenerTelefono());
			st.setString(3, participante.obtenerRegion());
			st.executeUpdate();
			dbConn.close();
			st.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e.getMessage());
		}
	}
}
