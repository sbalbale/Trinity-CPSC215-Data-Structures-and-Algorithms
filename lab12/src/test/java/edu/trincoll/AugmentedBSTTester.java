package edu.trincoll;

/**
 * AugmentedBSTTester tests the functionality of the augmented BST.
 * It demonstrates insertion, search, deletion, kth smallest, and rank
 * operations.
 *
 * In this example, we insert a set of keys into the BST,
 * print an in-order traversal showing keys and subtree sizes,
 * and then perform several order-statistic queries.
 */
public class AugmentedBSTTester {

    public static void main(String[] args) {
        AugmentedBST<Integer> bst = new AugmentedBST<>();

        int[] keys = { 15, 10, 20, 8, 12, 17, 25, 6, 11, 13, 19, 22 };
        // To do: Complete this (Insert a set of 'keys' into the BST.)
        for (int key : keys) {
            bst.insert(key);
        }
        // Print the BST in sorted order with subtree sizes.
        System.out.println("In-order traversal of the BST with subtree sizes:");
        bst.printInOrder();
        System.out.println("\n");

        System.out.println("Finding kth smallest elements:");
        // Find kth smallest elements for value of 3.
        int k = 3;
        int kthSmallest = bst.kthSmallest(k);
        for (k = 1; k <= bst.size(); k++) {
            kthSmallest = bst.kthSmallest(k);
            System.out.println("The " + k + "th smallest element is: " + kthSmallest);
        }
        System.out.println();


        System.out.println("Rank of keys in the BST:");
        // Determine the rank of several keys.
        int[] rankQueries = { 6, 10, 15, 22, 30 };
        // Determine the rank of several keys(rankQueries).
        for (int key : rankQueries) {
            int rank = bst.rank(key);
            // System.out.println("Rank of " + key + ": " + rank);
            if (rank >= bst.size()) {
                System.out.println("Key " + key + " not found in the BST.");
            } else {
                System.out.println("Rank of " + key + ": " + rank);
            }
        }

        // Demonstrate deletion.
        // Delete 10 and 20
        System.out.println("\nDeleting keys 10 and 20...");
        bst.delete(10);
        bst.delete(20);

        // After deletion
        // Print the BST in sorted order with subtree sizes after deletion.
        System.out.println("In-order traversal of the BST with subtree sizes after deletion:");
        bst.printInOrder();
        System.out.println();

        // Run a kth smallest query (3rd smallest)
        k = 3;
        kthSmallest = bst.kthSmallest(k);
        System.out.println("The " + k + "th smallest element after deletion is: " + kthSmallest);
        // Run a rank query (17)
        int rankKey = 17;
        int rank = bst.rank(rankKey);
        System.out.println("Rank of " + rankKey + " after deletion: " + rank);
    }
}
