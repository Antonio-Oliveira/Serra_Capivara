package br.com.novaroma.projeto.entidades;
public class Catalogo{
	private Produto produto[] = new Produto[10];

	public void Preenchimento() {
		produto[0] = new Produto();
		produto[0].setTipo("Copo");
		produto[0].setTema("Cena do beijo");
		produto[0].setCor("Azul");
		produto[0].setPreco(35);
		produto[0].setCodigo("ABC123");
		produto[0].setQuant(10);

		produto[1] = new Produto();
		produto[1].setTipo("Xícara");
		produto[1].setTema("Cena de caça");
		produto[1].setCor("Verde");
		produto[1].setPreco(25);
		produto[1].setCodigo("BBB222");
		produto[1].setQuant(2);
		
		produto[2] = new Produto();
		produto[2].setTipo("Prato");
		produto[2].setTema("Animais");
		produto[2].setCor("Marrom");
		produto[2].setPreco(40);
		produto[2].setCodigo("CCC333");
		produto[2].setQuant(2);
		
		produto[3] = new Produto();
		produto[3].setTipo("Sopeira");
		produto[3].setTema("Cena de luta");
		produto[3].setCor("Branco");
		produto[3].setPreco(30);
		produto[3].setCodigo("DDD444");
		produto[3].setQuant(5);
		
		produto[4] = new Produto();
		produto[4].setTipo("Jarro");
		produto[4].setTema("Cena de dança");
		produto[4].setCor("Branco");
		produto[4].setPreco(40);
		produto[4].setCodigo("EEE555");
		produto[4].setQuant(10);
		
		produto[5] = new Produto();
		produto[5].setTipo("Tijela");
		produto[5].setTema("Animais");
		produto[5].setCor("Azul");
		produto[5].setPreco(38);
		produto[5].setCodigo("FFF666");
		produto[5].setQuant(6);
		
		produto[6] = new Produto();
		produto[6].setTipo("Vazo");
		produto[6].setTema("Caça");
		produto[6].setCor("Marrom");
		produto[6].setPreco(60);
		produto[6].setCodigo("GGG777");
		produto[6].setQuant(5);
		
		produto[7] = new Produto();
		produto[7].setTipo("Bola decorativa");
		produto[7].setTema("Animais");
		produto[7].setCor("Branco e azul");
		produto[7].setPreco(65);
		produto[7].setCodigo("HHH888");
		produto[7].setQuant(3);
		
		produto[8] = new Produto();
		produto[8].setTipo("Saladeira");
		produto[8].setTema("Cena de dança");
		produto[8].setCor("Branco");
		produto[8].setPreco(70);
		produto[8].setCodigo("III999");
		produto[8].setQuant(2);
		
		produto[9] = new Produto();
		produto[9].setTipo("Tijela funda");
		produto[9].setTema("Cena do beijo");
		produto[9].setCor("Marrom");
		produto[9].setPreco(35);
		produto[9].setCodigo("JJJ132");
		produto[9].setQuant(20);
		}
		
		




	public Produto[] getCatalogo() {
		return produto;
	}

}
