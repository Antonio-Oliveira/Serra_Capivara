package br.com.novaroma.projeto.entidades;

import java.io.Serializable;

public class Produto implements Serializable {
	private String tipo;
	private String tema;
	private String cor;
	private double preco;
	private String id;
	private int quant;

	@Override
	public String toString() {
		return "Produto [tipo=" + tipo + ", tema=" + tema + ", cor=" + cor + ", preço=" + preco + ", id=" + id
				+ ", quantidade em estoque=" + quant + "]";
		
		//return "| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", id, tema, cor, tipo, quant, preco
	}

	public Produto() {

	}

	public Produto(String tipo, String tema, String cor, double preco, String id, int quant) {

		this.tipo = tipo;
		this.tema = tema;
		this.cor = cor;
		this.preco = preco;
		this.id = id;
		this.quant = quant;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getId() {
		return id;
	}

	public void setCodigo(String id) {
		this.id = id;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

}
