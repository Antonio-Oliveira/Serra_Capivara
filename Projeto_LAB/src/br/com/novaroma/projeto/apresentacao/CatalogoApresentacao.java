package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Cliente;
import br.com.novaroma.projeto.entidades.Produto;
import br.com.novaroma.projeto.negocio.ProdutoNegocio;

public class CatalogoApresentacao {

	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);
	private ArrayList<Produto> catalogo;
	private ProdutoNegocio negocio = new ProdutoNegocio();
	private Cliente cliente;
	private ArrayList<Produto> carrinho = new ArrayList<Produto>();

	public void principal(Cliente cliente) throws ClassNotFoundException, IOException {
		catalogo = negocio.listarProduto();

		this.cliente = cliente;
		int x;

		do {
			System.out.println(" ____________________________________________________________________");
			System.out.println("|           O que você deseja fazer?                                 |");
			System.out.println("|                                                                    |");
			System.out.println("|(Digite 1) -- para apresentar o catalogo completo                   |");
			System.out.println("|(Digite 2) -- para filtrar as informações do produto                |");
			if (cliente != null) {
				System.out.println("|(Digite 3) -- para acessar opcões do carrinho de compras            |");
			}
			System.out.println("|(Digite 0) -- para sair do menu                                     |");
			System.out.println("|____________________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				catalogoCompleto();
				continue;
			case 2:
				filtro();
				continue;
			case 3:
				carrinhoDeCompras();

			case 0:
				break;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				continue;
			}

		} while (x != 0);

	}

	private void carrinhoDeCompras() {
		int x;
		do {
			System.out.println(" ______________________________________________");
			System.out.println("|           O que você deseja fazer?           |");
			System.out.println("|                                              |");
			System.out.println("|(Digite 1) -- para visualizar carrinho        |");
			System.out.println("|(Digite 2) -- para remover produto            |");
			System.out.println("|(Digite 3) -- para adicionar produto          |");
			System.out.println("|(Digite 4) -- para finalizar compra           |");
			System.out.println("|                                              |");
			System.out.println("|(Digite 0) -- para sair do menu               |");
			System.out.println("|______________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				for (int i = 0; i < carrinho.size(); i++) {
					System.out.println((i + 1) + " " + carrinho.get(i).toString());
				}
				break;
			case 2:
				for (int i = 0; i < carrinho.size(); i++) {
					System.out.println((i + 1) + carrinho.get(i).toString());
				}
				System.out.println("informe o produto o numero do produto que desejua remover");
				int removerProduto = scanNum.nextInt();

				for (int i = 0; i < carrinho.size(); i++) {
					if ((removerProduto - 1) == i) {
						carrinho.remove(i);
					}
				}

				break;
			case 3:
				System.out.println(" ________________________________________________________");
				System.out.println("|          Como deseja visualizar o catalogo?            |");
				System.out.println("|                                                        |");
				System.out.println("|(Digite 1) -- para apresentar o catalogo completo       |");
				System.out.println("|(Digite 2) -- para filtrar as informações do catalogo   |");
				System.out.println("|(Digite 0) -- para sair do menu                         |");
				System.out.println("|________________________________________________________|");
				x = scanNum.nextInt();

				switch (x) {
				case 1:
					catalogoCompleto();
					break;
				case 2:
					filtro();
				case 0:
					break;
				default:
					System.out.println("Digite apenas de acordo com as opções acima!!!");
				}

				break;
			case 4:
				break;
			case 0:
				break;
			default:
				System.out.println("Digite apenas de acordo com oo menu acima!!!");

			}
		} while (x != 0);

	}

	private void catalogoCompleto() {

		System.out.println("______________________________________________________________________________________________________________");
		System.out.printf("| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", "Número", "Tema", "Cor", "Tipo", "Qtd.", "Preço");
		System.out.println();
		System.out.println("|____________|__________________________________________|_________________|____________|_______|_____________|");

		for (int i = 0; i < catalogo.size(); i++) {
			System.out.printf("| %-10s | %-40s | %-15s | %-10s | %5d | R$ %-8.2f |", (i + 1), catalogo.get(i).getTema(),
					catalogo.get(i).getCor(), catalogo.get(i).getTipo(), catalogo.get(i).getQuant(),
					catalogo.get(i).getPreco());
			System.out.println();

			if (i + 1 != catalogo.size()) {

				System.out.println("|------------|------------------------------------------|-----------------|------------|-------|-------------|");

			}

		}

		System.out.print("|____________________________________________________________________________________________________________|");

		if (cliente != null) {
			System.out.println("Deseja adicionar algum produto no carrinho de compras");
			System.out.println("Se sim digite 'Sim' se não digite'Não'");
			String condicao = scan.nextLine();

			if (condicao.equalsIgnoreCase("Sim")) {
				System.out.println("Digite o NÚMERO do produto que deseja adicionar ao carrinho");
				int numProduto = scanNum.nextInt();

				for (int i = 0; i < catalogo.size(); i++) {
					if ((numProduto - 1) == i) {
						carrinho.add(catalogo.get(i));

					}
				}
			}

		}

	}

	@SuppressWarnings("unused")
	private void filtro() {
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

		filtragem(tipo, tema, cor, precoMax, precoMin);

	}

	@SuppressWarnings("unused")
	private void filtragem(String tipo, String tema, String cor, double precoMaximo, double precoMinimo) {
		int aux = 0, cont = 1;

		System.out.println("________________________________________________________________________");
		for (int i = 0; i < catalogo.size(); i++) {
			if ((tipo.equalsIgnoreCase(catalogo.get(i).getTipo()) || tipo.equals(""))
					&& (tema.equalsIgnoreCase(catalogo.get(i).getTema()) || tema.equals(""))
					&& (cor.equalsIgnoreCase(catalogo.get(i).getCor()) || cor.equals(""))
					&& (precoMaximo >= catalogo.get(i).getPreco() || precoMaximo == 0)
					&& (precoMinimo <= catalogo.get(i).getPreco() || precoMinimo == 0)) {

				System.out.println((cont) + " - " + catalogo.get(i).getTipo() + " " + catalogo.get(i).getCor() + " ,"
						+ catalogo.get(i).getTema() + " ," + catalogo.get(i).getPreco() + " R$"
						+ " -- quantidade disponivel " + catalogo.get(i).getQuant());
				System.out.println("________________________________________________________________________");
				cont++;
				aux++;

			}
		}
		if (aux == 0) {
			System.out.println("Nenhum produto foi encontrado com essas informações");
		}
		if (cliente != null && aux != 0) {
			System.out.println("Deseja adicionar algum produto no carrinho de compras");
			System.out.println("Se sim digite 'Sim' se não digite'Não'");
			String condicao = scan.nextLine();

			if (condicao.equalsIgnoreCase("Sim")) {
				System.out.println("________________________________________________________________________");
				System.out.println("________________________________________________________________________");
				for (int i = 0; i < catalogo.size(); i++) {
					if ((tipo.equalsIgnoreCase(catalogo.get(i).getTipo()) || tipo.equals(""))
							&& (tema.equalsIgnoreCase(catalogo.get(i).getTema()) || tema.equals(""))
							&& (cor.equalsIgnoreCase(catalogo.get(i).getCor()) || cor.equals(""))
							&& (precoMaximo >= catalogo.get(i).getPreco() || precoMaximo == 0)
							&& (precoMinimo <= catalogo.get(i).getPreco() || precoMinimo == 0)) {

						System.out.println((cont) + " - " + catalogo.get(i).getTipo() + " " + catalogo.get(i).getCor()
								+ " ," + catalogo.get(i).getTema() + " ," + catalogo.get(i).getPreco() + " R$"
								+ " -- quantidade disponivel " + catalogo.get(i).getQuant());
						System.out.println("________________________________________________________________________");
						cont++;

					}
				}
				System.out.println("Digite o numero do produto que deseja adicionar ao carrinho");
				int numProduto = scanNum.nextInt();

				for (int i = 0; i < catalogo.size(); i++) {
					if ((tipo.equalsIgnoreCase(catalogo.get(i).getTipo()) || tipo.equals(""))
							&& (tema.equalsIgnoreCase(catalogo.get(i).getTema()) || tema.equals(""))
							&& (cor.equalsIgnoreCase(catalogo.get(i).getCor()) || cor.equals(""))
							&& (precoMaximo >= catalogo.get(i).getPreco() || precoMaximo == 0)
							&& (precoMinimo <= catalogo.get(i).getPreco() || precoMinimo == 0)) {

						if ((numProduto - 1) == cont) {
							carrinho.add(catalogo.get(i));
						}
						cont++;

					}
				}

			}

		}

	}

}
