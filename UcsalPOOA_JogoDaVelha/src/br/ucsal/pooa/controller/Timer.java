package br.ucsal.pooa.controller;

import javax.swing.JOptionPane;

public class Timer extends Thread {

	private int num = 60;

	public Timer() {
		super();
	}

	public Timer(int num) {
		super();
		this.num = num;
	}
	
	@Override
	public void run() {
		super.run();
		while (num >= 0) {
			try {
				Thread.sleep(1000);
				if (num > 10 && num % 60 == 0) {
					JOptionPane.showMessageDialog(null, "O jogo encerra em " + num + " segundos.");
				} else if (num < 10 && num % 5 == 0) {
					JOptionPane.showMessageDialog(null, "O jogo encerra em " + num + " segundos.");
				} else if (num == 0) {
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