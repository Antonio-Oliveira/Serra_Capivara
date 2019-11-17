package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.com.novaroma.projeto.entidades.Usuario;

public class UsuarioDados implements Serializable {

	public void cadastrar(Usuario usuario) throws IOException, ClassNotFoundException {

		Usuario[] colecaoUsuario;
		File arquivos = new File("arquivos/Usuario.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoUsuario = (Usuario[]) ois.readObject();
			ois.close();

		} else {

			arquivos.createNewFile();
			colecaoUsuario = new Usuario[1];

		}

		if (colecaoUsuario.length == 0) {

			colecaoUsuario = new Usuario[1];
		}

		colecaoUsuario[colecaoUsuario.length - 1] = new Usuario();
		colecaoUsuario[colecaoUsuario.length - 1] = usuario;

		Usuario[] usuarioNovoArray = new Usuario[colecaoUsuario.length + 1];

		System.arraycopy(colecaoUsuario, 0, usuarioNovoArray, 0, colecaoUsuario.length);
		colecaoUsuario = usuarioNovoArray;
		FileOutputStream fos = new FileOutputStream(arquivos);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecaoUsuario);
		oos.flush();
		oos.close();
	}

	public void removarDados(Usuario usuario) throws IOException, ClassNotFoundException {

		Usuario[] colecaoUsuario;
		File arquivos = new File("arquivos/Usuario.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoUsuario = (Usuario[]) ois.readObject();
			ois.close();
			int aux = 0;

			Usuario[] vetorAux = new Usuario[colecaoUsuario.length - 1];

			for (int i = 0; i < colecaoUsuario.length; i++) {

				if (colecaoUsuario[i] != null && !(usuario.getCpf().equals(colecaoUsuario[i].getCpf()))) {
					vetorAux[aux] = colecaoUsuario[i];
					aux++;
				}

			}

			colecaoUsuario = vetorAux;
			FileOutputStream fos = new FileOutputStream(arquivos);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoUsuario);
			oos.flush();
			oos.close();

		}
	}

	public void modificarDados(Usuario usuario) throws IOException, ClassNotFoundException {

		Usuario[] colecaoUsuario;
		File arquivos = new File("arquivos/Usuario.txt");

		if (arquivos.exists()) {

			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoUsuario = (Usuario[]) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoUsuario.length; i++) {

				if (colecaoUsuario[i] != null && usuario.getCpf().contentEquals(colecaoUsuario[i].getCpf())) {
					colecaoUsuario[i] = usuario;
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
		if (arquivos.exists()) {
			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Usuario[] usuarioCadastrado = (Usuario[]) ois.readObject();

			for (int i = 0; i < usuarioCadastrado.length - 1; i++) {
				if (usuarioCadastrado[i].getCpf().equals(cpf)) {
					ois.close();
					return usuarioCadastrado[i];
				}
			}

			ois.close();
		}
		return null;
	}

	public Usuario consultaUsuarioEmail(String email) throws IOException, ClassNotFoundException {
		File arquivos = new File("arquivos/Usuario.txt");
		if (arquivos.exists()) {
			FileInputStream fis = new FileInputStream(arquivos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Usuario[] usuarioCadastrado = (Usuario[]) ois.readObject();

			for (int i = 0; i < usuarioCadastrado.length - 1; i++) {
				if (usuarioCadastrado[i].getEmail().equalsIgnoreCase(email)) {
					ois.close();
					return usuarioCadastrado[i];
				}
			}

			ois.close();
		}
		return null;
	}

	public Usuario consultaUsuario(String email, String senha) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/Usuario.txt");
		FileInputStream fis = new FileInputStream(arquivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Usuario[] usuarioCadastrado = (Usuario[]) ois.readObject();

		if (arquivo.exists()) {
			for (int i = 0; i < usuarioCadastrado.length; i++) {
				if (usuarioCadastrado[i] != null) {

					if (usuarioCadastrado[i].getEmail().equalsIgnoreCase(email)
							&& usuarioCadastrado[i].getSenha().equals(senha)) {
						ois.close();
						return usuarioCadastrado[i];

					}
				}
			}

		}
		ois.close();
		return null;
	}

}
