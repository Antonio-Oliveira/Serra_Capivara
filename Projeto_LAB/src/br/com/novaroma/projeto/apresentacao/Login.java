package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.ClienteNegocio;

public class Login {

	static Scanner scan = new Scanner(System.in);
	private ClienteNegocio clienteNegocio = new ClienteNegocio();
	private LoginCliente loginCliente = new LoginCliente();

	public void loginInicial() throws ClassNotFoundException, IOException {

		System.out.println("--------------- LOGIN: ---------------");
		System.out.println("------ Digite 1 para funcionario -----");
		System.out.println("------ Digite 2 para cliente ---------");
		int x = scan.nextInt();

		switch (x) {
		case 1:

			break;
		case 2:
			System.out.println("--------- Digite seu Email: ----------");
			String email = scan.next();
			System.out.println("--------- Digite sua senha: ----------");
			String senha = scan.next();
			Cliente cliente = (Cliente) clienteNegocio.verificarLogin(email, senha);

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
