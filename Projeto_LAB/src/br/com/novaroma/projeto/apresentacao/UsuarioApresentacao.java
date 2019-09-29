package br.com.novaroma.projeto.apresentacao;
import java.util.Scanner;
import br.com.novaroma.projeto.entidades.Usuario;



public class UsuarioApresentacao {
	
	static Scanner scan = new Scanner(System.in);
	
	public static Usuario preencherUsuario() {
		
		System.out.println("================= Informe seu nome: =================");
		String nome = scan.next();
		
		System.out.println("================= Informe sua idade: =================");
		int idade = scan.nextInt();
		
		System.out.println("================= Informe seu sexo: ==================");
		String sexo = scan.next();
		
		System.out.println("========== Informe um numero para contato: ===========");
		int numTell = scan.nextInt();
		
		System.out.println("================= Informe seu email: =================");
		String email = scan.next();
		
		System.out.println("================= Informe seu CPF: ===================");
		String cpf = scan.next();
		
		System.out.println("================= Informe sua senha: =================");
		String senha = scan.next();
		
		return new Usuario(nome, idade, numTell, email, cpf, senha, sexo);
		
	}

	

}
