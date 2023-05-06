package Binary;

public class TreeNodeTest {

    public void testTreeNodeConstructor() {
        String expectedName = "apple";
        int expectedPrice = 10;
        TreeNode node = new TreeNode(expectedName, expectedPrice);
        if (!expectedName.equals(node.name)) {
            throw new AssertionError("Expected name: " + expectedName + ", actual name: " + node.name);
        }
        if (expectedPrice != node.price) {
            throw new AssertionError("Expected price: " + expectedPrice + ", actual price: " + node.price);
        }
        if (node.left != null) {
            throw new AssertionError("Expected left node to be null");
        }
        if (node.right != null) {
            throw new AssertionError("Expected right node to be null");
        }
    }
}
