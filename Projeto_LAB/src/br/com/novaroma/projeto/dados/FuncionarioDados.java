package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.entidades.Usuario;

public class FuncionarioDados {

	public void cadastrar(Funcionario funcs) throws IOException, ClassNotFoundException {

		ArrayList<Funcionario> colecaoFuncs;
		File arquivo = new File("arquivos/Funcionario.txt");

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();

		} else {

			arquivo.createNewFile();
			colecaoFuncs = new ArrayList<Funcionario>();

		}

		colecaoFuncs.add(funcs);
		FileOutputStream fos = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecaoFuncs);
		oos.flush();
		oos.close();
	}

	public void removerDados(String cpf) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Funcionario.txt");
		ArrayList<Funcionario> colecaoFuncs;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoFuncs.size(); i++) {

				if (cpf.equals(colecaoFuncs.get(i).getCpf())) {
					colecaoFuncs.remove(i);
				}

			}

			if (colecaoFuncs.size() == 0) {
				arquivo.delete();
			}

			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoFuncs);
			oos.flush();
			oos.close();

		}
	}

	public void modificarDados(Funcionario funcs) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Funcionario.txt");
		ArrayList<Funcionario> colecaoFuncs;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoFuncs.size(); i++) {

				if (funcs.getCpf().equals(colecaoFuncs.get(i).getCpf())) {
					colecaoFuncs.set(i, funcs);
				}

			}

			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoFuncs);
			oos.flush();
			oos.close();

		}
	}

	public boolean consultaFuncionarioCPF(String cpf) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Funcionario.txt");
		ArrayList<Funcionario> colecaoFuncs;

		if (arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoFuncs.size(); i++) {
				if (colecaoFuncs.get(i).getCpf().equals(cpf)) {
					return true;
				}
			}

		}
		return false;
	}

	public boolean consultaFuncionarioEmail(String email) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Funcionario.txt");
		ArrayList<Funcionario> colecaoFuncs;

		if (arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoFuncs.size(); i++) {
				if (colecaoFuncs.get(i).getEmail().equalsIgnoreCase(email)) {
					return true;
				}
			}
		}
		return false;
	}

	public Funcionario consultaFuncionario(String email, String senha) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Funcionario.txt");
		ArrayList<Funcionario> colecaoFuncs;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoFuncs.size(); i++) {
				if (colecaoFuncs.get(i).getEmail().equalsIgnoreCase(email)
						&& colecaoFuncs.get(i).getSenha().equals(senha)) {

					return colecaoFuncs.get(i);
				}
			}
		}
		return null;
	}
	public ArrayList<Funcionario> listarFuncionarios() throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Funcionario.txt");
		ArrayList<Funcionario> colecaoFuncs;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoFuncs = (ArrayList<Funcionario>) ois.readObject();
			ois.close();
			return colecaoFuncs;
			
		}
		return null;
	}

}
