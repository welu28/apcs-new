public class Linky<E> {
    private static class Node<E> {
        E skibidi;
        Node<E> next;

        public Node(E skibidi) { this.skibidi = skibidi; this.next = null; }
    }

    private Node<E> head;
    private int size;

    public Linky() { this.head = null; this.size = 0;}

    public void add(E skibidi) {
        Node<E> newNode = new Node<>(skibidi);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public boolean remove(E skibidi) {
        if (head == null) return false;
        if (head.skibidi.equals(skibidi)) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> current = head;
        while (current.next != null && !current.next.skibidi.equals(skibidi)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        size--;
        return true;
    }

    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.skibidi + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Linky<Integer> list = new Linky<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        list.remove(2);
        list.print();
        list.add(4);
        list.print();
        System.out.println("Size: " + list.getSize());
    }
}
