package br.com.novaroma.projeto.entidades;

public class Compras {
	private Catalogo[] carrinho = new Catalogo[5];
	
	public void CarrinhoDeCompras(Catalogo produto) {
		for(int i=0;i<carrinho.length;i++) {
			carrinho[i] = produto;
		}
	}

	public Catalogo[] getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Catalogo[] carrinho) {
		this.carrinho = carrinho;
	}
	
	

}
