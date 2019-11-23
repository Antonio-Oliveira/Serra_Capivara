package br.com.novaroma.projeto.entidades;

public class Empregado extends Usuario {
	private String kay;
	
	public Empregado(String nome, int idade, long numTell, String email, String cpf, String senha, String sexo,
			String kay) {
		super(nome, idade, numTell, email, cpf, senha, sexo);
		this.kay = kay;
	}

	public String getKay() {
		return kay;
	}

	public void setKay(String kay) {
		this.kay = kay;
	}

	

}
