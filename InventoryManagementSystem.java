package inventory;
import java.util.*;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return String.format("%-5d %-20s %-10d ₹%.2f", id, name, quantity, price);
    }
}

public class InventoryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    static void addProduct() {
        System.out.print("Enter product name: ");
        sc.nextLine(); 
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Product newProduct = new Product(nextId++, name, quantity, price);
        products.add(newProduct);
        System.out.println("✅ Product added successfully!");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in inventory.");
            return;
        }

        System.out.println("\n--- Product List ---");
        System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "Name", "Quantity", "Price");
        System.out.println("---------------------------------------------------");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Product p : products) {
            if (p.id == id) {
                found = true;
                System.out.println("Current details: " + p);
                System.out.print("Enter new quantity: ");
                p.quantity = sc.nextInt();
                System.out.print("Enter new price: ");
                p.price = sc.nextDouble();
                System.out.println("✅ Product updated successfully!");
                break;
            }
        }

        if (!found)
            System.out.println("❌ Product not found!");
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        boolean removed = products.removeIf(p -> p.id == id);

        if (removed)
            System.out.println("✅ Product deleted successfully!");
        else
            System.out.println("❌ Product not found!");
    }
}
