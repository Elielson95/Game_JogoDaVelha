package br.ucsal.pooa.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Timer extends Thread {

	private int num = 60;
	private JLabel relogio;

	public Timer(JLabel relogio) {
		super();
		this.relogio = relogio;
	}

	public Timer(int num) {
		super();
		this.num = num;
	}
	
	@Override
	public void run() {
		super.run();
		while (num >= 0) {
			relogio.setText(num + " segundos");
			try {
				Thread.sleep(1000);
				if (num == 60) {
					JOptionPane.showMessageDialog(null, "O jogo encerra em " + num + " segundos.");
				} else if (num == 10) {
					JOptionPane.showMessageDialog(null, "O jogo encerra em " + num + " segundos.");
				} else if (num == 0) {
					JOptionPane.showMessageDialog(null, "Jogo encerrado.");
					System.exit(0);
				}
				num--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}