package br.com.novaroma.projeto.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.projeto.dados.ProdutoDados;
import br.com.novaroma.projeto.entidades.Produto;

public class ProdutoNegocio {
	private ProdutoDados produtoDados = new ProdutoDados();

	public ArrayList<Produto> listarProduto() throws ClassNotFoundException, IOException {
		ArrayList<Produto> colecaoProduto = produtoDados.listarProduto();
		return colecaoProduto;
	}

	public String cadastrarProduto(Produto produto) throws ClassNotFoundException, IOException {
		produtoDados.cadastrarProduto(produto);
		return "Produto Cadastrado";
	}

	public String removerProduto(long codigo) throws ClassNotFoundException, IOException {
		produtoDados.removerProduto(codigo);
		return "Produto Removido";
	}

	public Produto modificarProduto(long id) throws ClassNotFoundException, IOException {
		Produto produto = produtoDados.modificarProduto(id);
		return produto;
	}

}
