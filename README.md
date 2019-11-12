# SnakeGame

Neste Projeto foram implementadas as seguintes funcionalidades:

- Implementado as snakes **comum** , **kitty** e **star**
- Implementado a simple fruit, bomb fruit, decrease fruit e big fruit;


# Como Jogar

1. Entre na pasta bin
2. Execute o programa (tenha um virtual machine java instalado)
3. Comandos

# Como compilar

No terminal

```javac Nomeprograma.java```

executar

```NomePrograma```
## Colisões

Caso as snakes colidam com a parede, serão levadas ao lado oposto do mapa.Snakes que colidirem com as barreiras serão levadas a morte, (exceto a kittysnake que os atravessa);

## Frutas

Frutas implementadas :

* **Simple Fruit:** Fruta comum, dá um ponto e aumenta o tamanho da cobra.
* **Bomb Fruit:** Essa fruta deve levar a morte da Snake.
* **Big Fruit:** Dá o dobro de pontos da Simple Fruit e aumenta o tamanho da cobra da mesma forma que a Simple Fruit.
* **Decrease Fruit:** Diminui o tamanho da cobra para o tamanho inicial, sem fornecer nem retirar pontos.

As frutas são geradas aleatoriamente pelo mapa de tempos em tempos.

## Pontos

Os pontos são atualizados em tempo real e mostrados quando o jogador perder.


