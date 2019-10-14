package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.novaroma.projeto.entidades.Usuario;

public class ConsultaDados {

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
