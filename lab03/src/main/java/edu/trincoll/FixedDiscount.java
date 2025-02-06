package edu.trincoll;

/**
 * Represents a fixed discount that can be applied to a product's price.
 */
public class FixedDiscount extends DiscountCalculator {
    private double fixedAmount;

    /**
     * Constructs a new FixedDiscount with the specified fixed amount.
     *
     * @param fixedAmount the fixed discount amount
     */
    public FixedDiscount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    /**
     * Calculates the discount for the given price.
     *
     * @param price the original price of the product
     * @return the fixed discount amount
     */
    @Override
    public double calculateDiscount(double price) {
        return fixedAmount;
    }
}