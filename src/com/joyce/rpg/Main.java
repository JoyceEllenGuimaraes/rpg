package com.joyce.rpg;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		try {
			narrar("=== SEJA BEM VINDO A ITER PERICULOSUM ===", 20);
			narrar("\nESPERAMOS QUE SUA JORNADA SEJA TRANQUILA...", 50);
			narrar("\n1. Novo jogo", 20);
			narrar("\n2. progresso salvo", 20);
			narrar("\nEscolha uma das opções acima: ", 20);
			
			int opcaoInicial = lerOpcaoInt(leitor);
			
			Jogador jogador = null;
			
			if(opcaoInicial == 2) {
				jogador = Salvamento.carregarJogo();
			}
			
			if(jogador == null) {
				jogador = criarNovoJogador(leitor);
			}
			
			Loja loja = new Loja();
				
			narrar("\nStatus do jogador após visita na loja: ", 20);
			narrar("\nOuro restante: " + jogador.getOuro(), 20);
			narrar("\nItens no inventário " + jogador.getInventario().getItens().size(), 20);
			
			menuInventario(jogador, leitor);
			System.out.println(jogador);
			
			TipoBoss[] chefes = {TipoBoss.ORC, TipoBoss.BRUXA, TipoBoss.DRAGAO};
			boolean fase = true;
			
			while(fase && jogador.getAndarAtual() < chefes.length) {
				int numeroDoAndar = jogador.getAndarAtual()  + 1;
				TipoBoss chefeAtual = chefes[jogador.getAndarAtual()];
				
				int totalDeBatalhas = 3;
				
				narrar(jogador.getNome() + "\nVOCÊ ACABA DE ENTRAR NO ANDAR" + numeroDoAndar, 20);
				narrar("\nDA MASMORRA SOMBRIA...", 20);
				
				boolean jogadorVivo = true;
				for(int sala = 1; sala <= totalDeBatalhas; sala++) {
					List<Monstro> inimigosDaSala = GeradorInimigo.inimigosGeradoSala(sala);
					narrar("\nEntrando na sala " + sala + " logo no início você percebe monstros "
							+ " a frente: " + inimigosDaSala.size(), 20);
					narrar("\nPrepare-se ", 20);
					
					for(Monstro monstroInimigo : inimigosDaSala) {
						narrar("\nO INIMIGO VEM EM ALTA VELOCIDADE EM SUA DIREÇÃO ", 20);
						narrar("\n "+monstroInimigo.getNome(), 20);
						
						boolean venceu = executarCombate(jogador, monstroInimigo, leitor);
						if(venceu) {
							narrar("\nCom um golpe épico você derrota o " + monstroInimigo.getNome(), 20);
							jogador.ganharExperiencia(monstroInimigo.getXpRecompensa());	
							int ouroGanho = monstroInimigo.ouroDropado();
							jogador.setOuro(jogador.getOuro() + ouroGanho);
							narrar("\n" + monstroInimigo.getNome() + "deixou em moedas de ouro, o total de: " + ouroGanho, 20);
							narrar("\nQuantidade de ouro atual em seu inventário é: " + jogador.getOuro(), 20);
							Equipamento itemDropado = monstroInimigo.equipamentoDropado();
							
							if(itemDropado != null) {
								boolean guardou = jogador.getInventario().adicionarItem(itemDropado);
								if(guardou) {
									narrar("\nO item obtido foi: " + itemDropado.getNome(), 20);
								}else {
									narrar(monstroInimigo.getNome() + "\ndropou o item: " + itemDropado.getNome() + "." 
								+ " Mas seu invetário esta cheio!", 20);	
								}
							 }
							
						}else {
							narrar("\nSua visão se nubla enquanto perde suas forças pouco a pouco e"
									+ " nesse momento você percebe a vida deixando seu corpo.", 100);
							narrar("\nVocê foi derrotado por: " + monstroInimigo.getNome() + ". Na sala: " 
									+ sala, 50 );
							jogadorVivo = false;
							break;
							}
						}
						if(jogadorVivo) {
							jogador.setVidaAtual(jogador.getVidaMax());
							jogador.setManaAtual(jogador.getManaMax());
							jogador.setEstaminaAtual(jogador.getEstaminaMax());
							narrar("\nComo recompensa por seu árduo trabalho, expurgando esses seres desse mundo a deusa o abençõa restaurando seus atributos! ", 50);
							AudioJogo.tocarSom("nivel.wav");
						}
						
						if(!jogadorVivo) {
							fase = false;
							break;
						}
					}
				if(jogadorVivo) {
					narrar("UM BUFARINHEIRO CORRE EM SUA DIREÇÃO COM SUAS BUGIGANGAS", 20);
					loja.abrirLoja(jogador, leitor);
						
					narrar("\nAPÓS PERCORRER UM LONGO CAMINHO VOCÊ SE DEPARA COM UMA SALA SOMBRIA ARREPIANDO SEUS OSSOS", 50);
					narrar("\nALGO TE OBSERVA NESSE LUGAR", 50);
						
					Boss boss = new Boss(chefeAtual.name(), chefeAtual);
					boolean venceuBoss = executarCombate(jogador, boss, leitor);
						
					if(!venceuBoss) {
						narrar("\nExausto, você sucumbe.", 50);
						narrar(chefeAtual.name() + "\ncomemora sua morte pisando em seu corpo!", 50);
						fase = false;							break;
					}
					jogador.setAndarAtual(jogador.getAndarAtual() + 1);
						
					if(jogador.getAndarAtual() >= chefes.length) {
						narrar("\nA DEUSA TE PARABENIZA PELA VITORIA!", 50);
						fase = false;
					}else {							
						narrar("\nCom grande gloria passou do andar: " + numeroDoAndar + ".", 20 );
						narrar("\n1. Seguir para o próximo andar [" + chefes[jogador.getAndarAtual()].name() + "]", 20);
						narrar("\n2. Salvar progresso e Sair do jogo", 20);
						narrar("\nOpção escolhada: ", 20);
							
						int opcaoPausa = lerOpcaoInt(leitor);
						leitor.nextLine();
							
						if(opcaoPausa == 2) {
							Salvamento.salvarJogo(jogador);
							narrar("\nSeu progresso foi salvo com sucesso! Te vejo depois. ", 20);
							fase = false;
						}	
					}	
					}		
				}
						
		}catch(Exception e) {
			narrar("Ocorreu um erro inesperado! " + e.getMessage(), 20);
			e.printStackTrace();
		}
	}
		
	private static Jogador criarNovoJogador(Scanner leitor) {	
		Jogador jogador = new Jogador();
		jogador.setOuro(100);
		
		narrar("Escolha o nome do seu personagem: ", 20);
		String nomeEscolhido = leitor.nextLine();
		jogador.setNome(nomeEscolhido);
		
		boolean classeEscolhidaComSucesso = false;
		while(!classeEscolhidaComSucesso) {
			narrar("Escolha uma das classes", 20);
			narrar("\n1. Bardo " + 
			"\n2. Guerreiro " + 
			"\n3. Mago" +
			"\n4. Ladino" +
			"\n5. Arqueiro ", 20);
			narrar("\n6. Ver atributos das classes", 20);
			narrar("\nOpção escolhada: ", 20);
			
			int opcao = lerOpcaoInt(leitor);
			
			switch(opcao) {
			case 1:
				jogador.escolhaClasse(ClassePersonagem.BARDO);
				classeEscolhidaComSucesso = true;
				break;
			case 2:
				jogador.escolhaClasse(ClassePersonagem.GUERREIRO);
				classeEscolhidaComSucesso = true;
				break;
			case 3:
				jogador.escolhaClasse(ClassePersonagem.MAGO);
				classeEscolhidaComSucesso = true;
				break;
			case 4: 
				jogador.escolhaClasse(ClassePersonagem.LADINO);
				classeEscolhidaComSucesso = true;
				break;
			case 5: 
				jogador.escolhaClasse(ClassePersonagem.ARQUEIRO);
				classeEscolhidaComSucesso = true;
				break;
			case 6:
				exibirAtributosClasses();
				break;
			default:
				narrar("\nOpção inválida! Tente escolher novamente. ", 20);
				break;
			}
		}
		
		Pocao pocaoCuraPequena = new Pocao("Poção de cura pequena", RaridadePocao.COMUM,
				"Restaura 30 de HP", 15, TipoPocao.VIDA, 30);
		
		jogador.getInventario().adicionarItem(pocaoCuraPequena);
		
		return jogador;
	}
	
	// HABILIDADE.
	public static boolean menuHabilidade(Jogador jogador, Personagem inimigo, Scanner leitor) {
		Habilidade[] habilidades = jogador.getHabilidades();
		
		narrar("\n------MENU DE HABILIDADE------", 10);
		for(int i = 0; i < habilidades.length; i++) {
			narrar((i + 1) + habilidades[i].getNome() 
					+ " \nMANA: "     + habilidades[i].getCustoMana()
					+ " \nESTAMINA: " + habilidades[i].getCustoEstamina()
					+ " \nDANO: "     + habilidades[i].getDanoTotal()					
					+ " \nNÍVEL MÍNIMO PARA USO: " + habilidades[i].getNivelMinimo(), 10);
		}
		
		narrar("\n0. Voltar", 10);
		narrar("\nOpção escolhida: ",10);
		
		int escolha = lerOpcaoInt(leitor);
		
		if(escolha == 0) {
			narrar("Voltando ao menu principal", 10);
			return false;
		}
		
		if(escolha > 0 && escolha <= habilidades.length) {
			Habilidade selecionada = habilidades[escolha - 1];
			return jogador.usarHabilidade(selecionada, inimigo);
		}else {
			narrar("Opção inválida. ", 10);
			return false;
		}
	}
	
	public static boolean executarCombate(Jogador jogador, Personagem inimigo, Scanner leitor) {
		while(jogador.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
			narrar("\nHERÓI: "    + jogador.getNome(), 20);
			narrar("\nVida: "     + BarraVida(jogador.getVidaAtual(), jogador.getVidaMax(), 15), 20);
			narrar("\nMana: "     + BarraVida(jogador.getManaAtual(), jogador.getManaMax(), 15), 20);
			narrar("\nEstamina: " + BarraVida(jogador.getEstaminaAtual(), jogador.getEstaminaMax(), 15), 20);
			narrar("\nINIMIGO: "  + inimigo.getNome(), 20);
			narrar("\nVida: "     + BarraVida(inimigo.getVidaAtual(), inimigo.getVidaMax(), 15), 20);
			
			narrar("\n------SUA VEZ DE AGIR------", 20);
			narrar("\n1. LANÇAR ATAQUE BÁSICO", 20);
			narrar("\n2. HABILIDADES ESPECIAIS", 20);
			narrar("\n3. POSICIONAMENTO DEFENSIVO", 20);
			narrar("\n4. VERIFICAR ITENS DO INVENTÁRIO", 20);
			narrar("\nESCOLHA UMA DAS OPÇÕES: ", 20);
			
			int opcaoDeJogada = lerOpcaoInt(leitor);
			
			switch(opcaoDeJogada){
			case 1: 
				AudioJogo.tocarSom("ataque.wav");
				int danoCausado = jogador.getAtaqueTotal();
				inimigo.setVidaAtual(inimigo.getVidaAtual() - danoCausado);
				narrar("Golpea o" + inimigo.getNome() + "."
						+ " E causa " + danoCausado + "de dano.", 50);
				break;
			case 2: 
				boolean usouHabilidade = menuHabilidade(jogador, inimigo, leitor);
				if(!usouHabilidade) {
					continue;
				}
				AudioJogo.tocarSom("ataque.wav");
				break;
			case 3:
				AudioJogo.tocarSom("defesa.wav");
				jogador.setDefendendo(true);
				int manaRecuperada = Math.min(15,  jogador.getManaMax() - jogador.getManaAtual());
				int estaminaRecuperada = Math.min(15, jogador.getEstaminaMax() - jogador.getEstaminaAtual());
				jogador.setManaAtual(jogador.getManaAtual() + manaRecuperada);
				jogador.setEstaminaAtual(jogador.getEstaminaAtual() + estaminaRecuperada);
				narrar("\nAo acionar a habilidade você entra em postura defensiva. ", 20);
				narrar("\nRecuperação de: " + manaRecuperada + " pontos na mana. \nE"
						+ "\n Recuperação de: " + estaminaRecuperada + " pontos de estamina.", 20);
				break;
			case 4:
				boolean usouItem = menuInventario(jogador, leitor);
				if(!usouItem)
					continue;
				break;
			default:
				narrar("\nEssa opção é inválida! ", 20);
				continue;
			}
			if(inimigo.getVidaAtual() > 0) {
				narrar(inimigo.getNome() + "\nSe prepara para o ataque", 100);
				int danoInimigo = (inimigo instanceof Boss) ? ((Boss) inimigo).CalculoDeDano() : inimigo.getForca();
				int danoEfetivo;
				
				if(jogador.isDefendendo()) {
					AudioJogo.tocarSom("defesa.wav");
					danoEfetivo = Math.max(0, (danoInimigo - jogador.getDefesaTotal())/2);
					narrar("\n" + jogador.getNome() + " usou sua habilidade de bloqueio e sofreu apenas metade do dano." , 100);
					narrar("\n Dano Recebido: " + danoEfetivo, 200);
					jogador.setDefendendo(false);
				}else {
					danoEfetivo = Math.max(0,  danoInimigo - jogador.getDefesaTotal());
					narrar("\n" + inimigo.getNome() + " ataca de forma brutal, causando um dano de: " + danoEfetivo, 100);
				}
				jogador.setVidaAtual(jogador.getVidaAtual() - danoEfetivo);
				narrar("Vida do" + jogador.getNome() + " é de: " + jogador.getVidaAtual() + "/" + jogador.getVidaMax(), 100);
			}
		}
		return jogador.getVidaAtual() > 0;
	}
		//INVENTÁRIO
		public static boolean menuInventario(Jogador jogador, Scanner leitor) {
			List<Item> itens = jogador.getInventario().getItens();
			
			if(itens.isEmpty()) {
				System.out.println("\nInventário vazio. ");
				return false;
			}
			System.out.println("\n------INVENTÁRIO------");
			for(int i = 0; i < itens.size(); i ++) {
				System.out.println((i + 1) + ". " + itens.get(i).getNome());
			}
			System.out.println("0. voltar");
			System.out.println("Escolha uma opção: ");
			
			int escolha = lerOpcaoInt(leitor);
			if(escolha == 0) return false;
			
			if(escolha > 0 && escolha <= itens.size()) {
				Item itemSelecionado = itens.get(escolha - 1);
				return jogador.usarItem(itemSelecionado);
			}else {
				System.out.println("Opção inválida! ");
				return false;
			}
			
		}
		//ATRIBUTOS.
		private static void exibirAtributosClasses() {
			narrar("------ATRIBUTOS BASE DOS HÉROIS------\n", 20);
			for(ClassePersonagem classe : ClassePersonagem.values()) {
				narrar("\n" + classe.name(), 05);
				narrar("\n   -> Vida Máxima: " + classe.getVidaBase(), 20);
				narrar("\n   -> Mana Máxima: " + classe.getManaBase(), 20);
				narrar("\n   -> Estamina Máxima: " + classe.getEstaminaBase(), 20);
				narrar("\n   -> Força Base: " + classe.getForcaBase(), 20);
			}
		}
		
		//MÉTODO PARA NARRATIVA.
		public static void narrar(String mensagem, int tempoPorLetra){
			
			for(char c : mensagem.toCharArray()) {
				System.out.print(c);
				
				try {
					Thread.sleep(tempoPorLetra);
					
				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		
		//BARRA DE VIDA
		public static String BarraVida(int atual, int max, int tamanho) {
			int preenchimento = (int) (((double) atual/max) * tamanho);
			
			StringBuilder barra = new StringBuilder("[");
			
			for(int i = 0; i < tamanho; i++) {
				if(i < preenchimento) {
					barra.append('\u2588');
				}else {
					barra.append('\u2591');
				}
			}
			barra.append("]").append(atual).append("/").append(max);
			return barra.toString();
		}
		
		//MÉTODO PARA LEITURA SIMPLIFICADA DAS OPÇÕES.
		public static int lerOpcaoInt(Scanner leitor) {
			while(true) {
				try {
					int opcao = leitor.nextInt();
					leitor.nextLine();
					return opcao;
				}catch(InputMismatchException e) {
					System.out.println("opção digitada invalida. "
							+ "informe a opção apenas em números!");
					leitor.nextLine();
					System.out.println("Tente novamente: ");
				}
			}
		}
		
		//TEMPO.
		public static void tempo(int milisegundos) {
			try {
				Thread.sleep(milisegundos);
			}catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
}
