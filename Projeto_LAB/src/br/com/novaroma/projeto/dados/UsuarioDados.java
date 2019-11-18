package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.com.novaroma.projeto.entidades.Usuario;

public class UsuarioDados implements Serializable {

	public void cadastrar(Usuario usuario) throws IOException, ClassNotFoundException {

		ArrayList<Usuario> colecaoUsuario;
		File arquivos = new File("arquivos/Usuario.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoUsuario = (ArrayList<Usuario>) ois.readObject();
			ois.close();

		} else {

			arquivos.createNewFile();
			colecaoUsuario = new ArrayList<Usuario>();

		}

		colecaoUsuario.add(usuario);
		FileOutputStream fos = new FileOutputStream(arquivos);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecaoUsuario);
		oos.flush();
		oos.close();
	}

	public void removarDados(Usuario usuario) throws IOException, ClassNotFoundException {
		File arquivos = new File("arquivos/Usuario.txt");
		ArrayList<Usuario> colecaoUsuario;

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoUsuario = (ArrayList<Usuario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoUsuario.size(); i++) {

				if (usuario.getCpf().equals(colecaoUsuario.get(i).getCpf())) {
					colecaoUsuario.remove(i);
				}

			}

			FileOutputStream fos = new FileOutputStream(arquivos);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoUsuario);
			oos.flush();
			oos.close();

		}
	}

	public void modificarDados(Usuario usuario) throws IOException, ClassNotFoundException {
		File arquivos = new File("arquivos/Usuario.txt");
		ArrayList<Usuario> colecaoUsuario;

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoUsuario = (ArrayList<Usuario>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoUsuario.size(); i++) {

				if (usuario.getCpf().equals(colecaoUsuario.get(i).getCpf())) {
					colecaoUsuario.remove(i);
				}

			}

			FileOutputStream fos = new FileOutputStream(arquivos);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoUsuario);
			oos.flush();
			oos.close();

		}
	}

	public Usuario consultaUsuarioCPF(String cpf) throws IOException, ClassNotFoundException {
		File arquivos = new File("arquivos/Usuario.txt");
		ArrayList<Usuario> colecaoUsuario;

		if (arquivos.exists()) {
			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();
			colecaoUsuario = (ArrayList<Usuario>) ois.readObject();

			for (int i = 0; i < colecaoUsuario.size(); i++) {
				if (colecaoUsuario.get(i).getCpf().equals(cpf)) {
					return colecaoUsuario.get(i);
				}
			}

		}
		return null;
	}

	public Usuario consultaUsuarioEmail(String email) throws IOException, ClassNotFoundException {
		File arquivos = new File("arquivos/Usuario.txt");
		ArrayList<Usuario> colecaoUsuario;

		if (arquivos.exists()) {
			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();
			colecaoUsuario = (ArrayList<Usuario>) ois.readObject();

			for (int i = 0; i < colecaoUsuario.size(); i++) {
				if (colecaoUsuario.get(i).getEmail().equalsIgnoreCase(email)) {
					colecaoUsuario.get(i);
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Usuario consultaUsuario(String email, String senha) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Usuario.txt");
		ArrayList<Usuario> colecaoUsuario;

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();
			colecaoUsuario = (ArrayList<Usuario>) ois.readObject();

			for (int i = 0; i < colecaoUsuario.size(); i++) {
				if (colecaoUsuario.get(i).getEmail().equalsIgnoreCase(email)
						&& colecaoUsuario.get(i).getSenha().equals(senha)) {

					return colecaoUsuario.get(i);
				}
			}
		}
		return null;
	}

}
