import java.util.Random;

public class SalaAtendimento {
    private Paciente paciente;
    private int counter;
    private int final_count;
    private Random randomizer;

    public SalaAtendimento(){
        paciente = null;
        counter = 0;
        final_count = 0;
        randomizer = new Random();
    }

    public boolean isEmpty() {
        return paciente == null;
    }

    public void insere(Paciente paciente){
        this.paciente = paciente;
        this.final_count = randomizer.nextInt(4) + 2;
    }

    public boolean atende() {
        if (counter == final_count) {
            return true;
        }

        counter++;
        return false;
    }

    public void retira() {
        this.paciente = null;
        counter = 0;
        final_count = 0;

    }
}
