package br.com.novaroma.projeto.entidades;

public class Funcionario extends Usuario {
<<<<<<< HEAD
	private String ctps;
	private String rg;
=======
	private String CTPS;
	private String RG;
	private boolean adm = false;
>>>>>>> branch 'master' of https://github.com/Eivrens/Serra_Da_Capivara

	public Funcionario(String nome, int idade, long numTell, String email, String cpf, String senha, String sexo,
			String ctps, String rg) {
		super(nome, idade, numTell, email, cpf, senha, sexo);
		this.ctps = ctps;
		this.rg = rg;

	}
	
	public void Adm() {
		setNome("Admin");
		setEmail("admin@admin.com");
		setSenha("AdminDaSerra01");
		
	}

	public String getCtps() {
		return ctps;
	}

	public void setCTPS(String ctps) {
		ctps = ctps;
	}

	public String getRg() {
		return rg;
	}

	public void setRG(String rg) {
		rg = rg;
	}

}
