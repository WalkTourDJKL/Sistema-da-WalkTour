package modelo;

public class DetalhesHospedagem {
	private int idDetalheHospedagem;
	private int idHospedagem;
	private int idUsuario;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDetalheHospedagem() {
		return idDetalheHospedagem;
	}

	public void setIdDetalheHospedagem(int idDetalheHospedagem) {
		this.idDetalheHospedagem = idDetalheHospedagem;
	}

	public int getIdHospedagem() {
		return idHospedagem;
	}

	public void setIdHospedagem(int idHospedagem) {
		this.idHospedagem = idHospedagem;
	}

}
