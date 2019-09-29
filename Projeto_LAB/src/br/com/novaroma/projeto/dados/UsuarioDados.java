package br.com.novaroma.projeto.dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.novaroma.projeto.entidades.Usuario;


public class UsuarioDados {
	public void cadastrar(Usuario usuario) throws IOException, ClassNotFoundException {
		File arquivo = new File("arqivos/alunos.txt");
		Usuario[] colecaoUsuario;
		 if(arquivo.exists()) {
			 FileInputStream fis = new FileInputStream(arquivo);
			 ObjectInputStream ois = new ObjectInputStream (fis);
			 colecaoUsuario = (Usuario[]) ois.readObject();
			 ois.close();
			 
			 }else {
				 arquivo.createNewFile();
				 colecaoUsuario = new Usuario[1];
				 
			 }
		 colecaoUsuario[colecaoUsuario.length-1] = usuario;
		 Usuario[] usuarioNovoArray = new Usuario[colecaoUsuario.length +1];
		 
		 System.arraycopy(colecaoUsuario, 0, usuarioNovoArray, 0, colecaoUsuario.length);
		 colecaoUsuario = usuarioNovoArray;
		 
		 for(int i=0; i<colecaoUsuario.length-1; i++) {
			 System.out.println(colecaoUsuario[i]);
		 }
		 FileOutputStream fos = new FileOutputStream(arquivo);
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 oos.writeObject(colecaoUsuario);
		 oos.close();
	}
	public Usuario consultaUsuario(String cpf) {
		return null;
	}
	
	
	

}
