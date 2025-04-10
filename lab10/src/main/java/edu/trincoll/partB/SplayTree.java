package edu.trincoll.partB;

public class SplayTree<T extends Comparable<T>> {

    public Node root;

    // ----------------- Node Definition -----------------
    public class Node {
        T key;
        Node left, right;

        public Node(T key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    // ----------------- Splay Operation -----------------
    // Splays the tree for the given key and returns the new root.
    private Node splay(Node root, T key) {
        if (root == null) {
            return null;
        }

        int cmp1 = key.compareTo(root.key);

        // If key is in root, we're done.
        if (cmp1 == 0) {
            return root;
        }

        // Key lies in left subtree
        if (cmp1 < 0) {
            if (root.left == null) {
                return root;
            }

            int cmp2 = key.compareTo(root.left.key);

            // Zig-Zig (Left Left)
            if (cmp2 < 0) {
                root.left.left = splay(root.left.left, key);
                root = rotateRight(root);
            }
            // Zig-Zag (Left Right)
            else if (cmp2 > 0) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null) {
                    root.left = rotateLeft(root.left);
                }
            }

            return (root.left == null) ? root : rotateRight(root);
        }
        // Key lies in right subtree
        else { 
            if (root.right == null) {
                return root;
            }

            int cmp2 = key.compareTo(root.right.key);

            // Zig-Zag (Right Left)
            if (cmp2 < 0) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null) {
                    root.right = rotateRight(root.right);
                }
            }
            // Zig-Zig (Right Right)
            else if (cmp2 > 0) {
                root.right.right = splay(root.right.right, key);
                root = rotateLeft(root);
            }

            return (root.right == null) ? root : rotateLeft(root);
        }
    }

    // ----------------- Rotation Methods -----------------
    // Right rotation.
    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    // Left rotation.
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // ----------------- Insertion -----------------
    // Inserts key into the Splay Tree and splays the inserted node to the root.
    public void insert(T key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        root = splay(root, key);
        int cmp = key.compareTo(root.key);

        // If the key is already present, no need to insert it again.
        if (cmp == 0) {
            return;
        }

        Node newNode = new Node(key);
        if (cmp < 0) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {  // cmp > 0
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }
        root = newNode;
    }

    // ----------------- Search -----------------
    // Searches for key in the Splay Tree.
    public boolean search(T key) {
        if (root == null) {
            return false;
        }
        root = splay(root, key);
        return key.compareTo(root.key) == 0;
    }

    // ----------------- Deletion -----------------
    // Deletes key from the Splay Tree.
    public void delete(T key) {
        if (root == null) {
            return;
        }
        root = splay(root, key);
        if (key.compareTo(root.key) != 0) {
            return; // Key not found; do nothing.
        }

        // If there is no left subtree, promote right subtree.
        if (root.left == null) {
            root = root.right;
        } else {
            // Splay the maximum node in the left subtree and attach the right subtree.
            Node temp = root.right;
            root = root.left;
            root = splay(root, key);
            root.right = temp;
        }
    }

    // ----------------- Display -----------------
    // Recursively displays the tree with the root at the top.
    // Each level is indented to indicate the hierarchy.
    public void display(Node node, int level) {
        if (node == null) {
            return;
        }

        // Print indentation based on the level.
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.key);

        // Display left subtree first then right subtree.
        display(node.left, level + 1);
        display(node.right, level + 1);
    }

    // ----------------- Test Method -----------------
    // Inserts a predefined set of keys and displays the resulting Splay Tree.
    public void testInsertAndDisplay() {
        Integer[] keys = {30, 20, 40, 10, 25, 35, 50};
        for (Integer key : keys) {
            insert((T) key);
        }
        System.out.println("Splay Tree Display (Root at Top):");
        display(root, 0);
    }
}
