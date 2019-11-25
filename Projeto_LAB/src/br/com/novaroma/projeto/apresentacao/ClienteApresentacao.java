package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.ClienteNegocio;

public class ClienteApresentacao {
	private ClienteNegocio clienteNegocio = new ClienteNegocio();
	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);

	public static Cliente preencherCliente() {

		System.out.println("----------- Informe seu nome: --------------");
		String nome = scan.nextLine();

		System.out.println("----------- Informe sua idade: -------------");
		int idade = scanNum.nextInt();

		System.out.println("----------- Informe seu sexo: --------------");
		String sexo = scan.nextLine();

		System.out.println("----- Informe um numero para contato: ------");
		long numTell = scanNum.nextLong();

		System.out.println("----------- Informe seu email: -------------");
		String email = scan.nextLine();

		System.out.println("----------- Informe seu CPF: ---------------");
		String cpf = scan.nextLine();

		System.out.println("----------- Informe sua senha: -------------");
		System.out.println("OBSERVAÇÃO!!! - maior que 8 digitos e menor que 15 digitos");
		String senha = scan.nextLine();

		return new Cliente(nome, idade, numTell, email, cpf, senha, sexo);

	}


	public void consultaLogin(Cliente cliente) throws ClassNotFoundException, IOException {
		int x;

		do {

			System.out.println("_____________________________________________");
			System.out.println("|	   O que você deseja fazer?          |");
			System.out.println("|                                            |");
			System.out.println("|(Digite 1) -- para verificar as informações |");
			System.out.println("|(Digite 2) -- para para modificar a conta   |");
			System.out.println("|(Digite 3) -- para remover a conta          |");
			System.out.println("|(Digite 0) -- para sair desse menu          |");
			System.out.println("|____________________________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				verificarConta(cliente);
				break;
			case 2:
				Usuario usuarioNovo = modificarConta(cliente);
				String mensagemMod = clienteNegocio.verificarModificacoes(cliente);
				System.out.println("      ");
				System.out.println(mensagemMod);
				System.out.println("      ");
				break;
			case 3:
				System.out.println(
						"Tem certeza que deseja excluir sua conta? (Se deseja digite |Sim|, se não digite |Não|)");
				String condicao = scan.next();

				if (condicao.equalsIgnoreCase("Sim")) {

					String mensagemRemov = clienteNegocio.verificarRemocao(cliente);
					System.out.println(mensagemRemov);

				}
				x = 0;
				break;
			case 0:
				break;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				break;
			}
		} while (x != 0);
	}

	private static void verificarConta(Cliente cliente) {
		System.out.println("____________________________________________");
		System.out.println("|Nome: " + cliente.getNome());
		System.out.println("|Idade: " + cliente.getIdade());
		System.out.println("|Sexo: " + cliente.getSexo());
		System.out.println("|Número do telefone: " + cliente.getNumTell());
		System.out.println("|Email: " + cliente.getEmail());
		System.out.println("|CPF: " + cliente.getCpf());
		System.out.println("|Senha: " + cliente.getSenha());
		System.out.println("|___________________________________________");

	}

	private static Cliente modificarConta(Cliente cliente) {
		int x;

		do {

			System.out.println("____________________________________________________");
			System.out.println("|	   O que você deseja fazer?                |");
			System.out.println("|                                                  |");
			System.out.println("|(Digite 1) -- para modificar a idade              |");
			System.out.println("|(Digite 2) -- para modificar a senha              |");
			System.out.println("|(Digite 3) -- para modificar o número de telefone |");
			System.out.println("|(Digite 4) -- para modificar o email              |");
			System.out.println("|(Digite 0) -- para sair desse Menu                |");
			System.out.println("|__________________________________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				System.out.println(" Informe sua idade atual ");
				int idade = scan.nextInt();
				cliente.setIdade(idade);
				break;
			case 2:
				System.out.println(" Informe sua nova senha ");
				String senha = scan.next();
				cliente.setSenha(senha);
				break;
			case 3:
				System.out.println(" Informe o novo número de Telefone");
				long numTell = scan.nextLong();
				cliente.setNumTell(numTell);
				break;
			case 4:
				System.out.println("Informe o novo email");
				String email = scan.next();
				cliente.setEmail(email);
				break;
			case 0:
				break;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				break;
			}

		} while (x != 0);

		return cliente;
	}


}
