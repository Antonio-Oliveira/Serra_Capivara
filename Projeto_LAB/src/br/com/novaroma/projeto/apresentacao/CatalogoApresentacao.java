package br.com.novaroma.projeto.apresentacao;

import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Catalogo;
import br.com.novaroma.projeto.entidades.Produto;

public class CatalogoApresentacao {

	static Scanner scan = new Scanner(System.in);

	public void infoPesquisa() {
		Catalogo produtos = new Catalogo();
		produtos.Preenchimento();
		char p;
		int x;

		do {
			System.out.println("------------Digite 1 para para apresentar Catalogo completo-------");
			System.out.println("------------Digite 2 para filtrar informacões---------------------");
			System.out.println("------------Digite 0 para sair desta opção------------------------");
			x = scan.nextInt();

			switch (x) {
			case 1:
				for (Produto i : produtos.getCatalogo()) {
					System.out.println("tipo:" + i.getTipo() + " ,tema: " + i.getTema() + " ,cor: " + i.getCor()
							+ " ,preço: " + i.getPreco() + "quantidade em estoque " + i.getQuant());
				}
				break;
			case 2:
				filtroApresentacao(produtos);
				break;
			default:
				System.out.println("Não temos essa opções, se deseja sair digite 0");

			}
		} while (x != 0);

	}

	private void filtroApresentacao(Catalogo produtos) {
		String tipo = null, tema = null, cor = null;
		double preco = 0;
		int x;

		do {
			System.out.println("------------Digite 1 para filtrar o tipo-----------------------");
			System.out.println("------------Digite 2 para filtrar o tema-----------------------");
			System.out.println("------------Digite 3 para filtrar a cor------------------------");
			System.out.println("------------Digite 4 para filtrar preço maximo-----------------");
			System.out.println("------------Digite 0 para sair desta opção---------------------");
			x = scan.nextInt();

			switch (x) {
			case 1:
				tipo = scan.next();
				break;
			case 2:
				tema = scan.next();
				break;
			case 3:
				cor = scan.next();
			case 4:
				preco = scan.nextInt();
			default:
				System.out.println("Não temos essa opções, se deseja sair digite 0");

			}
		} while (x != 0);
		for (int i = 0; i < produtos.getCatalogo().length; i++) {
			if (tipo.equalsIgnoreCase(produtos.getCatalogo()[1].getTipo()) && tema.equals(null) && cor.equals(null)
					&& preco == 0) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());

			} else if (tipo.equalsIgnoreCase(null) && tema.equals(produtos.getCatalogo()[i].getTema())
					&& cor.equals(null) && preco == 0) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());
			} else if (tipo.equalsIgnoreCase(null) && tema.equals(null)
					&& cor.equals(produtos.getCatalogo()[i].getCor()) && preco == 0) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());
			} else if (tipo.equalsIgnoreCase(null) && tema.equals(null) && cor.equals(null)
					&& preco == produtos.getCatalogo()[i].getPreco()) {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());
			} else {
				System.out.println("tipo " + produtos.getCatalogo()[i].getTipo() + "  tema "
						+ produtos.getCatalogo()[i].getTema() + " cor " + produtos.getCatalogo()[i].getCor() + " preço "
						+ produtos.getCatalogo()[i].getPreco());
			}

		}
	}
}
