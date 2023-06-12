public class Destino extends ElementoBasico {
    private boolean checked;

    public Destino(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "yellowSquare.jpg", linInicial, colInicial, tabuleiro);
    }

    public boolean getChecked() {
        return this.checked;
    }

    public void check() {
        this.checked = true;
    }

    public void uncheck() {
        this.checked = false;
    }

    @Override
    public boolean acao(ElementoBasico outro) {
        if (outro instanceof Caixa) {
            this.check();
        } else {
            this.uncheck();
        }
        
        return true;
    }
}
