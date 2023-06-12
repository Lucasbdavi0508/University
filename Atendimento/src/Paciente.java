public class Paciente {
    private Risco risco;
    private int timeWaited;
    private boolean fezReclamação;
    
    public Paciente() {
        this.risco = null;
        this.timeWaited = 0;
    }

    public Risco getRisco() {
        return risco;
    }
    
    public void setRisco(Risco risco) {
        this.risco = risco;
    }

    public int getTimeWaited() {
        return timeWaited;
    }

    public void await() {
        this.timeWaited++;
    }

    public void resetWaitTime(){
        this.timeWaited = 0;
        this.fezReclamação = false;
    }

    public boolean checarOuvidoria() {
        if (this.timeWaited >= 50 && !this.fezReclamação) {
            this.fezReclamação = true;
            return true;
        }
        return false;
    }

    
}
