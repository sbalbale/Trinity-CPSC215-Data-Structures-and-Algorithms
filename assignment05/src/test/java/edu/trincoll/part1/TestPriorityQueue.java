package edu.trincoll.part1;
public class TestPriorityQueue {
    public static void main(String[] args) {
        // Instantiate PriorityQueue
        PriorityQueue<Order> priorityQueue = new PriorityQueue<>();

        // Test enqueue method
        priorityQueue.enqueue(new Order(20, "Customer 1", 5));
        priorityQueue.enqueue(new Order(30, "Customer 2", 4));
        priorityQueue.enqueue(new Order(40, "Customer 3", 1));
        priorityQueue.enqueue(new Order(25, "Customer 4", 2));


        System.out.println("********* PRINTING PRIORITY QUEUE DUMP *********");
        int cap = 0;
        while(cap < priorityQueue.size()){
            priorityQueue.printInfo(cap).print();
            cap = cap + 1;
        }
        System.out.println("********* END PRIORITY QUEUE DUMP *********");
        System.out.println();

        // Test frontValue method
        System.out.println("Front Value:");
        priorityQueue.frontValue().print();
        System.out.println();

        // Test dequeue method
        System.out.println("\nDequeue:");
        Order removedOrder = priorityQueue.dequeue();
        removedOrder.print();
        System.out.println();


        System.out.println("********* PRINTING PRIORITY QUEUE DUMP *********");
        cap = 0;
        while(cap < priorityQueue.size()){
            priorityQueue.printInfo(cap).print();
            cap = cap + 1;
        }
        System.out.println("********* END PRIORITY QUEUE DUMP *********");


    }
}


