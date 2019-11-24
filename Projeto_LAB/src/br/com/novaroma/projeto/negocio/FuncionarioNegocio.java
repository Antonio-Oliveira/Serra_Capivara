package br.com.novaroma.projeto.negocio;

import java.io.IOException;

import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.utills.Verificar;

public class FuncionarioNegocio {
	public String verificarCadastro(Funcionario func) throws ClassNotFoundException, IOException {

		if (clienteDados.consultaClienteCPF(func.getCpf()) == true) {
			return "Esse CPF já foi cadastrado";

		} else if (clienteDados.consultaClienteEmail(func.getEmail()) == true) {

			return "Esse email já foi cadastrado";

		} else if (Verificar.verificarCPF(func) == false) {

			return "O Cliente " + func.getNome() + " não foi cadastrado, pois seu CPF está incorreto";

		} else if (func.getIdade() <= 18) {

			return "O Cliente " + func.getNome() + " não foi cadastrado pois não tem idade o suficiente";

		} else if (Verificar.verificarSenha(func) == false) {

			return "O Cliente " + func.getNome() + " não foi cadastrado pois a senha está incorreta";

		} else if (Verificar.VerificarEmail(func) == false) {

			return "O Cliente " + func.getNome() + " não foi cadastrado pois o email está incorreto";

		}

		clienteDados.cadastrar(cliente);
		return "Usuário Cadastrado com sucesso!";

	}

	public Funcionario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Funcionario func = (Funcionario) clienteDados.consultaUsuario(email, senha);
		return func;
	}

	public String verificarRemocao(Funcionario func) throws ClassNotFoundException, IOException {

	}

}
