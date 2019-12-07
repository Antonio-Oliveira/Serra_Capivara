package br.com.novaroma.projeto.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.projeto.dados.ProdutoDados;
import br.com.novaroma.projeto.entidades.Produto;

public class ProdutoNegocio {
	private ProdutoDados produtoDados = new ProdutoDados();

	public ArrayList<Produto> listarProduto() throws ClassNotFoundException, IOException {
		return produtoDados.listarProduto();
	}

	public String cadastrarProduto(Produto produto) throws ClassNotFoundException, IOException {
		produtoDados.cadastrarProduto(produto);
		return "Produto Cadastrado";
	}

	public String removerProduto(long id) throws ClassNotFoundException, IOException {
		return produtoDados.removerProduto(id);
	}

	public Produto buscaProduto(long id) throws ClassNotFoundException, IOException {
		Produto produto = produtoDados.buscarProduto(id);
		return produto;
	}

	public String modificarProduto(Produto produto) throws ClassNotFoundException, IOException {
		produtoDados.modificarProduto(produto);
		return "Produto modificado com sucesso!!!";
	}

}
