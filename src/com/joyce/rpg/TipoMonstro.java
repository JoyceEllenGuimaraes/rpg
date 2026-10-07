package com.joyce.rpg;

public enum TipoMonstro {
	
	GOBLINS("Goblins negros", 105, 25, 25, 5, 20),
	LOBOS("Alcateia faminta", 120, 20, 19, 5, 20),
	ARANHA("Aranhas do vale", 100, 30, 29, 5, 20),
	MORTOS("Corvo-seco", 110, 45, 50, 7, 30),
	CORROMPIDOS("Acererak", 125, 60, 60, 10, 35);
	
	private final String nome;
	private final int vidaBase;
	private final int forcaBase;
	private final int xpRecompensa;
	private final int ouroMin;
	private final int ouroMax;
	
	private TipoMonstro(String nome, int vidaBase, int forcaBase, int xpRecompensa, int ouroMin, int ouroMax) {
		this.nome = nome;
		this.vidaBase = vidaBase;
		this.forcaBase = forcaBase;
		this.ouroMin = ouroMin;
		this.ouroMax = ouroMax;
		this.xpRecompensa = xpRecompensa;
	}

	public String getNome() {
		return nome;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public int getForcaBase() {
		return forcaBase;
	}

	public int getXpRecompensa() {
		return xpRecompensa;
	}
	
	public int getOuroMin() {
		return ouroMin;
	}
	public int getOuroMax() {
		return ouroMax;
	}
}
