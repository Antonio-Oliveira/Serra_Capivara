package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.ClienteDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class ClienteNegocio {

	private ClienteDados clienteDados = new ClienteDados();

	public String verificarCadastro(Usuario usuario) throws ClassNotFoundException, IOException {

		if (clienteDados.consultaUsuarioCPF(usuario.getCpf()) != null) {
			return "Esse CPF j� foi cadastrado";

		} else if (clienteDados.consultaUsuarioEmail(usuario.getEmail()) != null) {

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

		clienteDados.cadastrar(usuario);
		return "Usu�rio Cadastrado com sucesso!";

	}

	public Usuario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Usuario usuario = clienteDados.consultaUsuario(email, senha);
		return usuario;
	}

	public String verificarModificacoes(Usuario usuarioNovo, Usuario usuarioAntigo)
			throws ClassNotFoundException, IOException {

		if (clienteDados.consultaUsuarioEmail(usuarioNovo.getEmail()) != null && !usuarioNovo.equals(usuarioAntigo)) {

			return "Email j� est� sendo utilizado";

		} else if (Verificar.VerificarEmail(usuarioNovo) == false) {

			return "O Usu�rio n�o pode ser modificado pois o email esta incorreto ou ja foi cadastrado";

		} else if (usuarioNovo.getIdade() < usuarioAntigo.getIdade()) {

			return "O Usu�rio n�o pode ser modificado pois a modifica��o estar abaixo da informada anteriormente";

		} else if (Verificar.verificarSenha(usuarioNovo) == false) {

			return "O Usu�rio n�o pode ser modificado pois a senha n�o esta nos padr�es aceitos";

		}
		clienteDados.modificarDados(usuarioNovo);
		return "---- Usu�rio Modificado com sucesso!!! -----";

	}

	public String verificarRemocao(Usuario usuario) throws ClassNotFoundException, IOException {

		clienteDados.removarDados(usuario);
		return "---- Conta removida com sucesso!!! -----";

	}

}
