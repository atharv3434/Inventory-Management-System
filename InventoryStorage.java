import java.io.*;
import java.util.*;

public class InventoryStorage {
    private static final String FILE_PATH = "inventory.txt";

    public static void saveInventory(List<Product> inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("❌ Error saving inventory data.");
        }
    }

    public static List<Product> loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
