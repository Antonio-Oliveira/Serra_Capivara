package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.ConsultaDados;
import br.com.novaroma.projeto.dados.UsuarioDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class UsuarioNegocio {

	private UsuarioDados usuarioDados = new UsuarioDados();
	private ConsultaDados consulta = new ConsultaDados();

	public String verificacoes(Usuario usuario) throws ClassNotFoundException, IOException {

		if (this.consulta.consultaUsuarioCPF(usuario.getCpf()) != null) {
			return "Esse CPF j� foi cadastrado";

		} else if (this.consulta.consultaUsuarioEmail(usuario.getEmail()) != null) {

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

}
