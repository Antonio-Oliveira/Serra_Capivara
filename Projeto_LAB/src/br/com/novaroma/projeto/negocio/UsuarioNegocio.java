package br.com.novaroma.projeto.negocio;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class UsuarioNegocio {

	public String verificacoes(Usuario usuario) {
		if (usuario.getIdade() <= 8) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		}else if(Verificar.verificarCPF(usuario)==false) {
			
			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois seu CPF esta incorreto";
			
		}else if(Verificar.verificarSenha(usuario)==false) {
			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois a senha esta incorreta";
		}else if(Verificar.verificarEmail(usuario)==false) {
			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois o email esta incorreta";
		}
		return "Usuario Cadastrado com sucesso";
	}
}
