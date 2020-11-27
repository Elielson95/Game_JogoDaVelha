package br.ucsal.pooa.model;

public class Jogador {

	private String nome;
	private String sobrenome;
	private int idade;
	private int vez;
	private int pontuacao;

	public Jogador(String nome, String sobrenome, int idade, int vez, int pontuacao) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.vez = vez;
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getVez() {
		return vez;
	}

	public void setVez(int vez) {
		this.vez = vez;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", pontuacao=" + pontuacao
				+ "]";
	}
}