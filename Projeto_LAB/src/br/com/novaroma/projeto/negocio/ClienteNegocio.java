package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.Dados;
import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.utills.Verificar;

public class ClienteNegocio {

	private Dados dados = new Dados();
	private Cliente ajuda = new Cliente();

	public String verificarCadastro(Cliente cliente) throws ClassNotFoundException, IOException {

		if (Verificar.verificarCPF(cliente)) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado, pois seu CPF est� incorreto";

		}
		if (cliente.getIdade() <= 8) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado pois n�o tem idade o suficiente";

		}
		if (Verificar.verificarSenha(cliente)) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado pois a senha est� incorreta";

		}
		if (Verificar.VerificarEmail(cliente)) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado pois o email est� incorreto";

		}

		dados.cadastrar(cliente);
		
		return "Usu�rio Cadastrado com sucesso!";

	}

	public Cliente verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		
		return (Cliente) dados.consultarLogin(email, senha, ajuda);
	}

	public String verificarModificacoes(Cliente cliente) throws ClassNotFoundException, IOException {
		
		dados.modificar(cliente);
		return "---- Usu�rio Modificado com sucesso!!! -----";

	}

	public String verificarRemocao(Cliente cliente) throws ClassNotFoundException, IOException {
		dados.remover(cliente);
		return "Conta removida!!!";

	}

}
