package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.UsuarioDados;
import br.com.novaroma.projeto.entidades.Usuario;

public class RemoverUsuarioNegocio {

	private UsuarioDados remover = new UsuarioDados();

	public String remover(Usuario usuario) throws ClassNotFoundException, IOException {

		remover.removarDados(usuario);
		return "----Conta removida com sucesso!-----";

	}

}
