package br.com.novaroma.projeto.apresentacao;

import br.com.novaroma.projeto.entidades.Catalogo;

public interface Filtro {

	public void filtro_1(String tipo, Catalogo produto);

	public void filtro_2(String tema, Catalogo produto);

	public void filtro_3(String cor, Catalogo produto);

	public void filtro_4(double precoMax, Catalogo produto);

	public void filtro_5(double precoMin, Catalogo produto);

	public void filtro_6(String tipo, String tema, Catalogo produto);

	public void filtro_7(String tipo, String cor, Catalogo produto);

	public void filtro_8(String tipo, double precoMax, Catalogo produto);

	public void filtro_9(String tipo, double precoMin, Catalogo produto);

	public void filtro_10(double precoMax, double precoMin, Catalogo produto);

	public void filtro_11(String tema, String cor, Catalogo produto);

	public void filtro_12(String tema, double precoMax, Catalogo produto);

	public void filtro_13(String tema, double precoMin, Catalogo produto);

	public void filtro_14(String cor, double precoMax, Catalogo produto);

	public void filtro_15(String cor, double precoMin, Catalogo produto);

	public void filtro_16(String tipo, String tema, String cor, Catalogo produto);

	public void filtro_17(String tipo, String tema, double precoMax, Catalogo produto);

	public void filtro_18(String tipo, String tema, double precoMin, Catalogo produto);

	public void filtro_19(String tipo, String cor, double precoMax, Catalogo produto);

	public  void filtro_20(String tipo, String cor, double precoMin, Catalogo produto);

	public void filtro_21(String tipo, double precoMax, double precoMin, Catalogo produto);

	public void filtro_22(String tema, String cor, double precoMax, Catalogo produto);

	public void filtro_23(String tema, double precoMax, double precoMin, Catalogo produto);

	public void filtro_24(String tema, String cor, double precoMin, Catalogo produto);

	public void filtro_25(String cor, double precoMax, double precoMin, Catalogo produto);

	public void filtro_26(String tipo, String tema, String cor, double precoMax, Catalogo produto);

	public void filtro_27(String tipo, String tema, String cor, double precoMin, Catalogo produto);

	public void filtro_28(String tipo, String tema, double precoMax, double precoMin, Catalogo produto);

	public void filtro_29(String tipo, String cor, double precoMax, double precoMin, Catalogo produto);

	public void filtro_30(String tema, String cor, double precoMax, double precoMin, Catalogo produto);

	public void filtro_31(String tipo, String tema, String cor, double precoMax, double precoMin, Catalogo produto);

}
