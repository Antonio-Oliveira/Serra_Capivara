package br.com.novaroma.projeto.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.projeto.dados.Dados;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.utills.Verificar;

public class FuncionarioNegocio {

	private Dados dados = new Dados();
	private Funcionario ajuda = new Funcionario();

	public String verificarCadastro(Funcionario func) throws ClassNotFoundException, IOException {

		if (Verificar.verificarCPF(func)) {

			return "O Funcionario não foi cadastrado, pois seu CPF está incorreto";

		}
		if (func.getIdade() < 17) {

			return "O Funcionario não foi cadastrado pois não tem idade o suficiente";

		}
		if (Verificar.verificarSenha(func)) {

			return "O Funcionario não foi cadastrado pois a senha está incorreta";

		}
		if (Verificar.VerificarEmail(func)) {

			return "O Funcionario não foi cadastrado pois o email está incorreto";

		}

		dados.cadastrar(func);
		return "Funcionario Cadastrado com sucesso!";

	}

	public Funcionario verificarLogin(String email, String senha) throws ClassNotFoundException, IOException {
		Funcionario funcionario = (Funcionario) dados.consultarLogin(email, senha, ajuda);
		return funcionario;
	}

	public String verificarRemocao(Funcionario funcionario) throws ClassNotFoundException, IOException {
		dados.remover(funcionario);
		return "Funcionario removido";
	}

	public ArrayList<Funcionario> listarFuncsNegocio() throws ClassNotFoundException, IOException {
		return dados.listar(ajuda);
	}
	
	public Funcionario buscar(String cpf) throws ClassNotFoundException, IOException {
		return (Funcionario) dados.consultar(cpf, ajuda);
	}

}
