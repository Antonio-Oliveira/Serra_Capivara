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
	private FuncionarioNegocio funcsNegocio = new FuncionarioNegocio();
	private ProdutoNegocio produtoNegocio = new ProdutoNegocio();

	public void contaLogada(Funcionario func) throws ClassNotFoundException, IOException {
		int x;

		do {

			System.out.println(" ________________________________________________________");
			System.out.println("|	   O que você deseja fazer, com os PRODUTOS?     |");
			System.out.println("|                                                        |");
			System.out.println("|(Digite 1) -- para VERIFICAR CATALOGO ATUAL             |");
			System.out.println("|(Digite 2) -- para ADICIONAR PRODUTO                    |");
			System.out.println("|(Digite 3) -- para MODIFICAR PRODUTO                    |");
			System.out.println("|(Digite 4) -- para REMOVER   PRODUTO                    |");
			if (func.getAdm()) {
				System.out.println("|	                                                 |");
				System.out.println("|	   O que você deseja fazer, com os FUNCIONARIOS? |");
				System.out.println("|(Digite 5) -- para LISTAR    FUNCIONARIOS               |");
				System.out.println("|(Digite 6) -- para ADICIONAR FUNCIONARIO                |");
				System.out.println("|(Digite 7) -- para REMOVER   FUNCIONARIO                |");
			}
			System.out.println("|                                                        |");
			System.out.println("|(Digite 0) -- para sair desse menu                      |");
			System.out.println("|________________________________________________________|");
			x = scanNum.nextInt();

			switch (x) {
			case 1:
				ArrayList<Produto> catalogo = produtoNegocio.listarProduto();
				listarProdutos(catalogo);
				break;
			case 2:
				Produto novoProduto = cadastrarProduto();
				System.out.println(produtoNegocio.cadastrarProduto(novoProduto));
				break;
			case 3:
				System.out.println("Informe o id do produto que deseja modificar");
				long id = scanNum.nextLong();
				Produto produto = produtoNegocio.modificarProduto(id);
				produto = modificarProdutos(produto);

				break;
			case 4:
				System.out.println("Informe o codigo do produto que deseja remover");
				long codigo = scanNum.nextLong();
				System.out.println(produtoNegocio.removerProduto(codigo));
				break;
			case 5:
				if (func.getAdm()) {
					listarFuncionarios();
				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}
				break;
			case 6:
				if (func.getAdm()) {

					Funcionario novoFuncionario = adicionarFuncionario();
					System.out.println(funcsNegocio.verificarCadastro(novoFuncionario));

				} else {
					System.out.println("Por favor... Digite apenas numeros de acordo com o menu acima!!!");
				}

				break;
			case 7:
				if (func.getAdm()) {

					System.out.println("Informe qual O CPF do funcionario que deseja remover");
					String cpf = scan.nextLine();
					System.out.println(funcsNegocio.verificarRemocao(cpf));

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

	private Produto modificarProdutos(Produto produto) {
		int x;
		do {
			
			
			
		}while(x!=0);

		
		
		
		
		
		
		
		return produto;
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
		long codigo = scanNum.nextInt();
		System.out.println("------ Informe a quantidade inicial ----");
		int quant = scanNum.nextInt();

		return new Produto(tipo, tema, cor, preco, codigo, quant);
	}

	private void listarProdutos(ArrayList<Produto> colecaoProduto) {

	}

	private void listarFuncionarios() throws ClassNotFoundException, IOException {
		ArrayList<Funcionario> colecaoFuncs = funcsNegocio.listarFuncsNegocio();
		for (Funcionario f : colecaoFuncs) {
			System.out.println(f.toString());
		}
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
