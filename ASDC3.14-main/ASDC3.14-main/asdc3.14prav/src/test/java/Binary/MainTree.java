package Binary;

class MainTree {
    public static void main(String[] args) {
        BinaryTreeSearch binaryTreeSearch = new BinaryTreeSearch();
        binaryTreeSearch.build("products.txt");

        testInsert(binaryTreeSearch);
        testSearch(binaryTreeSearch);
        testDelete(binaryTreeSearch);
    }

    private static void testInsert(BinaryTreeSearch binaryTreeSearch) {
        binaryTreeSearch.insert("pear", 20);
        TreeNode node = binaryTreeSearch.search("pear");
        if (node == null) {
            System.out.println("Insert test failed: pear not found");
        } else if (!node.name.equals("pear")) {
            System.out.println("Insert test failed: expected name pear, but found " + node.name);
        } else if (node.price != 20) {
            System.out.println("Insert test failed: expected price 20, but found " + node.price);
        } else {
            System.out.println("Insert test passed");
        }
    }

    private static void testSearch(BinaryTreeSearch binaryTreeSearch) {
        TreeNode node = binaryTreeSearch.search("banana");
        if (node == null) {
            System.out.println("Search test failed: banana not found");
        } else if (!node.name.equals("banana")) {
            System.out.println("Search test failed: expected name banana, but found " + node.name);
        } else if (node.price != 5) {
            System.out.println("Search test failed: expected price 5, but found " + node.price);
        } else {
            System.out.println("Search test passed");
        }
    }

    private static void testDelete(BinaryTreeSearch binaryTreeSearch) {
        boolean result = binaryTreeSearch.delete("banana");
        if (!result) {
            System.out.println("Delete test failed: banana not found");
        } else if (binaryTreeSearch.search("banana") != null) {
            System.out.println("Delete test failed: banana not deleted");
        } else {
            System.out.println("Delete test passed");
        }
    }
}
