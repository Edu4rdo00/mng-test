package br.com.manager.teste.bean;

public class Pais extends EntityBean {

	private static final long serialVersionUID = -371715111275889023L;
	
	private String nome;
	private String sigla;
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

}
