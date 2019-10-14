package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.AtualizarDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class ModificaUsuarioNegocio {

	private AtualizarDados atualizarDados = new AtualizarDados();

	public String verificacoes(Usuario usuario) throws ClassNotFoundException, IOException {

		if (usuario.getIdade() <= 8) {

			return "O Usuario n�o pod� ser modificado pois n�o tem idade o suficiente";

		} else if (Verificar.verificarSenha(usuario) == false) {

			return "O Usuario n�o pod� ser modificado pois a senha esta incorreta";

		} else if (Verificar.VerificarEmail(usuario) == false) {

			return "O Usuario n�o pod� ser modificado pois o email esta incorreta";

		}
		atualizarDados.modificarDados(usuario);
		return "==================== Usuario Modificado com sucesso=====================";

	}

}
