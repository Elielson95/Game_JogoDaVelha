package br.ucsal.pooa.model;

public class JogadorBuilder {
	
	private String nome;
	private String sobrenome;
	private int idade;
	private int vez;
	private int pontuacao;
	
	public static JogadorBuilder builder() {
		return new JogadorBuilder();
	}

	public JogadorBuilder nomeJogador(String nome) {
		this.nome = nome;
		
		return this;
	}
	
	public JogadorBuilder sobreJogador(String sobrenome) {
		this.sobrenome = sobrenome;
		
		return this;
	}
	
	public JogadorBuilder idadeJogador(int idade) {
		this.idade = idade;
		
		return this;
	}
	
	public JogadorBuilder vezJogador(int vez) {
		this.vez = vez;
		
		return this;
	}
	
	public JogadorBuilder pontuacaoJogador(int pontuacao) {
		this.pontuacao = pontuacao;
		
		return this;
	}
	
	public Jogador novo() {
		return new Jogador (nome, sobrenome, idade, vez, pontuacao);
	}
}