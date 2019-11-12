###### Nome : Pedro Henrique Vieira de Lima
###### Mátricula : 18/0129287

# SnakeGame

Neste Projeto foram implementadas as seguintes funcionalidades:

- Implementado as snakes comum, kitty e a star.
- Implementado a simple fruit, bomb fruit, decrease fruit e big fruit.
- Implementado 2 barreiras.
- Frutas são geradas aleatoriamente pelo mapa de tempos em tempos.
- Cobras atravessam paredes.

# Requisitos para Jogar

1. Ter um Maquina virtual Java instalada

# Como Jogar

### Método 1

1. Entre na pasta **jar**
2. Execute o arquivo **SnakeGame**

Obs: Em algumas distros do linux o .jar não acessa recursos necessários. Caso ocorra, utilize o método 2.

### Método 2

1. Copie e cole a pasta **images** na pasta **bin**
2. Abra o terminal na pasta **bin**
3. Digite o comando  ```java Main```

### Método 3

1. Abrindo a **src** em alguma IDE com suporte para java

## Colisões

Caso as snakes colidam com a parede, serão levadas ao lado oposto do mapa. Snakes que colidirem com as barreiras serão levadas a morte, (exceto a kittysnake, que os atravessa).

## Pontos

Os pontos são atualizados em tempo real e mostrados durante o jogo e quando o jogador perder.

## Menu

Um menu simples com uma rapida descrição das snakes. Clickar no nome seleciona a snake e inicia o game.

