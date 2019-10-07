package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.UsuarioDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class UsuarioNegocio {

	private UsuarioDados usuarioDados = new UsuarioDados();

	public String verificacoes(Usuario usuario) throws ClassNotFoundException, IOException {

		if (this.usuarioDados.consultaUsuarioCPF(usuario.getCpf()) != null) {
			return "CPF do usuario já foi cadastrado";

		}
		if (this.usuarioDados.consultaUsuarioEmail(usuario.getEmail()) != null) {
			return "Esse email já foi cadastrado";
		}

		if (Verificar.verificarCPF(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois seu CPF esta incorreto";

		} else if (usuario.getIdade() <= 8) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois a senha esta incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois o email esta incorreta";

		}
		usuarioDados.cadastrar(usuario);
		return "Usuario Cadastrado com sucesso";

	}

}
