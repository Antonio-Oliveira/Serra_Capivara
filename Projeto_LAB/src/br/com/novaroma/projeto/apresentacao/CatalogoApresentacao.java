package br.com.novaroma.projeto.apresentacao;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Catalogo;
import br.com.novaroma.projeto.entidades.Produto;

public class CatalogoApresentacao {

	static Scanner scan = new Scanner(System.in);
	static Scanner scanInt = new Scanner(System.in);

	public static void infoPesquisa() {
		Catalogo produto = new Catalogo();
		produto.Preenchimento();
		int x;

		do {
			System.out.println("------------Digite 1 para para apresentar Catalogo completo-------");
			System.out.println("------------Digite 2 para filtrar informacões---------------------");
			System.out.println("------------Digite 0 para sair desta opção------------------------");
			x = scanInt.nextInt();

			switch (x) {
			case 1:
				catalogoCompleto(produto);
				continue;
			case 2:
				filtro(produto);
				continue;
			default:
				System.out.println("Não temos essa opções, se deseja sair digite 0");
				continue;
			}

		} while (x != 0);

	}

	private static void catalogoCompleto(Catalogo produto) {

		for (int i = 0; i < produto.getCatalogo().length; i++) {
			System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
					+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
					+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			System.out.println("----------------------------------------------------------");
		}

	}

	@SuppressWarnings("unused")
	public static void filtro(Catalogo produto) {
		String tipo = "n", tema = "n", cor = "n";
		double preco = 0;
		int x;

		System.out.println("------------Digite 1 para filtrar o tipo-----------------------");
		System.out.println("------------Digite 2 para filtrar o tema-----------------------");
		System.out.println("------------Digite 3 para filtrar a cor------------------------");
		System.out.println("------------Digite 4 para filtrar preço maximo-----------------");
		System.out.println("------------Digite 5 para filtrar tipo e tema------------------");
		System.out.println("------------Digite 6 para filtrar tipo e cor-------------------");
		System.out.println("------------Digite 7 para filtrar tipo e preço maximo----------");
		System.out.println("------------Digite 8 para filtrar tema e cor-------------------");
		System.out.println("------------Digite 9 para filtrar tema e preço maximo----------");
		System.out.println("----------- Digite 10 para filtrar cor  e preço maximo---------");
		System.out.println("------------Digite 11 para filtrar tipo, tema e cor------------");
		System.out.println("------------Digite 12 para filtrar tipo, tema e preço maximo---");
		System.out.println("------------Digite 13 para filtrar tipo, cor e preço maximo----");
		System.out.println("------------Digite 14 para filtrar tema, cor e preço maximo----");
		System.out.println("------------Digite 0 se não deseja mais filtrar nada-----------");
		x = scanInt.nextInt();

		System.out.println("                                                                ");
		switch (x) {
		case 1:
			System.out.println("Informe o tipo do produto que deseja");
			tipo = scan.nextLine();
			filtro_1(tipo, produto);
			break;
		case 2:
			System.out.println("Informe o tema do produto que deseja");
			tema = scan.nextLine();
			filtro_2(tema, produto);
			break;
		case 3:
			System.out.println("Informe a cor do produto que deseja");
			cor = scan.nextLine();
			break;
		case 4:
			System.out.println("Informe o preço maximo do produto");
			preco = scanInt.nextInt();
			break;
		case 5:

			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;

		case 0:
			break;
		default:
			System.out.println("Não temos essa opções, se não deseja mais filtrar nada digite 0");

		}

	}

	private static void filtro_2(String tema, Catalogo produto) {
		// TODO Auto-generated method stub

	}

	private static void filtro_1(String tipo, Catalogo produto) {

		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo filtrado");
			}
		}
	}

}
