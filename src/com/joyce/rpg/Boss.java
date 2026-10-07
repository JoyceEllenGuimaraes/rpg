package com.joyce.rpg;
import java.util.Random;

public class Boss extends Personagem {
	private int recompensa;
	public Boss () {
		super();
	}
	public Boss(String nome, TipoBoss tipo) {
		super();
		this.setNome(nome);
		this.setClasse(tipo.name());
		this.setVidaMax(tipo.getVidaBase());
		this.setVidaAtual(tipo.getVidaBase());
		this.setForca(tipo.getForcaBase());
		this.setRecomenpensa(tipo.getXpRecompensa());
	}
	public int CalculoDeDano() {
		
		Random random = new Random();
		int danoMinimo = 5;
		return random.nextInt((this.getForca() - danoMinimo) +1) + danoMinimo;
	}
	public int getRecompensa() {
		return recompensa;
	}
	public void setRecomenpensa(int recompensa) {
		this.recompensa = recompensa;
	}
}
