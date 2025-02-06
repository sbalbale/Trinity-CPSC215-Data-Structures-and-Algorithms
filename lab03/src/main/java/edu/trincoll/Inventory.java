package edu.trincoll;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an inventory of products.
 *
 * @param <T> the type of product in the inventory, which must extend the Product class
 */
public class Inventory<T extends Product> {
    private List<T> products;

    /**
     * Constructs a new Inventory.
     */
    public Inventory() {
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product the product to add
     */
    public void addProduct(T product) {
        products.add(product);
    }

    /**
     * Removes a product from the inventory.
     *
     * @param product the product to remove
     */
    public void removeProduct(T product) {
        products.remove(product);
    }

    /**
     * Displays the current inventory of products.
     */
    public void displayInventory() {
        for (T product : products) {
            product.displayDetails();
        }
    }
}