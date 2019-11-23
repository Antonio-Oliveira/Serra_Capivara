package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.ClienteNegocio;

public class Login {

	private ClienteNegocio clienteNegocio = new ClienteNegocio();
	static Scanner scan = new Scanner(System.in);

	public void consultaLogin(Usuario usuario) throws ClassNotFoundException, IOException {
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
				verificarConta(usuario);
				break;
			case 2:
				Usuario usuarioNovo = modificarConta(usuario);
				String mensagemMod = clienteNegocio.verificarModificacoes(usuarioNovo, usuario);
				System.out.println("      ");
				System.out.println(mensagemMod);
				System.out.println("      ");
				break;
			case 3:
				System.out.println(
						"Tem certeza que deseja excluir sua conta? (Se deseja digite |Sim|, se não digite |Não|)");
				String condicao = scan.next();

				if (condicao.equalsIgnoreCase("Sim")) {

					String mensagemRemov = clienteNegocio.verificarRemocao(usuario);
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

	private static void verificarConta(Usuario usuario) {
		System.out.println("____________________________________________");
		System.out.println("|Nome: " + usuario.getNome());
		System.out.println("|Idade: " + usuario.getIdade());
		System.out.println("|Sexo: " + usuario.getSexo());
		System.out.println("|Número do telefone: " + usuario.getNumTell());
		System.out.println("|Email: " + usuario.getEmail());
		System.out.println("|CPF: " + usuario.getCpf());
		System.out.println("|Senha: " + usuario.getSenha());
		System.out.println("|___________________________________________");

	}

	private static Usuario modificarConta(Usuario usuario) {
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
				usuario.setIdade(idade);
				break;
			case 2:
				System.out.println(" Informe sua nova senha ");
				String senha = scan.next();
				usuario.setSenha(senha);
				break;
			case 3:
				System.out.println(" Informe o novo número de Telefone");
				long numTell = scan.nextLong();
				usuario.setNumTell(numTell);
				break;
			case 4:
				System.out.println("Informe o novo email");
				String email = scan.next();
				usuario.setEmail(email);
				break;
			case 0:
				break;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				break;
			}

		} while (x != 0);

		return usuario;
	}

	public Usuario loginUsuario() throws ClassNotFoundException, IOException {

		System.out.println("--------------- LOGIN: ---------------");
		System.out.println("--------- Digite seu Email: ----------");
		String email = scan.next();
		System.out.println("--------- Digite sua senha: ----------");
		String senha = scan.next();

		Usuario usuario = clienteNegocio.verificarLogin(email, senha);

		if (usuario != null) {

			System.out.println("                                    ");
			System.out.println("Seja Bem-Vindo! " + usuario.getNome());
			System.out.println("                                    ");
			return usuario;

		}

		return null;

	}

}
