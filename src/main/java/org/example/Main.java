package org.example;

import ar.unrn.database.ParticipanteDAOJDBC;
import ar.unrn.model.RegistroApi;
import ar.unrn.ui.RegistroParticipante;

public class Main {
    public static void main(String[] args) {
        var inscripcionApi = new RegistroApi(new ParticipanteDAOJDBC());
        var ventanaInscripcion = new RegistroParticipante(inscripcionApi);
    }
}