package ar.unrn.model;

import javax.swing.*;

public class Telefono {
	private String numero;

	public Telefono(String numero) throws RuntimeException {
		this.numero = numero;
		verificarNumero(numero);
	}

	public String obtenerNumero(){
		return numero;
	}

	private void verificarNumero(String numero) throws RuntimeException{
		if (numero.equals("")) {
			throw new RuntimeException("Debe cargar un telefono");
		}
		else if(numero.matches("\\d{4}-\\d{6}")){
			throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}
	}
}
