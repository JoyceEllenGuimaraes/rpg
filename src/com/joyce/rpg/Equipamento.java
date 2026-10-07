package com.joyce.rpg;

import java.io.Serializable;

public class Equipamento extends Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bonusAtaque;
	private int bonusDefesa;
	private TipoEquipamento tipo;
	
	public Equipamento(TipoEquipamento tipo) {
		super(tipo.getNome(), tipo.getDescricao(), tipo.getValor());
		this.bonusAtaque = tipo.getBonusAtaque();
		this.bonusDefesa = tipo.getBonusDefesa();
		this.tipo = tipo;
	}
	
	public boolean isArma() {
		return tipo.getCategoria().equalsIgnoreCase("ARMA");
	}
	
	public boolean isArmadura() {
		return tipo.getCategoria().equalsIgnoreCase("ARMADURA");
	}
	
	@Override
	public void usar(Jogador jogador) {
		if (this.isArma()) {
			Equipamento armaAntiga = jogador.getArmaEquipada();
			
			jogador.getInventario().removerItem(this);
			jogador.setArmaEquipada(this);
			
			if (armaAntiga != null) {
				jogador.getInventario().adicionarItem(armaAntiga);
				System.out.println(jogador.getNome() + ". desequipou: " + armaAntiga.getNome());
			}
			
			System.out.println(jogador.getNome() + " equipou: " + getNome() + ". Aumentando seu dano em: " + bonusAtaque + ".");
		} else if (this.isArmadura()) {
			Equipamento armaduraAntiga = jogador.getArmaduraEquipada();
			
			jogador.getInventario().removerItem(this);
			jogador.setArmaduraEquipada(this);
			
			if (armaduraAntiga != null) {
				jogador.getInventario().adicionarItem(armaduraAntiga);
				System.out.println(jogador.getNome() + ". desequipou: " + armaduraAntiga.getNome());
			}
			
			System.out.println(jogador.getNome() + " equipou: " + getNome() + ". Aumentando sua defesa em: " + bonusDefesa + ".");
		}
	}

	public int getBonusAtaque() {
		return bonusAtaque;
	}

	public void setBonusAtaque(int bonusAtaque) {
		this.bonusAtaque = bonusAtaque;
	}

	public int getBonusDefesa() {
		return bonusDefesa;
	}

	public void setBonusDefesa(int bonusDefesa) {
		this.bonusDefesa = bonusDefesa;
	}

	public TipoEquipamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquipamento tipo) {
		this.tipo = tipo;
	}
}