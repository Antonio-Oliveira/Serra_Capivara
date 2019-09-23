package br.com.novaroma.projeto.apresentacao;

import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.UsuarioNegocio;
import br.com.novaroma.projeto.utills.Verificar;

public class Principal {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		String prefixoNome = null;

		System.out.println("------------Digite 1 para gerar cadastro----------------------");
		System.out.println("------------Digite 2 para acessar conta-----------------------");
		System.out.println("------------Digite 3 para verificar nosso catalogo------------");
		System.out.println("------------Digite 0 para sair desta opção--------------------");
		int x = scan.nextInt();

		switch (x) {
		case 1:
			Usuario usuario = UsuarioApresentacao.preencherUsuario();
			String mensagem = usuarioNegocio.verificacoes(usuario);
			System.out.println(mensagem);
			break;
		case 2:

			break;
		case 3:
			CatalogoApresentacao.infoPesquisa();
			break;
		default:
			System.out.println("Volte Sempre!");

		}
	}

}