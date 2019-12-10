package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.ClienteNegocio;

public class ClienteApresentacao {
	private ClienteNegocio clienteNegocio = new ClienteNegocio();
	private CatalogoApresentacao catalogo = new CatalogoApresentacao();
	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);

	public Cliente preencherCliente() {

		System.out.println("____________________________________________________________");
		System.out.printf("| %-56S |", "Informe seus dados corretamente");
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Nome");
		System.out.println("........................................|");
		String nome = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Idade");
		System.out.println("........................................|");
		int idade = scanNum.nextInt();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Sexo");
		System.out.println("........................................|");
		String sexo = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Nº Telefone");
		System.out.println("........................................|");
		long numTell = scanNum.nextLong();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Email");
		System.out.println("........................................|");
		String email = scan.nextLine();
		System.out.printf("| %-15S |", "CPF");
		System.out.println("........................................|");
		String cpf = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Senha");
		System.out.println("........................................|");
		System.out.printf("| %-56S |\n", "A senha deve ter entre 8 e 15 dígitos");
		String senha = scan.nextLine();
		

		return new Cliente(nome, idade, numTell, email, cpf, senha, sexo);

	}

	public void contaLogado(Cliente cliente) throws ClassNotFoundException, IOException, InterruptedException {
		int x;

		do {

			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Verificar as informações");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Modificar a conta");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Remover a conta");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 4, "Acessar nosso catalogo");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				verificarConta(cliente);
				Thread.sleep(1000);

				break;
			case 2:
				Usuario usuarioNovo = modificarConta(cliente);
				String mensagemMod = clienteNegocio.verificarModificacoes(cliente);
				System.out.println("      ");
				System.out.println(mensagemMod);
				System.out.println("      ");
				break;
			case 3:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Tem certeza que deseja excluir sua conta? |Sim| ou |Não|");
				System.out.println("------------------------------------------------------------");
				String condicao = scan.next();

				if (condicao.equalsIgnoreCase("Sim")) {

					String mensagemRemov = clienteNegocio.verificarRemocao(cliente);
					System.out.println(mensagemRemov);

				}
				x = 0;
				break;
			case 4:
				catalogo.principal(cliente);
			case 0:
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Por favor, digite apenas números de acordo com o menu acima");
				System.out.println("------------------------------------------------------------");
				break;
			}
		} while (x != 0);
	}

	private static void verificarConta(Cliente cliente) {
		System.out.println("____________________________________________________________");
		System.out.printf("| %-12S | %-41s |", "Nome",  cliente.getNome());
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12S | %-41s |", "Idade", cliente.getIdade());
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12S | %-41s |", "Nº Telefone", cliente.getNumTell());
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12S | %-41s |", "Email", cliente.getEmail());
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12S | %-41s |", "CPF", cliente.getCpf());
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-12S | %-41s |", "Senha", cliente.getSenha());
		System.out.println("|__________________________________________________________|");

	}

	private static Cliente modificarConta(Cliente cliente) {
		int x;

		do {

			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Modificar a idade");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Modificar a senha");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Modificar o Nº Telefone");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 4, "Modificar o Email");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe sua idade atual");
				System.out.println("------------------------------------------------------------");
				int idade = scan.nextInt();
				cliente.setIdade(idade);
				break;
			case 2:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe sua nova senha");
				System.out.println("------------------------------------------------------------");
				String senha = scan.next();
				cliente.setSenha(senha);
				break;
			case 3:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o novo Nº de telefone");
				System.out.println("------------------------------------------------------------");
				long numTell = scan.nextLong();
				cliente.setNumTell(numTell);
				break;
			case 4:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe seu email atual");
				System.out.println("------------------------------------------------------------");
				String email = scan.next();
				cliente.setEmail(email);
				break;
			case 0:
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "\"Por favor, digite apenas números de acordo com o menu acima!");
				System.out.println("------------------------------------------------------------");
				break;
			}

		} while (x != 0);

		return cliente;
	}

}
