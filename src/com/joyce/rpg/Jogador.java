package com.joyce.rpg;
import java.io.Serializable;

public class Jogador extends Personagem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nivel;
	private Equipamento armaEquipada;
	private Equipamento armaduraEquipada;
	private int experiencia;
	private Inventario inventario = new Inventario(12);
	private ClassePersonagem classeEnum;
	private int andarAtual = 0;

	public Jogador() {
		this.nivel = 1;
		this.experiencia = 0;
	}

	public Jogador(String nome, String classe, String raca, int vidaMax, int vidaAtual, int forca, int estaminaMax, 
			int estaminaAtual, int agilidade, int sorte, int destreza, int carisma, int inteligencia, int manaMax, 
			int manaAtual, String habilidade, Equipamento armaEquipada, Equipamento armaduraEquipada, int experiencia,
			Inventario inventario, int defesa, int ouro) {

		super(nome, classe, raca, vidaMax, vidaAtual, forca, estaminaMax, estaminaAtual, agilidade, sorte, destreza, 
				carisma, inteligencia, manaMax, manaAtual, defesa, ouro);

		this.experiencia = experiencia;
		this.armaEquipada = armaEquipada;
		this.armaduraEquipada = armaduraEquipada;
		this.inventario = inventario;
		this.nivel = 1;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Habilidade[] getHabilidades() {
		if(this.classeEnum != null) {
			return this.classeEnum.getHabilidades();
		}
		return new Habilidade[0];
	}

	public Equipamento getArmaEquipada() {
		return armaEquipada;
	}

	public void setArmaEquipada(Equipamento armaEquipada) {
		this.armaEquipada = armaEquipada;
	}

	public Equipamento getArmaduraEquipada() {
		return armaduraEquipada;
	}

	public void setArmaduraEquipada(Equipamento armaduraEquipada) {
		this.armaduraEquipada = armaduraEquipada;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public void escolhaClasse(ClassePersonagem classeEscolhida) {
		this.setClasse(classeEscolhida.name());
		this.setVidaMax(classeEscolhida.getVidaBase());
		this.setVidaAtual(classeEscolhida.getVidaBase());
		this.setForca(classeEscolhida.getForcaBase());
		this.setEstaminaMax(classeEscolhida.getEstaminaBase());
		this.setEstaminaAtual(classeEscolhida.getEstaminaBase());
		this.setAgilidade(classeEscolhida.getAgilidadeBase());
		this.setDestreza(classeEscolhida.getDestrezaBase());
		this.setCarisma(classeEscolhida.getCarismaBase());
		this.setInteligencia(classeEscolhida.getInteligenciaBase());
		this.setManaMax(classeEscolhida.getManaBase());
		this.setManaAtual(classeEscolhida.getManaBase());	
		this.setSorte(classeEscolhida.getSorteBase());
		this.classeEnum = classeEscolhida;
	}

	public void ganharExperiencia(int xpGanho) {
		this.experiencia += xpGanho;
		System.out.println("XP total: " + this.experiencia);
		int xpNecessario = 100;
		while(this.experiencia >= xpNecessario) {
			this.experiencia -= xpNecessario;
			subirDeNivel();
		}
	}
	private void subirDeNivel() {
		AudioJogo.tocarSom("nivel.wav");
		this.nivel++;
		this.setVidaMax(this.getVidaMax() + 20);
		this.setVidaAtual(getVidaMax());
		this.setEstaminaMax(this.getEstaminaMax() + 10);
		this.setEstaminaAtual(getEstaminaMax());
		this.setManaMax(this.getManaMax() + 10);
		this.setManaAtual(getManaMax());
		this.setForca(getForca() + 10);
		System.out.println("\n--- PARABÉNS! VOCÊ SUBIU PARA O NÍVEL " + this.nivel + "! ---");
		System.out.println("Seus atributos aumentaram! Vida Máxima: " + this.getVidaMax() + " | Força: " + this.getForca() +
				"| Estamina: " + this.getEstaminaMax() + "| Mana: " + this.getManaMax());		
	}

	public boolean usarHabilidade(Habilidade habilidades, Personagem alvo) {
		if(this.nivel < habilidades.getNivelMinimo()) {
			System.out.println("Habilidade bloqueada. Nível necessario: " + habilidades.getNivelMinimo() + ".");
			return false;
		}	
		if(this.getManaAtual() >= habilidades.getCustoMana() && this.getEstaminaAtual() >= habilidades.getCustoEstamina()) {
			this.setManaAtual(this.getManaAtual() - habilidades.getCustoMana());
			this.setEstaminaAtual(this.getEstaminaAtual() - habilidades.getCustoEstamina());

			if(habilidades.getCura() > 0) {

				int vidaAntiga = this.getVidaAtual();

				int novaVida = Math.min(this.getVidaMax(), this.getVidaAtual() + habilidades.getCura());
				setVidaAtual(novaVida);

				int recuperado = this.getVidaAtual() - vidaAntiga;
				AudioJogo.tocarSom("pocao.wav");
				System.out.println(this.getNome() + " Usou " + habilidades.getNome().trim() + " e recuperou " + recuperado + " de vida.");
			}else {
				int danoCausado = habilidades.getDanoTotal() + getAtaqueTotal();
				alvo.setVidaAtual(alvo.getVidaAtual() - danoCausado);
				System.out.println(this.getNome() + " usou " + habilidades.getNome().trim() + " e deu " + danoCausado + " de dano.");
			}
			return true;	
		}else {
			System.out.println("Atributos insuficientes! ");
			return false;
		}
	}
	public int getAtaqueTotal() {	
		int ataqueTotal = getForca();

		if(armaEquipada != null) {
			ataqueTotal += armaEquipada.getBonusAtaque();	
		}
		return ataqueTotal;
	}

	public int getDefesaTotal() {
		int defesaTotal = getDefesa();

		if(armaduraEquipada != null) {
			defesaTotal += armaduraEquipada.getBonusDefesa();
		}
		if(isDefendendo()) {
			defesaTotal *= 2;
		}
		return defesaTotal;
	}
	public boolean usarItem(Item item) {
		if(item instanceof Pocao) {
			Pocao pocao = (Pocao) item;
			if (pocao.getTipo() == TipoPocao.VIDA) {

				if (this.getVidaAtual() >= this.getVidaMax()) {
					System.out.println("Sua vida já está cheia! A poção não foi usada.");
					return false;
				}
				int vidaAntiga = this.getVidaAtual();
				int novoValor = (int) (this.getVidaAtual() + pocao.getQuantidadeRestaurada());
				this.setVidaAtual(Math.min(this.getVidaMax(), novoValor));

				int recuperado = this.getVidaAtual() - vidaAntiga;

				AudioJogo.tocarSom("pocao.wav"); 
				System.out.println("Você usou a " + pocao.getNome() + " e recuperou: " + recuperado + " de vida.");
				
			}else if(pocao.getTipo() == TipoPocao.MANA) {
				if (this.getManaAtual() >= this.getManaMax()) {
					System.out.println("Sua mana já está cheia! A poção não foi usada.");
					return false; 
				}

				int manaAntiga = this.getManaAtual();
				int novoValor = (int) (this.getManaAtual() + pocao.getQuantidadeRestaurada());
				this.setManaAtual(Math.min(this.getManaMax(), novoValor));

				int recuperado = this.getManaAtual() - manaAntiga;

				AudioJogo.tocarSom("pocao.wav"); 
				System.out.println("Você usou a " + pocao.getNome() + " e recuperou " + recuperado + " de mana.");
			}	

			this.getInventario().removerItem(item);
			return true;

		}else if(item instanceof Equipamento) {

			Equipamento equipamento = (Equipamento) item;
			equiparItem(equipamento);
			return true;
		}
		System.out.println("Este item não pode ser consumido!");
		return false;
	}

	public void equiparItem(Equipamento novoEquipamento) {
		if(isArma(novoEquipamento.getTipo())) {

			if(this.armaEquipada != null) {
				this.getInventario().adicionarItem(this.armaEquipada);
				System.out.println("Você desequipou " + this.getArmaEquipada().getNome());
			}
			this.armaEquipada = novoEquipamento;
			this.getInventario().removerItem(novoEquipamento);
			System.out.println("Você equipou o item: " + this.getArmaEquipada().getNome());			

		}else if(isArmadura(novoEquipamento.getTipo())) {

			if(this.armaduraEquipada != null) {
				this.getInventario().adicionarItem(this.armaduraEquipada);
				System.out.println("Você desequipou " + this.getArmaduraEquipada().getNome());
			}

			this.armaduraEquipada = novoEquipamento;
			this.getInventario().removerItem(novoEquipamento);
			System.out.println("Você equipou " + this.getArmaduraEquipada().getNome());
		}
	}
	public boolean isArma(TipoEquipamento tipo){	
		return tipo == TipoEquipamento.ARMA_ALVORADA
				|| tipo == TipoEquipamento.ARMA_DEVORADORA
				|| tipo == TipoEquipamento.ARMA_LONGA;		
	}

	public boolean isArmadura(TipoEquipamento tipo) {
		return tipo == TipoEquipamento.ARMADURA_MALHA
				|| tipo == TipoEquipamento.ARMADURA_OSSOS
				|| tipo == TipoEquipamento.ARMADURA_PLACA;
	}
	public Inventario getInventario() {
		return inventario;
	}

	@Override
	public String toString() {
		return "\n=======================================" + 
				"\n            FICHA DO HEROI             " +
				"\n=======================================" +
				"\n Nome:     |" + getNome() +
				"\n Classe:   |" + getClasse() +
				"\n Nível:    |" + getNivel() + " | XP: " + getExperiencia() +
				"\n---------  |----------------------------" +
				"\n Vida:     | " + getVidaAtual() + "/" + getVidaMax() +
				"\n Mana:     | " + getManaAtual() + "/" + getManaMax() +
				"\n Estamina: | " + getEstaminaAtual() + "/" + getEstaminaMax() +
				"\n---------- |----------------------------" +
				"\n ATRIBUTOS:|"  +
				"\n Força:    | " + getForca() + "    | Agilidade: " + getAgilidade() +
				"\n Destreza: |"  + getDestreza() + " | Inteligência: " + getInteligencia() +
				"\n Carisma:  |"  + getCarisma() + "  | Sorte: " + getSorte() +
				"\n=======================================\n";
	}
}
