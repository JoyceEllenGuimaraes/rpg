package com.joyce.rpg;
import java.io.Serializable;

public class Pocao extends Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private TipoPocao tipo;
	private RaridadePocao raridade;
	private int quantidadeRestaurada;
	
	public Pocao(String nome, RaridadePocao raridade, String descricao, int valor, TipoPocao tipo, int quantidadeRestaurada) {
		super(nome, descricao, valor);
		this.tipo = tipo;
		this.raridade = raridade;
		this.quantidadeRestaurada = quantidadeRestaurada;
	}
	public void usar(Jogador jogador) {
		switch(tipo) {
		
		case VIDA:
			int vidaAntes = jogador.getVidaAtual();
			jogador.setVidaAtual(Math.min(jogador.getVidaMax(), jogador.getVidaAtual() + quantidadeRestaurada));
			int curaEfetiva = jogador.getVidaAtual() - vidaAntes;
			System.out.println(jogador.getNome() + " Usou " + getNome() + " e recuperou " + curaEfetiva + " de vida! ");
			break;
			
		case MANA: 
			int manaAntes = jogador.getManaAtual();
			jogador.setManaAtual(Math.min(jogador.getManaMax(), jogador.getManaAtual() + quantidadeRestaurada));
			int regeneracaoManaEfetiva = jogador.getManaAtual() - manaAntes;
			System.out.println(jogador.getNome() + " Usou " + getNome() + " e recuperou " + regeneracaoManaEfetiva + " de mana! " );
			break;
			
		case ESTAMINA:
			int estaminaAntes = jogador.getEstaminaAtual();
			jogador.setEstaminaAtual(Math.min(jogador.getEstaminaMax(), jogador.getEstaminaAtual() + quantidadeRestaurada));
			int regeneracaoEstaminaEfetiva = jogador.getEstaminaAtual() - estaminaAntes;
			System.out.println(jogador.getNome() + " Usou " + getNome() + " e recuperou " + regeneracaoEstaminaEfetiva 
					+ " de estamina! ");
			break; 		
		}
	}
	
	public TipoPocao getTipo() {
		return tipo;
	}
	
	public RaridadePocao getRaridade() {
		return raridade;
	}

	public int getQuantidadeRestaurada() {
		return quantidadeRestaurada;
	}
}
