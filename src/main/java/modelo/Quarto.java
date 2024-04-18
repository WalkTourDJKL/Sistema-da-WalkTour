package modelo;

import java.sql.Time;

public class Quarto {
	private int numQuarto;
	private Time horaLimpeza;
	private boolean servicoQuarto;
	private int tipoId;
	private ModeloQuarto modeloQuarto;

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Time getHoraLimpeza() {
		return horaLimpeza;
	}

	public void setHoraLimpeza(Time horaLimpeza) {
		this.horaLimpeza = horaLimpeza;
	}

	public boolean isServicoQuarto() {
		return servicoQuarto;
	}

	public void setServicoQuarto(boolean servicoQuarto) {
		this.servicoQuarto = servicoQuarto;
	}

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}

	public ModeloQuarto getModeloQuarto() {
		return modeloQuarto;
	}

	public void setModeloQuarto(ModeloQuarto modeloQuarto) {
		this.modeloQuarto = modeloQuarto;
	}
}
