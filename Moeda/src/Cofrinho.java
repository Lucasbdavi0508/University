public class Cofrinho {
    private Moeda[] cofre;
    private int current_slot = 0;
    public Cofrinho(int tamanho){
        cofre = new Moeda[tamanho];
        System.out.println("Cofrinho com espaço para " + tamanho + " moedas foi criado");
    }

    public boolean insere(Moeda moeda){
        if (current_slot < cofre.length){
            cofre[current_slot] = moeda;
            current_slot++;
            return true;
        }

        return false;
    }

    public Moeda retira(){
        if (current_slot > 0){
            current_slot--;
            Moeda tmp = cofre[current_slot];
            cofre[current_slot] = null;
            return tmp;
        }

        return null;
    }

    public int getQtdadeMoedas(){
        for (int i = 0; i < cofre.length; i++) {
            if (cofre[i] == null){
                return i;
            }
        }

        return cofre.length;
    }

    public int getQtdadeMoedasTipo(NomeMoeda nomeMoeda){
        int total = 0;
        for (Moeda moeda : cofre) {
            if (moeda==null) { break; }

            if (moeda.getNomeMoeda() == nomeMoeda){
                total++;
            }
        }

        return total;
    }

    public int getValorTotalCentavos(){
        int total = 0;
        for (Moeda moeda : cofre) {
            if (moeda==null) { break; }

            total += moeda.getValorCentavos();
        }

        return total;
    }


    public double getValorTotalReais(){
        double total = 0;
        for (Moeda moeda : cofre) {
            if (moeda==null) { break; }
            
            total += moeda.getValorReais();
        }

        return total;
    }
}
