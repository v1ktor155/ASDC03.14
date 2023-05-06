import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BinaryTreeSearch {
    private TreeNode root;

    public BinaryTreeSearch() {
        root = null;
    }

    public void build(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\КОКСИК\\IdeaProjects\\asdc03\\src\\products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int price = Integer.parseInt(parts[1]);
                insert(name, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, int price) {
        TreeNode newNode = new TreeNode(name, price);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (name.compareTo(current.name) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode search(String name) {
        TreeNode current = root;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            } else if (name.compareTo(current.name) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public boolean delete(String name) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while (!current.name.equals(name)) {
            parent = current;
            if (name.compareTo(current.name) < 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.right;
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            parentOfSuccessor.left = successor.right;
            successor.right = node.right;
        }
        successor.left = node.left;
        if (node == root) {
            root = successor;
        } else if (node == parentOfSuccessor.left) {
            parentOfSuccessor.left = successor;
        } else {
            parentOfSuccessor.right = successor;
        }
        return node;
    }
}