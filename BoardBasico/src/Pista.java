public class Pista extends ElementoBasico{
    private boolean fechada;
    private int nroPista;

    public Pista(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "fundoPista.jpg", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
    }

    public int getNroPista(){
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (fechada){
            fechada = false;
            setImage(Tabuleiro.createImageIcon("Pista"+nroPista+".jpg"));
        }else{
            fechada = true;
            setImage(Tabuleiro.createImageIcon("fundoPista.jpg"));
        }
    }    
}
