package Binary;

class BinaryTreeSearchTest {
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

    public static class MainTree {
        public static void main(String[] args) {
            BinaryTreeSearch tree = new BinaryTreeSearch();
            tree.build("C:\\Users\\КОКСИК\\IdeaProjects\\asdc03\\src\\products.txt");

            // поиск узла по имени
            TreeNode foundNode = tree.search("Pasteurized milk");
            if (foundNode != null) {
                System.out.println("Found product: " + foundNode.name + ", price: " + foundNode.price);
            } else {
                System.out.println("Product not found");
            }

            // удаление узла по имени
            boolean isDeleted = tree.delete("Oil");
            if (isDeleted) {
                System.out.println("Product is deleted");
            } else {
                System.out.println("Product not found");
            }

            // добавление нового узла
            tree.insert("Organic eggs", 45);
            foundNode = tree.search("Organic eggs");
            if (foundNode != null) {
                System.out.println("Found product: " + foundNode.name + ", price: " + foundNode.price);
            } else {
                System.out.println("Product not found");
            }

            // удаление узла, которого нет в дереве
            isDeleted = tree.delete("Cocoa");
            if (isDeleted) {
                System.out.println("Product is deleted");
            } else {
                System.out.println("Product not found");
            }
        }
    }
}
