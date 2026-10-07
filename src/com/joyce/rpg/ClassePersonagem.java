package com.joyce.rpg;

public enum ClassePersonagem {	

	BARDO(240, 60, 80, 70, 60, 110, 80, 80, 80, 1, new Habilidade[]{
			new Habilidade("Alaúde Enfeitiçado", 20, 10, 15, 0, 1), 
			new Habilidade("Canto Enfurecido", 35, 15, 40, 0, 3),
			new Habilidade("Canto Reparador", 20, 10, 0, 40, 4)}), 

	GUERREIRO(270, 90, 100, 50, 60, 40, 40, 50, 50, 1, new Habilidade[]{
			new Habilidade("Frenesi", 0, 25, 20, 0, 1),
			new Habilidade("Corte Profundo", 0, 40, 35, 0, 3), 
			new Habilidade("Retaliação de aço", 20, 40, 65, 15, 5)}),

	MAGO(230, 65, 60, 60, 60, 60, 120, 120, 80, 1, new Habilidade[]{
			new Habilidade("O Contemplar do Mago", 25, 0, 20, 0, 1),
			new Habilidade("Shuryo: O Fim", 45, 15, 55, 0, 3),
			new Habilidade("Vendaval de rosas", 35, 20, 66, 7, 5 )}),   

	LADINO(250, 70, 80, 110, 90, 40, 50, 50, 90, 1, new Habilidade[]{
			new Habilidade("Sombras Saltitantes", 0, 20, 18, 0, 1),
			new Habilidade("Carniceiro", 0, 40, 32, 0, 3),
			new Habilidade("Engano da raposa", 10, 40, 60, 7, 5)}),

	ARQUEIRO(240, 60, 90, 100, 110, 40, 60, 50, 70, 1, new Habilidade[]{
			new Habilidade("Vendaval Incendiário", 10, 20, 18, 0, 1),
			new Habilidade("Tiro de Meta", 0, 35, 30, 0, 3), 
			new Habilidade("Beijo da viúva", 15, 30, 50, 10, 5)});

	private Habilidade[] habilidades;

	private final int vidaBase;
	private final int forcaBase;
	private final int estaminaBase;
	private final int agilidadeBase;
	private final int destrezaBase;
	private final int carismaBase;
	private final int inteligenciaBase;
	private final int manaBase; 
	private final int sorteBase;
	private final int nivelBase;
	
	ClassePersonagem(int vidaBase, int forcaBase, int estaminaBase, int agilidadeBase, int destrezaBase,
			int carismaBase, int inteligenciaBase, int manaBase, int sorteBase, int nivelBase, Habilidade habilidades[]) {

		this.vidaBase = vidaBase;
		this.forcaBase = forcaBase;
		this.estaminaBase = estaminaBase;
		this.agilidadeBase = agilidadeBase;
		this.destrezaBase = destrezaBase;
		this.carismaBase = carismaBase;
		this.inteligenciaBase = inteligenciaBase;
		this.manaBase = manaBase;
		this.sorteBase = sorteBase;
		this.nivelBase = nivelBase;
		this.habilidades = habilidades;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public int getForcaBase() {
		return forcaBase;
	}

	public int getEstaminaBase() {
		return estaminaBase;
	}

	public int getAgilidadeBase() {
		return agilidadeBase;
	}

	public int getDestrezaBase() {
		return destrezaBase;
	}

	public int getCarismaBase() {
		return carismaBase;
	}

	public int getInteligenciaBase() {
		return inteligenciaBase;
	}

	public int getManaBase() {
		return manaBase;
	}

	public int getSorteBase() {
		return sorteBase;
	}

	public int getNivelBase() {
		return nivelBase;
	}
	
	public Habilidade[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Habilidade[] habilidades) {
		this.habilidades = habilidades;
	}
}
