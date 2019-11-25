package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.ClienteDados;
import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class ClienteNegocio {

	private ClienteDados clienteDados = new ClienteDados();

	public String verificarCadastro(Cliente cliente) throws ClassNotFoundException, IOException {

		if (clienteDados.consultaClienteCPF(cliente.getCpf())) {
			return "Esse CPF j� foi cadastrado";

		} 
		if (clienteDados.consultaClienteEmail(cliente.getEmail())) {

			return "Esse email j� foi cadastrado";

		} 
		if (Verificar.verificarCPF(cliente) ) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado, pois seu CPF est� incorreto";

		} 
		if (cliente.getIdade() <= 8) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado pois n�o tem idade o suficiente";

		} 
		if (Verificar.verificarSenha(cliente) ) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado pois a senha est� incorreta";

		} 
		if (Verificar.VerificarEmail(cliente)) {

			return "O Cliente " + cliente.getNome() + " n�o foi cadastrado pois o email est� incorreto";

		}

		clienteDados.cadastrar(cliente);
		return "Usu�rio Cadastrado com sucesso!";

	}

	public Cliente verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Cliente cliente = (Cliente) clienteDados.consultaUsuario(email, senha);
		return cliente;
	}

	public String verificarModificacoes(Cliente cliente) throws ClassNotFoundException, IOException {

		if (Verificar.VerificarEmail(cliente) == false) {

			return "O Usu�rio n�o pode ser modificado pois o email esta incorreto ou ja foi cadastrado";

		} 
		if (cliente.getIdade() < cliente.getIdade()) {

			return "O Usu�rio n�o pode ser modificado pois a modifica��o estar abaixo da informada anteriormente";

		} 
		if (Verificar.verificarSenha(cliente) == false) {

			return "O Usu�rio n�o pode ser modificado pois a senha n�o esta nos padr�es aceitos";

		}
		clienteDados.modificarDados(cliente);
		return "---- Usu�rio Modificado com sucesso!!! -----";

	}

	public String verificarRemocao(Cliente cliente) throws ClassNotFoundException, IOException {
		clienteDados.removerDados(cliente);
		return "Conta removida!!!";

	}

}
