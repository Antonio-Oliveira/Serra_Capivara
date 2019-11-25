package br.com.novaroma.projeto.entidades;

public class Funcionario extends Usuario {
	private String ctps;
	private String rg;
	private boolean adm = false;

	public Funcionario(String nome, int idade, long numTell, String email, String cpf, String senha, String sexo,
			String ctps, String rg) {
		super(nome, idade, numTell, email, cpf, senha, sexo);
		this.ctps =ctps;
		this.rg = rg;

	}
	
	public Funcionario() {
		
	}

	public void Adm() {
		setNome("Admin");
		setEmail("admin@admin.com");
		setSenha("AdminDaSerra01");
		setAdm(true);

	}

	public String getCtps() {
		return ctps;
	}

	public void setCTPS(String CTPS) {
		this.ctps = ctps;
	}

	public String getRg() {
		return rg;
	}

	public void setRG(String rg) {
		this.rg= rg;
	}

	public boolean getAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	@Override
	public String toString() {
		return "Funcionario : Nome =" + getNome() + ", Idade=" + getIdade() + ", Sexo=" + getSexo()
				+ ", Numero de telefone=" + getNumTell() + ", Email=" + getEmail() + ", Cpf()=" + getCpf() + ", RG="
				+ rg + ", CTPS=" + ctps+".";
	}
	

}
