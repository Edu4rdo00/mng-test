package br.com.manager.teste.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioAutenticado implements Serializable {

	private static final long serialVersionUID = 5804285479239397777L;
	
	private String token;
	private String login;
	@ApiModelProperty(hidden=true)
	private Timestamp expiracao;
	private boolean administrador;
	private boolean autenticado;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Timestamp getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(Timestamp expiracao) {
		this.expiracao = expiracao;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

}
