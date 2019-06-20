package br.com.manager.teste.bean;

import java.sql.Timestamp;

public class Token extends EntityBean {

	private static final long serialVersionUID = 6735736609312723076L;

	private String token;
	private Usuario usuario;
	private Timestamp expiracao;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Timestamp getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(Timestamp expiracao) {
		this.expiracao = expiracao;
	}
	
	
}
