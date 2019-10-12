package br.com.novaroma.projeto.utills;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.novaroma.projeto.entidades.Usuario;

public class Verificar {

	public static boolean verificarCPF(Usuario usuario) {
		char dig10, dig11;
		int soma = 0, r, num, peso = 10;

		for (int i = 0; i < 9; i++) {

			num = (int) (usuario.getCpf().charAt(i) - 48);
			soma += (num * peso);
			peso--;
		}

		r = 11 - (soma % 11);
		if ((r == 10) || (r == 11)) {
			dig10 = '0';
		} else {
			dig10 = (char) (r + 48);
		}
		soma = 0;
		peso = 11;
		for (int i = 0; i < 10; i++) {
			num = (int) (usuario.getCpf().charAt(i) - 48);
			soma += (num * peso);
			peso--;
		}

		r = 11 - (soma % 11);
		if ((r == 10) || (r == 11)) {
			dig11 = '0';
		} else {
			dig11 = (char) (r + 48);
		}
		if (usuario.getCpf().equals("00000000000") || usuario.getCpf().equals("11111111111")
				|| usuario.getCpf().equals("22222222222") || usuario.getCpf().equals("33333333333")
				|| usuario.getCpf().equals("44444444444") || usuario.getCpf().equals("55555555555")
				|| usuario.getCpf().equals("66666666666") || usuario.getCpf().equals("77777777777")
				|| usuario.getCpf().equals("88888888888") || usuario.getCpf().equals("99999999999")
				|| usuario.getCpf().length() < 11) {
			return false;
		} else if (usuario.getCpf().charAt(9) != dig10 || usuario.getCpf().charAt(10) != dig11) {
			return false;
		}

		return true;

	}

	public static String verificarPrefixo(Usuario usuario) {

		String prefixoNome = null;

		if (usuario.getSexo().equalsIgnoreCase("Masculino")) {
			return prefixoNome = "Sr. " + usuario.getNome();

		} else {
			return prefixoNome = "Sra. " + usuario.getNome();

		}
	}

	public static boolean VerificarEmail(Usuario usuario) {

		if (usuario.getEmail() != null && usuario.getEmail().length() > 0) {
			String expressao = ".+@.+\\.[a-z]+";
			Pattern p = Pattern.compile(expressao);
			Matcher m = p.matcher(usuario.getEmail());
			if (m.matches()) {
				return true;

			}
		}

		return false;

	}

	public static boolean verificarSenha(Usuario usuario) {
		if (usuario.getSenha().length() >= 8 && usuario.getSenha().length() <= 15) {
			String expressao = ".+";
			Pattern p = Pattern.compile(expressao);
			Matcher m = p.matcher(usuario.getSenha());
			if (m.matches()) {
				return true;
			}
		}
		return false;

	}

}
