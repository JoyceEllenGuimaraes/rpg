package com.joyce.rpg;

public enum TipoEquipamento {
	
	ARMADURA_MALHA("COTA DE MALHA","ARMADURA", "S", 20, 0, 25),
	ARMADURA_PLACA("COURAÇA DA AURORA", "ARMADURA", "S", 30, 0, 40),
	ARMADURA_OSSOS("MURALHA DE OSSOS", "ARMADURA", "S", 50, 0, 75),
	
	ARMA_LONGA("ESPADA LONGA", "ARMA", "S", 20, 25, 0),
	ARMA_DEVORADORA("DEVORADORA DE ALMAS","ARMA", "S", 30, 40, 0),
	ARMA_ALVORADA("ALVORADA SAGRADA", "ARMA", "S", 50,75,0),;
	
	
	private final String nome;
	private final String categoria;
	private final String descricao;
	private final int valor;
	private final int bonusAtaque;
	private final int bonusDefesa;

	
	private TipoEquipamento(String nome, String categoria, String descricao, int valor, int bonusAtaque, int bonusDefesa) {
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.valor = valor;
		this.bonusAtaque = bonusAtaque;
		this.bonusDefesa = bonusDefesa;

	}
	

	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}


	public String getDescricao() {
		return descricao;
	}

	public int getValor() {
		return valor;
	}

	public int getBonusAtaque() {
		return bonusAtaque;
	}

	public int getBonusDefesa() {
		return bonusDefesa;
	}
	
}
