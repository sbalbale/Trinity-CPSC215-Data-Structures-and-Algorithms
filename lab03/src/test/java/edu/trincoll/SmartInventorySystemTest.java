package edu.trincoll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the SmartInventorySystem class.
 */
class SmartInventorySystemTest {

    private Product laptop;
    private Product shirt;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        laptop = new Product(1, "Laptop", 10, 899.99);
        shirt = new Product(2, "T-Shirt", 50, 19.99);
    }

    /**
     * Tests the Product class.
     */
    @Test
    public void testProduct() {
        assertEquals(1, laptop.getProductId());
        assertEquals("Laptop", laptop.getName());
        assertEquals(10, laptop.getQuantity());
        assertEquals(899.99, laptop.getPrice());
    }

    /**
     * Tests the InsufficientQuantityException class.
     */
    @Test
    public void testInsufficientQuantityException() {
        InsufficientQuantityException exception = new InsufficientQuantityException("Test Exception");
        assertEquals("Test Exception", exception.getMessage());
    }

    /**
     * Tests the Category class.
     */
    @Test
    public void testCategory() {
        Category category = new Category("TestCategory");
        assertEquals("TestCategory", category.getCategoryName());
    }

    /**
     * Tests the ClothingCategory class.
     */
    @Test
    public void testClothingCategory() {
        ClothingCategory clothing = new ClothingCategory();
        assertEquals("Clothing", clothing.getCategoryName());
        assertEquals(44.9995, clothing.calculateTax(899.99), 0.0001); // Specify delta
    }

    /**
     * Tests the ElectronicsCategory class.
     */
    @Test
    public void testElectronicsCategory() {
        ElectronicsCategory electronics = new ElectronicsCategory();
        assertEquals("Electronics", electronics.getCategoryName());
        assertEquals(89.99, electronics.calculateTax(899.99), 0.01); // Specify delta
    }

    // @Test
    // public void testFixedDiscount() {
    //     // To do: Complete this
    // }

    // @Test
    // public void testPercentageDiscount() {
    //     // To do: Complete this
    // }
}