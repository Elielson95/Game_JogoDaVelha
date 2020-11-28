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
			//.sobreJogador(JOptionPane.showInputDialog("Sobrenome do 1� Jogador: "))
			//.idadeJogador(Integer.parseInt(JOptionPane.showInputDialog("Idade do 1� Jogador: ")))
			.vezJogador(1)
			.pontuacaoJogador(0);
			
	Jogador jg1 = novoJogador1.novo();
	
	JogadorBuilder novoJogador2 = JogadorBuilder.builder()
			.nomeJogador(JOptionPane.showInputDialog("SITH, informe o seu nome: "))
			//.sobreJogador(JOptionPane.showInputDialog("Sobrenome do 2� Jogador: "))
			//.idadeJogador(Integer.parseInt(JOptionPane.showInputDialog("Idade do 2� Jogador: ")))
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
								JOptionPane.showMessageDialog(null, "C�digo JEDI:\n" + 
										"N�o h� emo��o, h� paz.\r\n" + 
										"N�o h� ignor�ncia, h� conhecimento.\r\n" + 
										"N�o h� paix�o, h� serenidade.\r\n" + 
										"N�o h� caos, h� harmonia.\r\n" + 
										"N�o h� morte, h� a For�a.");
							} else {
								JOptionPane.showMessageDialog(null, "C�digo SITH:\n" + 
										"Paz � uma mentira, s� existe paix�o.\r\n" + 
										"Atrav�s da paix�o, ganho for�a.\r\n" + 
										"Atrav�s da for�a, ganho poder.\r\n" + 
										"Atrav�s do poder, ganho a vit�ria.\r\n" + 
										"Atrav�s da vit�ria, minhas correntes se rompem.\r\n" + 
										"A For�a me libertar�.\r\n");
							}
							System.exit(0);
						} else if (contJog == 0) {
							JOptionPane.showMessageDialog(null, "Ningu�m venceu!");
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