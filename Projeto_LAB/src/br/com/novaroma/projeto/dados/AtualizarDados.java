package br.com.novaroma.projeto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.novaroma.projeto.entidades.Usuario;

public class AtualizarDados {

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

}
