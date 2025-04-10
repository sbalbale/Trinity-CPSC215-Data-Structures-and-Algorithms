package edu.trincoll.partA;

public class AVLTree<T extends Comparable<T>> {

    public Node root;

    // Node definition
    public class Node {
        T key;
        int height;
        Node left, right;
        
        public Node(T key) {
            this.key = key;
            this.height = 1;
        }
    }
    
    // ----------------- Insertion -----------------
    
    // Recursive insert with balancing (internal method)
    public Node insert(Node node, T key) {
        //To do: Complete this (Steps below)

        // 1. Perform standard BST insert
        // 2. Update height
        // 3. Get balance factor
        
        // 4. Balance the tree
            // Left Left Case
            // Right Right Case
            // Left Right Case
            // Right Left Case

        if (node == null) {
            return new Node(key);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed
            return node;
        }
        // Update height of this ancestor node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        
        // Get the balance factor
        int balance = getBalance(node);
        
        // If this node becomes unbalanced, then there are 4 cases:
        // Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }
        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        // Return the (unchanged) node pointer
        return node;

        
    }
    
    // Public wrapper for insertion that updates root.
    public void insert(T key) {
        root = insert(root, key); // Calls helper method
    }
    
    // ----------------- Rotation Methods -----------------
    
    // Right rotation
    private Node rightRotate(Node y) {
        //To do: Complete this (Steps below)  
        
            // Perform rotation
            // Update heights
            // Return new root

        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x; // New root
        
    }
    
    // Left rotation
    private Node leftRotate(Node x) {
        //To do: Complete this (Steps below)  

            // Perform rotation
            // Update heights
            // Return new root

        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y; // New root
        
    }
    
    // ----------------- Utility Methods -----------------
    
    // Returns the height of the node
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }
    
    // Returns the balance factor of the node
    private int getBalance(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }
    
    // ----------------- Search -----------------
    
    // Recursive search: returns the node if found, else null.
    public Node search(Node node, T key) {
        if (node == null || key.equals(node.key)) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
    
    // Public search wrapper. Returns true if the key exists.
    public boolean search(T key) {
        return search(root, key) != null;
    }
    
    // ----------------- Deletion -----------------
    
    // Recursive deletion of a node with given key.
    public Node delete(Node node, T key) {
        if (node == null) {
            return node;
        }
        
        // Standard BST deletion
        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            // Node to be deleted found
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    // No child case
                    node = null;
                } else {
                    // One child case
                    node = temp;
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = delete(node.right, temp.key);
            }
        }
        
        // If the tree had only one node then return
        if (node == null) {
            return node;
        }
        
        // Update height and balance the node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    
    // Finds the node with minimum key value in a subtree.
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // Public wrapper for deletion
    public void delete(T key) {
        root = delete(root, key);
    }
    
    // ----------------- Display -----------------
    
    // Recursively displays the tree in an indented (sideways) format.
    public void display(Node node, int level) {
        if (node == null) {
            return;
        }
        
        display(node.right, level + 1); // right subtree first
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.key);
        display(node.left, level + 1);  // then left subtree
    }
    
    // ----------------- Test Method -----------------
    
    // Inserts a predefined set of keys and displays the resulting AVL tree.
    public void testInsertAndDisplay() {
        // Using an array of Integer keys for this test.
        // (Casting required because of generic array creation limitations.)

        T[] keys = (T[]) new Comparable[]{(T)(Integer)30, (T)(Integer)20, (T)(Integer)40, (T)(Integer)10, (T)(Integer)25, (T)(Integer)35, (T)(Integer)50};
        
        for (T key : keys) {
            insert(key);
        }
        
        System.out.println("AVL Tree Display:");
        System.out.println("Please read tree right (Root) to left (Leaves) ");
        display(root, 0);
    }
}
