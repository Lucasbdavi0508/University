// Algumas mudanças pequenas foram feitas nessa classe para organizaçao pessoal

public class CadastroDinossauro {
    Dinossauro[] cadastroDinossauros;
    private int proximaPosicao;

    public CadastroDinossauro() {
        cadastroDinossauros = new Dinossauro[50];
        proximaPosicao = 0;
    }

    public boolean adicionarDinossauro(Dinossauro dino) {
        if (proximaPosicao < cadastroDinossauros.length) {
            cadastroDinossauros[proximaPosicao] = dino;
            proximaPosicao++;
            return true;
        } else {
            return false;
        }
    }

    public Dinossauro pesquisarDinossauro(int id) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (cadastroDinossauros[i].getIdDinossauro() == id) {
                return cadastroDinossauros[i];
            }
        }
        return null;
    }

    public boolean removerDinossauro(int id) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (cadastroDinossauros[i].getIdDinossauro() == id) {
                cadastroDinossauros[i] = null;
                for (int j = i+1; j < proximaPosicao; j++) {
                    cadastroDinossauros[j-1] = cadastroDinossauros[j];
                }
                cadastroDinossauros[proximaPosicao] = null;
                proximaPosicao--;
                return true;
            }
        }
        return false;
    }
    
}