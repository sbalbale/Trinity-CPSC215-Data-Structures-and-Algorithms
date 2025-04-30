package edu.trincoll;

import java.util.InputMismatchException;
import java.util.LinkedList; 
import java.util.Scanner;

/**
 * Provides a text-based menu for testing ProductInventory.
 * Allows adding, removing, finding, updating, and displaying products.
 *
 * @author Sean Balbale
 * @version 1.6
 */
public class InventoryMenu {

    private static final int MAX_RECENT_SEARCHES = 5; 

    /**
     * Displays the menu options.
     * Time Complexity: O(1)
     */
    private static void displayMenu() {
        System.out.println("\n--- Inventory Menu ---");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product by ID"); 
        System.out.println("3. Find Product by ID"); 
        System.out.println("4. Display Detailed Info of All Products");
        System.out.println("5. Display Available Products (Quantity > 0)");
        System.out.println("6. Find Product by Name");
        System.out.println("7. Display Recently Found Products (Max 5)"); 
        System.out.println("8. Exit"); 
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a product ID to the recent searches list (max size maintained).
     * Time Complexity: O(1)
     * @param recentSearches The list of recent search IDs.
     * @param productId The product ID to add.
     */
    private static void addRecentSearch(LinkedList<Integer> recentSearches, int productId) {
        recentSearches.removeFirstOccurrence(productId); 
        recentSearches.addFirst(productId); 
        if (recentSearches.size() > MAX_RECENT_SEARCHES) {
            recentSearches.removeLast(); 
        }
    }

    /**
     * Main method to run the inventory menu.
     * Time Complexity: O(k*n) where k is user interactions and n is inventory size for some operations.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Company Name for the Inventory System: ");
        String companyName = scanner.nextLine();
        System.out.println("\nWelcome to the " + companyName + " Inventory Management System!");

        ProductInventory inventory = new ProductInventory(companyName); 
        LinkedList<Integer> recentSearches = new LinkedList<>(); 
        int choice = -1;

        inventory.addProduct(new Product(101, "Laptop", 15, 1200.50)); 
        inventory.addProduct(new Product(102, "Mouse", 50, 25.99)); 
        inventory.addProduct(new Product(103, "Keyboard", 30, 75.00)); 
        inventory.addProduct(new Product(104, "Monitor", 0, 300.00)); 

        while (choice != 8) { 
            displayMenu(); 
            try {
                choice = scanner.nextInt(); 
                scanner.nextLine(); 

                switch (choice) {
                    case 1: 
                        try {
                            System.out.print("Enter Product ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Enter Product Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Quantity: ");
                            int quantity = scanner.nextInt();
                            if (quantity < 0) {
                                System.err.println("Error: Quantity cannot be negative.");
                                break; 
                            }
                            System.out.print("Enter Price: ");
                            double price = scanner.nextDouble();
                            if (price < 0) {
                                System.err.println("Error: Price cannot be negative.");
                                break; 
                            }
                            scanner.nextLine(); 
                            inventory.addProduct(new Product(id, name, quantity, price));
                        } catch (InputMismatchException e) {
                            System.err.println("Error: Invalid input type. Please enter numbers where required.");
                            scanner.nextLine(); 
                        } catch (IllegalArgumentException e) { 
                            System.err.println("Error adding product: " + e.getMessage());
                        }
                        break;
                    case 2: 
                        System.out.println("Note: Removing by product name requires changes to ProductInventory and is not currently supported.");
                        try {
                            System.out.print("Enter Product ID to remove: ");
                            int removeId = scanner.nextInt();
                            scanner.nextLine(); 
                            inventory.removeProduct(removeId);
                        } catch (InputMismatchException e) {
                            System.err.println("Error: Invalid input. Please enter a valid Product ID (integer).");
                            scanner.nextLine(); 
                        }
                        break;
                    case 3: 
                        try {
                            System.out.print("Enter Product ID to find: ");
                            int findId = scanner.nextInt();
                            scanner.nextLine(); 
                            Product foundProduct = inventory.findProduct(findId);
                            if (foundProduct != null) {
                                System.out.println("Product Found: " + foundProduct);
                                addRecentSearch(recentSearches, findId); 
                            } else {
                                System.out.println("Product with ID " + findId + " not found.");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Error: Invalid input. Please enter a valid Product ID (integer).");
                            scanner.nextLine(); 
                        }
                        break;
                    case 4: 
                        System.out.println("\n--- All Products ---");
                        System.out.println(inventory.toString());
                        break;
                    case 5: 
                        System.out.println("\n--- Available Products (Quantity > 0) ---");
                        boolean foundAvailable = false;
                        for (Product p : inventory) { 
                            if (p.getQuantity() > 0) { 
                                System.out.println(p); 
                                foundAvailable = true;
                            }
                        }
                        if (!foundAvailable) {
                            System.out.println("No products currently available.");
                        }
                        break;
                    case 6: 
                        try {
                            System.out.print("Enter Product Name to find: ");
                            String findName = scanner.nextLine();
                            Product foundProductByName = inventory.findProductByName(findName); 
                            if (foundProductByName != null) {
                                System.out.println("Product Found: " + foundProductByName);
                                addRecentSearch(recentSearches, foundProductByName.getId()); 
                            } else {
                                System.out.println("Product with name '" + findName + "' not found.");
                            }
                        } catch (Exception e) { 
                            System.err.println("An error occurred while searching by name: " + e.getMessage());
                        }
                        break;
                    case 7: 
                        System.out.println("\n--- Recently Found Product IDs (Max " + MAX_RECENT_SEARCHES + ") ---");
                        if (recentSearches.isEmpty()) {
                            System.out.println("No products have been successfully found recently.");
                        } else {
                            System.out.print("Recent IDs: ");
                            for (int i = 0; i < recentSearches.size(); i++) {
                                System.out.print(recentSearches.get(i) + (i < recentSearches.size() - 1 ? ", " : ""));
                            }
                            System.out.println();
                        }
                        break;
                    case 8: 
                        System.out.println("Exiting inventory system for " + companyName + "."); 
                        break;
                    
                    default: 
                        System.err.println("Error: Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for the menu choice.");
                scanner.nextLine(); 
                choice = -1; 
            }
        }

        scanner.close(); 
    }
}
