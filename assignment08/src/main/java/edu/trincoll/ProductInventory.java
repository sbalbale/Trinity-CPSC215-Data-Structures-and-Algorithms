package edu.trincoll;

import java.util.Iterator;

/**
 * Represents an inventory of products using a PositionalList.
 * Allows adding, removing, finding, updating, and displaying products.
 * 
 * @author Sean Balbale
 * @version 1.7
 */
public class ProductInventory implements Iterable<Product> {

    /** The list storing the products. */
    private PositionalList<Product> products;
    /** The name of the company. */
    private String companyName;

    /**
     * Default constructor. Initializes an empty inventory.
     * Time Complexity: O(1)
     */
    public ProductInventory() {
        this.companyName = "Default Company";
        this.products = new LinkedPositionalList<>();
    }

    /**
     * Parametrized constructor. Initializes an empty inventory for a company.
     * Time Complexity: O(1)
     *
     * @param companyName The name of the company. Defaults if null/empty.
     */
    public ProductInventory(String companyName) {
        if (companyName == null || companyName.trim().isEmpty()) {
            this.companyName = "Default Company";
        } else {
            this.companyName = companyName;
        }
        this.products = new LinkedPositionalList<>();
    }

    /**
     * Gets the company name.
     * Time Complexity: O(1)
     * 
     * @return The company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Adds a product to the inventory. Fails if ID exists or product is null.
     * Time Complexity: O(n)
     *
     * @param product The Product to add. Must not be null.
     * @return true if added, false otherwise.
     */
    public boolean addProduct(Product product) {
        if (product == null) {
            System.err.println("Error: Cannot add a null product.");
            return false;
        }
        if (findProductPosition(product.getId()) != null) {
            System.err.println("Error: Product with ID " + product.getId() + " already exists.");
            return false;
        }
        products.addLast(product);
        System.out.println("Product added: " + product.getName());
        return true;
    }

    /**
     * Removes a product by ID.
     * Time Complexity: O(n)
     *
     * @param productId The ID of the product to remove.
     * @return true if removed, false otherwise.
     */
    public boolean removeProduct(int productId) {
        Position<Product> productPosition = findProductPosition(productId);
        if (productPosition != null) {
            Product removedProduct = products.remove(productPosition);
            System.out.println("Product removed: " + removedProduct.getName());
            return true;
        } else {
            System.err.println("Error: Product with ID " + productId + " not found.");
            return false;
        }
    }

    /**
     * Finds a product by ID.
     * Time Complexity: O(n)
     *
     * @param productId The ID of the product to find.
     * @return The Product if found, null otherwise.
     */
    public Product findProduct(int productId) {
        Position<Product> productPosition = findProductPosition(productId);
        if (productPosition != null) {
            return productPosition.getElement();
        }
        return null;
    }

    /**
     * Updates the quantity of a product.
     * Time Complexity: O(n)
     *
     * @param productId   The ID of the product to update.
     * @param newQuantity The new quantity (must be non-negative).
     * @return true if updated, false otherwise.
     */
    public boolean updateQuantity(int productId, int newQuantity) {
        if (newQuantity < 0) {
            System.err.println("Error: Quantity cannot be negative.");
            return false;
        }
        Position<Product> productPosition = findProductPosition(productId);
        if (productPosition != null) {
            Product product = productPosition.getElement();
            product.setQuantity(newQuantity);
            System.out.println("Updated quantity for Product ID " + productId + " to " + newQuantity);
            return true;
        } else {
            System.err.println("Error: Product with ID " + productId + " not found for update.");
            return false;
        }
    }

    /**
     * Returns the number of products.
     * Time Complexity: O(1)
     * 
     * @return The number of products.
     */
    public int size() {
        return products.size();
    }

    /**
     * Checks if the inventory is empty.
     * Time Complexity: O(1)
     * 
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * Helper method to find the Position of a product by ID.
     * Time Complexity: O(n)
     *
     * @param productId The ID of the product to find.
     * @return The Position<Product> if found, null otherwise.
     */
    private Position<Product> findProductPosition(int productId) {
        for (Position<Product> pos : products.positions()) {
            if (pos.getElement().getId() == productId) {
                return pos;
            }
        }
        return null;
    }

    /**
     * Finds a product by name (case-insensitive).
     * Time Complexity: O(n)
     *
     * @param name The name of the product to find.
     * @return The first matching Product if found, null otherwise.
     */
    public Product findProductByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        String lowerCaseName = name.toLowerCase();

        for (Product product : products) {
            if (product.getName().toLowerCase().equals(lowerCaseName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Updates the quantity and price of a product.
     * Time Complexity: O(n)
     *
     * @param productId   The ID of the product to update.
     * @param newQuantity The new quantity.
     * @param newPrice    The new price.
     * @return true if updated, false otherwise.
     */
    public boolean updateProduct(int productId, int newQuantity, double newPrice) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setQuantity(newQuantity);
                product.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the inventory.
     * Time Complexity: O(n)
     *
     * @return A string listing all products, or an empty message.
     */
    @Override
    public String toString() {
        if (products.isEmpty()) {
            return companyName + " Inventory is empty.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(companyName).append(" Inventory:\n");
        sb.append("------------------------------------\n");

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();
            sb.append(currentProduct.toString()).append("\n");
        }

        sb.append("------------------------------------\n");
        return sb.toString();
    }

    /**
     * Displays the inventory to the console.
     * Time Complexity: O(n)
     */
    public void displayInventory() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    /**
     * Returns an iterator over the products.
     * Time Complexity: O(1)
     * 
     * @return an Iterator<Product>.
     */
    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
