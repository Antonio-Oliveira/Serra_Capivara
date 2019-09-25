package br.com.novaroma.projeto.utills;

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

		if (Usuario.getSexo().equalsIgnoreCase("masculino")) {
			return prefixoNome = "Sr. " + Usuario.getNome();

		} else {
			return prefixoNome = "Sra. " + Usuario.getNome();

		}
	}

	public static boolean VerificarEmail(Usuario usuario) {
		boolean statusEmail = false;
		if (email != null && email.length() > 0) {
			String expressao = ".+@.+\\.[a-z]+";
			Pattern p = Pattern.compile(expressao);
			Matcher m = p.matcher(email);
			if (m.matches()) {
				statusEmail = true;

			}
		}

		return statusEmail;

	}

	public static boolean verificarSenha(Usuario usuario) {
		boolean statusSenha = false;
		String senhaInvalida;
		if (senha.length() >= 8 && senha.length() <= 15) {
			String expressao = "[A-Z][a-z0-9].+";
			Pattern p = Pattern.compile(expressao);
			Matcher m = p.matcher(senha);
			if(m.matches()) {
				statusSenha = true;
			}
		}
		return statusSenha;

	}

}
