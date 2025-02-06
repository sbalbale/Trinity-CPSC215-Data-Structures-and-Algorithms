package edu.trincoll;

/**
 * Represents a category of products.
 */
public class Category {
    private String categoryName;

    /**
     * Constructs a new Category with the specified name.
     *
     * @param categoryName the name of the category
     */
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets the name of the category.
     *
     * @return the name of the category
     */
    public String getCategoryName() {
        return categoryName;
    }
}