package Tovar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestProduct {
    @Test
    public void testConstructorAndGetters() {
        Product product = new Product("Apple", 1.99);
        assertEquals("Apple", product.getName());
        assertEquals(1.99, product.getPrice());
    }

    @Test
    public void testSetters() {
        Product product = new Product("Apple", 1.99);
        product.setName("Orange");
        product.setPrice(0.99);
        assertEquals("Orange", product.getName());
        assertEquals(0.99, product.getPrice());
    }

    @Test
    public void testToString() {
        Product product = new Product("Apple", 1.99);
        assertEquals("Product{name='Apple', price=1.99}", product.toString());
    }

    @Test
    public void testEquals() {
        Product product1 = new Product("Apple", 1.99);
        Product product2 = new Product("Apple", 1.99);
        Product product3 = new Product("Orange", 0.99);
        assertTrue(product1.equals(product2));
        assertFalse(product1.equals(product3));
    }
}
