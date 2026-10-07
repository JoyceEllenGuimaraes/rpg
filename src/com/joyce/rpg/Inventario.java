package com.joyce.rpg;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventario implements Serializable{
	private static final long serialVersionOID = 1L;
	private ArrayList<Item> itens; 
	private int capacidadeMax;
	
	public Inventario(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
		this.itens = new ArrayList<>();
	}
	public boolean adicionarItem(Item item) {
		if(itens.size() < capacidadeMax) {
			itens.add(item);
			System.out.println("\uD83C\uDF92" + item.getNome() + " Foi adicionado em seu inventario! ");
			return true; 
		}else {
			System.out.println("Não é póssivel guardar " + item.getNome() + " Inventario cheio! ");
			return false;
		}
	}	
	public void removerItem(Item item) {
		itens.remove(item);
	}

	public void listarItem() {
		if(itens.isEmpty()) {
			System.out.println("\n\uD83C\uDF92 seu inventário esá vazio ");
			return;
		}

		System.out.println("---------- \uD83C\uDF92 INVENTÁRIO -----------");
		for(int i = 0; i < itens.size(); i++) {
			Item itemAtual = itens.get(i);
			System.out.println((i + 1) + ". " + itemAtual.getNome() + "-" + itemAtual.getDescricao());
		}
		System.out.println("------------------------------------------");
	}
		public ArrayList<Item> getItens() {
			return itens;
		}
		
		public int getCapacidadeMax() {
			return capacidadeMax;
		}
}
