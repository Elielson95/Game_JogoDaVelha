package br.ucsal.pooa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.ucsal.pooa.controller.RelogioLabel;
import br.ucsal.pooa.controller.Timer;
import br.ucsal.pooa.model.Jogador;
import br.ucsal.pooa.model.JogadorBuilder;

public class Tabuleiro {
	
	JogadorBuilder novoJogador1 = JogadorBuilder.builder()
			.nomeJogador(JOptionPane.showInputDialog("JEDI, informe o seu nome: "))
			//.sobreJogador(JOptionPane.showInputDialog("Sobrenome do 1º Jogador: "))
			//.idadeJogador(Integer.parseInt(JOptionPane.showInputDialog("Idade do 1º Jogador: ")))
			.vezJogador(1)
			.pontuacaoJogador(0);
			
	Jogador jg1 = novoJogador1.novo();
	
	JogadorBuilder novoJogador2 = JogadorBuilder.builder()
			.nomeJogador(JOptionPane.showInputDialog("SITH, informe o seu nome: "))
			//.sobreJogador(JOptionPane.showInputDialog("Sobrenome do 2º Jogador: "))
			//.idadeJogador(Integer.parseInt(JOptionPane.showInputDialog("Idade do 2º Jogador: ")))
			.vezJogador(2)
			.pontuacaoJogador(0);
			
	Jogador jg2 = novoJogador2.novo();
	
	int jogadorVez = jg1.getVez();
	
	Bloco[] blocos = new Bloco[9];
	Timer timed; 
		
	JPanel pTela = new JPanel(new GridLayout(3, 3, 10, 10));
	JLabel lInformacao = new JLabel("Jogador: " + jg1.getNome()/* + " " + jg1.getSobrenome() + " - " + jg1.getIdade() + " anos"*/);
	JLabel lClock = new RelogioLabel();
	
	public Tabuleiro(Mesa novo) {
		timed = new Timer(lClock);
		timed.start();
		novo.add(BorderLayout.CENTER, pTela);
		novo.add(BorderLayout.NORTH, lInformacao);
		novo.add(BorderLayout.SOUTH, lClock);
		pTela.setBackground(Color.BLACK);
		lInformacao.setFont(new Font("Arial", Font.BOLD, 20));
		lInformacao.setForeground(Color.GREEN);
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		lClock.setFont(new Font("Arial", Font.BOLD, 20));
		lClock.setForeground(Color.BLUE);
		lClock.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < 9; i++) {
			Bloco bloco = new Bloco();
			blocos[i] = bloco;
			pTela.add(bloco);
		}
		novo.setVisible(true);
		
	}
	
	ImageIcon iconJedi = new ImageIcon(getClass().getResource("/br.ucsal.pooa.images/jedi.jpg"));
	ImageIcon iconSith = new ImageIcon(getClass().getResource("/br.ucsal.pooa.images/sith.jpg"));
	int contJog = 9;
	
	public class Bloco extends JButton {
		int quem = 0;
		String vencedor = "";
		public Bloco() {
			setBackground(Color.WHITE);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (quem == 0) {
						if (jogadorVez == jg1.getVez()) {
							setIcon(iconJedi);
							if (timed.isAlive()) {
								quem = jg1.getVez();
								vencedor = jg1.getNome();
								contJog--;
							} else {
								JOptionPane.showMessageDialog(null, "Limite de tempo excedido!");
								System.exit(0);
							}
							
						} else if (jogadorVez == jg2.getVez()) {
							setIcon(iconSith);
							if (timed.isAlive()) {
								quem = jg2.getVez();
								vencedor = jg2.getNome();
								contJog--;
							} else {
								JOptionPane.showMessageDialog(null, "Limite de tempo excedido!");
								System.exit(0);
							}
						}
						
						if (testarVitoria(quem)) {
							if (quem == jg1.getVez()) {
								JOptionPane.showMessageDialog(null, "Código JEDI:\n" + 
										"Não há emoção, há paz.\r\n" + 
										"Não há ignorância, há conhecimento.\r\n" + 
										"Não há paixão, há serenidade.\r\n" + 
										"Não há caos, há harmonia.\r\n" + 
										"Não há morte, há a Força.");
							} else {
								JOptionPane.showMessageDialog(null, "Código SITH:\n" + 
										"Paz é uma mentira, só existe paixão.\r\n" + 
										"Através da paixão, ganho força.\r\n" + 
										"Através da força, ganho poder.\r\n" + 
										"Através do poder, ganho a vitória.\r\n" + 
										"Através da vitória, minhas correntes se rompem.\r\n" + 
										"A Força me libertará.\r\n");
							}
							System.exit(0);
						} else if (contJog == 0) {
							JOptionPane.showMessageDialog(null, "Ninguém venceu!");
							System.exit(0);
						}
						mudarVez();
					}
				}
			});		
		}
	}
	
	public boolean testarVitoria(int jog) {
		if (blocos[0].quem == jog && blocos[1].quem == jog && blocos[2].quem == jog ) {
			return true;
		}
		if (blocos[3].quem == jog && blocos[4].quem == jog && blocos[5].quem == jog ) {
			return true;
		}
		if (blocos[6].quem == jog && blocos[7].quem == jog && blocos[8].quem == jog ) {
			return true;
		}
		if (blocos[0].quem == jog && blocos[3].quem == jog && blocos[6].quem == jog ) {
			return true;
		}
		if (blocos[1].quem == jog && blocos[4].quem == jog && blocos[7].quem == jog ) {
			return true;
		}
		if (blocos[2].quem == jog && blocos[5].quem == jog && blocos[8].quem == jog ) {
			return true;
		}
		if (blocos[0].quem == jog && blocos[4].quem == jog && blocos[8].quem == jog ) {
			return true;
		}
		if (blocos[2].quem == jog && blocos[4].quem == jog && blocos[6].quem == jog ) {
			return true;
		}
		return false;
	}
	
	public void mudarVez() {
		if (jogadorVez == 1) {
			jogadorVez = 2;
			lInformacao.setText("Jogador: " + jg2.getNome()/* + " " + jg2.getSobrenome() + " - " + jg2.getIdade() + " anos"*/);
			lInformacao.setForeground(Color.RED);
		} else {
			jogadorVez = 1;
			lInformacao.setText("Jogador: " + jg1.getNome()/* + " " + jg1.getSobrenome() + " - " + jg1.getIdade() + " anos"*/);
			lInformacao.setForeground(Color.GREEN);
		}
	}
}