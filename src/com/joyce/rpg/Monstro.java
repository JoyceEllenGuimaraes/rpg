package com.joyce.rpg;
import java.util.Random;

public class Monstro extends Personagem{
	private int xpRecompensa;
	private int ouroMin;
	private int ouroMax;
	private Equipamento equipamento; 
	
	public Monstro(int xpRecompensa, int ouroMin, int ouroMax, Equipamento equipamento) {
		super();
		this.xpRecompensa = xpRecompensa;
		this.ouroMin = ouroMin;
		this.ouroMax = ouroMax;
		this.equipamento = equipamento;
	}

	public Monstro(TipoMonstro tipo) {

		this.setNome(tipo.getNome());
		this.setVidaMax(tipo.getVidaBase());
		this.setVidaAtual(tipo.getVidaBase());
		this.setForca(tipo.getForcaBase());
		this.xpRecompensa = tipo.getXpRecompensa();
		this.ouroMax = tipo.getOuroMax();
		this.ouroMin = tipo.getOuroMin();
	}

	public int ouroDropado() {
		Random aleatorio = new Random();
		return aleatorio.nextInt((ouroMax - ouroMin + 1)) + ouroMin;
	}

	public Equipamento equipamentoDropado() {
		if(this.equipamento == null) {
			return null;	
		}
		if(Math.random() <= 0.3) {	
			return equipamento;
		}else {
			return null;
		}
	}

	public int getXpRecompensa() {
		return xpRecompensa;
	}

	public int getOuromin() {
		return ouroMin;
	}

	public int getOuroMax() {
		return ouroMax;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}
	
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
}
