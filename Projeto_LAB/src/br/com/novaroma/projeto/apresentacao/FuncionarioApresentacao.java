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

			System.out.println(" ________________________________________________________");
			System.out.println("|	   O que você deseja fazer, com os PRODUTOS?     |");
			System.out.println("|                                                        |");
			System.out.println("|(Digite 1) -- para LISTAR    CATALOGO ATUAL             |");
			System.out.println("|(Digite 2) -- para ADICIONAR PRODUTO                    |");
			System.out.println("|(Digite 3) -- para MODIFICAR PRODUTO                    |");
			System.out.println("|(Digite 4) -- para REMOVER   PRODUTO                    |");
			if (func.getAdm()) {
				System.out.println("|	                                                 |");
				System.out.println("|	   O que você deseja fazer, com os FUNCIONARIOS? |");
				System.out.println("|                                                        |");
				System.out.println("|(Digite 5) -- para LISTAR    FUNCIONARIOS               |");
				System.out.println("|(Digite 6) -- para ADICIONAR FUNCIONARIO                |");
				System.out.println("|(Digite 7) -- para REMOVER   FUNCIONARIO                |");
			}
			System.out.println("|                                                        |");
			System.out.println("|(Digite 0) -- para SAIR DO MENU                         |");
			System.out.println("|________________________________________________________|");
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
				System.out.println("Informe o id do produto que deseja modificar");
				String id = scan.nextLine();
				Produto produto = produtoNegocio.buscaProduto(id);
				if (produto != null) {
					produto = modificarProdutos(produto);
					System.out.println(produtoNegocio.modificarProduto(produto));
				} else {
					System.out.println("Não existe produto com determinado ID");
				}
				break;
			case 4:
				System.out.println("Informe o codigo do produto que deseja remover");
				String idd = scan.nextLine();
				Produto remover = produtoNegocio.buscaProduto(idd);
				if (remover != null) {
					System.out.println("Deseja remover tal produto abaixo");
					System.out.println(remover.toString());
					System.out.println("Se deseja digite |Sim|, se não desejar digite|Não|");
					String condicao = scan.nextLine();
					if (condicao.equalsIgnoreCase("Sim")) {
						System.out.println(produtoNegocio.removerProduto(remover));
					} else {
						System.out.println("Não existe produto com determinado ID");
					}
				}
				break;
			case 5:
				if (func.getAdm()) {
					ArrayList<Funcionario> colecaoFuncs = negocio.listarFuncsNegocio();
					listarFuncionarios(colecaoFuncs);
				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
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

					System.out.println("Informe qual O CPF do funcionario que deseja remover");
					String cpf = scan.nextLine();
					Funcionario removerFunc = negocio.buscar(cpf);
					System.out.println("Deseja remover tal produto abaixo");
					System.out.println(removerFunc.toString());
					System.out.println("Se deseja digite |Sim|, se não desejar digite|Não|");
					String condicaoo = scan.nextLine();
					if (condicaoo.equalsIgnoreCase("Sim")) {
						System.out.println(negocio.verificarRemocao(removerFunc));
					}

				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
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
		for (int i = 0; i < catalogoAtual.size(); i++) {
			System.out.println((i + 1) + " " + catalogoAtual.get(i).toString());
		}

	}

	private Produto cadastrarProduto() {
		System.out.println("------ Informe o tipo do produto -------");
		String tipo = scan.nextLine();
		System.out.println("------ Informe o tema do produto ------ ");
		String tema = scan.nextLine();
		System.out.println("------ Informe a cor do produto: -------");
		String cor = scan.nextLine();
		System.out.println("------ Informe o preço do produto: -----");
		double preco = scanNum.nextDouble();
		System.out.println("------ Informe o codigo do produto -----");
		String id = scan.nextLine();
		System.out.println("------ Informe a quantidade inicial ----");
		int quant = scanNum.nextInt();

		return new Produto(tipo, tema, cor, preco, id, quant);
	}

	private Produto modificarProdutos(Produto produto) {
		int x = 0;
		do {

			System.out.println("                                                                   ");
			System.out.println("OBSERVAÇÃO - O  PRODUTO SERA MODIFICADO DE ACORDO COM SUAS ESCOLHAS");
			System.out.println("              QUANDO TIVER ACABADO DE MODIFICAR DIGITE '0'         ");
			System.out.println(" ________________________________________________________");
			System.out.println("|                                                        |");
			System.out.println("|(Digite 1) -- para modificar o tipo  do produto         |");
			System.out.println("|(Digite 2) -- para modificar o tema  do produto         |");
			System.out.println("|(Digite 3) -- para modificar a cor   do produto         |");
			System.out.println("|(Digite 4) -- para modificar o preço do produto         |");
			System.out.println("|(Digite 5) -- para modificar a quantidade do produto    |");
			System.out.println("|(Digite 0) -- para sair do programa                     |");
			System.out.println("|________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				System.out.println("Informe o tipo do produto para modificação");
				produto.setTipo(scan.nextLine());
				continue;
			case 2:
				System.out.println("Informe o tema do produto para modificação");
				produto.setTema(scan.nextLine());
				continue;

			case 3:
				System.out.println("Informe a cor do produto para modificação");
				produto.setCor(scan.nextLine());
				continue;
			case 4:
				System.out.println("Informe o preço do produto para modificação");
				produto.setPreco(scanNum.nextDouble());
				continue;
			case 5:
				System.out.println("Informe a quantidade do produto para modificação");
				produto.setQuant(scanNum.nextInt());
				continue;
			case 0:
				break;
			default:
				System.out.println("Digite apenas numeros de acordo com a tabela acima !!!");
			}

		} while (x != 0);

		return produto;
	}

	private Funcionario adicionarFuncionario() {
		System.out.println("Informe o nome:");
		String nome = scan.nextLine();

		System.out.println("Informe a idade:");
		int idade = scanNum.nextInt();

		System.out.println("Informe o sexo:");
		String sexo = scan.nextLine();

		System.out.println("Informe um numero para contato:");
		long numTell = scanNum.nextLong();

		System.out.println("Informe o email:");
		String email = scan.nextLine();

		System.out.println("Informe o CPF:");
		String cpf = scan.nextLine();

		System.out.println("Informe a RG:");
		String RG = scan.nextLine();

		System.out.println("Informe a CTPS:");
		String CTPS = scan.nextLine();

		System.out.println("Informe a senha:");
		System.out.println("OBSERVAÇÃO!!! - maior que 8 digitos e menor que 15 digitos");
		String senha = scan.nextLine();

		return new Funcionario(nome, idade, numTell, email, cpf, senha, sexo, CTPS, RG);
	}

}
