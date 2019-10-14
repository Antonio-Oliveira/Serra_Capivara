package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.ConsultaDados;
import br.com.novaroma.projeto.entidades.Usuario;

public class LoginNegocio {

	private ConsultaDados login = new ConsultaDados();

	public Usuario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Usuario usuario = login.consultaUsuario(email, senha);
		return usuario;
	}

}
