public class Principal
    {
	public static void main(String[] args) {
		ControleTeleSena controle = new ControleTeleSena(); 
		
		//MENSAGEM DE BOAS VINDAS
        System.out.println(" =========================================================================================================");
        System.out.printf("|\t%58s\t%36s", "BEM-VINDOS A TELE SENA! ", "|\n");
        System.out.println(" ---------------------------------------------------------------------------------------------------------");
        
        
        //PAUSAR O SISTEMA 
        try {
        	Thread.sleep(2000);
        } catch (Exception e) {}
        
		
        //CRIA OS PARTICIPANTES 
		String [] nomes = { "Julia", "Laura", "Mateus", "Ana","João", "Maria", "Luana" , "Carlos", "Joana", "Fernanda",
	            "Luis", "Paula", "Gabriel", "Eduarda" ,"Lucas" , "Carolina", "Rafael", "José", "Rafaela", "Manuel"};
		
		for (int i = 0; i < 20; i++) {
			Pessoa participante = new Pessoa(nomes[i]); //cria as instâncias 
			participante.insereTeleSena(); //
			controle.InserePessoa(participante);
			controle.AumentaQtddVendida(participante);
		}
		
		//PAUSA O SISTEMA A CADA IMPRESSÃO DE PARTICIPANTE
        for (Pessoa p : controle.getParticipantes()) {
        	p.ImprimeDadosParticipante();
            System.out.println("|---------------------------------------------------------------------------------------------------------|");
            try {
            	Thread.sleep(600);
            } catch (Exception e) {}
        }
        System.out.println(" =========================================================================================================");
        
        //PAUSA O SISTEMA
        try {
        	Thread.sleep(2000);
        } catch (Exception e) {}
        
        
        //GERA OS NUMEROS PREMIADOS
        ControleTeleSena.numerosSorteados = new int[60];
        ControleTeleSena.GeraNumerosSorteados(ControleTeleSena.numerosSorteados);
        
        
        //IMPRIME OS NUMEROS SORTEADOS
        System.out.println("\n\n _/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\\_");
        System.out.printf("|\t%58s\t%36s", "SORTEIO DOS NÚMEROS PREMIADOS!", "|\n");
      //PAUSA O SISTEMA PARA O INICIO DO SORTEIO
    	try {
        	Thread.sleep(1500);
        } catch (Exception e) {}
        
        
        for (int i = 0; i<25; i++ )
        {
        	if (i == 0)
        		System.out.printf("%9s", ControleTeleSena.numerosSorteados[i] + "  ");
        	else
        		System.out.print(ControleTeleSena.numerosSorteados[i] + "  ");
        	//PAUSA O SISTEMA A CADA SORTEIO DE NÚMERO
        	try {
            	Thread.sleep(500);
            } catch (Exception e) {}
        }
        System.out.println("\n *--------------------------------------------------------------------------------------------------------*");
        
        
        //CALCULA AS INFORMAÇOES IMPORTANTES
        controle.CalculaValorTotalVendas();
        controle.CalculaPremio();
        controle.CalculaLucro();

        
        //VERIFICA SE TEVE GANHADOR
        Pessoa[] ganhadores = controle.verificaGanhardor(); //GUARDA OS GANHADORES
        double premioGanhador = controle.getValorPremio() / ControleTeleSena.quantGanhador; // VALOR TOTAL E DIVIDIDO PELA QTDD DE GANHADORES

        for (Pessoa p : ganhadores)
        	{
        		if (p != null)
        		{	//IMPRIME OS GANHADORES
        			System.out.println("\n\n _/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\\_");
        			System.out.printf("|\t%52s\t%44s", "GANHADOR(A): " + p.getNome(), "|\n");
        			System.out.printf("|\t%52s\t%44s", "PRÊMIO: R$" + premioGanhador, "|\n");
        			System.out.println(" *-------------------------------------------------------------------------------------------------------*\n");
                
        			p.setValorPremiacao(premioGanhador); //muda o valor do prêmio do ganhador
        		}
         	}
        
      //PAUSA O SISTEMA
		try {
        	Thread.sleep(1500);
        } catch (Exception e) {}
        MenuDeOpcoes(controle);
        
	}
	
	
	
	/* 
	 * MÉTODO QUE IMPRIME UM MENU COM 4 OPCOES PARA O USUÁRIO ESCOLHER
	 * A primeira opcao irá imprimir todas as tele senas dos participantes
	 * A segunda opcao imprime as tele senas de um participante especifico informado pelo usuário
	 * A terceira opcao imprime informaocoes adicionais, como lucro, quantidade de tele senas vendidas, etc.
	 * A quarta opcao finaliza a sessao e imprime uma mensagem de agradecimento
	 */
	public static void MenuDeOpcoes(ControleTeleSena controle)
	{
		System.out.println("\n +------------------------ MENU -------------------------+");
		System.out.printf("| %35s\t%20s", "Escolha uma das opcoes abaixo", "|\n");
    	System.out.println("|---------------------------------------------------------|");
        System.out.printf("| %10s\t%4s", "1 - Ver as Tele Senas de todos os participantes", "|\n");
        System.out.printf("| %10s\t%4s", "2 - Ver as Tele Senas de um participante especifico", "|\n");
        System.out.printf("| %10s\t%20s", "3 - Imprimir informacoes adicionais", "|\n");
        System.out.printf("| %8s\t%44s", "4 - Finalizar", "|\n");
        System.out.println(" ---------------------------------------------------------");
        int opcao = Teclado.leInt();

		
        switch (opcao) {
		case 1:
			for (Pessoa p : controle.getParticipantes())
        	{
        		
                System.out.println(" =========================================================================================================");
                System.out.println(p.getNome());

        		for (int i=0; i<p.getTeleSenasCompradas().length; i++) //imprimir todas as tele senas compradas
            	{
            		System.out.println(p.getTeleSenasCompradas()[i]);

            	}

        	}
			
        	//PAUSA O SISTEMA
    		try {
            	Thread.sleep(1000);
            } catch (Exception e) {}
            
        	MenuDeOpcoes(controle);
        	break;
        	
		case 2:
			 String nome = Teclado.leString("Digite o nome do participante :");
		   	 for (Pessoa p : controle.getParticipantes()) {
		      		if (p.getNome().equals(nome)){
		        			for (int i=0; i<p.getTeleSenasCompradas().length; i++) { 
		                		System.out.println(p.getTeleSenasCompradas()[i]);
		        			}
		        		}
		        	}
		        	//PAUSA O SISTEMA
		    		try {
		            	Thread.sleep(1000);
		            } catch (Exception e) {}
		            
		    		//Apresenta o menu de opcoes novamente
		        	MenuDeOpcoes(controle);
		        	break;
		case 3:
			controle.ImprimirInformacoes();
            MenuDeOpcoes(controle);
            break;
		case 4:
        	System.out.printf("|\t%58s\t%36s", "OBRIGADO PELA SUA PARTICIPACAO!", "|\n");
    		System.out.println(" =========================================================================================================");
			break;
		default:
			System.out.println("Opção Inválida!");
			break;
		}
        
        
        
       

        	
    }
	}


