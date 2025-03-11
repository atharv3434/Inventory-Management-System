public class Product3 {
    private String name;
    private int stock;
    private double price;

    public Product3(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getName() { return name; }
    public int getStock() { return stock; }
    public double getPrice() { return price; }

    public void setStock(int stock) { this.stock = stock; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "📦 Product: " + name + " | 🏷 Price: ₹" + price + " | 📊 Stock: " + stock + " units";
    }
}
