package edu.trincoll;

/**
 * Test class for ProductInventory.
 * Tests add, remove, find, update, toString, and basic operations.
 * 
 * @author Sean Balbale
 * @version 1.1
 */
public class ProductInventoryTest {

    
    /**
     * Main method demonstrating ProductInventory functionality.
     * Time Complexity: O(n) (dominated by loops and inventory operations)
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ProductInventory mainInventory = new ProductInventory("Sample Company");

        Product cheese = new Product(1, "Cheese", 90, 5.99);
        Product eggs = new Product(498, "Eggs", 50, 2.99);
        Product chicken = new Product(99, "Chicken", 38, 8.49);
        Product bread = new Product(3213, "Bread", 819, 3.49);
        Product drPepper = new Product(297, "Dr Pepper", 120, 1.99);
        Product coffee = new Product(297, "Coffee", 60, 9.99); 
        Product marlboro = new Product(368, "Marlboro Reds", 100, 12.50);

        System.out.println("TESTING ALL METHODS-");
        System.out.println();

        System.out.println("Displaying the names and product numbers of products in inventory (Initial)");
        if (mainInventory.isEmpty()) {
            System.out.println("The inventory is currently empty."); 
        } else {
            mainInventory.displayInventory(); 
        }

        System.out.println("Displaying available products (Initial)-");
        if (mainInventory.isEmpty()) {
            System.out.println("The inventory is currently empty."); 
        } else {
            System.out.println("No available products to display yet."); 
                                                                         
        }
        System.out.println();

        System.out.println("Now adding Cheese to inventory...");
        mainInventory.addProduct(cheese); 
        System.out.println("Now adding Eggs to inventory...");
        mainInventory.addProduct(eggs); 
        System.out.println("Now adding Chicken to inventory...");
        mainInventory.addProduct(chicken); 
        System.out.println("Now adding Bread to inventory...");
        mainInventory.addProduct(bread); 
        System.out.println("Now adding Dr Pepper to inventory...");
        mainInventory.addProduct(drPepper); 
        System.out.println("Now adding Coffee to inventory...");
        if (!mainInventory.addProduct(coffee)) {
            System.out.println("Failed to add Coffee (ID 297 likely exists).");
        }
        System.out.println("Now adding Marlboro Reds to inventory...");
        mainInventory.addProduct(marlboro); 
        System.out.println();

        System.out.println("Displaying the names and product numbers of products in inventory (After Adds)");
        for (Product p : mainInventory) { 
            System.out.printf("%s, Product Number %d\n", p.getName(), p.getId());
        }
        System.out.println();

        System.out.println("Removing item with number 498 (Eggs)...");
        if (mainInventory.removeProduct(498)) {
            System.out.println("Successfully removed item 498.");
        } else {
            System.out.println("Failed to remove item 498 (not found?)."); 
        }

        System.out.println("Removing item with number 2 (non-existent)...");
        if (!mainInventory.removeProduct(2)) {
            System.out.println("Failed to remove item 2 (as expected, not found).");
        }
        System.out.println();

        System.out.println("Displaying the names and product numbers of products in inventory (After Removes)");
        for (Product p : mainInventory) {
            System.out.printf("%s, Product Number %d\n", p.getName(), p.getId());
        }
        System.out.println();

        System.out.println("Displaying available products (Stock Details)-");
        int totalAvailable = 0; 
        if (mainInventory.isEmpty()) {
            System.out.println("The inventory is currently empty.");
        } else {
            for (Product p : mainInventory) {
                System.out.printf("%s, %d products in stock.\n", p.getName(), p.getQuantity());
                totalAvailable += p.getQuantity();
            }
            System.out.println("The total number of available products (sum of quantities) is: " + totalAvailable);
            System.out.println("The inventory currently has " + mainInventory.size() + " distinct items.");
        }

        System.out.println();

        int[] idsToFind = { 1, 368, 498, 297, 99 };
        for (int id : idsToFind) {
            System.out.println("Looking for item with number " + id + "...");
            Product found = mainInventory.findProduct(id);
            if (found != null) {
                System.out.println("Product Found: " + found.toString()); 
                                                                        

            } else {
                System.out.println("No item with number " + id + " found in inventory."); 
                                                                                        
            }
        }

        System.out.println("\n--- End of Main Method Test Run ---");

    }
}