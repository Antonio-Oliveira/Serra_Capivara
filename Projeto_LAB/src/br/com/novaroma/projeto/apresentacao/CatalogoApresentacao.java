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

		System.out.println("------------Digite 1 para para apresentar Catalogo completo-------");
		System.out.println("------------Digite 2 para filtrar informacões---------------------");
		System.out.println("------------Digite 0 para sair desta opção------------------------");
		x = scan.nextInt();

		switch (x) {
		case 1:
			for (int i = 0; i < produtos.getCatalogo().length; i++) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());
			}
			break;
		case 2:
			filtroApresentacao(produtos);
			break;
		default:
			System.out.println("Não temos essa opções, se deseja sair digite 0");

		}

	}

	static Produto filtroApresentacao(Catalogo produtos) {
		String tipo = null, tema = null, cor = null;
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
			if (produtos.getCatalogo()[i].getTipo().equalsIgnoreCase(tipo) && tema == null && cor == null
					&& preco == 0.0) {

				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());

				System.out.println("Deseja adicionar esse produto ao carrinho de compras? sim ou não?");
				String condicao = scan.next();
				if (condicao.equalsIgnoreCase("sim")) {
					return produtos.getCatalogo()[i];
				}

			} else if (tipo == null && produtos.getCatalogo()[i].getTema().equals(tema) && cor == null
					&& preco == 0.0) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());

				System.out.println("Deseja adicionar esse produto ao carrinho de compras? sim ou não?");
				String condicao = scan.next();
				if (condicao.equalsIgnoreCase("sim")) {
					return produtos.getCatalogo()[i];
				}

			} else if (tipo == null && tema == null && cor == produtos.getCatalogo()[i].getCor() && preco == 0.0) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());

				System.out.println("Deseja adicionar esse produto ao carrinho de compras? sim ou não?");
				String condicao = scan.next();
				if (condicao.equalsIgnoreCase("sim")) {
					return produtos.getCatalogo()[i];
				}

			} else if (tipo == null && tema == null && cor == null && preco >= produtos.getCatalogo()[i].getPreco()) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());

				System.out.println("Deseja adicionar esse produto ao carrinho de compras? sim ou não?");
				String condicao = scan.next();
				if (condicao.equalsIgnoreCase("sim")) {
					return produtos.getCatalogo()[i];
				}

			} else if (tipo.equalsIgnoreCase(produtos.getCatalogo()[i].getTipo())
					&& preco == produtos.getCatalogo()[i].getPreco()
					&& produtos.getCatalogo()[i].getCor().equalsIgnoreCase(cor)
					&& tema.equals(produtos.getCatalogo()[i].getTema())) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());

				System.out.println("Deseja adicionar esse produto ao carrinho de compras? sim ou não?");
				String condicao = scan.next();
				if (condicao.equalsIgnoreCase("sim")) {
					return produtos.getCatalogo()[i];
				}

			}

		}
		return null;
	}
}
