import java.util.ArrayList;

abstract class Product {
    String name;
    double price;
    Product(String name, double price) { this.name = name; this.price = price; }
    void applyDiscount(double percentage) { price -= price * percentage / 100; }
    abstract void displayDetails();
}

class BookCategory extends Product {
    BookCategory(String name, double price) { super(name, price); }
    @Override void displayDetails() { System.out.println("Book: " + name + " Rs." + price); }
}

class ClothingCategory extends Product {
    ClothingCategory(String name, double price) { super(name, price); }
    @Override void displayDetails() { System.out.println("Clothing: " + name + " Rs." + price); }
}

class GadgetsCategory extends Product {
    GadgetsCategory(String name, double price) { super(name, price); }
    @Override void displayDetails() { System.out.println("Gadget: " + name + " Rs." + price); }
}

class ProductCatalog<T extends Product> {
    final ArrayList<T> catalog = new ArrayList<>();
    void addProduct(T product) { catalog.add(product); }
    void displayInfo() { for (T item : catalog) item.displayDetails(); }
    <U extends Product> void applyDiscount(U product, double percentage) { product.applyDiscount(percentage); }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<BookCategory> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new BookCategory("Java Programming", 500));
        bookCatalog.addProduct(new BookCategory("Data Structures", 400));

        ProductCatalog<ClothingCategory> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new ClothingCategory("T-shirt", 800));
        clothingCatalog.addProduct(new ClothingCategory("Jeans", 1200));

        ProductCatalog<GadgetsCategory> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new GadgetsCategory("Smartphone", 15000));
        gadgetCatalog.addProduct(new GadgetsCategory("Laptop", 50000));

        System.out.println("Before Discount:");
        bookCatalog.displayInfo();
        clothingCatalog.displayInfo();
        gadgetCatalog.displayInfo();

        bookCatalog.applyDiscount(bookCatalog.catalog.get(0), 10);
        clothingCatalog.applyDiscount(clothingCatalog.catalog.get(0), 5);
        gadgetCatalog.applyDiscount(gadgetCatalog.catalog.get(0), 20);

        System.out.println("\nAfter Discount:");
        bookCatalog.displayInfo();
        clothingCatalog.displayInfo();
        gadgetCatalog.displayInfo();
    }
}
