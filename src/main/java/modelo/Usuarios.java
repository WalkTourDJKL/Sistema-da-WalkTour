package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Usuarios {
	private int idUsuario;
	private String nome;
	private String nomeSocial;
	private String login;
	private String senha;
	private String cpf;
	private LocalDate dtNasc;
	private int tipoUser;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	


	public String getNomeRegistro() {	
		return nome;
	}

	
	public String getNome() {
		if (getNomeSocial() != null) {
		return nomeSocial;	
	}
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

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dataNascimento) {
		this.dtNasc = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}
}
