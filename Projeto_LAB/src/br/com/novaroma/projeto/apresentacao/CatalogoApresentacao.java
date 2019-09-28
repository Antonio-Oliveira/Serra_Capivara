package br.com.novaroma.projeto.apresentacao;

import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Catalogo;
import br.com.novaroma.projeto.entidades.Produto;

public class CatalogoApresentacao {

	static Scanner scan = new Scanner(System.in);

	public static void infoPesquisa() {
		Catalogo produtos = new Catalogo();
		produtos.Preenchimento();
		int x;

		do {
			System.out.println("------------Digite 1 para para apresentar Catalogo completo-------");
			System.out.println("------------Digite 2 para filtrar informacões---------------------");
			System.out.println("------------Digite 0 para sair desta opção------------------------");
			x = scan.nextInt();

			switch (x) {
			case 1:
				catalogoCompleto(produtos);
				break;
			case 2:
				filtro(produtos);
				break;
			default:
				System.out.println("Não temos essa opções, se deseja sair digite 0");

			}

		} while (x != 0);

	}

	private static void catalogoCompleto(Catalogo produtos) {
		produtos.Preenchimento();
		for (int i = 0; i < produtos.getCatalogo().length; i++) {
			System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor() + " ,"
					+ produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco() + " R$"
					+ " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
			System.out.println("----------------------------------------------------------");
		}

	}

	@SuppressWarnings("unused")
	public static void filtro(Catalogo produtos) {
		String tipo = "n", tema = "n", cor = "n";
		double preco = 0;
		int x;

		produtos.Preenchimento();

		do {
			System.out.println("------------Digite 1 para filtrar o tipo-----------------------");
			System.out.println("------------Digite 2 para filtrar o tema-----------------------");
			System.out.println("------------Digite 3 para filtrar a cor------------------------");
			System.out.println("------------Digite 4 para filtrar preço maximo-----------------");
			System.out.println("------------Digite 0 para sair desta opção---------------------");
			x = scan.nextInt();

			System.out.println("                                                                ");
			switch (x) {
			case 1:
				System.out.println("Informe o tipo do produto que deseja");
				tipo = scan.next();
				break;
			case 2:
				System.out.println("Informe o tema do produto que deseja");
				tema = scan.next();
				break;
			case 3:
				System.out.println("Informe a cor do produto que deseja");
				cor = scan.next();
				break;
			case 4:
				System.out.println("Informe o preço maximo do produto");
				preco = scan.nextInt();
			case 0:
				break;
			default:
				System.out.println("Não temos essa opções, se deseja sair digite 0");

			}
		} while (x != 0);

		for (int i = 0; i < produtos.getCatalogo().length; i++) {
			if (tipo == "n" || tema == "n" || cor == "n" || preco == 0) {

				if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo()) && tema == "n" && cor == "n"
						&& preco == 0.0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema()) && cor == "n"
						&& preco == 0.0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema == "n" && cor.equalsIgnoreCase(produtos.getCatalogo()[i].getCor())
						&& preco == 0.0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema == "n" && cor == "n" && preco >= produtos.getCatalogo()[i].getPreco()) {
					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo())
						&& tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema()) && cor == "n" && preco == 0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo()) && tema == "n"
						&& cor.contentEquals(produtos.getCatalogo()[i].getCor()) && preco == 0.0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo()) && tema == "n" && cor == "n"
						&& preco >= produtos.getCatalogo()[i].getPreco()) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema()) && cor == "n"
						&& preco >= produtos.getCatalogo()[i].getPreco()) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema())
						&& cor.equalsIgnoreCase(produtos.getCatalogo()[i].getCor()) && preco == 0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema == "n" && cor.equalsIgnoreCase(produtos.getCatalogo()[i].getCor())
						&& preco >= produtos.getCatalogo()[i].getPreco()) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo())
						&& tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema())
						&& cor.equalsIgnoreCase(produtos.getCatalogo()[i].getCor()) && preco == 0) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo())
						&& tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema()) && cor == "n"
						&& preco >= produtos.getCatalogo()[i].getPreco()) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo()) && tema == "n"
						&& cor.equalsIgnoreCase(produtos.getCatalogo()[i].getCor())
						&& preco >= produtos.getCatalogo()[i].getPreco()) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				} else if (tipo == "n" && tema.equalsIgnoreCase(produtos.getCatalogo()[i].getTema())
						&& cor.equalsIgnoreCase(produtos.getCatalogo()[i].getCor())
						&& preco >= produtos.getCatalogo()[i].getPreco()) {

					System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor()
							+ " ," + produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco()
							+ " R$" + " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
					System.out.println("-------------------------------------------------------");
					continue;

				}

			} else {
				System.out.println(produtos.getCatalogo()[i].getTipo() + " " + produtos.getCatalogo()[i].getCor() + " ,"
						+ produtos.getCatalogo()[i].getTema() + " ," + produtos.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produtos.getCatalogo()[i].getQuant());
				System.out.println("-------------------------------------------------------");
				continue;
			}

		}
	}
}
