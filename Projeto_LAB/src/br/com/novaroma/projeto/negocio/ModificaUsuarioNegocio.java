package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.AtualizarDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class ModificaUsuarioNegocio {

	private AtualizarDados atualizarDados = new AtualizarDados();

	public String verificacoes(Usuario usuario) throws ClassNotFoundException, IOException {

		if (usuario.getIdade() <= 8) {

			return "O Usu�rio n�o pode ser modificado pois n�o tem idade suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usu�rio n�o pode ser modificado pois a senha esta incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usu�rio n�o pode ser modificado pois o email esta incorreto";

		}
		atualizarDados.modificarDados(usuario);
		return "============== Usu�rio Modificado com sucesso ===============";

	}

}
