package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.entidades.Produto;

public class Dados<T> {
	private ArrayList<T> colecao;
	private T objeto;
	private File arquivo;

	public void criarArquivo(T obj) throws IOException, ClassNotFoundException {

		if (obj instanceof Cliente) {
			arquivo = new File("arquivos/Cliente.txt");
		}
		if (obj instanceof Funcionario) {
			arquivo = new File("arquivos/Funcionario.txt");
		}
		if (obj instanceof Produto) {
			arquivo = new File("arquivos/Produto.txt");
		}

	}

	public void ler() {

		if (arquivo.exists()) {
			try {
				System.out.println(arquivo);
				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(fis);
				this.colecao = (ArrayList<T>) ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			try {
				arquivo.createNewFile();
				colecao = new ArrayList<T>();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public boolean cadastrar(T obj) throws ClassNotFoundException, IOException {
		criarArquivo(obj);

		ler();

		colecao.add(obj);

		FileOutputStream fos = new FileOutputStream(arquivo);

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(colecao);

		oos.close();

		return true;
	}

	@SuppressWarnings("unchecked")
	public T consultarLogin(String email, String senha, T tipo) throws ClassNotFoundException, IOException {
		criarArquivo(tipo);
		ler();
		if (arquivo.exists()) {

			if (tipo instanceof Cliente) {
				for (int i = 0; i < colecao.size(); i++) {
					ArrayList<Cliente> cliente = (ArrayList<Cliente>) colecao;
					if (email.equals(cliente.get(i).getEmail()) && senha.equals(cliente.get(i).getSenha())) {
						return (T) cliente.get(i);
					}

				}
			}

			if (tipo instanceof Funcionario) {
				ArrayList<Funcionario> funcionario = (ArrayList<Funcionario>) colecao;
				if (funcionario.size() == 0) {
					((Funcionario) tipo).Adm();
					funcionario.add((Funcionario) tipo);
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
					oos.writeObject(colecao);
					oos.close();
				}
				for (int i = 0; i < colecao.size(); i++) {
					if (email.equals(funcionario.get(i).getEmail()) && senha.equals(funcionario.get(i).getSenha())) {
						return (T) funcionario.get(i);
					}

				}
			}
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	public T consultar(String consulta, T tipo) throws ClassNotFoundException, IOException {
		criarArquivo(tipo);
		if (arquivo.exists()) {
			ler();

			for (int i = 0; i < colecao.size(); i++) {
				if (tipo instanceof Produto) {
					ArrayList<Produto> produto = (ArrayList<Produto>) colecao;
					if (consulta.equals(produto.get(i).getId())) {
						return (T) produto.get(i);
					}

				}

				if (tipo instanceof Funcionario) {
					ArrayList<Funcionario> funcionario = (ArrayList<Funcionario>) colecao;
					if (consulta.equals(funcionario.get(i).getCpf())) {
						return (T) funcionario.get(i);
					}

				}
			}
		}

		return null;
	}

	public ArrayList<T> listar(T obj) throws ClassNotFoundException, IOException {
		criarArquivo(obj);
		if (arquivo.exists()) {
			ler();
			return colecao;
		}
		return null;
	}

	public void remover(T obj) throws ClassNotFoundException, IOException {
		criarArquivo(obj);
		if (arquivo.exists()) {

			ler();

			if (obj instanceof Cliente) {
				ArrayList<Cliente> cliente = (ArrayList<Cliente>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (((Cliente) obj).getCpf().equals(cliente.get(i).getCpf())) {
						cliente.remove(i);
						colecao = (ArrayList<T>) cliente;
					}

				}

			}

			if (obj instanceof Funcionario) {
				ArrayList<Funcionario> funcionario = (ArrayList<Funcionario>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (((Funcionario) obj).getCpf().equals(funcionario.get(i).getCpf())) {
						funcionario.remove(i);
						colecao = (ArrayList<T>) funcionario;

					}

				}

			}

			if (obj instanceof Produto) {
				ArrayList<Produto> produto = (ArrayList<Produto>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (((Produto) obj).getId().equals(produto.get(i).getId())) {
						produto.remove(i);
						colecao = (ArrayList<T>) produto;
					}

				}

			}

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
			oos.writeObject(colecao);
			oos.flush();
			oos.close();
		}
	}

	@SuppressWarnings("unchecked")
	public void modificar(T obj) throws ClassNotFoundException, IOException {
		criarArquivo(obj);
		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecao = (ArrayList<T>) ois.readObject();
			ois.close();

			if (obj instanceof Cliente) {
				ArrayList<Cliente> cliente = (ArrayList<Cliente>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (((Cliente) obj).getCpf().equals(cliente.get(i).getCpf())) {
						cliente.set(i, (Cliente) obj);
						colecao = (ArrayList<T>) cliente;
					}

				}

			}

			if (obj instanceof Produto) {
				ArrayList<Produto> produto = (ArrayList<Produto>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (((Produto) obj).getId().equals(produto.get(i).getId())) {
						produto.set(i, (Produto) obj);
						colecao = (ArrayList<T>) produto;
					}

				}

			}

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
			oos.writeObject(colecao);
			oos.flush();
			oos.close();
		}

	}

	public boolean consultaCPF(String cpf, T obj) throws IOException, ClassNotFoundException {
		criarArquivo(obj);

		if (arquivo.exists()) {
			ler();

			if (obj instanceof Cliente) {
				ArrayList<Cliente> cliente = (ArrayList<Cliente>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (cpf.equals(cliente.get(i).getCpf())) {
						return true;
					}

				}

			}

			if (obj instanceof Funcionario) {
				ArrayList<Funcionario> funcionario = (ArrayList<Funcionario>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (cpf.equals(funcionario.get(i).getCpf())) {
						return true;

					}

				}

			}
		}
		return false;
	}

	public boolean consultaEmail(String email, T obj) throws IOException, ClassNotFoundException {
		criarArquivo(obj);

		if (arquivo.exists()) {
			ler();

			if (obj instanceof Cliente) {
				ArrayList<Cliente> cliente = (ArrayList<Cliente>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (email.equals(cliente.get(i).getEmail())) {
						return true;
					}

				}

			}

			if (obj instanceof Funcionario) {
				ArrayList<Funcionario> funcionario = (ArrayList<Funcionario>) colecao;

				for (int i = 0; i < colecao.size(); i++) {

					if (email.equals(funcionario.get(i).getEmail())) {
						return true;

					}

				}

			}
		}
		return false;
	}

}
