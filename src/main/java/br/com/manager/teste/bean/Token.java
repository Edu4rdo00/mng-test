package br.com.manager.teste.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "token")
@Entity
public class Token {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pais_sequence")
	@SequenceGenerator(name = "pais_sequence", sequenceName = "SEQ_PAIS")
	private int id;
	@Column(name = "token", nullable = false)
	private String token;
	@Column(name = "expiracao", nullable = false)
	private Timestamp expiracao;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;


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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
