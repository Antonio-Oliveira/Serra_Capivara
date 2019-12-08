package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.Dados;
import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.utills.Verificar;

public class ClienteNegocio {

	// private ClienteDados clienteDados = new ClienteDados();
	private Dados dados = new Dados();
	private Cliente ajuda = new Cliente();

	public String verificarCadastro(Cliente cliente) throws ClassNotFoundException, IOException {

		/*
		 * if (clienteDados.consultaClienteCPF(cliente.getCpf())) { return
		 * "Esse CPF j� foi cadastrado";
		 * 
		 * } if (clienteDados.consultaClienteEmail(cliente.getEmail())) {
		 * 
		 * return "Esse email j� foi cadastrado";
		 * 
		 * }
		 */
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

		//clienteDados.cadastrar(cliente);
		dados.cadastrar(cliente);
		
		return "Usu�rio Cadastrado com sucesso!";

	}

	public Cliente verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
	//	Cliente cliente = (Cliente) clienteDados.consultaUsuario(email, senha);
		
		return (Cliente) dados.consultarLogin(email, senha, ajuda);
	}

	public String verificarModificacoes(Cliente cliente) throws ClassNotFoundException, IOException {
		
		//clienteDados.modificarDados(cliente);
		dados.modificar(cliente);
		return "---- Usu�rio Modificado com sucesso!!! -----";

	}

	public String verificarRemocao(Cliente cliente) throws ClassNotFoundException, IOException {
		//clienteDados.removerDados(cliente);
		dados.remover(cliente);
		return "Conta removida!!!";

	}

}
