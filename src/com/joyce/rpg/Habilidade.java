package com.joyce.rpg;
import java.io.Serializable;
public class Habilidade implements Serializable {
	private static final long serialVersionOID = 1L;
	
	private String nome;
	private int custoMana;
	private int custoEstamina;
	private int danoTotal;
	private int cura;
	private int nivelMinimo;
	
	public Habilidade() {
		super();
	}
	
	public Habilidade(String nome, int custoMana,int custoEstamina, int danoTotal, int cura,  int nivelMinimo) {
		this.nome = nome;
		this.custoMana = custoMana;
		this.custoEstamina = custoEstamina;
		this.danoTotal = danoTotal;
		this.cura = cura;
		this.nivelMinimo = nivelMinimo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCustoMana() {
		return custoMana;
	}

	public void setCustoMana(int custoMana) {
		this.custoMana = custoMana;
	}

	public int getCustoEstamina() {
		return custoEstamina;
	}

	public void setCustoEstamina(int custoEstamina) {
		this.custoEstamina = custoEstamina;
	}

	public int getDanoTotal() {
		return danoTotal;
	}

	public void setDanoTotal(int danoTotal) {
		this.danoTotal = danoTotal;
	}

	public int getCura() {
		return cura;
	}

	public void setCura(int cura) {
		this.cura = cura;
	}

	public int getNivelMinimo() {
		return nivelMinimo;
	}

	public void setNivelMinimo(int nivelMinimo) {
		this.nivelMinimo = nivelMinimo;
	}
	
}
