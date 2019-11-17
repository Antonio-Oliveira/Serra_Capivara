package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.UsuarioNegocio;

public class UsuarioLogin {

	private UsuarioNegocio usuarioNegocio = new UsuarioNegocio();

	static Scanner scan = new Scanner(System.in);

	public Usuario loginUsuario() throws ClassNotFoundException, IOException {
		System.out.println("===================== LOGIN: ====================");
		System.out.println("=============== Digite seu Email: ===============");
		String email = scan.next();
		System.out.println("=============== Digite sua senha: ===============");
		String senha = scan.next();

		Usuario usuario = usuarioNegocio.verificarLogin(email, senha);
		if (usuario != null) {
			System.out.println("                                                                      ");
			System.out.println("=========== Seja Bem-Vindo! " + usuario.getNome() + "=============");
			System.out.println("                                                                      ");
			return usuario;

		} else {
			System.out.println("Você não possui cadastro na loja ou dados incorretos! :(");
			return null;

		}

	}

	public void consultaLogin(Usuario usuario) throws ClassNotFoundException, IOException {
		int x;
		do {
			System.out.println("========== Olá! " + usuario.getNome() + " ===================");
			System.out.println("========== O que deseja fazer? ==============================");
			System.out.println("========== Digite 1 para modificar a conta ==================");
			System.out.println("========== Digite 2 para remover a conta ====================");
			System.out.println("========== Digite 3 para verificar as informações ===========");
			System.out.println("========== Digite 0 para sair do Menu =======================");
			x = scan.nextInt();

			switch (x) {
			case 1:
				Usuario usuarioNovo = modificarConta(usuario);
				String mensagem = usuarioNegocio.verificarModificacoes(usuarioNovo);
				System.out.println("                                                         ");
				System.out.println(mensagem);
				System.out.println("                                                         ");

				break;
			case 2:
				boolean condicao = removerConta(usuario);

				if (condicao = true) {

					String mensagem1 = usuarioNegocio.verificarRemocao(usuario);
					System.out.println(mensagem1);

				}
				x = 0;
				break;
			case 3:
				verificarConta(usuario);
			default:
				break;
			}

		} while (x != 0);
	}

	private static void verificarConta(Usuario usuario) {
		System.out.println("--------------------------------------");
		System.out.println("|Nome: " + usuario.getNome());
		System.out.println("|Idade: " + usuario.getIdade());
		System.out.println("|Sexo: " + usuario.getSexo());
		System.out.println("|Número do telefone: " + usuario.getNumTell());
		System.out.println("|Email: " + usuario.getEmail());
		System.out.println("|CPF: " + usuario.getCpf());
		System.out.println("|Senha: " + usuario.getSenha());
		System.out.println("--------------------------------------");

	}

	private static boolean removerConta(Usuario usuario) {
		System.out.println("Tem certeza que deseja excluir a conta? (Se deseja digite Sim, se não deseja digite Não)");
		String condicao = scan.next();
		if (condicao.equalsIgnoreCase("Sim")) {
			return true;
		} else {
			return false;
		}

	}

	private static Usuario modificarConta(Usuario usuario) {
		int x;

		System.out.println("======== O que deseja modificar?=========================");
		System.out.println("======== Digite 1 para modificar a idade ================");
		System.out.println("======== Digite 2 para modificar a senha ================");
		System.out.println("======== Digite 3 para modificar o número de telefone ===");
		System.out.println("======== Digite 0 para sair desse Menu ==================");
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
		case 0:
			break;
		default:
			System.out.println("Esse opção não existe (Informe um número de acordo com o Menu!)");
			break;
		}

		return usuario;
	}

}
