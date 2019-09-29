package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.UsuarioNegocio;

public class Principal {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		int x;

		do {
			System.out.println("=============== BEM-VINDO, Visitante! ===============");
			System.out.println("=============== O que você deseja fazer? =============== \n");
			System.out.println("=============== Digite 1 para EXPLORAR NOSSO CATALOGO ===============");
			System.out.println("=============== Digite 2 para EFETUAR O LOGIN ===============");
			System.out.println("=============== Digite 3 para REALIZAR UM CADASTRO ===============");
			System.out.println("=============== Digite 4 para RECUPERAR A CONTA ===============");
			System.out.println("=============== Digite 0 para retornar ===============");
			x = scan.nextInt();

			switch (x) {
			case 1:
				CatalogoApresentacao.infoPesquisa();
				break;
			case 2:
				UsuarioLogin.loginUsuario();
				break;
			case 3:
				Usuario usuario = UsuarioApresentacao.preencherUsuario();
				String mensagem = usuarioNegocio.verificacoes(usuario);
				System.out.println(mensagem);
				break;
			case 4:

				break;
			default:
				System.out.println("Volte Sempre!");

			}
		} while (x != 0);
	}

}