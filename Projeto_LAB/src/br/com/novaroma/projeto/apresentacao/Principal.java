package br.com.novaroma.projeto.apresentacao;

import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocio.UsuarioNegocio;
import br.com.novaroma.projeto.utills.Verificar;

public class Principal {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String prefixoNome = null;

		System.out.println("==============" + prefixoNome + ", o que deseja fazer?" + "==============" + "\n\n"
				+ "============== Digite 1 para realizar LOGIN ou CADASTRO ==============" + "\n"
				+ "============== Digite 2 para verificar nossas opções de produto ==============" + "\n"
				+ "============== Digite 3 ==============");
		int x = scan.nextInt();

		switch (x) {
		case 1:
			Usuario usuario = UsuarioApresentacao.preencherUsuario();
			break;
		case 2:

			break;
		case 3:
			break;
		default:
			System.out.println("Volte Sempre!");

		}
	}

}