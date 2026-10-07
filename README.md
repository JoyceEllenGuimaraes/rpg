## RPG de Fantasia — Java CLI
Esse projeto é um jogo de RPG em modo de texto (CLI) desenvolvido em Java 21 e focado na aplicação prática de Programação Orientada a Objetos (POO), código limpo, controle de fluxo com persistência de dados.

## Sobre o Projeto
Esse projeto simula a jornada que o usuário percorre com seu herói, escolhendo uma classe com habilidades diferentes, enfrenta dungeons geradas aleatoriamente com inimigos e chefes de andares, gerenciando ouro e inventário através de uma loja integrada.

## Principais Funcionalidades
Criação e Detalhamento de Personagens: Escolha entre 5 classes distintas (Bardo, Guerreiro, Mago, Ladino, Arqueiro), cada uma com atributos base e conjunto próprio de habilidades.

Sistema de Combate Dinâmico: Batalhas por turnos com opções de Ataque Básico, Uso de Habilidades especiais, Postura Defensiva (que também recupera uma quantidade de recursos) e uso de Itens.

A Interface Visual CLI: Barra de vida, mana e estamina em texto no console, e alguns  efeitos sonoros integrados (.wav).

A progressão é por Andares: Dungeons com salas em sequencia de combate, drops de equipamentos e moedas de ouro, terminando em batalhas estratégicas contra Bosses (Orc, Bruxa, Dragão etc...).

Inventário: Sistema de loja para compra de itens de consumo e equipamentos, protegido contra compras sem saldo e espaço e gerenciamento de inventário.

Sistema de Save (Persistência): Faz o salvamento e o carregamento do estado completo do jogador em arquivo .dat através de serialização Java (Serializable).

Tratamento de Exceções: Sistema de leitura segura com Scanner para o caso de possíveis falhas ocorridas por digitação incorreta do usuário (InputMismatchException).

## Tecnologias Utilizadas
Linguagem: Java (JDK 21+)
IDE: Eclipse IDE

Paradigma: Programação Orientada a Objetos (Herança, Polimorfismo, Encapsulamento, Enums, Abstração)

Estrutura de Dados: ArrayList, Árvores de Objetos e Enums

Persistência: Serialização Nativa do Java (ObjectInputStream)

## Arquitetura e Estrutura de Pacotes
src/
 └── com/joyce/rpg/
      ├── Main.java                # Loop principal do jogo e menus de navegação
      ├── Personagem.java          # Classe base para entidades do jogo      (Serializable)
      ├── Jogador.java             # Subclasse contendo atributos, ouro e métodos do jogador
      ├── Monstro.java             # Inimigos comuns das salas
      ├── Boss.java                # Subclasse de Monstro com lógica avançada de ataque
      ├── ClassePersonagem.java    # Enum com atributos e habilidades de cada classe
      ├── Habilidade.java          # Atributos de habilidades especiais
      ├── Inventario.java          # Gerenciamento de itens do jogador
      ├── Item.java                # Classe base de itens do jogo
      ├── Pocao.java / Equipamento # Especializações de itens
      ├── Loja.java                # Sistema de compra e validação de compras
      ├── Salvamento.java          # Gerenciador de leitura de Save (.dat)
      ├── GeradorInimigo.java      # Geração procedural de encontros por sala
      └── AudioJogo.java           # Execução de efeitos sonoros (.wav)
## Como Executar o Projeto
Pré-requisitos
Java Development Kit (JDK 21) ou superior instalado.

Eclipse IDE ou qualquer outra IDE Java.

Clone o repositório:

Bash
git clone https://github.com/JoyceEllenGuimaraes/rpg.git

## Exemplo de Execução:

=== RPG ===
1. Novo Jogo
2. Continuar Jogo Salvo
Escolha uma opção: 1

Escolha o nome do seu personagem: NEKO

------- Escolha uma das categorias a seguir ------
1. Bardo
2. Guerreiro
3. Mago
4. Ladino
5. Arqueiro
6. Ver atributos das classes
Opção escolhida: 1

=================================================
    VOCÊ ENTROU NO ANDAR 1 (3 salas)
=================================================

------------------------------------------------
HERÓI: NEKO
Vida:     ███████████████ 240/240
Mana:     ███████████████ 80/80
Estamina: ███████████████ 80/80
------------------------------------------------
INIMIGO: GOBLINS
Vida:     ███████████████ 105/105
------------------------------------------------

--- SEU TURNO ---
1. ATAQUE BÁSICO 
2. HABILIDADE ESPECIAL 
3. DEFESA
4. INVENTÁRIO 

## Autora

Desenvolvido por **Joyce Ellen Guimaraes**.

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/JoyceEllenGuimaraes)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joyce-ellen-guimaraes-ba5b22315/)
