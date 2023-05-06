package Tovar;

import java.util.NoSuchElementException;

public class LinkedListTest {
    public static void main(String[] args) {
        testAdd();
        testRemove();
        testPrint();
    }

    public static void testAdd() {
        LinkedList list = new LinkedList();
        Product apple = new Product("Apple", 1.99);
        Product orange = new Product("Orange", 0.99);

        list.add(apple);
        assert apple.equals(list.head.product);
        assert list.head.next == null;

        list.add(orange);
        assert apple.equals(list.head.product);
        assert orange.equals(list.head.next.product);
        assert list.head.next.next == null;
    }

    public static void testRemove() {
        LinkedList list = new LinkedList();
        Product apple = new Product("Apple", 1.99);
        Product orange = new Product("Orange", 0.99);
        Product banana = new Product("Banana", 2.49);

        // Test removing from empty list
        try {
            list.remove(1);
            assert false;
        } catch (NoSuchElementException e) {
            // expected exception
        }

        // Test removing head element
        list.add(apple);
        list.add(orange);
        list.add(banana);

        list.remove(apple.getId());
        assert orange.equals(list.head.product);
        assert banana.equals(list.head.next.product);
        assert list.head.next.next == null;

        // Test removing non-head element
        list.remove(banana.getId());
        assert orange.equals(list.head.product);
        assert list.head.next == null;

        // Test removing non-existing element
        try {
            list.remove(1);
            assert false;
        } catch (NoSuchElementException e) {
            // expected exception
        }
    }

    public static void testPrint() {
        LinkedList list = new LinkedList();
        Product apple = new Product("Apple", 1.99);
        Product orange = new Product("Orange", 0.99);
        Product banana = new Product("Banana", 2.49);

        list.add(apple);
        list.add(orange);
        list.add(banana);

        // Redirect standard output to test output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.print();
        assert "Product{name='Apple', price=1.99}\nProduct{name='Orange', price=0.99}\nProduct{name='Banana', price=2.49}\n".equals(outContent.toString());
    }

}