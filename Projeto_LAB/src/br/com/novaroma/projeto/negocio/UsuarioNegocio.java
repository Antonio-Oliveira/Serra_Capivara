package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.UsuarioDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class UsuarioNegocio {

	private UsuarioDados usuarioDados = new UsuarioDados();

	public String verificarCadastro(Usuario usuario) throws ClassNotFoundException, IOException {

		if (usuarioDados.consultaUsuarioCPF(usuario.getCpf()) != null) {
			return "Esse CPF j� foi cadastrado";

		} else if (usuarioDados.consultaUsuarioEmail(usuario.getEmail()) != null) {

			return "Esse email j� foi cadastrado";

		} else if (Verificar.verificarCPF(usuario) == false) {

			return "O Usu�rio " + usuario.getNome() + " n�o foi cadastrado, pois seu CPF est� incorreto";

		} else if (usuario.getIdade() <= 8) {

			return "O Usu�rio " + usuario.getNome() + " n�o foi cadastrado pois n�o tem idade o suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " n�o foi cadastrado pois a senha est� incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usuario " + usuario.getNome() + " n�o foi cadastrado pois o email est� incorreto";

		}
		usuarioDados.cadastrar(usuario);
		return "Usu�rio Cadastrado com sucesso!";

	}

	public Usuario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Usuario usuario = usuarioDados.consultaUsuario(email, senha);
		return usuario;
	}

	public String verificarModificacoes(Usuario usuario) throws ClassNotFoundException, IOException {

		if (usuario.getIdade() <= 8) {

			return "O Usu�rio n�o pode ser modificado pois n�o tem idade suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usu�rio n�o pode ser modificado pois a senha esta incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usu�rio n�o pode ser modificado pois o email esta incorreto";

		}
		usuarioDados.modificarDados(usuario);
		return "============== Usu�rio Modificado com sucesso ===============";

	}

	public String verificarRemocao(Usuario usuario) throws ClassNotFoundException, IOException {

		usuarioDados.removarDados(usuario);
		return "----Conta removida com sucesso!-----";

	}

}
