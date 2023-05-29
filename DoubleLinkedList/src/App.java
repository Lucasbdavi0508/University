public class App {
    public static void main(String[] args) throws Exception {
        DoubleLinkedList dll = new DoubleLinkedList();
        
        
        dll.add(1);
        dll.add(4);
        dll.add(12);
        dll.add(142);
        dll.add(76);
        dll.add(98);

        dll.add(3, 99);

        dll.remove();
        System.out.println(dll);
    }
}
