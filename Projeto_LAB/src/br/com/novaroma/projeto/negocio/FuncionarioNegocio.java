package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.utills.Verificar;

public class FuncionarioNegocio {
	public String verificarCadastro(Funcionario func) throws ClassNotFoundException, IOException {

		if (clienteDados.consultaClienteCPF(func.getCpf()) == true) {
			return "Esse CPF j� foi cadastrado";

		} else if (clienteDados.consultaClienteEmail(func.getEmail()) == true) {

			return "Esse email j� foi cadastrado";

		} else if (Verificar.verificarCPF(func) == false) {

			return "O Cliente " + func.getNome() + " n�o foi cadastrado, pois seu CPF est� incorreto";

		} else if (func.getIdade() <= 18) {

			return "O Cliente " + func.getNome() + " n�o foi cadastrado pois n�o tem idade o suficiente";

		} else if (Verificar.verificarSenha(func) == false) {

			return "O Cliente " + func.getNome() + " n�o foi cadastrado pois a senha est� incorreta";

		} else if (Verificar.VerificarEmail(func) == false) {

			return "O Cliente " + func.getNome() + " n�o foi cadastrado pois o email est� incorreto";

		}

		clienteDados.cadastrar(cliente);
		return "Usu�rio Cadastrado com sucesso!";

	}

	public Funcionario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Funcionario func = (Funcionario) clienteDados.consultaUsuario(email, senha);
		return func;
	}

	public String verificarRemocao(Funcionario func) throws ClassNotFoundException, IOException {

	}

}
