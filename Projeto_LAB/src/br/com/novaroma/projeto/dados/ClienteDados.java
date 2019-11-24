package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Usuario;

public class ClienteDados implements Serializable {

	public void cadastrar(Cliente cliente) throws IOException, ClassNotFoundException {

		ArrayList<Cliente> colecaoCliente;
		File arquivo = new File("arquivos/Cliente.txt");

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoCliente = (ArrayList<Cliente>) ois.readObject();
			ois.close();

		} else {

			arquivo.createNewFile();
			colecaoCliente = new ArrayList<Cliente>();

		}

		colecaoCliente.add(cliente);
		FileOutputStream fos = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecaoCliente);
		oos.flush();
		oos.close();
	}

	public void removarDados(Cliente cliente) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Cliente.txt");
		ArrayList<Cliente> colecaoCliente;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoCliente = (ArrayList<Cliente>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoCliente.size(); i++) {

				if (cliente.getCpf().equals(colecaoCliente.get(i).getCpf())) {
					colecaoCliente.remove(i);
				}

			}

			if (colecaoCliente.size() == 0) {
				arquivo.delete();
			}
			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoCliente);
			oos.flush();
			oos.close();

		}
	}

	public void modificarDados(Cliente cliente) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Cliente.txt");
		ArrayList<Cliente> colecaoCliente;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoCliente = (ArrayList<Cliente>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoCliente.size(); i++) {

				if (cliente.getCpf().equals(colecaoCliente.get(i).getCpf())) {
					colecaoCliente.set(i, cliente);
				}

			}

			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoCliente);
			oos.flush();
			oos.close();

		}
	}

	public boolean consultaClienteCPF(String cpf) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Cliente.txt");
		ArrayList<Cliente> colecaoCliente;

		if (arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoCliente = (ArrayList<Cliente>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoCliente.size(); i++) {
				if (colecaoCliente.get(i).getCpf().equals(cpf)) {
					return true;
				}
			}

		}
		return false;
	}

	public boolean consultaClienteEmail(String email) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Cliente.txt");
		ArrayList<Cliente> colecaoCliente;

		if (arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoCliente = (ArrayList<Cliente>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoCliente.size(); i++) {
				if (colecaoCliente.get(i).getEmail().equalsIgnoreCase(email)) {
					return true;
				}
			}
		}
		return false;
	}

	public Usuario consultaUsuario(String email, String senha) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Cliente.txt");
		ArrayList<Cliente> colecaoCliente;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoCliente = (ArrayList<Cliente>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoCliente.size(); i++) {
				if (colecaoCliente.get(i).getEmail().equalsIgnoreCase(email)
						&& colecaoCliente.get(i).getSenha().equals(senha)) {

					return colecaoCliente.get(i);
				}
			}
		}
		return null;
	}

}
