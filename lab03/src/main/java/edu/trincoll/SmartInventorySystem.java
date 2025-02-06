package edu.trincoll;

/**
 * The SmartInventorySystem class demonstrates a simple inventory management system.
 * It creates instances of products, categories, discounts, and inventory, and performs
 * various operations such as adding products to inventory, displaying inventory, 
 * setting product quantities, applying discounts, and calculating taxes.
 * 
 * The main method performs the following tasks:
 * - Creates instances of Product (laptop and shirt)
 * - Creates instances of ElectronicsCategory and ClothingCategory
 * - Creates an Inventory object and adds products to it
 * - Displays the inventory
 * - Simulates product operations including setting quantities and handling exceptions
 * - Applies percentage and fixed discounts to products and displays the results
 * - Calculates and displays tax for products
 * 
 * Exception Handling:
 * - Catches InsufficientQuantityException when product quantity is set to an invalid value
 * 
 * Discount Application:
 * - Applies a 10% percentage discount to the laptop
 * - Applies a $5 fixed discount to the shirt
 * 
 * Tax Calculation:
 * - Calculates and displays tax for the laptop and shirt based on their respective categories
 * 
 * Note: The code includes placeholders for additional tasks such as adding products to inventory,
 * displaying inventory, setting quantities, and handling exceptions.
 */
public class SmartInventorySystem {
    /**
     * The main method that demonstrates the functionality of the SmartInventorySystem.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create instances of products, categories, discounts, and inventory
        Product laptop = new Product(1, "Laptop", 10, 899.99);
        Product shirt = new Product(2, "T-Shirt", 50, 19.99);

        ElectronicsCategory electronics = new ElectronicsCategory();
        ClothingCategory clothing = new ClothingCategory();

        // Create an inventory object of type Product
        Inventory<Product> inventory = new Inventory<>();
        // Add products to inventory (laptop and shirt)
        inventory.addProduct(laptop);
        inventory.addProduct(shirt);

        // Display inventory
        inventory.displayInventory();

        // Simulate product operations
        System.out.println("\n");

        try {
            // Set Quantity to 5 (laptop)
            laptop.setQuantity(5);
            laptop.displayDetails();
            // Set Quantity to -5 to initiate an exception
            laptop.setQuantity(-5);

        } catch (InsufficientQuantityException e) {
            System.out.println(e.getMessage());
        }

        // Apply discounts
        System.out.println("\n");
        PercentageDiscount percentageDiscount = new PercentageDiscount(10);
        FixedDiscount fixedDiscount = new FixedDiscount(5);

        // Apply percentage discount of 10% for laptop
        System.out.println("Discount for Laptop: " + percentageDiscount.calculateDiscount(laptop.getPrice()));

        // Apply fixed discount of $5 for shirt
        System.out.println("Discount for T-Shirt: " + fixedDiscount.calculateDiscount(shirt.getPrice()));

        // Apply tax
        System.out.println("\n");
        laptop.displayDetails();
        System.out.print("Tax for Laptop: ");
        System.out.format("%.4f", electronics.calculateTax(laptop.getPrice()));
        System.out.println("");

        // Calculate and display tax for laptop and shirt
        shirt.displayDetails();
        System.out.println("Tax for T-Shirt: ");
        System.out.format("%.4f", clothing.calculateTax(shirt.getPrice()));
        System.out.println("");
    }
}