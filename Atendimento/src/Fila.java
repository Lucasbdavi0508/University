public class Fila {

    class Node {
        Paciente val;
        Node next;

        public Node(Paciente val) {
            this.val = val;
            next = null;
        }
    }

    private Node front, back;
    private int nElementos;

    public Fila() {
        this.front = null;
        this.back = null;
    }

    public void enqueue(Paciente val) {

        Node aux = new Node(val);

        if (this.back == null) {
            this.front = aux;
            this.back = aux;
        } else {

            this.back.next = aux;
            this.back = aux;
        }

        nElementos++;

    }

    public Paciente dequeue(){
        if (this.front == null) {
            return null;
        }

        Node aux = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.back = null;
        }

        nElementos--;

        return aux.val;
    }

    public int size() {
        return nElementos;
    }

    public boolean isEmpty() {
        return nElementos == 0;
    }

    public int waitAllAndCheck() {
        int checker = 0;
        Node walker = this.front;
        for (int i = 0; i < nElementos; i++) {
            walker.val.await();
            if (walker.val.checarOuvidoria()) {
                checker += 1;
            }
            walker = walker.next;
        }

        return checker;
    }

}
