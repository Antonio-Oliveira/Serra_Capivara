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
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			filtro_1(tipo, produto);
			break;
		case 2:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			filtro_2(tema, produto);
			break;
		case 3:
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			filtro_3(cor, produto);
			break;
		case 4:
			System.out.println("Informe o preço maximo do produto: ");
			preco = scan.nextDouble();
			filtro_4(preco, produto);
			break;
		case 5:
			System.out.println("Informe o tipo e o tema que deseja: ");
			tema = scan.nextLine();
			tipo = scan.nextLine();
			filtro_5(tema, tipo, produto);
			break;
		case 6:
			System.out.println("Informe o tipo e a cor que deseja: ");
			tipo = scan.nextLine();
			cor = scan.nextLine();
			filtro_6(tipo, cor, produto);
			break;
		case 7:
			System.out.println("Informe o tipo e o preço maximo que deseja: ");
			tipo = scan.nextLine();
			preco = scan.nextDouble();
			filtro_7(tipo, preco, produto);
			break;
		case 8:
			System.out.println("Informe o tema e a cor que deseja: ");
			tema = scan.nextLine();
			cor = scan.nextLine();
			filtro_8(tema, cor, produto);
			break;
		case 9:
			System.out.println("Informe o tema e o preço máximo que deseja: ");
			tema = scan.nextLine();
			preco = scan.nextDouble();
			filtro_9(tema, preco, produto);
			break;
		case 10:
			System.out.println("Informe a cor e o preço máximo que deseja: ");
			cor = scan.nextLine();
			preco = scan.nextDouble();
			filtro_10(cor, preco, produto);
			break;
		case 11:
			System.out.println("Informe o tipo, tema e cor que deseja: ");
			tipo = scan.nextLine();
			tema = scan.nextLine();
			cor = scan.nextLine();
			filtro_11(tipo, tema, cor, produto);
			break;
		case 12:
			System.out.println("Informe o tipo, tema e preço que deseja: ");
			tipo = scan.nextLine();
			tema = scan.nextLine();
			preco = scan.nextDouble();
			filtro_12(tipo, tema, preco, produto);
			break;
		case 13:
			System.out.println("Informe o tipo, cor e preço que deseja: ");
			tipo = scan.nextLine();
			cor = scan.nextLine();
			preco = scan.nextDouble();
			filtro_13(tipo, cor, preco, produto);
			break;
		case 14:
			System.out.println("Informe o tema, cor e preço que deseja: ");
			tema = scan.nextLine();
			preco = scan.nextDouble();
			cor = scan.nextLine();
			filtro_14(tema, cor, preco, produto);
			break;

		case 0:
			break;
		default:
			System.out.println("Não temos essa opções, se não deseja mais filtrar nada digite 0");

		}

	}

	private static void filtro_2(String tema, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tema filtrado! ");
			}

		}

	}

	private static void filtro_1(String tipo, Catalogo produto) {

		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo filtrado! ");
			}
		}

	}

	private static void filtro_3(String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} else {
				System.out.println("Não foi encontrado nenhum produto com a cor filtrada! ");

			}
		}

	}
	

	private static void filtro_4(double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (preco == produto.getCatalogo()[i].getPreco()) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} else {
				System.out.println("Não foi encontrado nenhum produto com o preço máximo filtrado! ");

			}
		}
	}

	private static void filtro_5(String tema, String tipo, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo e o tema solicitados! ");
			}
		}

	}
	private static void filtro_6(String tipo, String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {
				
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo e a cor solicitados! ");
			}
				
			}
		}
	private static void filtro_7(String tipo, double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& preco == produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo e o preço solicitados! ");
			}
			}
		}
	private static void filtro_8(String tema, String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tema e a cor solicitadas! ");
			}
			}
		}
	private static void filtro_9(String tema, double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& preco == produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tema e o preço solicitados! ");
			}
			}
		}
	private static void filtro_10(String cor, double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& preco == produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o cor e o preço solicitados! ");
			}
			}
		}
	private static void filtro_11(String tipo, String tema, String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo, tema e a cor solicitados! ");
			}
			}
		}
	private static void filtro_12(String tipo, String tema, double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& preco == produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo, tema e o preço solicitados! ");
			}
			}
		}
	private static void filtro_13(String tipo, String cor, double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& preco == produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tipo, cor e o preço solicitados! ");
			}
			}
		}
	private static void filtro_14(String tema, String cor, double preco, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& preco == produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} else {
				System.out.println("Não foi encontrado nenhum produto com o tema, cor e o preço solicitados! ");
			}
			}
		}
	
	
	
	
	
	
	}
	
	


