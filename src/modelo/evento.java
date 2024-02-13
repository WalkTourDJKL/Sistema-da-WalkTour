package modelo;

import java.sql.Time;
import java.sql.Date;

public class evento {
    private int idEvento;
    private Date diaInicio;
    private Date diaFim;
    private Time horaInicio;
    private Time horaFim;
    private String nomeEvento;
    private float preco;
	private endereco endereco;

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public Date getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(Date diaInicio) {
		this.diaInicio = diaInicio;
	}

	public Date getDiaFim() {
		return diaFim;
	}

	public void setDiaFim(Date diaFim) {
		this.diaFim = diaFim;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(endereco endereco) {
		this.endereco = endereco;
	}
}
