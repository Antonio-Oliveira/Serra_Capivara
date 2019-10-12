package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.projeto.dados.ConsultaUsuario;
import br.com.novaroma.projeto.entidades.Usuario;

public class UsuarioLogin {

	static Scanner sc = new Scanner(System.in);

	public static void loginUsuario() throws ClassNotFoundException, IOException {
		System.out.println("========================= LOGIN: ========================= \n");
		System.out.println("=============== Digite seu email: ===============");
		String email = sc.next();
		System.out.println("=============== Digite sua senha: ===============");
		String senha = sc.next();

		ConsultaUsuario usuarioCadastrado = new ConsultaUsuario();
		Usuario usuarioConta = usuarioCadastrado.consultaUsuario(email, senha);
		if (usuarioConta != null) {
			System.out.println("Bem-Vindo, " + usuarioConta.getNome() + "!");

		} else {
			System.out.println("Você não possui cadastro na loja ou dados incorretos! :(");

		}

	}

}
