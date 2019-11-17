package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.UsuarioDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class UsuarioNegocio {

	private UsuarioDados usuarioDados = new UsuarioDados();

	public String verificarCadastro(Usuario usuario) throws ClassNotFoundException, IOException {

		if (usuarioDados.consultaUsuarioCPF(usuario.getCpf()) != null) {
			return "Esse CPF já foi cadastrado";

		} else if (usuarioDados.consultaUsuarioEmail(usuario.getEmail()) != null) {

			return "Esse email já foi cadastrado";

		} else if (Verificar.verificarCPF(usuario) == false) {

			return "O Usuário " + usuario.getNome() + " não foi cadastrado, pois seu CPF está incorreto";

		} else if (usuario.getIdade() <= 8) {

			return "O Usuário " + usuario.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois a senha está incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " não foi cadastrado pois o email está incorreto";

		}
		usuarioDados.cadastrar(usuario);
		return "Usuário Cadastrado com sucesso!";

	}

	public Usuario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Usuario usuario = usuarioDados.consultaUsuario(email, senha);
		return usuario;
	}

	public String verificarModificacoes(Usuario usuario) throws ClassNotFoundException, IOException {

		if (usuario.getIdade() <= 8) {

			return "O Usuário não pode ser modificado pois não tem idade suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usuário não pode ser modificado pois a senha esta incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usuário não pode ser modificado pois o email esta incorreto";

		}
		usuarioDados.modificarDados(usuario);
		return "============== Usuário Modificado com sucesso ===============";

	}

	public String verificarRemocao(Usuario usuario) throws ClassNotFoundException, IOException {

		usuarioDados.removarDados(usuario);
		return "----Conta removida com sucesso!-----";

	}

}
