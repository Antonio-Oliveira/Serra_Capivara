package br.com.novaroma.projeto.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.projeto.dados.FuncionarioDados;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.entidades.Produto;
import br.com.novaroma.projeto.utills.Verificar;

public class FuncionarioNegocio {

	private FuncionarioDados funcsDados = new FuncionarioDados();

	public String verificarCadastro(Funcionario func) throws ClassNotFoundException, IOException {

		if (Verificar.verificarCPF(func) == false) {

			return "O Funcionario n�o foi cadastrado, pois seu CPF est� incorreto";

		}
		if (func.getIdade() < 17) {

			return "O Funcionario n�o foi cadastrado pois n�o tem idade o suficiente";

		}
		if (Verificar.verificarSenha(func) == false) {

			return "O Funcionario n�o foi cadastrado pois a senha est� incorreta";

		}
		if (Verificar.VerificarEmail(func) == false) {

			return "O Funcionario n�o foi cadastrado pois o email est� incorreto";

		}

		funcsDados.cadastrar(func);
		return "Funcionario Cadastrado com sucesso!";

	}

	public Funcionario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Funcionario funcionario = (Funcionario) funcsDados.consultaFuncionario(email, senha);
		return funcionario;
	}

	public String verificarRemocao(String cpf) throws ClassNotFoundException, IOException {
		funcsDados.removerDados(cpf);
		return "Funcionario removido";
	}

	public ArrayList<Funcionario> listarFuncsNegocio() throws ClassNotFoundException, IOException {
		return funcsDados.listarFuncionarios();
	}

}
