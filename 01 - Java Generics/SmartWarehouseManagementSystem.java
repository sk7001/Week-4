import java.util.ArrayList;

abstract class WarehouseItem {
    abstract String getName();
}

class Electronics extends WarehouseItem {
    String name;
    Electronics(String name) { this.name = name; }
    String getName() { return name; }
}

class Groceries extends WarehouseItem {
    String name;
    Groceries(String name) { this.name = name; }
    String getName() { return name; }
}

class Furniture extends WarehouseItem {
    String name;
    Furniture(String name) { this.name = name; }
    String getName() { return name; }
}

class Storage<T extends WarehouseItem> {
    private final ArrayList<T> items = new ArrayList<>();
    void addItem(T item) { items.add(item); }
    ArrayList<T> getItems() { return items; }
    static void displayItems(ArrayList<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }
}

public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop"));
        electronicStorage.addItem(new Electronics("SmartPhone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Bananas"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chairs"));

        System.out.println("Display Electronics:");
        Storage.displayItems(electronicStorage.getItems());
        System.out.println("Display Groceries:");
        Storage.displayItems(groceriesStorage.getItems());
        System.out.println("Display Furniture:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
