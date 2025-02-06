package edu.trincoll;

/**
 * Represents an entity that can calculate tax on a given price.
 */
public interface Taxable {
    /**
     * Calculates the tax for the given price.
     *
     * @param price the price on which to calculate the tax
     * @return the calculated tax
     */
    double calculateTax(double price);
}