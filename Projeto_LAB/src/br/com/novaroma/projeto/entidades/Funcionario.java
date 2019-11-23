package br.com.novaroma.projeto.entidades;

public class Funcionario extends Usuario {
	private String key;
	
	public Funcionario(String nome, int idade, long numTell, String email, String cpf, String senha, String sexo,
			String kay) {
		super(nome, idade, numTell, email, cpf, senha, sexo);
		this.key = key;
	}

	public String getKay() {
		return key;
	}

	public void setKay(String key) {
		this.key = key;
	}

	

}
