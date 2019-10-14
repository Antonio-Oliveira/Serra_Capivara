package br.com.novaroma.projeto.apresentacao;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Catalogo;
import br.com.novaroma.projeto.entidades.Produto;

public class CatalogoApresentacao {

	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);

	public static void infoPesquisa() {
		Catalogo produto = new Catalogo();
		produto.Preenchimento();
		int x;

		do {
			System.out.println("------------Digite 1 para para apresentar Catalogo completo-------");
			System.out.println("------------Digite 2 para filtrar informac�es---------------------");
			System.out.println("------------Digite 0 para sair desta op��o------------------------");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				catalogoCompleto(produto);
				continue;
			case 2:
				filtro(produto);
				continue;
			default:
				System.out.println("N�o temos essas op��es, caso deseja sair digite 0");
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
		String tipo, tema, cor;
		double precoMax, precoMin;
		int x;

		System.out.println("------------Digite 1 para filtrar o tipo---------------------------------------");
		System.out.println("------------Digite 2 para filtrar o tema---------------------------------------");
		System.out.println("------------Digite 3 para filtrar a cor----------------------------------------");
		System.out.println("------------Digite 4 para filtrar pre�o maximo---------------------------------");
		System.out.println("------------Digite 5 para filtrar pre�o m�nimo---------------------------------");
		System.out.println("------------Digite 6 para filtrar tipo e tema----------------------------------");
		System.out.println("------------Digite 7 para filtrar tipo e cor-----------------------------------");
		System.out.println("------------Digite 8 para filtrar tipo e pre�o m�ximo--------------------------");
		System.out.println("------------Digite 9 para filtrar tipo e pre�o m�nimo--------------------------");
		System.out.println("------------Digite 10 para filtrar pre�o m�ximo e pre�o m�nimo-----------------");
		System.out.println("------------Digite 11 para filtrar tema e cor----------------------------------");
		System.out.println("------------Digite 12 para filtrar tema e pre�o maximo-------------------------");
		System.out.println("------------Digite 13 para filtrar tema e pre�o m�nimo ------------------------");
		System.out.println("------------Digite 14 para filtrar cor  e pre�o maximo-------------------------");
		System.out.println("------------Digite 15 para filtrar cor e pre�o m�nimo--------------------------");
		System.out.println("------------Digite 16 para filtrar tipo, tema e cor----------------------------");
		System.out.println("------------Digite 17 para filtrar tipo, tema e pre�o maximo-------------------");
		System.out.println("------------Digite 18 para filtra tipo, tema e pre�o m�nimo--------------------");
		System.out.println("------------Digite 19 para filtrar tipo, cor e pre�o maximo--------------------");
		System.out.println("------------Digite 20 para filtrar tipo, cor e pre�o m�nimo--------------------");
		System.out.println("------------Digite 21 para filtrar tipo, pre�o m�ximo e pre�o m�nimo-----------");
		System.out.println("------------Digite 22 para filtrar tema, cor e pre�o maximo--------------------");
		System.out.println("------------Digite 23 para filtrar tema, pre�o m�ximo e pre�o m�nimo-----------");
		System.out.println("------------Digite 24 para filtrar tema, cor e pre�o m�nimo--------------------");
		System.out.println("------------Digite 25 para filtrar cor, pre�o m�ximo e pre�o m�nimo------------");
		System.out.println("------------Digite 26 para filtrar tipo, tema, cor e pre�o m�ximo--------------");
		System.out.println("------------Digite 27 para filtrar tipo, tema, cor e pre�o m�nimo--------------");
		System.out.println("------------Digite 28 para filtrar tipo, tema, pre�o m�ximo e pre�o m�nimo-----");
		System.out.println("------------Digite 29 para filtrar tipo, cor, pre�o m�ximo e pre�o m�nimo------");
		System.out.println("------------Digite 30 para filtrar tema, cor, pre�o m�ximo e pre�o m�nimo------");
		System.out.println("------------Digite 31 para filtrar tema, tipo, cor, pre�o m�ximo e pre�o m�nimo");
		System.out.println("------------Digite 0 se n�o deseja mais filtrar nada---------------------------");
		x = scanNum.nextInt();

		System.out.println("                                                                               ");
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
			System.out.println("Informe o pre�o maximo do produto: ");
			precoMax = scanNum.nextDouble();
			filtro_4(precoMax, produto);
			break;
		case 5:
			System.out.println("Informe o pre�o m�nimo do produto: ");
			precoMin = scanNum.nextDouble();
			filtro_5(precoMin, produto);
			break;
		case 6:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			filtro_6(tipo, tema, produto);
			break;
		case 7:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			filtro_7(tipo, cor, produto);
			break;
		case 8:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_8(tipo, precoMax, produto);
			break;
		case 9:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo= scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_9(tipo, precoMin, produto);
			break;
		case 10:
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_10(precoMax, precoMin, produto);
			break;
		case 11:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			filtro_11(tema, cor, produto);
			break;
		case 12:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_12(tema, precoMax, produto);
			break;
		case 13:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_13(tema, precoMin, produto);
			break;
		case 14:
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_14(cor, precoMax, produto);
			break;
		case 15:
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_15(cor, precoMin, produto);
			break;
		case 16:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			filtro_16(tipo, tema, cor, produto);
			break;
		case 17:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_17(tipo, tema, precoMax, produto);
			break;
		case 18:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_18(tipo, tema, precoMin, produto);
			break;
		case 19:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_19(tipo, cor, precoMax, produto);
			break;
		case 20:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_20(tipo, cor, precoMin, produto);
			break;
		case 21:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_21(tipo, precoMax, precoMin, produto);
			break;
		case 22:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_22(tema, cor, precoMax, produto);
			break;
		case 23:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_23(tema, precoMax, precoMin, produto);
			break;
		case 24:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_24(tema, cor, precoMin, produto);
			break;
		case 25:
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_25(cor, precoMax, precoMin, produto);
			break;
		case 26:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			filtro_26(tipo, tema, cor, precoMax, produto);
			break;
		case 27:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_27(tipo, tema, cor, precoMin, produto);
			break;
		case 28:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_28(tipo, tema, precoMax, precoMin, produto);
			break;
		case 29:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_29(tipo, cor, precoMax, precoMin, produto);
			
			break;
		case 30:
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_30(tema, cor, precoMax, precoMin, produto);
			break;
		case 31:
			System.out.println("Informe o tipo do produto que deseja: ");
			tipo = scan.nextLine();
			System.out.println("Informe o tema do produto que deseja: ");
			tema = scan.nextLine();
			System.out.println("Informe a cor do produto que deseja: ");
			cor = scan.nextLine();
			System.out.println("Informe o pre�o m�ximo do produto que deseja: ");
			precoMax = scanNum.nextDouble();
			System.out.println("Informe o pre�o m�nimo do produto que deseja: ");
			precoMin = scanNum.nextDouble();
			filtro_31(tipo, tema, cor, precoMax, precoMin, produto);
			break;

		case 0:
			break;
		default:
			System.out.println("N�o temos essa op��es, se n�o deseja mais filtrar nada digite 0");

		}

	}

	private static void filtro_2(String tema, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 

		}

	}

	private static void filtro_1(String tipo, Catalogo produto) {

		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} 
		}

	}

	private static void filtro_3(String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} 		}

	}
	

	private static void filtro_4(double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (precoMax >= produto.getCatalogo()[i].getPreco()) {

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());

			} 
		}
	}

	private static void filtro_5(double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (precoMin <= produto.getCatalogo()[i].getPreco()){

				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
		}

	}
	private static void filtro_6(String tipo, String tema, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if (tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())) {
				
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
				
			}
		}
	private static void filtro_7(String tipo, String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_8(String tipo, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_9(String tipo, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_10(double precoMax,double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(precoMax >= produto.getCatalogo()[i].getPreco()
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_11(String tema, String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_12(String tema, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_13(String tema, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_14(String cor, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	
	aaaaaaaaa;
	
	private static void filtro_15(String cor, double precoMin, Catalogo  produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_16(String tipo, String tema, String cor, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_17(String tipo, String tema, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_18(String tipo, String tema, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_19(String tipo, String cor, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_20(String tipo, String cor, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_21(String tipo, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& precoMax >= produto.getCatalogo()[i].getPreco()
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_22(String tema, String cor, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_23(String tema, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& precoMax >=produto.getCatalogo()[i].getPreco()
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_24(String tema, String cor, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_25(String cor, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >=produto.getCatalogo()[i].getPreco()
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_26(String tipo, String tema, String cor, double precoMax, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_27(String tipo, String tema, String cor, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMin <= produto.getCatalogo()[i].getPreco()) {
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_28(String tipo, String tema, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& precoMax >= produto.getCatalogo()[i].getPreco()
			        && precoMin <= produto.getCatalogo()[i].getPreco()){
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_29(String tipo, String cor, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()
			        && precoMin <= produto.getCatalogo()[i].getPreco()){
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_30(String tema, String cor, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()
			        && precoMin <= produto.getCatalogo()[i].getPreco()){
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	private static void filtro_31(String tipo, String tema, String cor, double precoMax, double precoMin, Catalogo produto) {
		for (int i = 0; i < produto.getCatalogo().length; i++) {
			if(tema.equalsIgnoreCase(produto.getCatalogo()[i].getTema())
					&& tipo.equalsIgnoreCase(produto.getCatalogo()[i].getTipo())
					&& cor.equalsIgnoreCase(produto.getCatalogo()[i].getCor())
					&& precoMax >= produto.getCatalogo()[i].getPreco()
			        && precoMin <= produto.getCatalogo()[i].getPreco()){
			
				System.out.println(produto.getCatalogo()[i].getTipo() + " " + produto.getCatalogo()[i].getCor() + " ,"
						+ produto.getCatalogo()[i].getTema() + " ," + produto.getCatalogo()[i].getPreco() + " R$"
						+ " -- quantidade em estoque " + produto.getCatalogo()[i].getQuant());
			} 
			}
		}
	
	
	
	
	
	
	
	
	
	
	}
	
	


