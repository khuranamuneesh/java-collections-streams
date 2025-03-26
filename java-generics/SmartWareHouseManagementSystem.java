import java.util.*;

abstract class WarehouseItem // Abstract class representing a warehouse item
{
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item: " + name;
    }
}

// Subclasses representing different item types
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic class for Storage
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}

// Utility class to display any type of warehouse items
class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWareHouseManagementSystem {
    public static void main(String[] args) {
        // Creating storage for different items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items to the storage
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Milk"));

        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Displaying items from all storages
        System.out.println("Electronics:");
        WarehouseUtility.displayItems(electronicsStorage.getAllItems());
        System.out.println();
        System.out.println("Groceries:");
        WarehouseUtility.displayItems(groceriesStorage.getAllItems());
        System.out.println();
        System.out.println("Furniture:");
        WarehouseUtility.displayItems(furnitureStorage.getAllItems());
    }
}
