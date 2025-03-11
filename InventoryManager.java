import java.util.*;

public class InventoryManager {
    private List<Product> inventory;
    private Scanner sc;

    public InventoryManager() {
        this.inventory = InventoryStorage.loadInventory();
        this.sc = new Scanner(System.in);
    }

    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter stock quantity: ");
        int stock = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline

        inventory.add(new Product(name, stock, price));
        InventoryStorage.saveInventory(inventory);
        System.out.println("✅ Product Added Successfully!");
    }

    public void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("📄 No products in inventory.");
            return;
        }

        System.out.println("\n📦 Current Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

    public void updateProduct() {
        viewProducts();
        System.out.print("Enter product number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < inventory.size()) {
            System.out.print("Enter new stock quantity: ");
            inventory.get(index).setStock(sc.nextInt());
            System.out.print("Enter new price: ");
            inventory.get(index).setPrice(sc.nextDouble());
            sc.nextLine(); // Consume newline

            InventoryStorage.saveInventory(inventory);
            System.out.println("✅ Product Updated Successfully!");
        } else {
            System.out.println("❌ Invalid product number.");
        }
    }

    public void deleteProduct() {
        viewProducts();
        System.out.print("Enter product number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < inventory.size()) {
            inventory.remove(index);
            InventoryStorage.saveInventory(inventory);
            System.out.println("✅ Product Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid product number.");
        }
    }

    public void searchProduct() {
        System.out.print("Enter product name to search: ");
        String query = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Product product : inventory) {
            if (product.getName().toLowerCase().contains(query)) {
                System.out.println("\n🔍 Found Product:");
                System.out.println(product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No product found with the given name.");
        }
    }
}
