package br.com.novaroma.projeto.utills;
import br.com.novaroma.projeto.entidades.Usuario;

public  class Verificacoes {
	public static void main(String[]args) {

		String email = "melyssagoliveiragmail.com";
		int indiceEmail = email.indexOf('@');
		if (indiceEmail > 0) {
		System.out.println("E-mail v�lido!");
	}else {
		System.out.println("E-mail inv�lido!");
		
	}
	}
}




	
	
	//public boolean verificarCPF(Usuario usuario);
	//public boolean verificarSenha(Usuario usuario);
	
	


