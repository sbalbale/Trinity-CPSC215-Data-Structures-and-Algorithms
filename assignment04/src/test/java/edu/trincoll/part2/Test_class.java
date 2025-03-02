package edu.trincoll.part2;
// package P2;

/**
 * This class is used to test the functionality of DQStack, DQQueue, and DLDQueue classes.
 */
public class Test_class {
    public static void main(String args[]) {
        // Testing DQStack
        System.out.println("Making the Stack Object");
        DQStack<Integer> stack = new DQStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("Printing stack: " + stack); // Output: Printing stack: [4-3-2-1-0]
        System.out.println("Printing size: " + stack.size()); // Output: Printing size: 5
        Object o = stack.pop();
        System.out.println("Pop element = " + o); // Output: Pop element = 4
        o = stack.pop();
        System.out.println("Pop element = " + o); // Output: Pop element = 3
        System.out.println("Printing stack: " + stack); // Output: Printing stack: [2-1-0]
        System.out.println();
        System.out.println();

        // Testing DQQueue
        System.out.println("Making the Queue Object");
        DLDQueue<Integer> queue = new DLDQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("Printing queue: " + queue); // Output: Printing queue: [4-3-2-1-0]
        System.out.println("Printing size: " + queue.size()); // Output: Printing size: 5
        o = queue.dequeue();
        System.out.println("Deque element = " + o); // Output: Deque element = 0
        o = stack.pop(); // Should be queue.pop() instead of stack.pop()
        System.out.println("Pop element = " + o); // Output: Pop element = 2
        System.out.println("Printing queue: " + queue); // Output: Printing queue: [4-3-2-1]
        System.out.println();
        System.out.println();

  
    }
}
