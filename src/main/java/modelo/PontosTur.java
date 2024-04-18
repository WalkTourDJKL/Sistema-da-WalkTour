package modelo;

import java.sql.Time;

public class PontosTur {
	private int pontoId;
	private Time horaAbre;
	private Time horaFecha;
	private float preco;
	private String nomePontoTur;

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

	public String getNomePontoTur() {
		return nomePontoTur;
	}

	public void setNomePontoTur(String nomePontoTur) {
		this.nomePontoTur = nomePontoTur;
	}

	private int enderecoId;
}
