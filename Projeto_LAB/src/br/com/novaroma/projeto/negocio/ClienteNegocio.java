package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.dados.ClienteDados;
import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.utills.Verificar;

public class ClienteNegocio {

	private ClienteDados clienteDados = new ClienteDados();

	public String verificarCadastro(Cliente cliente) throws ClassNotFoundException, IOException {

		if (clienteDados.consultaClienteCPF(cliente.getCpf()) == true) {
			return "Esse CPF já foi cadastrado";

		} else if (clienteDados.consultaClienteEmail(cliente.getEmail()) == true) {

			return "Esse email já foi cadastrado";

		} else if (Verificar.verificarCPF(cliente) == false) {

			return "O Cliente " + cliente.getNome() + " não foi cadastrado, pois seu CPF está incorreto";

		} else if (cliente.getIdade() <= 8) {

			return "O Cliente " + cliente.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		} else if (Verificar.verificarSenha(cliente) == false) {

			return "O Cliente " + cliente.getNome() + " não foi cadastrado pois a senha está incorreta";

		} else if (Verificar.VerificarEmail(cliente) == false) {

			return "O Cliente " + cliente.getNome() + " não foi cadastrado pois o email está incorreto";

		}

		clienteDados.cadastrar(cliente);
		return "Usuário Cadastrado com sucesso!";

	}

	public Cliente verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Cliente cliente = (Cliente) clienteDados.consultaUsuario(email, senha);
		return cliente;
	}

	public String verificarModificacoes(Cliente cliente) throws ClassNotFoundException, IOException {

		if (Verificar.VerificarEmail(cliente) == false) {

			return "O Usuário não pode ser modificado pois o email esta incorreto ou ja foi cadastrado";

		} else if (cliente.getIdade() < cliente.getIdade()) {

			return "O Usuário não pode ser modificado pois a modificação estar abaixo da informada anteriormente";

		} else if (Verificar.verificarSenha(cliente) == false) {

			return "O Usuário não pode ser modificado pois a senha não esta nos padrões aceitos";

		}
		clienteDados.modificarDados(cliente);
		return "---- Usuário Modificado com sucesso!!! -----";

	}

	public String verificarRemocao(Cliente cliente) throws ClassNotFoundException, IOException {
		clienteDados.removerDados(cliente);
		return "Conta removida!!!";

	}

}
