package edu.trincoll;

public class BSTTest {
    public static void main(String[] args) {
        // Create a BST with String keys (song titles) and String values (artist - genre)
        BST<String, String> playlist = new BST<>();

        System.out.println("Testing BST operations:");

        // Test initial state
        System.out.println("\n--- Initial State ---");
        System.out.println("Is empty: " + playlist.isEmpty()); // Expected: true
        System.out.println("Size: " + playlist.size());         // Expected: 0

        // Test insertions
        System.out.println("\n--- Inserting Songs ---");
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        playlist.insert("Dancing Queen", "ABBA - Disco");
        playlist.insert("Bohemian Rhapsody", "Queen - Rock");
        playlist.insert("Hotel California", "Eagles - Rock");
        System.out.println("Size after inserts: " + playlist.size()); // Expected: 5

        // Test find method
        System.out.println("\n--- Finding Songs ---");
        System.out.println("Find 'Africa': " + playlist.find("Africa")); // Expected: Toto - Rock
        System.out.println("Find 'Nonexistent': " + playlist.find("Nonexistent")); // Expected: null

        // Test getMin and getMax
        System.out.println("\n--- Min and Max ---");
        System.out.println("Min: " + playlist.getMin()); // Expected: Africa
        System.out.println("Max: " + playlist.getMax()); // Expected: Imagine

        // Test traversal methods
        System.out.println("\n--- Traversals ---");
        System.out.println("Inorder traversal:");
        playlist.display_inorder(); // Expected: Africa, Bohemian Rhapsody, Dancing Queen, Hotel California, Imagine
        System.out.println("\nPreorder traversal:");
        playlist.display_preorder();
        System.out.println("\nPostorder traversal:");
        playlist.display_postorder();

        // Test containsValue method
        System.out.println("\n--- Contains Value ---");
        System.out.println("Contains 'Toto - Rock': " + playlist.containsValue("Toto - Rock")); // Expected: true
        System.out.println("Contains 'Michael Jackson - Pop': " + playlist.containsValue("Michael Jackson - Pop")); // Expected: false

        // Test successor and predecessor methods
        System.out.println("\n--- Successor and Predecessor ---");
        System.out.println("Successor of 'Bohemian Rhapsody': " + playlist.successor("Bohemian Rhapsody")); // Expected: Dancing Queen
        System.out.println("Predecessor of 'Hotel California': " + playlist.predecessor("Hotel California")); // Expected: Dancing Queen
        System.out.println("Successor of 'Imagine': " + playlist.successor("Imagine")); // Expected: null
        System.out.println("Predecessor of 'Africa': " + playlist.predecessor("Africa")); // Expected: null

        // Test remove method
        System.out.println("\n--- Removing 'Dancing Queen' ---");
        playlist.remove("Dancing Queen");
        System.out.println("Size after remove: " + playlist.size()); // Expected: 4
        System.out.println("Inorder after remove:");
        playlist.display_inorder(); // Expected: Africa, Bohemian Rhapsody, Hotel California, Imagine

        // Test removing a non-existent key
        System.out.println("\n--- Removing non-existent 'Thriller' ---");
        playlist.remove("Thriller"); // Should do nothing
        System.out.println("Size: " + playlist.size()); // Expected: 4

        // Test removeAny method
        System.out.println("\n--- Remove Any ---");
        String removed = playlist.removeAny();
        System.out.println("Removed song details: " + removed);
        System.out.println("Size after removeAny: " + playlist.size()); // Expected: 3
        System.out.println("Inorder after removeAny:");
        playlist.display_inorder();

        // Test clear method
        System.out.println("\n--- Clearing the Playlist ---");
        playlist.clear();
        System.out.println("Is empty: " + playlist.isEmpty()); // Expected: true
        System.out.println("Size: " + playlist.size());         // Expected: 0

        // Test inserting after clear
        System.out.println("\n--- Inserting New Songs ---");
        playlist.insert("Stairway to Heaven", "Led Zeppelin - Rock");
        playlist.insert("Smells Like Teen Spirit", "Nirvana - Grunge");
        System.out.println("Size: " + playlist.size()); // Expected: 2
        System.out.println("Inorder traversal:");
        playlist.display_inorder(); // Expected: Smells Like Teen Spirit, Stairway to Heaven
    }
}
