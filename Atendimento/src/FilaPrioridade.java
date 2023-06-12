public class FilaPrioridade {
    private Fila vermelha;
    private double vermelhaTotalWaitTime;
    private double vermelhaQtdTotal;
    private Fila amarela;
    private double amarelaTotalWaitTime;
    private double amarelaQtdTotal;
    private Fila verde;
    private double verdeTotalWaitTime;
    private double verdeQtdTotal;
    private Fila azul;
    private double azulTotalWaitTime;
    private double azulQtdTotal;

    public FilaPrioridade() {
        vermelha = new Fila();
        amarela = new Fila();
        verde = new Fila();
        azul = new Fila();
    }

    public void insere(Paciente paciente) {
        switch (paciente.getRisco()) {
            case Altíssimo:
                vermelha.enqueue(paciente);
                break;
            case Alto:
                amarela.enqueue(paciente);
                break;
            case Medio:
                verde.enqueue(paciente);
                break;
            case Baixo:
                azul.enqueue(paciente);
                break;
            default:
                System.out.println("An Error Ocurred");;
                break;
        }
    }

    public boolean isEmpty() {
        return vermelha.isEmpty() && verde.isEmpty() && amarela.isEmpty() && azul.isEmpty();
    }

    public Paciente retira() {
        if (!vermelha.isEmpty()) {
            Paciente aux = vermelha.dequeue();
            vermelhaTotalWaitTime += aux.getTimeWaited();
            vermelhaQtdTotal++;
            return aux;
        }
        
        if (!amarela.isEmpty()) {
            Paciente aux = amarela.dequeue();
            amarelaTotalWaitTime += aux.getTimeWaited();
            amarelaQtdTotal++;
            return aux;
        }
        if (!verde.isEmpty()) {
            Paciente aux = verde.dequeue();
            verdeTotalWaitTime += aux.getTimeWaited();
            verdeQtdTotal++;
            return aux;
        }
        if (!azul.isEmpty()) {
            Paciente aux = azul.dequeue();
            azulTotalWaitTime += aux.getTimeWaited();
            azulQtdTotal++;
            return aux;
        }

        return null;
    }

    public int waitAllAndCheck() {
        int checker = vermelha.waitAllAndCheck() + amarela.waitAllAndCheck() + verde.waitAllAndCheck() + azul.waitAllAndCheck();

        return checker;
    }

    public String getAVG() {
        return "\nAVG vermelha: " + vermelhaTotalWaitTime / vermelhaQtdTotal +
                "\nAVG amarela: " + amarelaTotalWaitTime / amarelaQtdTotal +
                "\nAVG verde: "   + verdeTotalWaitTime  / verdeQtdTotal + 
                "\nAVG azul: "    + azulTotalWaitTime  / azulQtdTotal;
    }
}
