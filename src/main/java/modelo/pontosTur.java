package modelo;

import java.sql.Time;

public class pontosTur {
	private int pontoId;
	private Time horaAbre;
	private Time horaFecha;
	private float preco;

	public int getPontoId() {
		return pontoId;
	}

	public void setPontoId(int pontoId) {
		this.pontoId = pontoId;
	}

	public Time getHoraAbre() {
		return horaAbre;
	}

	public void setHoraAbre(Time horaAbre) {
		this.horaAbre = horaAbre;
	}

	public Time getHoraFecha() {
		return horaFecha;
	}

	public void setHoraFecha(Time horaFecha) {
		this.horaFecha = horaFecha;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(int enderecoId) {
		this.enderecoId = enderecoId;
	}

	private int enderecoId;
}
