import java.util.*;

// Abstract class representing a product category
abstract class ProductCategory {
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Specific product categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Electronics");
    }
}

// Generic Product class restricted to specific categories
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (Category: " + category.getName() + ", Price: Rs " + price + ")";
    }
}

// Generic method to apply discounts dynamically
class DiscountUtility {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = (product.getPrice() * percentage) / 100;
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + percentage + "% off. New price: Rs " + product.getPrice());
    }
}

public class DynamicOnlineMarket {
    public static void main(String[] args) {
        // Creating products
        Product<BookCategory> book = new Product<>("Java Programming", 5100.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 750.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 24550.0, new GadgetCategory());

        // Storing products in a catalog
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        // Displaying all products
        System.out.println("Product Catalog:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }

        // Applying discounts
        System.out.println("\nApplying Discounts:");
        DiscountUtility.applyDiscount(book, 10);
        DiscountUtility.applyDiscount(shirt, 15);
        DiscountUtility.applyDiscount(phone, 5);
    }
}
