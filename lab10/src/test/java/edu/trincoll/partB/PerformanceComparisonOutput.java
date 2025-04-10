package edu.trincoll.partB;

import edu.trincoll.partA.AVLTree;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PerformanceComparisonOutput {

    // Class to store performance data
    private static class PerformanceData {
        String dataStructure;
        int numberOfElements;
        String operation;
        long completionTime;
        
        public PerformanceData(String dataStructure, int numberOfElements, String operation, long completionTime) {
            this.dataStructure = dataStructure;
            this.numberOfElements = numberOfElements;
            this.operation = operation;
            this.completionTime = completionTime;
        }
    }
    
    // Method to generate random elements
    public static int[] generateRandomElements(int size) {
        int[] randomElements = new int[size];
        for (int i = 0; i < size; i++) {
            randomElements[i] = (int) (Math.random() * 10000); // Generate random integers
        }
        return randomElements;
    }
    
    // Method to write performance data to CSV
    public static void writeToCSV(List<PerformanceData> dataList, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header
            writer.println("Data Structure,\"Number of Elements (N)\",Operation,Actual Completion Time (ns)");
            
            // Write data
            for (PerformanceData data : dataList) {
                writer.println(data.dataStructure + "," + data.numberOfElements + "," + 
                              data.operation + "," + data.completionTime);
            }
            System.out.println("CSV file created successfully: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test the performance of the different data structures
        int[] n = {1000, 10000, 100000, 500000};
        long startTime, endTime, duration;
        
        // Create list to store performance data
        List<PerformanceData> performanceDataList = new ArrayList<>();
        
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
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                avlTree.insert(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("AVL Tree", size, "Insert N Elements", duration));
            System.out.println("Insertion time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                avlTree.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("AVL Tree", size, "Delete N/2 Elements", duration));
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                avlTree.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("AVL Tree", size, "Search N/2 Elements", duration));
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");


            // BST
            System.out.println("Binary Search Tree:");
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();

            // insert N elements  
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                bst.insert(randomElements[i]);
            }          
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("BST", size, "Insert N Elements", duration));
            System.out.println("Insertion time  for n elements: " + duration + " ns");
            
            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                bst.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("BST", size, "Delete N/2 Elements", duration));
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                bst.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("BST", size, "Search N/2 Elements", duration));
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            

            // Hash Table 
            System.out.println("Hash Table:");
            HashTable<Integer, Integer> hashTable = new HashTable<>();
            
            // insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hashTable.put(randomElements[i], randomElements[i]);
            }          
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Hash Table", size, "Insert N Elements", duration));
            System.out.println("Insertion time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                hashTable.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Hash Table", size, "Delete N/2 Elements", duration));
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                hashTable.get(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Hash Table", size, "Search N/2 Elements", duration));
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            // Queues
            System.out.println("Queue:");
            Queue<Integer> queue = new Queue<>();
            
            // insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                queue.enqueue(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Queues", size, "Insert N Elements", duration));
            System.out.println("Enqueue time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                queue.dequeue();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Queues", size, "Delete N/2 Elements", duration));
            System.out.println("Dequeue time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                queue.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Queues", size, "Search N/2 Elements", duration));
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            // Stacks
            System.out.println("Stack:");
            Stack<Integer> stack = new Stack<>();
            
            // insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                stack.push(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Stacks", size, "Insert N Elements", duration));
            System.out.println("Push time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                stack.pop();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Stacks", size, "Delete N/2 Elements", duration));
            System.out.println("Pop time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                stack.peek();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Stacks", size, "Search N/2 Elements", duration));
            System.out.println("Peek time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            // Splay Tree
            System.out.println("Splay Tree:");
            SplayTree<Integer> splayTree = new SplayTree<>();

            // insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                splayTree.insert(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Splay Tree", size, "Insert N Elements", duration));
            System.out.println("Insertion time for n elements: " + duration + " ns");
            
            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                splayTree.delete(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Splay Tree", size, "Delete N/2 Elements", duration));
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");
            
            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                splayTree.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Splay Tree", size, "Search N/2 Elements", duration));
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");


            // Heaps
            System.out.println("Heap:");
            Heap<Integer> heap = new Heap<>(2*size);
            
            // insert N elements
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                heap.insert(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Heaps", size, "Insert N Elements", duration));
            System.out.println("Insertion time for n elements: " + duration + " ns");

            // delete N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                heap.extractMax();
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Heaps", size, "Delete N/2 Elements", duration));
            System.out.println("Deletion time for n/2 elements: " + duration + " ns");

            // search N/2 elements
            startTime = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                heap.search(randomElements[i]);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            performanceDataList.add(new PerformanceData("Heaps", size, "Search N/2 Elements", duration));
            System.out.println("Search time for n/2 elements: " + duration + " ns");
            System.out.println("--------------------------------------------------");
            
            System.out.println();
        }
        
        // Write all performance data to CSV
        writeToCSV(performanceDataList, "performance_data_max.csv");
    }
}