package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.novaroma.projeto.entidades.Usuario;

public class ConsultaUsuario {

	public Usuario consultaUsuario(String email, String senha) throws IOException, ClassNotFoundException {
		File arquivo = new File("arquivos/alunos.txt");
		FileInputStream fis = new FileInputStream(arquivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Usuario[] usuarioCadastrado = (Usuario[]) ois.readObject();
		ois.close();

		if (arquivo.exists()) {
			for (int i = 0; i < usuarioCadastrado.length; i++) {
				if (usuarioCadastrado[i].getEmail().equalsIgnoreCase(email)) {
					if (usuarioCadastrado[i].getSenha().equals(senha)) {
						return usuarioCadastrado[i];
					}
				}
			}

		}

		return null;
	}

}
