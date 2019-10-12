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

}
