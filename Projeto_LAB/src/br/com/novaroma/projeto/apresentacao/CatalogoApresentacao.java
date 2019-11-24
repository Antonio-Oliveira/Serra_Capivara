package br.com.novaroma.projeto.apresentacao;

import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Catalogo;

public class CatalogoApresentacao {

	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);

	public void infoPesquisa() {
		Catalogo produto = new Catalogo();
		produto.Preenchimento();
		int x;

		do {
			System.out.println("___________________________________________________________");
			System.out.println("|	   O que você deseja fazer?                           |");
			System.out.println("|                                                         |");
			System.out.println("|(Digite 1) -- para apresentar o catalogo completo        |");
			System.out.println("|(Digite 2) -- para filtrar as informações do produto     |");
			System.out.println("|(Digite 0) -- para sair do programa                      |");
			System.out.println("|_________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				catalogoCompleto(produto);
				continue;
			case 2:
				filtro(produto);
				continue;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				continue;
			}

		} while (x != 0);

	}

	private void catalogoCompleto(Catalogo produto) {

		System.out.println("________________________________________________________________________");
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			System.out.println(i + " - " + produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor()
					+ " ," + produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
					+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			System.out.println("________________________________________________________________________");
		}

	}

	@SuppressWarnings("unused")
	public void filtro(Catalogo produto) {
		String tipo = "", tema = "", cor = "";
		double precoMax = 0, precoMin = 0;
		int x;

		do {
			System.out.println("                                                              ");
			System.out.println("OBSERVAÇÃO -  O  FILTRO E MODELADO DE ACORDO COM SUAS ESCOLHAS");
			System.out.println("              QUANDO TIVER ACABADO DE PREENCHER DIGITE '0'    ");
			System.out.println("________________________________________________________");
			System.out.println("|                                                      |");
			System.out.println("|(Digite 1) -- para escolher o tipo do produto         |");
			System.out.println("|(Digite 2) -- para escolher o tema do produto         |");
			System.out.println("|(Digite 3) -- para escolher a cor do produto          |");
			System.out.println("|(Digite 4) -- para escolher o preço maximo do produto |");
			System.out.println("|(Digite 5) -- para escolher o preço minimo do produto |");
			System.out.println("|(Digite 0) -- para sair do programa                   |");
			System.out.println("|______________________________________________________|");
			x = scanNum.nextInt();

			System.out.println("   ");
			switch (x) {
			case 1:
				System.out.println("Informe o tipo do produto que deseja");
				tipo = scan.next();
				continue;
			case 2:
				System.out.println("Informe o tema do produto que deseja");
				tema = scan.next();
				continue;
			case 3:
				System.out.println("Informe a cor do produto que deseja: ");
				cor = scan.nextLine();
				continue;
			case 4:
				System.out.println("Informe o preço maximo do produto: ");
				precoMax = scanNum.nextDouble();
				continue;
			case 5:
				System.out.println("Informe o preço mínimo do produto: ");
				precoMin = scanNum.nextDouble();
				continue;
			case 0:
				continue;
			default:
				System.out.println("Não temos essa opções, se deseja terminar o filtrar nada digite '0'");
			}

		} while (x != 0);

		filtragem(tipo, tema, cor, precoMax, precoMin, produto);

	}

	@SuppressWarnings("unused")
	private void filtragem(String tipo, String tema, String cor, double precoMaximo, double precoMinimo,
			Catalogo produto) {
		int aux = 0, cont = 1;

		System.out.println("________________________________________________________________________");
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if ((tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo()) || tipo.equals(""))
					&& (tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema()) || tema.equals(""))
					&& (cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor()) || cor.equals(""))
					&& (precoMaximo >= produto.getCatalogo()[i].getPreco() || precoMaximo == 0)
					&& (precoMinimo <= produto.getCatalogo()[i].getPreco() || precoMinimo == 0)) {

				System.out.println(
						cont + " - " + produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor()
								+ " ," + produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco()
								+ " R$" + " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
				System.out.println("________________________________________________________________________");
				cont++;
				aux++;

			}
		}
		if (aux == 0) {
			System.out.println("Nenhum produto foi encontrado com essas informações");
		}

	}

}
