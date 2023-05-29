import java.io.IOException;

public class DoubleLinkedList {
    private Node head, trail;
    private int nElementos;

    public DoubleLinkedList(){
        head = new Node(null, null, 0);
        trail = new Node(head, null, 0);
        head.next = trail;
        nElementos = 0;
    }

    public void add(int valor){
        Node novo = new Node(trail.prev, trail, valor);
        trail.prev.next = novo;
        trail.prev = novo; 
        nElementos++;
    }

    public void add(int index, int valor) throws IOException{
        if (index > nElementos || index < 0){
            throw new IOException();
        } 

        if (index == nElementos){
            add(valor);
            return;
        }

        Node dummy = head.next;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        
        }
        Node new_node = new Node(dummy.prev, dummy, valor);
        dummy.prev.next = new_node;
        dummy.prev = new_node;
        nElementos++;        
    }


    public int get(int index) throws IOException{
        if (index >= nElementos || index < 0) {
            throw new IOException();
        }

        Node dummy = head.next;

        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }

        return dummy.val;
    } 

    public void set(int index, int val) throws IOException{
        if (index >= nElementos || index < 0) {
            throw new IOException();
        }

        Node dummy = head.next;

        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }

        dummy.val = val;

    }


    public boolean remove(){
        if (nElementos > 0){
            trail.prev.prev.next = trail;
            trail.prev = trail.prev.prev;
            nElementos--;
            return true;
        }

        return false;
    }

    public boolean remove(int val){
        Node dummy = head.next;
        for (int i = 0; i < nElementos; i++) {
            if (dummy.val == val){
                dummy.next.prev = dummy.prev;
                dummy.prev.next = dummy.next;
                nElementos--;
                return true;
            }
        }

        return false;
    }

    public void removeByIndex(int index) throws IOException{
        if (index >= nElementos || index < 0){
            throw new IOException();
        }

        Node dummy = head.next;

        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }

        dummy.prev.next = dummy.next;
        dummy.next.prev = dummy.prev;

        nElementos = 0;
    }

    public boolean isEmpty(){
        return nElementos == 0;
    }

    public int size(){
        return nElementos;
    }

    public boolean contains(int val){
        
        Node dummy = head.next;
        for (int i = 0; i < nElementos; i++) {
            if (dummy.val == val){
                return true;
            }
        }

        return false;
    }


    public int indexOf(int val) throws IOException{
        Node dummy = head.next;
        for (int i = 0; i < nElementos; i++) {
            if (dummy.val == val){
                return i;
            }
        }

        throw new IOException();
    }


    public void clear(){
        head.next = trail;
        trail.prev = head;
        nElementos = 0;
    }

    public String toString(){
        Node dummy = head.next;
        String ret = "";
        for (int i = 0; i < nElementos; i++) {
            ret += dummy.val;
            ret += " -> ";
            dummy = dummy.next;
        }

        return ret.substring(0, ret.length()-4);



    }
}
