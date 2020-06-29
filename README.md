# TeleSena
Trabalho proposto pela cadeira Algoritmos e Programação: Fundamentos | Unisinos

  Silvio Santos está cansado de realizar manualmente o sorteio da Tele Sena. Desta forma, ele solicitou que fosse desenvolvido um sistema para realização dos sorteios de forma automática, bem como a conferência dos resultados e informações sobre ganhadores, valores a serem pagos e lucro com cada sorteio.

  Assim sendo, você deve implementar um sistema que seja capaz de:
    
    • Gerenciar as vendas de uma determinada edição da Tele Sena
    
    • Realizar o sorteio desta edição da Tele Sena
    
    • Gerenciar os ganhadores desta edição da Tele Sena

  Informações importantes
    • Cada Tele Sena custa R$10,00
    • Em cada Tele Sena existem 2 conjuntos de 25 números. Assim sendo, em cada Tele Sena existem duas chances de ganhar
    • Para ganhar na Tele Sena, a pessoa deve acertar os 25 números de um dos conjuntos da(s) sua(s) Tele Sena(s)
    • No sorteio da Tele Sena, são sorteados 25 números. Caso não hajam ganhadores, o sorteio continua até que pelo menos uma Tele Sena seja premiada (em qualquer um dos dois conjuntos)
    • 20 pessoas vão concorrer na Tele Sena
    • Cada pessoa pode comprar no máximo 15 Tele Senas
    • Existem apenas 300 Tele Senas disponíveis para compra, mas nem todas necessariamente precisam ser vendidas para a realização do sorteio
    • O sorteio é realizado logo que as 20 pessoas compram sua(s) Tele Sena(s)
    • Cada um dos conjuntos de números de cada Tele Sena possui 25 números aleatórios entre 1 e 60, sem repetições (ou seja, no mesmo conjunto de 25 números não podem haver números repetidos)
    • O valor do prêmio é 80% do valor total de vendas das Tele Senas. Caso haja mais de um ganhador, o prêmio é dividido igualmente entre todos os ganhadores
    • Ao final do sorteio, devem ser informados:
        
        o Números sorteados na Tele Sena
        o Quantidade de Tele Senas vendidas
        o Quantidade de ganhadores
        o Nome de cada um dos ganhadores
        o Valor do prêmio para cada ganhador
        o Valor total das Tele Senas vendidas
        o Lucro obtido pelo Silvio Santos com a Tele Sena


  Classes
No seu sistema devem existir, no mínimo, as seguintes classes:
  • TeleSena, que possui:
      o um valor de venda, que é um valor constante de R$10,00
      o dois arrays de inteiros de tamanho 25, que se referem aos dois conjuntos de números que cada Tele Sena possui (estes arrays devem ser preenchidos logo que uma Tele Sena for criada)
      o métodos que você achar serem necessários
  • Pessoa, que possui, no mínimo:
      o um nome
      o um array de Tele Senas (que são as Tele Senas que ela possui para concorrer)
      o um valor de premiação recebido pelas Tele Senas premiadas
      o métodos que você achar serem necessários
  • ControleTeleSena, que deve possui, no mínimo:
      o array de Pessoa (com 20 posições)
      o métodos necessários para gerenciar a venda de Tele Senas, gerenciar quantidade de Tele Senas vendidas, informações sobre prêmios, lucros e ganhadores
      o método para realização do sorteio da Tele Sena
      o demais métodos que você achar serem necessários
  • Principal, que possui o método main. No main, os métodos das classes anteriores devem ser chamados para que o sistema funcione conforme descrito anteriormente
  • Demais classes que você achar serem necessárias, desde que não alterem a lógica e o funcionamento do sistema conforme descrito anteriormente


Considerações adicionais
  • Para o sorteio de valores, você deve utilizar o método Math.random(). O Math.random() sorteia um valor double no intervalo [0..1[ (0 fechado e 1 aberto).
  • Você pode sortear o nome das pessoas e a quantidade de Tele Senas que cada uma delas vai comprar, desde que siga as informações descritas anteriormente sobre o funcionamento do sistema. Assim sendo, não é necessário utilizar a classe Teclado para obter informações de cada uma das pessoas.
  • Não esqueça de garantir que os valores sorteados tanto do sorteio quanto dos conjuntos das Tele Senas não contenham valores repetidos!
  • Você pode criar métodos e/ou classes adicionais para realização do trabalho
  • Mostre as informações na tela conforme forem acontecendo de forma clara, organizada e legível! Este é um dos critérios de avaliação. Para auxiliar, caso seja desejado, você pode utilizar o trecho de código abaixo para pausar o sistema por um determinado tempo:
      try {
      Thread.sleep(1000);
      } catch (Exception e) {}
  Quando o código chega no trecho acima, ele pausa o programa por 1 segundo (1000 milissegundos). Basta alterar o valor do parâmetro do sleep para aumentar ou diminuir o tempo parado. Por exemplo, com Thread.sleep(3000), o programa parará por 3 segundos, com 5000 parará por 5 segundos e assim por diante.
