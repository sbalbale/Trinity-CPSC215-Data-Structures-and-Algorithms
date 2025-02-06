// ElectronicsCategory.java
package edu.trincoll;
public class ElectronicsCategory extends Category implements Taxable {
    /**
     * Constructor for the ElectronicsCategory class.
     * This constructor initializes the category with the name "Electronics".
     */
    public ElectronicsCategory() {
        super("Electronics");
    }

    /**
     * Calculates the tax for electronics.
     * 
     * @param price The price of the electronic item.
     * @return The tax amount for the given price, calculated at 10%.
     */
    @Override
    public double calculateTax(double price) {
        // To do: Implement tax calculation for electronics (10% tax)
        return price * 0.10;
    }
}
