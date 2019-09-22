package br.com.novaroma.projeto.negocio;

import br.com.novaroma.projeto.entidades.Usuario;

public class UsuarioNegocio {

	public String verificarIdade(Usuario usuario) {
		if (usuario.getIdade() <= 8) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		}
		return null;
	}
}
