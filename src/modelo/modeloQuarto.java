package modelo;

public class modeloQuarto {
	private int tipoId;
	private String nomeModelo;
	private int qtdBanheiro;
	private int qtdCamas;
	private boolean frigobar;
	private boolean servicoQuarto;

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public int getQtdBanheiro() {
		return qtdBanheiro;
	}

	public void setQtdBanheiro(int qtdBanheiro) {
		this.qtdBanheiro = qtdBanheiro;
	}

	public int getQtdCamas() {
		return qtdCamas;
	}

	public void setQtdCamas(int qtdCamas) {
		this.qtdCamas = qtdCamas;
	}

	public boolean isFrigobar() {
		return frigobar;
	}

	public void setFrigobar(boolean frigobar) {
		this.frigobar = frigobar;
	}

	public boolean isServicoQuarto() {
		return servicoQuarto;
	}

	public void setServicoQuarto(boolean servicoQuarto) {
		this.servicoQuarto = servicoQuarto;
	}
}
