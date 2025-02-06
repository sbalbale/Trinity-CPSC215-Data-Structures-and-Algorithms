// PercentageDiscount.java
package edu.trincoll;
public class PercentageDiscount extends DiscountCalculator {
    private double percentage;

    /**
     * Constructs a PercentageDiscount with the specified discount percentage.
     *
     * @param percentage the discount percentage to be applied
     */
    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Calculates the discount based on a percentage of the original price.
     *
     * @param price The original price before discount.
     * @return The discounted amount calculated as a percentage of the original price.
     */
    @Override
    public double calculateDiscount(double price) {
        // To do: Implement percentage discount calculation
        return price * percentage / 100;
    }
}
