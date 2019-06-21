package br.com.manager.teste.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "pais")
@Entity
public class Pais {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pais_sequence")
    @SequenceGenerator(name = "pais_sequence", sequenceName = "SEQ_PAIS")
    private int id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "sigla", nullable = false)
	private String sigla;
	@Column(name = "gentilico", nullable = false)
	private String gentilico;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getGentilico() {
		return gentilico;
	}
	public void setGentilico(String gentilico) {
		this.gentilico = gentilico;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
