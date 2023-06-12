public class SalaEspera {
    private Fila pacientesEmEspera;
    private double totalWaitTime;
    private double qtdTotal;


    public SalaEspera() {
        pacientesEmEspera = new Fila();
    }

    public boolean isEmpty() {
        return pacientesEmEspera.isEmpty();
    }

    public boolean checarNovosPacientes(){
        if (Math.random() > 0.5) {
            if (pacientesEmEspera.size() < 50){
                pacientesEmEspera.enqueue(new Paciente());
                return true;
            } 
            return false;
        }
        return true;
    }

    public Paciente retirar() {
        Paciente aux = pacientesEmEspera.dequeue();
        totalWaitTime += aux.getTimeWaited();
        qtdTotal++;
        return aux;

    }

    public int waitAllAndCheck(){
        return pacientesEmEspera.waitAllAndCheck();
    }

    public String getAVG() {
        return "AVG sala de espera: " + totalWaitTime / qtdTotal;
    }
}