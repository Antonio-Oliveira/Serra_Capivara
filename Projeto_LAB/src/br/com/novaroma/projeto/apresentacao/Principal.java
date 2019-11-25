package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.negocio.ClienteNegocio;
import br.com.novaroma.projeto.negocio.FuncionarioNegocio;

public class Principal {

	private static Scanner scan = new Scanner(System.in);
	private static ClienteNegocio clienteNegocio = new ClienteNegocio();
	private static FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
	private static CatalogoApresentacao catalogo = new CatalogoApresentacao();
	private static FuncionarioApresentacao funcApresentacao = new FuncionarioApresentacao();
	private static ClienteApresentacao clienteApresentacao = new ClienteApresentacao();

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		int x;

		do {
			System.out.println(" ___________________________________________ ");
			System.out.println("|	    BEM-VINDO, Visitante!           |");
			System.out.println("|___________________________________________|");
			System.out.println("|	   O que você deseja fazer?         |");
			System.out.println("|                                           |");
			System.out.println("|(Digite 1) -- para EXPLORAR NOSSO CATALOGO |");
			System.out.println("|(Digite 2) -- para EFETUAR O LOGIN         |");
			System.out.println("|(Digite 3) -- para REALIZAR UM CADASTRO    |");
			System.out.println("|(Digite 0) -- para sair do programa        |");
			System.out.println("|___________________________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				catalogo.infoPesquisa();
				break;
			case 2:
				Login();
				break;
			case 3:
				Cliente cliente = ClienteApresentacao.preencherCliente();
				String mensagem = clienteNegocio.verificarCadastro(cliente);
				System.out.println("      ");
				System.out.println(mensagem);
				break;
			case 0:
				System.out.println("             ");
				System.out.println("Volte Sempre!");
				break;
			default:
				System.out.println("Não temos essa opção em nosso menu");

			}
		} while (x != 0);
	}

	private static void Login() {
		System.out.println("--------------- LOGIN: ---------------");
		System.out.println("------ Digite 1 para funcionario -----");
		System.out.println("------ Digite 2 para cliente ---------");
		int x = scan.nextInt();
		System.out.println("--------- Digite seu Email: ----------");
		String email = scan.next();
		System.out.println("--------- Digite sua senha: ----------");
		String senha = scan.next();

		switch (x) {
		case 1:

			Funcionario funcionario = funcionarioNegocio.verificarLogin(email, senha);
			if (funcionario != null) {

				System.out.println("                                    ");
				System.out.println("Seja Bem-Vindo! " + funcionario.getNome());
				System.out.println("                                    ");
				funcApresentacao.contaLogada(funcionario);

			} else {
				System.out.println("Ops... você não tem cadastro");
			}

			break;
		case 2:

			Cliente cliente = clienteNegocio.verificarLogin(email, senha);

			if (cliente != null) {

				System.out.println("                                    ");
				System.out.println("Seja Bem-Vindo! " + cliente.getNome());
				System.out.println("                                    ");
				clienteLogado.consultaLogin(cliente);

			} else {
				System.out.println("Ops... você não tem cadastro");
			}

			break;
		default:
			System.out.println("Não existe tal opção escolhida");

		}

	}

}