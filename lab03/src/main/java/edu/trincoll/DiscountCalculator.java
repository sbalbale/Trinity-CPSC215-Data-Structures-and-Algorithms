package edu.trincoll;

/**
 * Abstract class representing a discount calculator.
 * Subclasses should provide an implementation for calculating the discount on a given price.
 */
public abstract class DiscountCalculator {
    /**
     * Calculates the discount for the given price.
     *
     * @param price the original price of the product
     * @return the calculated discount
     */
    public abstract double calculateDiscount(double price);
}