package br.com.novaroma.projeto.entidades;

import java.util.ArrayList;

public class Cliente extends Usuario {
	ArrayList<Produto> historicoCompras;

	public Cliente(String nome, int idade, long numTell, String email, String cpf, String senha, String sexo) {
		super(nome, idade, numTell, email, cpf, senha, sexo);
	}

	public ArrayList<Produto> getHistoricoCompras() {
		return historicoCompras;
	}

	public void setHistoricoCompras(ArrayList<Produto> historicoCompras) {
		this.historicoCompras = historicoCompras;
	}

}
