package br.com.novaroma.projeto.negocio;

import br.com.novaroma.projeto.entidades.Usuario;

public class UsuarioNegocio {

	public String verificarIdade(Usuario usuario) {
		if (usuario.getIdade() <= 8) {

			return "O Usuario " + usuario.getNome() + " n�o foi cadastrado pois n�o tem idade o suficiente";

		}
		return null;
	}
}
