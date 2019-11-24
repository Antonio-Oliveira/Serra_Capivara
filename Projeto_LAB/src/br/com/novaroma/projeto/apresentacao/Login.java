package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.negocio.ClienteNegocio;
import br.com.novaroma.projeto.negocio.FuncionarioNegocio;

public class Login {

	static Scanner scan = new Scanner(System.in);
	private ClienteNegocio clienteNegocio = new ClienteNegocio();
	private LoginCliente loginCliente = new LoginCliente();
	private FuncionarioNegocio funcsNegocio = new FuncionarioNegocio();
	private LoginFuncionario loginFuncs = new LoginFuncionario();

	public void loginInicial() throws ClassNotFoundException, IOException {

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

			Funcionario func = funcsNegocio.verificarLogin(email, senha);
			if (func != null) {

				System.out.println("                                    ");
				System.out.println("Seja Bem-Vindo! " + func.getNome());
				System.out.println("                                    ");
				loginFuncs.consultaLogin(func);

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
				loginCliente.consultaLogin(cliente);

			} else {
				System.out.println("Ops... você não tem cadastro");
			}

			break;
		default:
			System.out.println("Não existe tal opção escolhida");

		}

	}

}
