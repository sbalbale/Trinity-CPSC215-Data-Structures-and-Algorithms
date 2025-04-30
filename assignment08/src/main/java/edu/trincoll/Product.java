package edu.trincoll;

/**
 * Represents a single product in the inventory.
 *
 * @author Sean Balbale
 * @version 1.3
 */
class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructs a new Product with validation.
     * Time Complexity: O(1)
     *
     * @param id       Unique ID (positive).
     * @param name     Name (non-empty).
     * @param quantity Quantity (non-negative).
     * @param price    Price (non-negative).
     * @throws IllegalArgumentException if constraints violated.
     */
    public Product(int id, String name, int quantity, double price) {
        if (id <= 0)
            throw new IllegalArgumentException("Product ID must be positive.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Product name cannot be empty.");
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative.");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative.");

        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets the product ID.
     * Time Complexity: O(1)
     * 
     * @return The product ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the product name.
     * Time Complexity: O(1)
     * 
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the product quantity.
     * Time Complexity: O(1)
     * 
     * @return The product quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the product price.
     * Time Complexity: O(1)
     * 
     * @return The product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product name (non-empty).
     * Time Complexity: O(1)
     * 
     * @param name The new product name.
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.err.println("Error: Product name cannot be empty.");
        }
    }

    /**
     * Sets the product quantity (non-negative).
     * Time Complexity: O(1)
     * 
     * @param quantity The new quantity. Must be non-negative.
     */
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.err.println("Error: Quantity cannot be negative.");
        }
    }

    /**
     * Sets the product price (non-negative).
     * Time Complexity: O(1)
     * 
     * @param price The new price. Must be non-negative.
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.err.println("Error: Price cannot be negative.");
        }
    }

    /**
     * Returns a string representation of the product.
     * Time Complexity: O(1)
     *
     * @return Formatted string with product details.
     */
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Quantity: %d, Price: $%.2f",
                id, name, quantity, price);
    }

    /**
     * Checks equality based on product ID.
     * Time Complexity: O(1)
     *
     * @param o The object to compare with.
     * @return true if objects are equal (same ID), false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return id == product.id;
    }

    /**
     * Returns the hash code based on product ID.
     * Time Complexity: O(1)
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}