package edu.trincoll;

/**
 * Represents the clothing category of products.
 * Implements the Taxable interface to calculate tax for clothing items.
 */
public class ClothingCategory extends Category implements Taxable {
    /**
     * Constructs a new ClothingCategory.
     */
    public ClothingCategory() {
        super("Clothing");
    }

    /**
     * Calculates the tax for the given price.
     *
     * @param price the price on which to calculate the tax
     * @return the calculated tax (5% of the price)
     */
    @Override
    public double calculateTax(double price) {
        return price * 0.05;
    }
}