package br.ucsal.pooa.view;

import javax.swing.JFrame;

public class Mesa extends JFrame {
	
	public Mesa() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static Mesa configurarMesa() {
		return new Mesa();
	}
	
	public Tabuleiro novoJogo() {
		return new Tabuleiro(this);
	}
}