package br.com.novaroma.projeto.apresentacao;

import java.util.Scanner;
import br.com.novaroma.projeto.entidades.Usuario;

public class UsuarioApresentacao {

	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);

	public static Usuario preencherUsuario() {

		System.out.println("======================== Informe seu nome: ===============================================================");
		String nome = scan.nextLine();

		System.out.println("======================== Informe sua idade: ==============================================================");
		int idade = scanNum.nextInt();

		System.out.println("======================== Informe seu sexo: ===============================================================");
		String sexo = scan.nextLine();

		System.out.println("======================== Informe um numero para contato: =================================================");
		long numTell = scanNum.nextLong();

		System.out.println("======================== Informe seu email: ==============================================================");
		String email = scan.nextLine();

		System.out.println("======================== Informe seu CPF: ================================================================");
		String cpf = scan.nextLine();

		System.out.println(	"======================= Informe sua senha (maior que 8 digitos e menor que 15 digitos): =================");
		String senha = scan.nextLine();

		return new Usuario(nome, idade, numTell, email, cpf, senha, sexo);

	}

}
