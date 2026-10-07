package com.joyce.rpg;
import java.io.Serializable;
public abstract class Personagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String classe;
	private String raca;
	private int vidaMax;
	private int vidaAtual;
	private int forca;
	private int estaminaMax;
	private int estaminaAtual;
	private int agilidade;
	private int sorte; 
	private int destreza;
	private int carisma;
	private int inteligencia;
	private int manaMax;
	private int manaAtual;
	private int defesa;
	private int ouro;
	private boolean defendendo = false;
	
	public Personagem() {}

	public Personagem(String nome, String classe, String raca, int vidaMax, int vidaAtual, int forca, 
			int estaminaMax, int estaminaAtual, int agilidade, int sorte, int destreza, int carisma, 
			int inteligencia, int manaMax, int manaAtual, int defesa, int ouro) {

		this.nome = nome;
		this.classe = classe;
		this.raca = raca;
		this.vidaMax = vidaMax;
		this.vidaAtual = vidaAtual;
		this.forca = forca;
		this.estaminaMax = estaminaMax;
		this.estaminaAtual = estaminaAtual;
		this.agilidade = agilidade;
		this.sorte = sorte;
		this.destreza = destreza;
		this.carisma = carisma;
		this.inteligencia = inteligencia;
		this.manaMax = manaMax;
		this.manaAtual = manaAtual;
		this.defesa = defesa;
		this.ouro = ouro;
	}
	
	public boolean isDefendendo() {
		return defendendo;
	}

	public void setDefendendo(boolean defendendo) {
		this.defendendo = defendendo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public int getVidaMax() {
		return vidaMax;
	}
	
	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}
	
	public int getVidaAtual() {
		return vidaAtual;
	}
	
	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getEstaminaMax() {
		return estaminaMax;
	}

	public void setEstaminaMax(int estaminaMax) {
		this.estaminaMax = estaminaMax;
	}
	
	public int getEstaminaAtual() {
		return estaminaAtual;
	}

	public void setEstaminaAtual(int estaminaAtual) {
		this.estaminaAtual = estaminaAtual;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public int getSorte() {
		return sorte;
	}

	public void setSorte(int sorte) {
		this.sorte = sorte;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getCarisma() {
		return carisma;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public int getManaMax() {
		return manaMax;
	}
	
	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	public int getManaAtual() {
		return manaAtual;
	}

	public void setManaAtual(int manaAtual) {
		this.manaAtual = manaAtual;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
	public int getOuro() {
		return ouro;
	}
	
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
}
