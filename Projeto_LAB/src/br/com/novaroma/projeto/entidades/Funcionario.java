package br.com.novaroma.projeto.entidades;

public class Funcionario extends Usuario {
	private String CTPS;
	private String RG;
	private boolean adm = false;

	public Funcionario(String nome, int idade, long numTell, String email, String cpf, String senha, String sexo,
			String CTPS, String RG) {
		super(nome, idade, numTell, email, cpf, senha, sexo);
		this.CTPS = CTPS;
		this.RG = RG;

	}

	public String getCTPS() {
		return CTPS;
	}

	public void setCTPS(String cTPS) {
		CTPS = cTPS;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public boolean getAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

}
