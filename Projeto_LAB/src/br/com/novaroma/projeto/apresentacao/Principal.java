package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.UsuarioNegocio;

public class Principal {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		CatalogoApresentacao catalogo = new CatalogoApresentacao();
		int x;

		do {
			System.out.println("                                                             ");
			System.out.println("=============== BEM-VINDO, Visitante! =======================");
			System.out.println("=============== O que você deseja fazer? ==================== \n");
			System.out.println("=============== Digite 1 para EXPLORAR NOSSO CATALOGO =======");
			System.out.println("=============== Digite 2 para EFETUAR O LOGIN ===============");
			System.out.println("=============== Digite 3 para REALIZAR UM CADASTRO ==========");
			System.out.println("=============== Digite 0 para sair do programa ==============");
			x = scan.nextInt();

			switch (x) {
			case 1:
				catalogo.infoPesquisa();
				break;
			case 2:
				UsuarioLogin login = new UsuarioLogin();
				Usuario usuarioCadastrado = login.loginUsuario();
				if (usuarioCadastrado != null) {
					login.consultaLogin(usuarioCadastrado);
				}
				break;
			case 3:
				Usuario usuario = UsuarioApresentacao.preencherUsuario();
				String mensagem = usuarioNegocio.verificarModificacoes(usuario);
				System.out.println("                                ");
				System.out.println(mensagem);
				System.out.println("                                ");
				break;
			case 0:
				System.out.println("  ");
				System.out.println("Volte Sempre!");
				break;
			default:
				System.out.println("Não temos essa opção em nosso menu");

			}
		} while (x != 0);
	}

}