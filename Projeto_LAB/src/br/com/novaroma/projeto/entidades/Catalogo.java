package br.com.novaroma.projeto.entidades;
public class Catalogo implements Buscas{
	private Produto produto[] = new Produto[2];

	public void Preenchimento() {
		produto[0] = new Produto();
		produto[0].setTipo("Copo");
		produto[0].setTema("qualquer");
		produto[0].setCor("Azul");
		produto[0].setPreco(30);
		produto[0].setCodigo("ABC123");
		produto[0].setQuant(10);

		produto[1] = new Produto();
		produto[1].setTipo("colher");
		produto[1].setTema("prata");
		produto[1].setCor("verde");
		produto[1].setPreco(5);
		produto[1].setCodigo("BBB222");
		produto[1].setQuant(2);

	}

	public void catalogoCompleto() {
		for(Produto x: getCatalogo()) {
			System.out.println("tipo:" +x.getTipo()+" ,tema: "+x.getTema()+" ,cor: "+x.getCor()+" ,preço: "+x.getPreco());
			
		}
	}
	
	public void filtro(Produto produto) {
		
		
		
	}

	public Produto[] getCatalogo() {
		return produto;
	}

}
