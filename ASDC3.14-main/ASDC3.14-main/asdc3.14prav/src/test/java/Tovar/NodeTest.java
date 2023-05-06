package Tovar;

public class NodeTest {
    public static void main(String[] args) {
        testConstructorAndGetters();
        testSetNext();
    }

    public static void testConstructorAndGetters() {
        Product product = new Product("Apple", 1.99);
        Node node = new Node(product);

        assertSame(product, node.product);
        assertNull(node.next);
    }

    public static void testSetNext() {
        Product product1 = new Product("Apple", 1.99);
        Product product2 = new Product("Orange", 0.99);
        Node node1 = new Node(product1);
        Node node2 = new Node(product2);

        node1.next = node2;
        assertSame(node2, node1.next);
    }
}
