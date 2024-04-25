package modelo;

import java.sql.Date;

public class Reserva {
	private int idHospedagem;
	private String formaPag;
	private Date dataIn;
	private Date dataOut;

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

	public Date getDataIn() {
		return dataIn;
	}

	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}

	public Date getDataOut() {
		return dataOut;
	}

	public void setDataOut(Date dataOut) {
		this.dataOut = dataOut;
	}

}
