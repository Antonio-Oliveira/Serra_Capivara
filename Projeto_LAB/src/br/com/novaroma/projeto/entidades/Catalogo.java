package br.com.novaroma.projeto.entidades;

public class Catalogo {
	private Produto produto[] = new Produto[10];

	public void Preenchimento() {
		produto[0] = new Produto();
		produto[0].setTipo("Copo");
		produto[0].setTema("Cena do beijo");
		produto[0].setCor("Azul");
		produto[0].setPreco(35);

		produto[0].setQuant(10);

		produto[1] = new Produto();
		produto[1].setTipo("Tijela");
		produto[1].setTema("Caça");
		produto[1].setCor("Marrom");
		produto[1].setPreco(35);

		produto[1].setQuant(20);

		produto[2] = new Produto();
		produto[2].setTipo("Prato");
		produto[2].setTema("Animais");
		produto[2].setCor("Marrom");
		produto[2].setPreco(40);

		produto[2].setQuant(32);

		produto[3] = new Produto();
		produto[3].setTipo("Sopeira");
		produto[3].setTema("luta");
		produto[3].setCor("Branco");
		produto[3].setPreco(30);

		produto[3].setQuant(27);

		produto[4] = new Produto();
		produto[4].setTipo("Jarro");
		produto[4].setTema("Animais");
		produto[4].setCor("Branco");
		produto[4].setPreco(40);

		produto[4].setQuant(10);

		produto[5] = new Produto();
		produto[5].setTipo("Tijela");
		produto[5].setTema("Animais");
		produto[5].setCor("Azul");
		produto[5].setPreco(38);

		produto[5].setQuant(60);

		produto[6] = new Produto();
		produto[6].setTipo("Vazo");
		produto[6].setTema("Caça");
		produto[6].setCor("Marrom");
		produto[6].setPreco(60);

		produto[6].setQuant(5);

		produto[7] = new Produto();
		produto[7].setTipo("Copo");
		produto[7].setTema("Animais");
		produto[7].setCor("Azul");
		produto[7].setPreco(35);

		produto[7].setQuant(12);

		produto[8] = new Produto();
		produto[8].setTipo("Saladeira");
		produto[8].setTema("Animais");
		produto[8].setCor("Azul");
		produto[8].setPreco(70);

		produto[8].setQuant(16);

		produto[9] = new Produto();
		produto[9].setTipo("Tijela");
		produto[9].setTema("Cena do beijo");
		produto[9].setCor("Marrom");
		produto[9].setPreco(35);

		produto[9].setQuant(20);

	}

	public Produto[] getCatalogo() {
		return produto;
	}

}
