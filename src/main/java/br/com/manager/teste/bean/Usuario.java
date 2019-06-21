package br.com.manager.teste.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "usuario")
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pais_sequence")
	@SequenceGenerator(name = "pais_sequence", sequenceName = "SEQ_PAIS")
	private int id;
	@Column(name = "login", nullable = false, unique=true)
	private String login;
	@Column(name = "senha", nullable = false)
	private String senha;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "administrador", nullable = false)
	private boolean administrador;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
