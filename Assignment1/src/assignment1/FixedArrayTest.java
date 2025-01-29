package assignment1;

//Main.java

public class FixedArrayTest {
    public static void main(String[] args) {

        // Demonstrating encapsulation with FixedArray
        FixedArray<String> stringArray = new FixedArray<>(5);

        // Inserting elements
        stringArray.insert("Apple");
        stringArray.insert("Banana");
        stringArray.insert("Cherry");
        stringArray.display(); // Expected Output: Apple Banana Cherry

        // Removing an element
        stringArray.remove(1);
        stringArray.display(); // Expected Output: Apple Cherry

        // Swapping elements
        stringArray.insert("Date");
        stringArray.insert("Elderberry");
        stringArray.swap(0, 2);
        stringArray.display(); // Expected Output: Cherry Date Apple Elderberry

        // Edge cases
        // stringArray.swap(0, 5); // Expected Output: Invalid index
        // stringArray.remove(4); // Expected Output: Invalid index
        // stringArray.insert("Strawberry");
        // stringArray.display(); // Expected Output: Cherry Date Apple Elderberry Strawberry
        // stringArray.insert("Blueberry"); // Expected Output: Array is full
        // stringArray.display(); // Expected Output: Cherry Date Apple Elderberry Strawberry
        

        // Demonstrating polymorphism
        FixedArray<Number> numberArray = new FixedArray<>(5);
        numberArray.insert(10); // Integer
        numberArray.insert(15.5); // Double
        numberArray.insert(20L); // Long
        numberArray.display(); // Expected Output: 10 15.5 20

        // Accessing elements via abstraction
        System.out.println("Element at index 1: " + numberArray.get(1)); // Expected Output: 15.5

        // Clearing the array
        numberArray.clear();
        numberArray.display(); // Expected Output: (empty line)

        System.out.println("Encapsulation ensures size is: " + stringArray.getSize()); // Expected Output: 4
    }
}
