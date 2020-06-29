
public class TeleSena
{
    private static double valorVenda;
    private int[] conjunto1;
    private int[] conjunto2;

    public TeleSena()
    {
        TeleSena.valorVenda = 10.00;
        conjunto1 = new int[25];
        geraConjunto(conjunto1);
        conjunto2 = new int[25];
        geraConjunto(conjunto2);
    }

    public void geraConjunto(int[] conjunto)
    {
        int i = 0;
        while (i < conjunto.length) {
            conjunto[i] = (int) ((Math.random() * 60) + 1);
            boolean colide = false;
            for (int j = 0; j < i; j++) {
                if (conjunto[i] == conjunto[j]) {
                    colide = true;
                    break;
                }
            }
            if (!colide) {
                i++;
            }
        }
    }
    
    public double getValorVenda()
    {
        return TeleSena.valorVenda;
    }
    
    public int[] getConjunto1()
    {
        return this.conjunto1;
    }
    
    public int[] getConjunto2()
    {
        return this.conjunto2;
    }
    
    public String toString()
    {
    	String s = " > " ;
    	for (int i = 0; i<25; i++)
    	{
    		s += this.conjunto1[i] + "  ";
    	}
    	s += "\n > ";
    	for (int i = 0; i<25; i++)
    	{
    		s += this.conjunto2[i] + "  ";
    	}
    	s+= "\n";
    	return s;
    }
}

