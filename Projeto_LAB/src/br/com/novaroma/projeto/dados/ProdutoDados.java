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

	public ArrayList<Produto> listarProduto() throws IOException, ClassNotFoundException {

		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produto.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();
			return colecaoProduto;

		}
		return null;

	}

	public void cadastrarProduto(Produto produto) throws IOException, ClassNotFoundException {

		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produto.txt");

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

	public Produto buscarProduto(long id) throws IOException, ClassNotFoundException {

		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produto.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoProduto.size(); i++) {

				if (id == colecaoProduto.get(i).getId()) {
					return colecaoProduto.get(i);

				}

			}

		}
		return null;

	}

	public void modificarProduto(Produto produto) throws IOException, ClassNotFoundException {

		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produto.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoProduto.size(); i++) {

				if (produto.getId() == colecaoProduto.get(i).getId()) {
					colecaoProduto.set(i, produto);

				}
				FileOutputStream fos = new FileOutputStream(arquivos);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(colecaoProduto);
				oos.flush();
				oos.close();
			}
		}

	}

	public String removerProduto(long id) throws IOException, ClassNotFoundException {

		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produto.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoProduto.size(); i++) {

				if (id == colecaoProduto.get(i).getId()) {
					colecaoProduto.remove(i);

				}
				FileOutputStream fos = new FileOutputStream(arquivos);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(colecaoProduto);
				oos.flush();
				oos.close();
				return "Produto removido";
			}
			return "Id de produto não encontrado";
		}
		return "Ainda não existe catalogo de produtos";

	}

	public void exibirProduto(Produto produto) throws IOException, ClassNotFoundException {

		ArrayList<Produto> colecaoProduto;
		File arquivos = new File("arquivos/Produto.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProduto = (ArrayList<Produto>) ois.readObject();
			ois.close();
			System.out.println(
					"______________________________________________________________________________________________________________");
			System.out.printf("| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", "Código", "Tema", "Cor", "Tipo",
					"Qtd.", "Preço");
			System.out.println();
			System.out.println(
					"|____________|__________________________________________|_________________|____________|_______|_____________|");
			for (int i = 0, c = 1; i < colecaoProduto.size(); i++, c++) {
				System.out.printf("| %-10s | %-40s | %-15s | %-10s | %5d | R$ %-8.2f |", colecaoProduto.get(i).getId(),
						colecaoProduto.get(i).getTema(), colecaoProduto.get(i).getCor(),
						colecaoProduto.get(i).getTipo(), colecaoProduto.get(i).getQuant(),
						colecaoProduto.get(i).getPreco());
				System.out.println();

				if (c != colecaoProduto.size()) {
					System.out.println(
							"|------------|------------------------------------------|-----------------|------------|-------|-------------|");

				}

			}
			System.out.print(
					"|____________________________________________________________________________________________________________|");
		}

	}

}