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
			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Apresentar o catalogo completo");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Filtrar as informações do produto");
			System.out.println("\n|----------------------------------------------------------|");
			if (cliente != null) {
				System.out.println("|----------------------------------------------------------|");
				System.out.printf("| %-12s | %-41s |", 3, "Acessar opcões do carrinho de compras");
				System.out.println("\n|----------------------------------------------------------|");
				
			}
			
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
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
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Digite apenas números de acordo com o menu acima!");
				System.out.println("------------------------------------------------------------");
				continue;
			}

		} while (x != 0);

	}

	private void carrinhoDeCompras() {
		int x;
		do {
			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Visualizar carrinho");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Remover produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Adicionar produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Finalizar compra");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
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
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Informe o número do produto que deseja remover");
				System.out.println("------------------------------------------------------------");
				int removerProduto = scanNum.nextInt();

				for (int i = 0; i < carrinho.size(); i++) {
					if ((removerProduto - 1) == i) {
						carrinho.remove(i);
					}
				}

				break;
			case 3:
				System.out.println("____________________________________________________________");
				System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
				System.out.println("\n|----------------------------------------------------------|");
				System.out.printf("| %-12s | %-41s |", 1, "Apresentar catalogo completo");
				System.out.println("\n|----------------------------------------------------------|");
				System.out.printf("| %-12s | %-41s |", 2, "Filtrar as informações do catalogo");
				System.out.println("\n|----------------------------------------------------------|");
				System.out.println("|----------------------------------------------------------|");
				System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
				System.out.println("\n|__________________________________________________________|");
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
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56s |\n", "Digite apenas de acordo com as opções acima!");
					System.out.println("------------------------------------------------------------");
				}

				break;
			case 4:
				break;
			case 0:
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Digite apenas de acordo com o menu acima!");
				System.out.println("------------------------------------------------------------");

			}
		} while (x != 0);

	}

	private void catalogoCompleto() {
		System.out.println(
				"______________________________________________________________________________________________________________");
		System.out.printf("| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", "Número", "Tema", "Cor", "Tipo", "Qtd.",
				"Preço");
		System.out.println();
		System.out.println(
				"|____________|__________________________________________|_________________|____________|_______|_____________|");

		for (int i = 0; i < catalogo.size(); i++) {
			System.out.printf("| %-10s | %-40s | %-15s | %-10s | %5d | R$ %-8.2f |", (i + 1), catalogo.get(i).getTema(),
					catalogo.get(i).getCor(), catalogo.get(i).getTipo(), catalogo.get(i).getQuant(),
					catalogo.get(i).getPreco());
			System.out.println();

			if (i + 1 != catalogo.size()) {

				System.out.println(
						"|------------|------------------------------------------|-----------------|------------|-------|-------------|");

			}

		}

		System.out.print(
				"|____________________________________________________________________________________________________________|");

		if (cliente != null) {
			System.out.println("------------------------------------------------------------");
			System.out.printf("| %-56s |\n", "Deseja adicionar algum produto no carrinho de compras?");
			System.out.println("------------------------------------------------------------");
			System.out.println("Se sim digite 'Sim' se não digite'Não'");
			String condicao = scan.nextLine();

			if (condicao.equalsIgnoreCase("Sim")) {
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Digite o NÚMERO do produto que deseja colocar no carrinho");
				System.out.println("------------------------------------------------------------");
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
			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Escolher o TIPO do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Escolher o TEMA do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Escolher a COR do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 4, "Escolher o preço MÁX. do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 5, "Escolher o preço MÍN. do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
			x = scanNum.nextInt();

			System.out.println("   ");
			switch (x) {
			case 1:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o tipo do produto que deseja");
				System.out.println("------------------------------------------------------------");
				tipo = scan.next();
				continue;
			case 2:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o tema do produto que deseja");
				System.out.println("------------------------------------------------------------");
				tema = scan.next();
				continue;
			case 3:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe a cor do produto que deseja");
				System.out.println("------------------------------------------------------------");
				cor = scan.nextLine();
				continue;
			case 4:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o preço máximo do produto que deseja");
				System.out.println("------------------------------------------------------------");
				precoMax = scanNum.nextDouble();
				continue;
			case 5:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o preço mínimo do produto que deseja");
				System.out.println("------------------------------------------------------------");
				precoMin = scanNum.nextDouble();
				continue;
			case 0:
				continue;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Não temos essas opções, se deseja sair, digite '0'");
				System.out.println("------------------------------------------------------------");
			}

		} while (x != 0);

		filtragem(tipo, tema, cor, precoMax, precoMin);

	}

	@SuppressWarnings("unused")
	private void filtragem(String tipo, String tema, String cor, double precoMaximo, double precoMinimo) {
		int aux = 0, cont = 1;

		System.out.println(
				"______________________________________________________________________________________________________________");
		for (int i = 0; i < catalogo.size(); i++) {
			if ((tipo.equalsIgnoreCase(catalogo.get(i).getTipo()) || tipo.equals(""))
					&& (tema.equalsIgnoreCase(catalogo.get(i).getTema()) || tema.equals(""))
					&& (cor.equalsIgnoreCase(catalogo.get(i).getCor()) || cor.equals(""))
					&& (precoMaximo >= catalogo.get(i).getPreco() || precoMaximo == 0)
					&& (precoMinimo <= catalogo.get(i).getPreco() || precoMinimo == 0)) {

				System.out.printf("| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", "Número", "Tema", "Cor", "Tipo",
						"Qtd.", "Preço");
				System.out.println();
				System.out.println(
						"|____________|__________________________________________|_________________|____________|_______|_____________|");

				for (int j = 0; i < catalogo.size(); j++) {
					System.out.printf("| %-10s | %-40s | %-15s | %-10s | %5d | R$ %-8.2f |", (cont),
							catalogo.get(i).getTema(), catalogo.get(i).getCor(), catalogo.get(i).getTipo(),
							catalogo.get(i).getQuant(), catalogo.get(i).getPreco());
					System.out.println();

					if (i + 1 != catalogo.size()) {

						System.out.println(
								"|------------|------------------------------------------|-----------------|------------|-------|-------------|");

					}

				}

				System.out.print(
						"|____________________________________________________________________________________________________________|");
				cont++;
				aux++;

			}
		}
		if (aux == 0) {
			System.out.println("------------------------------------------------------------");
			System.out.printf("| %-56s |\n", "Nenhum produto foi encontrado com essas informações");
			System.out.println("------------------------------------------------------------");
		}
		if (cliente != null && aux != 0) {
			System.out.println("Deseja adicionar algum produto no carrinho de compras");
			System.out.println("Se sim digite 'Sim' se não digite'Não'");
			String condicao = scan.nextLine();

			if (condicao.equalsIgnoreCase("Sim")) {
				
				System.out.println(
						"______________________________________________________________________________________________________________");
				for (int i = 0; i < catalogo.size(); i++) {
					if ((tipo.equalsIgnoreCase(catalogo.get(i).getTipo()) || tipo.equals(""))
							&& (tema.equalsIgnoreCase(catalogo.get(i).getTema()) || tema.equals(""))
							&& (cor.equalsIgnoreCase(catalogo.get(i).getCor()) || cor.equals(""))
							&& (precoMaximo >= catalogo.get(i).getPreco() || precoMaximo == 0)
							&& (precoMinimo <= catalogo.get(i).getPreco() || precoMinimo == 0)) {

						System.out.printf("| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", "Número", "Tema", "Cor", "Tipo",
								"Qtd.", "Preço");
						System.out.println();
						System.out.println(
								"|____________|__________________________________________|_________________|____________|_______|_____________|");

						for (int j = 0; i < catalogo.size(); j++) {
							System.out.printf("| %-10s | %-40s | %-15s | %-10s | %5d | R$ %-8.2f |", (cont),
									catalogo.get(i).getTema(), catalogo.get(i).getCor(), catalogo.get(i).getTipo(),
									catalogo.get(i).getQuant(), catalogo.get(i).getPreco());
							System.out.println();

							if (i + 1 != catalogo.size()) {

								System.out.println(
										"|------------|------------------------------------------|-----------------|------------|-------|-------------|");

							}

						}

						System.out.print(
								"|____________________________________________________________________________________________________________|");
						cont++;

					}
				}
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56s |\n", "Digite o número do produto que deseja adicionar ao carrinho");
				System.out.println("------------------------------------------------------------");
				int numProduto = scanNum.nextInt();

				for (int i = 0; i < catalogo.size(); i++) {
					if ((tipo.equalsIgnoreCase(catalogo.get(i).getTipo()) || tipo.equals(""))
							&& (tema.equalsIgnoreCase(catalogo.get(i).getTema()) || tema.equals(""))
							&& (cor.equalsIgnoreCase(catalogo.get(i).getCor()) || cor.equals(""))
							&& (precoMaximo >= catalogo.get(i).getPreco() || precoMaximo == 0)
							&& (precoMinimo <= catalogo.get(i).getPreco() || precoMinimo == 0)) {

						if ((numProduto - 1) == cont) {
							System.out.println("------------------------------------------------------------");
							System.out.printf("| %-56S |\n", carrinho.add(catalogo.get(i)));
							System.out.println("------------------------------------------------------------");
						}
						cont++;

					}
				}

			}

		}

	}

}
