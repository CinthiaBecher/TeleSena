
public class Pessoa
{
    private String nome;
    private TeleSena[] teleSenasCompradas;
    private double ValorPremiacao;

    public Pessoa(String nome)
    {
        this.nome = nome;
        teleSenasCompradas = new TeleSena[(int) ((Math.random( )*15)+1)];
        this.ValorPremiacao = 0;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public TeleSena[] getTeleSenasCompradas()
    {
        return this.teleSenasCompradas;
    }
    
    public double getValorPremiacao()
    {
        return this.ValorPremiacao;
    }
    
    public void setValorPremiacao(double valor)
    {
        this.ValorPremiacao = valor;
    }
    
    public void insereTeleSena()
    {
    	for (int i=0; i<getTeleSenasCompradas().length; i++)
    	{
    		TeleSena t = new TeleSena(); // cria instancia de TeleSena
    		this.teleSenasCompradas[i] = t; //adiciona a instancia na posicao i
    	}
    }
    
    public void ImprimeDadosParticipante()
    {
    	System.out.printf("\t%-30s \t%10s",  getNome() + " comprou " + getTeleSenasCompradas().length + " Tele Sena(s)!", "\n");
    	
    }
    
}

