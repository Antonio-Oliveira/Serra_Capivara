package br.com.novaroma.projeto.entidades;

public class Produto {
	private String tipo;
	private String tema;
	private String cor;
	private double preco;
	private String codigo;
	private int quant;

	Produto() {

	}

	Produto(String tipo,String tema,String cor,double preco,String codigo,int quant) {
		this.tipo = tipo;
		this.tema = tema;
		this.cor = cor;
		this.preco = preco;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

}
