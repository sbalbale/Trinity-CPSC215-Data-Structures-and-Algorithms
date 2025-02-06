// Product.java
package edu.trincoll;

public class Product {
    private int productId;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructs a new Product with the specified details.
     *
     * @param productId the unique identifier for the product
     * @param name      the name of the product
     * @param quantity  the quantity of the product in stock
     * @param price     the price of the product
     */
    public Product(int productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Displays the details of the product.
     */
    public void displayDetails() {
        System.out.println(
                "Product ID: " + productId + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + price);
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the quantity of the product in stock.
     *
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity the new quantity to set
     * @throws InsufficientQuantityException if the quantity is less than 0
     */
    public void setQuantity(int quantity) throws InsufficientQuantityException {
        // To do: Complete the setQuantity method here
        // To to: Check if quantity <0, then throw new exception
        if (quantity < 0) {
            throw new InsufficientQuantityException("Exception: Insufficient Quantity for " + name);
        }
        this.quantity = quantity;

    }
}
