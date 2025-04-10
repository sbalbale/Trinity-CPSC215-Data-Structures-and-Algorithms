package edu.trincoll.partB;

import edu.trincoll.partA.AVLTree;

public class PerformanceComparisonTest {

    // Method to generate random elements
    public static int[] generateRandomElements(int size) {
        int[] randomElements = new int[size];
        for (int i = 0; i < size; i++) {
            randomElements[i] = (int) (Math.random() * 10000); // Generate random integers
        }
        return randomElements;
    }

    public static void main(String[] args) {
        // Test the performance of the different data structures
        int[] n = {1000, 10000, 100000, 500000};
        long startTime, endTime, duration;
        // Test the performance of the different data structures

        for (int size : n) {
            // Generate N random elements using generateRandomElements method
            int[] randomElements = generateRandomElements(size);
            System.out.println("--------------------------------------------------");
            

            System.out.println("Testing with size: " + size);
            System.out.println("--------------------------------------------------");
            // AVL Tree
            System.out.println("AVL Tree:");
            AVLTree<Integer> avlTree = new AVLTree<>();
            
            // insert N elements
            // Measure the time taken to insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                avlTree.insert(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Insertion time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                avlTree.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                avlTree.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");


            // BST
            System.out.println("Binary Search Tree:");
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();

            // insert N elements
            // Measure the time taken to insert N elements  
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                bst.insert(randomElements[i]);
            }          
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Insertion time  for n elements: " + duration + " ns");
            
            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                bst.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                bst.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            

            // Hash Table 
            System.out.println("Hash Table:");
            HashTable<Integer, Integer> hashTable = new HashTable<>();
            
            // insert N elements
            // Measure the time taken to insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hashTable.put(randomElements[i], randomElements[i]);
            }          
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Insertion time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                hashTable.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                hashTable.get(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            // Queues
            System.out.println("Queue:");
            Queue<Integer> queue = new Queue<>();
            
            // insert N elements
            // Measure the time taken to insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                queue.enqueue(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Enqueue time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                queue.dequeue();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Dequeue time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                queue.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Peek time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            // Stacks
            System.out.println("Stack:");
            Stack<Integer> stack = new Stack<>();
            
            // insert N elements
            // Measure the time taken to insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                stack.push(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Push time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                stack.pop();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Pop time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                stack.peek();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Peek time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            // Splay Tree
            System.out.println("Splay Tree:");
            SplayTree<Integer> splayTree = new SplayTree<>();

            // insert N elements
            // Measure the time taken to insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                splayTree.insert(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Insertion time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                splayTree.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                splayTree.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");


            // Heaps
            System.out.println("Heap:");
            Heap<Integer> heap = new Heap<>(2*size);
            
            // insert N elements
            // Measure the time taken to insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                heap.insert(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Insertion time for n elements: " + duration + " ns");

            // delete N/2 elements
            // Measure the time taken to delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                heap.extractMax();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");

            // search N/2 elements
            // Measure the time taken to search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                heap.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            System.out.println();

        }



        

        
    }
}
