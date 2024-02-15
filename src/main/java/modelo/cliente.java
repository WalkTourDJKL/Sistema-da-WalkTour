package modelo;

import java.sql.Date;

public class cliente {
    private int idHospede;
    private String nome;
    private String senha;
    private String nomeSocial;
    private Date dtNasc;
	private String cpf;

	public int getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
