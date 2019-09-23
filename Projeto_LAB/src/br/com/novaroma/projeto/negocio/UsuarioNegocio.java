package br.com.novaroma.projeto.negocio;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class UsuarioNegocio {

	public String verificacoes(Usuario usuario) {
		if (usuario.getIdade() <= 8) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		}else if(Verificar.verificarCPF(usuario)==false) {
			
			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois seu CPF esta incorreto";
			
		}
		return "Usuario Cadastrado com sucesso";
	}
}
