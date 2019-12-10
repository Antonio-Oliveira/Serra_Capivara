package br.com.novaroma.projeto.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.projeto.entidades.Funcionario;
import br.com.novaroma.projeto.entidades.Produto;
import br.com.novaroma.projeto.negocio.FuncionarioNegocio;
import br.com.novaroma.projeto.negocio.ProdutoNegocio;

public class FuncionarioApresentacao {
	static Scanner scan = new Scanner(System.in);
	static Scanner scanNum = new Scanner(System.in);
	private FuncionarioNegocio negocio = new FuncionarioNegocio();
	private ProdutoNegocio produtoNegocio = new ProdutoNegocio();

	public void contaLogada(Funcionario func) throws ClassNotFoundException, IOException {
		int x;

		do {
			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-56S |", "O que você deseja fazer com os PRODUTOS?");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Listar catalogo atual");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Adicionar produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Modificar produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 4, "Remover produto");
			System.out.println("\n|----------------------------------------------------------|");
			if(func.getAdm()) {
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-56S |", "O que você deseja fazer com os FUNCIONÁRIOS?");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Listar funcionários");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Adicionar funcionário");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Remover funcionário");
			System.out.println("\n|----------------------------------------------------------|");
			}
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				listarProdutos(produtoNegocio.listarProduto());
				break;
			case 2:
				Produto novoProduto = cadastrarProduto();
				System.out.println(produtoNegocio.cadastrarProduto(novoProduto));
				break;
			case 3:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o ID do produto que deseja modificar");
				System.out.println("------------------------------------------------------------");
				String id = scan.nextLine();
				Produto produto = produtoNegocio.buscaProduto(id);
				if (produto != null) {
					produto = modificarProdutos(produto);
					System.out.println(produtoNegocio.modificarProduto(produto));
				} else {
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Não existe produtos com esse ID");
					System.out.println("------------------------------------------------------------");
				}
				break;
			case 4:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o código do produto que deseja remover");
				System.out.println("------------------------------------------------------------");
				String idd = scan.nextLine();
				Produto remover = produtoNegocio.buscaProduto(idd);
				if (remover != null) {
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Deseja remover o produto abaixo");
					System.out.println("------------------------------------------------------------");
					System.out.println(remover.toString());
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Se deseja digite |Sim|, se não desejar digite|Não|");
					System.out.println("------------------------------------------------------------");
					String condicao = scan.nextLine();
					if (condicao.equalsIgnoreCase("Sim")) {
						System.out.println(produtoNegocio.removerProduto(remover));
					} else {
						System.out.println("------------------------------------------------------------");
						System.out.printf("| %-56S |\n", "Não existe produtos com esse ID");
						System.out.println("------------------------------------------------------------");
					}
				}
				break;
			case 5:
				if (func.getAdm()) {
					ArrayList<Funcionario> colecaoFuncs = negocio.listarFuncsNegocio();
					listarFuncionarios(colecaoFuncs);
				} else {
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Por favor, digite apenas números de acordo com o menu acima");
					System.out.println("------------------------------------------------------------");
				}
				break;
			case 6:
				if (func.getAdm()) {

					Funcionario novoFuncionario = adicionarFuncionario();
					System.out.println(negocio.verificarCadastro(novoFuncionario));

				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}

				break;
			case 7:
				if (func.getAdm()) {

					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Por favor, digite apenas números de acordo com o menu acima");
					System.out.println("------------------------------------------------------------");
					String cpf = scan.nextLine();
					Funcionario removerFunc = negocio.buscar(cpf);
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Deseja remover o produto abaixo?");
					System.out.println("------------------------------------------------------------");
					System.out.println(removerFunc.toString());
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Se deseja digite |Sim|, se não desejar digite|Não|");
					System.out.println("------------------------------------------------------------");
					String condicaoo = scan.nextLine();
					if (condicaoo.equalsIgnoreCase("Sim")) {
						System.out.println(negocio.verificarRemocao(removerFunc));
					}

				} else {
					System.out.println("------------------------------------------------------------");
					System.out.printf("| %-56S |\n", "Por favor, digite apenas números de acordo com o menu acima");
					System.out.println("------------------------------------------------------------");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Por favor, digite apenas números de acordo com o menu acima");
				System.out.println("------------------------------------------------------------");
				break;
			}
		} while (x != 0);
	}

	private void listarFuncionarios(ArrayList<Funcionario> colecaoFuncs) {
		for (Funcionario f : colecaoFuncs) {
			System.out.println(f.toString());
		}

	}

	private void listarProdutos(ArrayList<Produto> catalogoAtual) {
		System.out.println(
				" ____________________________________________________________________________________________________________");
		System.out.printf("| %-10S | %-40S | %-15S | %-10S | %-5S | %-11S |", "Código", "Tema", "Cor", "Tipo", "Qtd.",
				"Preço");
		System.out.println();
		System.out.println(
				"|____________|__________________________________________|_________________|____________|_______|_____________|");

		for (int i = 0, c = 1; i < catalogoAtual.size(); i++, c++) {
			System.out.printf("| %-10s | %-40s | %-15s | %-10s | %5d | R$ %-8.2f |", catalogoAtual.get(i).getId(),
					catalogoAtual.get(i).getTema(), catalogoAtual.get(i).getCor(), catalogoAtual.get(i).getTipo(),
					catalogoAtual.get(i).getQuant(), catalogoAtual.get(i).getPreco());
			System.out.println();

			if (c != catalogoAtual.size()) {
				
				System.out.println("|------------|------------------------------------------|-----------------|------------|-------|-------------|");

			}

		}

		System.out.print("|____________________________________________________________________________________________________________|");

	}

	private Produto cadastrarProduto() {
		System.out.println("____________________________________________________________");
		System.out.printf("| %-56S |", "Informe seus dados do produto");
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Tipo");
		System.out.println("........................................|");
		String tipo = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Tema");
		System.out.println("........................................|");
		String tema = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Cor");
		System.out.println("........................................|");
		String cor = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Preço");
		System.out.println("........................................|");
		long preco = scanNum.nextLong();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Código");
		System.out.println("........................................|");
		String id = scan.nextLine();
		System.out.printf("| %-15S |", "Quantidade inicial");
		System.out.println("........................................|");
		int quant = scanNum.nextInt();

		return new Produto(tipo, tema, cor, preco, id, quant);
	}

	private Produto modificarProdutos(Produto produto) {
		int x = 0;
		do {

			System.out.println("                                                                   ");
			System.out.println("OBSERVAÇÃO - O  PRODUTO SERA MODIFICADO DE ACORDO COM SUAS ESCOLHAS");
			System.out.println("              QUANDO TIVER ACABADO DE MODIFICAR DIGITE '0'         ");
			System.out.println("____________________________________________________________");
			System.out.printf("| %-12S | %-41S |", "Digite", "Ação");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 1, "Modificar o TIPO do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 2, "Modificar o TEMA do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 3, "Modificar a COR do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 4, "Modificar o PREÇO do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 5, "Modificar a QUANTIDADE do produto");
			System.out.println("\n|----------------------------------------------------------|");
			System.out.println("|----------------------------------------------------------|");
			System.out.printf("| %-12s | %-41s |", 0, "Sair desse menu");
			System.out.println("\n|__________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o tipo do produto para modificação");
				System.out.println("------------------------------------------------------------");
				produto.setTipo(scan.nextLine());
				continue;
			case 2:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o tema do produto para modificação");
				System.out.println("------------------------------------------------------------");
				produto.setTema(scan.nextLine());
				continue;

			case 3:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe a cor do produto para modificação");
				System.out.println("------------------------------------------------------------");
				produto.setCor(scan.nextLine());
				continue;
			case 4:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe o preço do produto para modificação");
				System.out.println("------------------------------------------------------------");
				produto.setPreco(scanNum.nextDouble());
				continue;
			case 5:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Informe a quantidade do produto para modificação");
				System.out.println("------------------------------------------------------------");
				produto.setQuant(scanNum.nextInt());
				continue;
			case 0:
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.printf("| %-56S |\n", "Digite apenas números de acordo com a tabela acima!");
				System.out.println("------------------------------------------------------------");
			}

		} while (x != 0);

		return produto;
	}

	private Funcionario adicionarFuncionario() {
		System.out.println("____________________________________________________________");
		System.out.printf("| %-56S |", "Informe os dados do funcionário");
		System.out.println("\n|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Nome");
		System.out.println("........................................|");
		String nome = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Idade");
		System.out.println("........................................|");
		int idade = scanNum.nextInt();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Sexo");
		System.out.println("........................................|");
		String sexo = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Nº Telefone");
		System.out.println("........................................|");
		long numTell = scanNum.nextLong();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "Email");
		System.out.println("........................................|");
		String email = scan.nextLine();
		System.out.printf("| %-15S |", "CPF");
		System.out.println("........................................|");
		String cpf = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "RG");
		System.out.println("........................................|");
		String RG = scan.nextLine();
		System.out.println("|----------------------------------------------------------|");
		System.out.printf("| %-15S |", "CTPS");
		System.out.println("........................................|");
		String CTPS = scan.nextLine();
		System.out.printf("| %-15S |", "Senha");
		System.out.println("........................................|");
		System.out.printf("| %-56S |\n", "A senha deve ter entre 8 e 15 dígitos");
		String senha = scan.nextLine();

		return new Funcionario(nome, idade, numTell, email, cpf, senha, sexo, CTPS, RG);
	}

}
