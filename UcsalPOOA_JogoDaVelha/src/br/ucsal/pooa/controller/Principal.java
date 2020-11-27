package br.ucsal.pooa.controller;

import br.ucsal.pooa.view.Mesa;
import br.ucsal.pooa.view.Tabuleiro;

public class Principal {
	
	public static void main(String[] args) {
			
		Tabuleiro novaMesa = Mesa.configurarMesa()
				.novoJogo();
	}
}