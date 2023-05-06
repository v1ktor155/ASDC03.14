public class MainTree {
    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();
        tree.build("C:\\Users\\КОКСИК\\IdeaProjects\\asdc3.14prav\\src\\products.txt");

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
    }
}
