package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.dados.AtualizarDados;
import br.com.novaroma.projeto.dados.ConsultaDados;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.ModificaUsuarioNegocio;

public class UsuarioLogin {

	private AtualizarDados atualizar = new AtualizarDados();
	private ModificaUsuarioNegocio negocioModifica = new ModificaUsuarioNegocio();

	static Scanner scan = new Scanner(System.in);

	public Usuario loginUsuario() throws ClassNotFoundException, IOException {
		System.out.println("===================== LOGIN: ====================");
		System.out.println("=============== Digite seu email: ===============");
		String email = scan.next();
		System.out.println("=============== Digite sua senha: ===============");
		String senha = scan.next();

		ConsultaDados usuarioCadastrado = new ConsultaDados();
		Usuario usuarioConta = usuarioCadastrado.consultaUsuario(email, senha);
		if (usuarioConta != null) {
			System.out.println("                                                                      ");
			System.out.println("=========== Seja bem-vindo " + usuarioConta.getNome() + "=============");
			System.out.println("                                                                      ");
			return usuarioConta;

		} else {
			System.out.println("Você não possui cadastro na loja ou dados incorretos! :(");
			return null;

		}

	}

	public void consultaLogin(Usuario usuario) throws ClassNotFoundException, IOException {
		int x;
		do {
			System.out.println("========== Ola " + usuario.getNome() + " ======================");
			System.out.println("========== Oque de seja fazer ===============================");
			System.out.println("========== Digite 1 para modificar a conta ==================");
			System.out.println("========== Digite 2 para removar a conta ====================");
			System.out.println("========== Digite 3 verificar as informações ================");
			System.out.println("========== Digite 0 para sair desse Menu ====================");
			x = scan.nextInt();

			switch (x) {
			case 1:
				Usuario usuarioNovo = modificarConta(usuario);
				String mensagem = negocioModifica.verificacoes(usuarioNovo);
				System.out.println("                                                         ");
				System.out.println(mensagem);
				System.out.println("                                                         ");

				break;
			case 2:
				boolean condicao = removerConta(usuario);

				if (condicao = true) {

					atualizar.removarDados(usuario);
					System.out.println("Conta removida com sucesso");

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
		System.out.println("|Numero de telefone: " + usuario.getNumTell());
		System.out.println("|Email: " + usuario.getEmail());
		System.out.println("|CPF: " + usuario.getCpf());
		System.out.println("|Senha: " + usuario.getSenha());
		System.out.println("--------------------------------------");

	}

	private static boolean removerConta(Usuario usuario) {
		System.out.println("Tem certeza que deseja excluir a conta(Se deseja digite sim,se não deseja digite não)");
		String condicao = scan.next();
		if (condicao.equalsIgnoreCase("Sim")) {
			return true;
		} else {
			return false;
		}

	}

	private static Usuario modificarConta(Usuario usuario) {
		int x;

		System.out.println("======== Oque deseja modificar ==========================");
		System.out.println("======== Digite 1 para modificar a idade ================");
		System.out.println("======== Digite 2 para modificar a senha ================");
		System.out.println("======== Digite 3 para modificar o numero de telefone ===");
		System.out.println("======== Digite 0 para sair desse menu ==================");
		x = scan.nextInt();

		switch (x) {
		case 1:
			System.out.println(" Informe sua idade atual ");
			int idade = scan.nextInt();
			usuario.setIdade(idade);
			break;

		case 2:
			System.out.println(" Informe seu nova senha ");
			String senha = scan.next();
			usuario.setSenha(senha);
			break;
		case 3:
			System.out.println(" Informe o novo numero de Telefone");
			long numTell = scan.nextLong();
			usuario.setNumTell(numTell);
			break;
		case 0:
			break;
		default:
			System.out.println("Esse opção não existe(Informe um numero de acordo com o menu)");
			break;
		}

		return usuario;
	}

}
