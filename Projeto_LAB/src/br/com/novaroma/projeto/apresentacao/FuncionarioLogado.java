package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.negocio.FuncionarioNegocio;

public class FuncionarioLogado {
	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);
	private FuncionarioNegocio funcsNegocio = new FuncionarioNegocio();

	public void consultaLogin(Funcionario func) throws ClassNotFoundException, IOException {
		int x;

		do {

			System.out.println(" ________________________________________________________");
			System.out.println("|	   O que você deseja fazer, com os PRODUTOS?     |");
			System.out.println("|                                                        |");
			System.out.println("|(Digite 1) -- para verificar o catalogo atual           |");
			System.out.println("|(Digite 2) -- para adicionar um produto no catalogo     |");
			System.out.println("|(Digite 3) -- para remover um produto no catalogo       |");
			if (func.getAdm() == true) {
				System.out.println("|	                                                 |");
				System.out.println("|	   O que você deseja fazer, com os FUNCIONARIOS? |");
				System.out.println("|(Digite 4) -- para listar funcionario                   |");
				System.out.println("|(Digite 5) -- para remover um funcionario               |");
				System.out.println("|(Digite 6) -- para adicionar um novo funcionario        |");
			}
			System.out.println("|                                                        |");
			System.out.println("|(Digite 0) -- para sair desse menu                      |");
			System.out.println("|________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				if (func.getAdm() == true) {
					listarFuncionarios();
				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}
				break;
			case 5:
				if (func.getAdm() == true) {

					System.out.println("Informe qual O CPF do funcionario que deseja remover");
					String cpf = scan.nextLine();
					System.out.println(funcsNegocio.verificarRemocao(cpf));

				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}
				break;
			case 6:
				if (func.getAdm() == true) {

					Funcionario novoFuncionario = adicionarFuncionario();
					System.out.println(funcsNegocio.verificarCadastro(novoFuncionario));

				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				break;
			}
		} while (x != 0);
	}

	private void listarFuncionarios() throws ClassNotFoundException, IOException {
		ArrayList<Funcionario> colecaoFuncs = funcsNegocio.listarNegocio();
		for (Funcionario f : colecaoFuncs) {
			System.out.println(f.toString());
		}
	}

	private Funcionario adicionarFuncionario() {
		System.out.println("----------- Informe o nome: --------------");
		String nome = scan.nextLine();

		System.out.println("----------- Informe a idade: -------------");
		int idade = scanNum.nextInt();

		System.out.println("----------- Informe o sexo: --------------");
		String sexo = scan.nextLine();

		System.out.println("----- Informe um numero para contato: ----");
		long numTell = scanNum.nextLong();

		System.out.println("----------- Informe o email: -------------");
		String email = scan.nextLine();

		System.out.println("----------- Informe o CPF: ---------------");
		String cpf = scan.nextLine();

		System.out.println("----------- Informe a RG: --------------");
		String RG = scan.nextLine();

		System.out.println("----------- Informe a CTPS: --------------");
		String CTPS = scan.nextLine();

		System.out.println("----------- Informe a senha: -------------");
		System.out.println("OBSERVAÇÃO!!! - maior que 8 digitos e menor que 15 digitos");
		String senha = scan.nextLine();

		return new Funcionario(nome, idade, numTell, email, cpf, senha, sexo, CTPS, RG);
	}

}
