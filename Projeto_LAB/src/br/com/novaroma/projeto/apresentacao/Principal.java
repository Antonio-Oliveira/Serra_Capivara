package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.negocio.ClienteNegocio;

public class Principal {

	private static Scanner scan = new Scanner(System.in);
	private static Login login = new Login();
	private static ClienteNegocio clienteNegocio = new ClienteNegocio();
	private static CatalogoApresentacao catalogo = new CatalogoApresentacao();

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
				login.loginInicial();
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

}