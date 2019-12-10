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

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {

		int x;

		do {
			System.out.println("____________________________________________________________");
			System.out.printf("| %-56S |", "Bem-Vindo, Visitante!");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-56S |", "O que você deseja fazer?");
			System.out.println("\n|__________________________________________________________|");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Explorar nosso catálogo");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Efetuar o login");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Realizar um cadastro");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				catalogo.principal(null);
				break;
			case 2:
				Login();
				break;
			case 3:
				Cliente cliente = clienteApresentacao.preencherCliente();
				String mensagem = clienteNegocio.verificarCadastro(cliente);
				System.out.println("      ");
				System.out.println(mensagem);
				break;
			case 0:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Volte Sempre!");
				System.out.println("------------------------------------------------------------");
				System.exit(x);
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Não temos essa opção no nosso menu!");
				System.out.println("------------------------------------------------------------");

			}
		} while (x != 0);
	}

	private static void Login() throws ClassNotFoundException, IOException, InterruptedException {
		System.out.println("____________________________________________________________");
		System.out.printf("| %-56S |", "Login");
		System.out.println("\n|__________________________________________________________|");
		System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12s | %-41s |", 1, "FUNCIONÁRIO?");
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12s | %-41s |", 2, "CLIENTE?");
		System.out.println("\n|__________________________________________________________|");
		int x = scan.nextInt();
		System.out.printf("| %-15S |", "Email");
		System.out.println("........................................|");
		String email = scan.next();
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Senha");
		System.out.println("........................................|");
		String senha = scan.next();

		switch (x) {
		case 1:

			Funcionario funcionario = funcionarioNegocio.verificarLogin(email, senha);
			if (funcionario != null) {
				
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", ("Seja Bem-Vindo! " + funcionario.getNome()));
				System.out.println("------------------------------------------------------------");

				System.out.println("                                    ");
				System.out.println("Seja Bem-Vindo! " + funcionario.getNome());
				System.out.println("                                    ");
				funcApresentacao.contaLogada(funcionario);

			} else {
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Ops! Você não tem cadastro!");
				System.out.println("------------------------------------------------------------");
			}

			break;
		case 2:

			Cliente cliente = clienteNegocio.verificarLogin(email, senha);

			if (cliente != null) {

				System.out.println("                                    ");
				System.out.println("Seja Bem-Vindo! " + cliente.getNome());
				System.out.println("                                    ");

			} else {
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Ops! Você não tem cadastro!");
				System.out.println("------------------------------------------------------------");
			}

			break;
		default:
			System.out.println("------------------------------------------------------------");
			System.out.printf("| %-56s |\n", "Não existe a opção escolhida!");
			System.out.println("------------------------------------------------------------");

		}

	}

}