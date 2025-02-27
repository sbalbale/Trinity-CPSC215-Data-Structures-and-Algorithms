package edu.trincoll.part2;
// package Lab_4;

//Class to test the LQueue implementation
public class LQueueTest {
    public static void main(String args[]) {
        // Declare a Queue1 object for Q1
        // Declare a Queue1 object for Q2
        // Initialize temporary variable to hold dequeued element

        // Initialize Q1 with a new LQueue object
        // Initialize Q2 with a new LQueue object of size 15
        System.out.println("Creating Queue Q1 and Q2");
        LQueue<Integer> Q1 = new LQueue<Integer>();
        LQueue<Integer> Q2 = new LQueue<Integer>(15);

        System.out.println("Enqueuing three elements in Q2");
        // Add 100 to Q2
        // Add 200 to Q2
        // Add 150 to Q2
        Q2.enqueue(100);
        Q2.enqueue(200);
        Q2.enqueue(150);

        System.out.println("Printing the elements in Q2");
        // Print the elements in Q2
        System.out.println(Q2.toString());

        System.out.println("Dequeing from Q2 and enqueing the elements in Q1");
        // While Q2 is not empty
        // Dequeue an element from Q2
        // Enqueue the dequeued element into Q1
        while (Q2.size() != 0) {
            Q1.enqueue(Q2.dequeue());
        }

        System.out.println("Enqueuing three elements in Q2");
        // Add 10 to Q2
        // Add 20 to Q2
        // Add 50 to Q2
        Q2.enqueue(10);
        Q2.enqueue(20);
        Q2.enqueue(50);

        System.out.println("Printing the elements in Q1");
        // Print the elements in Q1
        System.out.println(Q1.toString());

        System.out.println("Printing the elements in Q2");
        // Print the elements in Q2
        // Print the length of Q2
        // Print the length of Q1
        System.out.println(Q2.toString());
        System.out.println("Length of Q2 " + Q2.size());
        System.out.println("Length of Q1 " + Q1.size());

        System.out.println();
        // Peek at the front element of Q1
        // Peek at the front element of Q2
        System.out.println("Peaking Q1 " + Q1.frontValue());
        System.out.println("Peaking Q2 " + Q2.frontValue());

        System.out.println("Enqueuing three elements in Q2");
        // Add 70 to Q2
        // Add 80 to Q2
        // Add 90 to Q2
        // Print the length of Q2
        Q2.enqueue(70);
        Q2.enqueue(80);
        Q2.enqueue(90);
        System.out.println("Length of Q2 " + Q2.size());

        System.out.println("Printing the elements in Q2");
        // Print the elements in Q2
        System.out.println(Q2.toString());
    }
}
