
public class ControleTeleSena
{
    private Pessoa[] participantes; 
    private int qtddParticipantes; 
    private int qtddVendida;
    private double valorTotalVendas;
    private double valorPremio;
    private double lucro;
    static int[] numerosSorteados;
    static int quantGanhador;
    static boolean achouGanhador;
    
    public ControleTeleSena()
    {
        participantes = new Pessoa[20];
        this.qtddVendida = 0;
        this.valorTotalVendas = 0;
        this.valorPremio = 0;
        this.lucro = 0;
        
    }
    
    public Pessoa[] getParticipantes()
    {
        return this.participantes;
    }
    
    public int getQtdVendida()
    {
        return this.qtddVendida;
    }
    
    public double getValorTotalVendas()
    {
        return this.valorTotalVendas;
    }
    
    public double getValorPremio()
    {
        return this.valorPremio;
    }
    
    public double getLucro()
    {
        return this.lucro;
    }
    
    //método que aumenta a quantidade de tele senas vendidas
    public void AumentaQtddVendida(Pessoa p1)
    {
        this.qtddVendida += p1.getTeleSenasCompradas().length;
    }
    
    public void CalculaValorTotalVendas()
    {
        valorTotalVendas = qtddVendida * 10.00;
    }
    
    public void CalculaPremio()
    {
        this.valorPremio = valorTotalVendas * 0.8;
    }
    
    public void CalculaLucro()
    {
        this.lucro = valorTotalVendas - this.valorPremio;
    }
    
    //insere as pessoas no array de participantes
    public void InserePessoa(Pessoa p) 
    {
        participantes[qtddParticipantes] = p;
        qtddParticipantes++;
    }
    
    //Método que imprime informacoes adicionais
    public void ImprimirInformacoes()
    {
    	System.out.println("\n +---------------- INFORMAÇOES ADICIONAIS ---------------+");
    	System.out.println("|---------------------------------------------------------|");
        System.out.printf("|\t%10s\t%20s", "* VALOR TOTAL VENDAS: R$" +  this.valorTotalVendas, "|\n");
        System.out.printf("|\t%10s\t%12s", "* QUANTIDADE VENDIDAS: " +  this.qtddVendida + " Tele Senas", "|\n");
        System.out.printf("|\t%10s\t%20s", "* VALOR DO PREMIO: R$" +  this.valorPremio, "|\n");
        System.out.printf("|\t%8s\t%28s", "* VALOR LUCRO: R$" +  this.lucro, "|\n");
        System.out.println(" ---------------------------------------------------------");

        
    }
    
    //Método que faz o sorteio dos numeros premiados, gerando os 60 numeros e conferindo se não existe nenhum repetido
      public static void GeraNumerosSorteados(int[] numerosSorteados)
    {
    	
    	int i = 0;
        while (i < 60) {
        numerosSorteados[i] = (int) ((Math.random() * 60) + 1);
        boolean colide = false;
        for (int j = 0; j < i; j++) {
            if (numerosSorteados[i] == numerosSorteados[j]) {
                colide = true;
                break;
            }
        }
        if (!colide) {
            i++;
        }
       }
    
	}
    
    /* MÉTODO QUE VERIFICA QUEM É O GANHADOR DA TELE SENA.
     * Enquanto a variável achou ganhador for false, ele irá rodar alguns 'for' para comparar cada conjunto de tele sena de cada participante
     * com os numeros sorteados. Inicialmente ira percorrer apenas 25 primeiros numeros sorteados, caso nenhum ganhador seja encontrado, irá 
     * incrementar a variável "quantVezesTentadas" para entao poder percorrer os 26 numeros e assim por diante.
     * 
     * Ele ainda exibe uma mensagem caso não tenha encontrado nenhum ganhador, e mostra os outros numeros sorteados
     */
    public Pessoa[] verificaGanhardor() 
    {
    	int imprimirErro = 1; //variavel auxiliar para imprimir a mensagem "NÃO ENCONTRAMOS NENHUM GANHADOR!..." apenas uma vez.
    	Pessoa[] ganhadores = new Pessoa[20]; // array de pessoa que armazena os ganhadores
    	achouGanhador = false; // continua rodando o codigo enquanto não houver ganhador (true)
    	int quantVezesTentadas = 0; //  variavel auxiliar para guardar o numero de vezes tentadas, e ir aumentando a quantidade de necessaria de numeros sorteados percorridos
    	
    	while (!achouGanhador) {
    		for (Pessoa p : participantes) {
    			int acertos = 0;
    			for (TeleSena ts : p.getTeleSenasCompradas()) {
    				acertos = 0;
    				for (int n : ts.getConjunto1()) { // for para percorrer o conjunto 1 de casa tele sena
    					for (int i = 0; i < 25 + quantVezesTentadas; i++) { 
    						if (numerosSorteados[i] == n) {
    							acertos++; // se o numero do conjunto for igual ao sorteado, o numero de acertos aumenta
    							if (acertos == 25) //se o conjunto da pessoa p tiver 25 acertos, ela é adicionada no array de ganhadores
    							{
    								ganhadores[quantGanhador] = p;
    								quantGanhador++;
    								achouGanhador = true;
    							}
    						}
    					}
    				}
    				acertos = 0;
    				for (int n : ts.getConjunto2()) { // for para percorrer o conjunto 2 de casa tele sena
    					for (int i = 0; i < 25 + quantVezesTentadas; i++) { 
    						if (numerosSorteados[i] == n) {
    							acertos++; 
    							if (acertos == 25) {
    								ganhadores[quantGanhador] = p;
    								quantGanhador++;
    								achouGanhador = true;
    							}
    						}
    					}
    				}
    			}
    		}
    		quantVezesTentadas++; 
    		// IMPRIME MENSAGEM CASO NÃO TENHA ENCONTRADO NENHUM GANHADOR, E IMPRIME OS OUTROS NUMEROS SORTEADOS 
    		if (!ControleTeleSena.achouGanhador)
            {
    			while ( imprimirErro == 1) //ESPECIFICACAO PARA IMPRIMIR APENAS UMA VEZ A MENSAGEM
    			{
    				//PAUSA SISTEMA
    				try {
        	        	Thread.sleep(2500);
        	        } catch (Exception e) {}
    				
    				System.out.printf("\n\t%34s\t%36s", "*** NÃO ENCONTRAMOS NENHUM GANHADOR! NOVOS NÚMEROS SERÃO SORTEADOS ATÉ QUE EXISTA UM GANHADOR ***", "|\n");
    				System.out.println(" +-------------------------------------------------------------------------------------------------------+");
    				
    				//PAUSA SISTEMA
    				try {
        	        	Thread.sleep(1000);
        	        } catch (Exception e) {}
    				imprimirErro++;
    			}
    			
    			//PAUSA SISTEMA
    	        try {
    	        	Thread.sleep(500);
    	        } catch (Exception e) {}
    	        System.out.print("  " + numerosSorteados[25 + quantVezesTentadas] );
    	    
            	
            }
    	}
    	return ganhadores; //RETORNA OS GANHADORES
    }
    
    
   
}

    		
    	



    
    
    
  