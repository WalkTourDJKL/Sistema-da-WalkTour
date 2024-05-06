package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {
	private int idHospedagem;
	private String formaPag;
	private LocalDate dataIn;
	private LocalDate dataOut;
	private int preco;

	public int getIdHospedagem() {
		return idHospedagem;
	}

	public void setIdHospedagem(int idHospedagem) {
		this.idHospedagem = idHospedagem;
	}

	public String getFormaPag() {
		return formaPag;
	}

	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}

	public LocalDate getDataIn() {
		return dataIn;
	}

	public void setDataIn(LocalDate dataIn) {
		this.dataIn = dataIn;
	}

	public LocalDate getDataOut() {
		return dataOut;
	}

	public void setDataOut(LocalDate dataOut) {
		this.dataOut = dataOut;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

}
