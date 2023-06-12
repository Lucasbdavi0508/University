import java.util.Random;

public class SalaTriagem {
    private Paciente paciente;
    private int counter;
    private int final_count;
    private Random randomizer;

    public SalaTriagem(){
        paciente = null;
        counter = 0;
        final_count = 0;
        randomizer = new Random();
    }

    public boolean isEmpty() {
        return this.paciente == null;
    }

    public void insere(Paciente paciente){
        this.paciente = paciente;
        this.final_count = randomizer.nextInt(3) + 1;
    }

    public boolean triagem() {
        if (counter >= final_count) {
            return true;
        }

        counter++;
        return false;
    }



    public Paciente retira() {
        Paciente aux = this.paciente;
        this.paciente = null;
        counter = 0;
        final_count = 0;

        aux.setRisco(Risco.values()[randomizer.nextInt(4)]);

        return aux;
    }
}
