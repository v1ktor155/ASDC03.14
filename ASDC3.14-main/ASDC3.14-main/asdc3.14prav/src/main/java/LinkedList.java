import java.util.NoSuchElementException;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(Product product) {
        Node newNode = new Node(product);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void remove(int id) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head.product.getId() == id) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null && current.product.getId() != id) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void print() {
        Node current = head;

        while (current != null) {
            System.out.println(current.product.toString());
            current = current.next;
        }
    }
}
