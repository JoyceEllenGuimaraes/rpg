package com.joyce.rpg;

public enum TipoBoss {

	ORC(350, 40, 100),
	BRUXA(300, 80, 120),
	DRAGAO(400, 70, 150),
	NECROMANTE(270, 90, 160);

	private final int vidaBase;
	private final int forcaBase;
	private final int xpRecompensa;

	TipoBoss(int vidaBase, int forcaBase, int xpRecompensa) {
		this.vidaBase = vidaBase;
		this.forcaBase = forcaBase;
		this.xpRecompensa = xpRecompensa;
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
}
