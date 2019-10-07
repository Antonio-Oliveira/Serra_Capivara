package br.com.novaroma.projeto.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static String nome;
	private int idade;
	private int numTell;
	private String email;
	private String cpf;
	private String senha;
	private static String sexo;
	


	public Usuario() {

	}

	public Usuario(String nome, int idade, int numTell, String email, String cpf, String senha, String sexo) {
		this.nome = nome;
		this.idade = idade;
		this.numTell = numTell;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.sexo = sexo;
	}

	public static String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNumTell() {
		return numTell;
	}

	public void setNumTell(int numTell) {
		this.numTell = numTell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public static String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
