public class App {
    public static void main(String[] args){
        int afastadoPorLotaçao = 0;
        FilaPrioridade fila = new FilaPrioridade();
        SalaEspera salaEspera = new SalaEspera();

        SalaTriagem[] salasTriagem = new SalaTriagem[1000];
        SalaAtendimento[] salasAtendimento = new SalaAtendimento[1000];

        salasTriagem[0] = new SalaTriagem();
        salasAtendimento[0] = new SalaAtendimento();

        int nTriagem = 1;
        int nAtendimento = 1;
        int ouvidoriasEspera = 0;
        int ouvidoriasFila = 0;

        int nroRepetiçoes = 10000;
        for (int i = 0; i < nroRepetiçoes; i++) {

            if (!salaEspera.checarNovosPacientes()) {
                afastadoPorLotaçao++;
            }

            for (SalaTriagem salaTriagem : salasTriagem) {
                if (salaTriagem == null) {
                    break;
                }
                if (!salaEspera.isEmpty() && salaTriagem.isEmpty()) {
                    salaTriagem.insere(salaEspera.retirar());
                }
                
                if (!salaTriagem.isEmpty()) {
                    if (salaTriagem.triagem()) {
                        Paciente aux = salaTriagem.retira();
                        aux.resetWaitTime();
                        fila.insere(aux);
                    }
                }
            }

            for (SalaAtendimento salaAtendimento : salasAtendimento) {
                if (salaAtendimento == null) { break; }

                if (!fila.isEmpty() && salaAtendimento.isEmpty()) {
                    salaAtendimento.insere(fila.retira());
                }

                if (!salaAtendimento.isEmpty()) {
                    if (salaAtendimento.atende()) {
                        salaAtendimento.retira();
                    }
                }
            }

            ouvidoriasEspera += salaEspera.waitAllAndCheck();
            if (ouvidoriasEspera >= 10) {
                ouvidoriasEspera = 0;
                salasTriagem[nTriagem++] = new SalaTriagem();
            }

            ouvidoriasFila += fila.waitAllAndCheck();
            if (ouvidoriasFila >= 10) {
                ouvidoriasFila = 0;
                salasAtendimento[nAtendimento++] = new SalaAtendimento();
            }

        }

        System.out.println("quantidade de afastados por lotação: " + afastadoPorLotaçao);
        System.out.println(salaEspera.getAVG());
        System.out.println(fila.getAVG());
        System.out.println("numero de triagens: " + nTriagem);
        System.out.println("numero de atendimentos: " + nAtendimento);
    }
}
