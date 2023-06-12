public class Marker extends ElementoBasico {

    private boolean checked;

    public Marker(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "redCircle.png", linInicial, colInicial, tabuleiro);
        this.checked = false;
    }

    public boolean getChecked() {
        return checked;
    }

    public void check() {
        this.checked = true;
        setImage(Tabuleiro.createImageIcon("greenCircle.png"));
    }

    @Override
    public boolean acao(ElementoBasico outro) {
        if (outro instanceof Caixa) {
            this.check();
        }
        
        return true;
    }
}
