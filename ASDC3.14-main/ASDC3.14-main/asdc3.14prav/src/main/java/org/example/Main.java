import java.io.*;
import java.util.*;
 public class Main {
    public static void main(String[] args) {
        LinkedList productList = new LinkedList();
        String filename = "products.txt";
        try {
            File file = new File("C:\\Users\\КОКСИК\\IdeaProjects\\asdc3.14prav\\src\\products.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String description = parts[1].trim();
                int price = Integer.parseInt(parts[2].trim());
                int quantity = Integer.parseInt(parts[3].trim());
                String unit = parts[4].trim();
                int id = Integer.parseInt(parts[5].trim());

                Product product = new Product(name, description, price, quantity, unit, id);
                productList.add(product);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        productList.print();
        System.out.println();

        productList.remove(2);
        productList.print();
    }
}
