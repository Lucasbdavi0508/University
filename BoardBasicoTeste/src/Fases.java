public class Fases {
    private String[] fases;
    private int curFase;
    private final int totalFases;


    public Fases() {
        totalFases = 5;
        fases = new String[totalFases];
        curFase = 0;
        fases[0] = 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppj  pppppp" +
        "pppppp pcpppppp" + 
        "pppppp c ddpppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp"  
        ; 
        fases[1] = 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp"  
        ; 
        fases[2] = 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp"  
        ; 
        fases[3] = 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppppppppppp" +
        "ppppppppppppppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp" + 
        "ppppppppppppppp"  
        ; 
        
        fases[4] = 
        "ppppppppppppppp" +
        "ppppppp   ppppp" + 
        "pppppj dcdppppp" +
        "ppppp  c cppppp" + 
        "pppppppdcdppppp" + 
        "ppppppp   ppppp" + 
        "ppppppppppppppp"  
        ; 
    }

    public String getFase() {
        return fases[curFase];
    }

    public void passarFase() {
        curFase++;
    }

    public boolean checarTerminou() {
        return curFase >= totalFases;
    }
}
