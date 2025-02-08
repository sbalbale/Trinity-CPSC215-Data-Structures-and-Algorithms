package edu.trincoll.part3;

/**
 * Test class for the Set ADT implementation.
 * Demonstrates various set operations including:
 * - Set creation and element insertion
 * - Union of two sets
 * - Intersection of two sets
 * - Difference of two sets
 * - Symmetric difference of two sets
 */
public class SetTest {
    
    /**
     * Main method to test the Set ADT implementation.
     * Creates two sets A and B with Integer elements and tests:
     * - Basic set operations (insertion)
     * - Set size checking
     * - Union operation (A ∪ B)
     * - Intersection operation (A ∩ B)
     * - Difference operation (A - B)
     * - Symmetric difference operation (A ^ B)
     *
     * Set A contains prime numbers: {2, 3, 5, 7, 11, 13, 17, 19, 23}
     * Set B contains a mix of numbers: {1, 3, 6, 8, 9, 11, 12, 17, 19, 23, 24, 25}
     *
     * @param args command line arguments (not used)
     */
    public static void main(String args[]) {
        // Create and populate Set A with prime numbers
        Set<Integer> A = new ASet<Integer>();  
        A.insert(2); 
        A.insert(3); 
        A.insert(5); 
        A.insert(7); 
        A.insert(11); 
        A.insert(13); 
        A.insert(17); 
        A.insert(19); 
        A.insert(23);                         

        // Create and populate Set B with a mix of numbers
        Set<Integer> B = new ASet<Integer>(100);  
        B.insert(1); 
        B.insert(3); 
        B.insert(6); 
        B.insert(8); 
        B.insert(9); 
        B.insert(11); 
        B.insert(12); 
        B.insert(17); 
        B.insert(19); 
        B.insert(23); 
        B.insert(24); 
        B.insert(25);       

        // Display sets and perform set operations
        System.out.println("A has " + A.size() + " elements: " + A);
        System.out.println("B has " + B.size() + " elements: " + B);
        System.out.println("The union of A and B = " + A.union(B));
        System.out.println("The intersection of A and B = " + A.intersect(B));
        System.out.println("The difference of A and B = " + A.diff(B));
        System.out.println("The symmetric difference of A and B = " + A.symDiff(B));
    } 
}