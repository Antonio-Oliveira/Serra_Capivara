package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.com.novaroma.projeto.entidades.Produto;

public class ProdutoDados implements Serializable {

	public void removerProduto(Produto produto) throws IOException, ClassNotFoundException {
		
		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produtos.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoProduto.size(); i++) {
				
				if (produto.getCodigo().equals(colecaoProduto.get(i).getCodigo())) {
					colecaoProduto.remove(i);
					
				}
				FileOutputStream fos = new FileOutputStream(arquivos);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(colecaoProduto);
				oos.flush();
				oos.close();
			}
		}

	}

	public void cadastrarProduto(Produto produto) throws IOException, ClassNotFoundException {
		
		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produtos.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();
			
		} else {

			arquivos.createNewFile();
			colecaoProduto = new ArrayList<Produto>();

		}
		colecaoProduto.add(produto);
		FileOutputStream fos = new FileOutputStream(arquivos);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecaoProduto);
		oos.flush();
		oos.close();

	}
	

}
