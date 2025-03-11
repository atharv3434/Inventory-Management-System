import java.util.Scanner;

public class InventoryApp {
    private static InventoryManager inventoryManager = new InventoryManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("📦 Welcome to Inventory Management System 📦");

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inventoryManager.addProduct();
                    break;
                case 2:
                    inventoryManager.viewProducts();
                    break;
                case 3:
                    inventoryManager.updateProduct();
                    break;
                case 4:
                    inventoryManager.deleteProduct();
                    break;
                case 5:
                    inventoryManager.searchProduct();
                    break;
                case 6:
                    System.out.println("Exiting... Manage your inventory efficiently! ✅");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
