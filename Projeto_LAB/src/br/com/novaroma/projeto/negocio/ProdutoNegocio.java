package br.com.novaroma.projeto.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.projeto.dados.Dados;
import br.com.novaroma.projeto.entidades.Produto;

public class ProdutoNegocio {
	private Dados dados = new Dados();
	private Produto obj = new Produto();

	public ArrayList<Produto> listarProduto() throws ClassNotFoundException, IOException {
		return dados.listar(obj);
	}

	public String cadastrarProduto(Produto produto) throws ClassNotFoundException, IOException {
		dados.cadastrar(produto);
		return "Produto Cadastrado";
	}

	public String removerProduto(Produto produto) throws ClassNotFoundException, IOException {
		dados.remover(produto);
		return ("Produto " + produto.toString() + " Removido");

	}

	public Produto buscaProduto(String id) throws ClassNotFoundException, IOException {
		Produto produto = (Produto) dados.consultar(id, obj);
		return produto;
	}

	public String modificarProduto(Produto produto) throws ClassNotFoundException, IOException {
		dados.modificar(produto);
		return "Produto modificado com sucesso!!!";
	}

	

}
