package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.ClienteDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class ClienteNegocio {

	private ClienteDados clienteDados = new ClienteDados();

	public String verificarCadastro(Usuario usuario) throws ClassNotFoundException, IOException {

		if (clienteDados.consultaUsuarioCPF(usuario.getCpf()) != null) {
			return "Esse CPF já foi cadastrado";

		} else if (clienteDados.consultaUsuarioEmail(usuario.getEmail()) != null) {

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

		clienteDados.cadastrar(usuario);
		return "Usuário Cadastrado com sucesso!";

	}

	public Usuario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Usuario usuario = clienteDados.consultaUsuario(email, senha);
		return usuario;
	}

	public String verificarModificacoes(Usuario usuarioNovo, Usuario usuarioAntigo)
			throws ClassNotFoundException, IOException {

		if (clienteDados.consultaUsuarioEmail(usuarioNovo.getEmail()) != null && !usuarioNovo.equals(usuarioAntigo)) {

			return "Email já está sendo utilizado";

		} else if (Verificar.VerificarEmail(usuarioNovo) == false) {

			return "O Usuário não pode ser modificado pois o email esta incorreto ou ja foi cadastrado";

		} else if (usuarioNovo.getIdade() < usuarioAntigo.getIdade()) {

			return "O Usuário não pode ser modificado pois a modificação estar abaixo da informada anteriormente";

		} else if (Verificar.verificarSenha(usuarioNovo) == false) {

			return "O Usuário não pode ser modificado pois a senha não esta nos padrões aceitos";

		}
		clienteDados.modificarDados(usuarioNovo);
		return "---- Usuário Modificado com sucesso!!! -----";

	}

	public String verificarRemocao(Usuario usuario) throws ClassNotFoundException, IOException {

		clienteDados.removarDados(usuario);
		return "---- Conta removida com sucesso!!! -----";

	}

}
