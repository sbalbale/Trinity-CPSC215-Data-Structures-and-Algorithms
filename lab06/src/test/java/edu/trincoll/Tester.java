package edu.trincoll;

public class Tester {
    public static void main(String[] args) {
        // Initialize an empty list (jobQueue) using DList
        DList jobQueue = new DList();

        // Create five Job objects
        Job job1 = new Job(1, "Alice", 15, 3);
        Job job2 = new Job(2, "Bob", 8, 1);
        Job job3 = new Job(3, "Charlie", 20, 2);
        Job job4 = new Job(4, "David", 12, 4);
        Job job5 = new Job(5, "Eve", 18, 5);

        // Insert five Job objects
        jobQueue.insert(job1);
        jobQueue.insert(job2);
        jobQueue.insert(job3);
        jobQueue.insert(job4);
        jobQueue.insert(job5);

        // Display the job list
        System.out.println("Initial Job Queue:");
        jobQueue.display();
        System.out.println();

        // Add a duplicate job (duplicate Eve aka job5)
        jobQueue.insert(job5);
        System.out.println("After adding duplicate job:");
        jobQueue.display();
        System.out.println();

        // Remove duplicates
        System.out.println("\nAfter removing duplicates:");
        jobQueue.remove_duplicates();
        jobQueue.display();

        // Reverse the list
        System.out.println("\nAfter reversing the list:");
        jobQueue.reverse();
        jobQueue.display();

        // Call skip display
        System.out.println("\nSkip Display (first 2 elements):");
        jobQueue.skip_display(2);

        // Define a time quantum
        int quantum = 5;
        System.out.println();
        System.out.println("Time Quantum: " + quantum + " units");

        // Print Current State
        System.out.println("Current State:");
        jobQueue.display();
        System.out.println();

        // Start Round-Robin Job Scheduling
        System.out.println("\nStarting Round-Robin Job Scheduling with quantum = " + quantum);

        while (!jobQueue.isEmpty()) {
            DLink currentJob = jobQueue.getHead().getNext();
            Job job = currentJob.getData();

            // Execute the job for the time quantum
            System.out.println("Executing Job " + job.getJobId() + " for " + quantum + " units");

            job.setRemainingTime(job.getRemainingTime() - quantum);

            // Print Pending Jobs (Not including the current job)
            System.out.println("Pending Jobs:");
            jobQueue.skip_display(1);
            System.out.println();

            // Remove the job if it is completed
            if (job.getRemainingTime() <= 0) {
                System.out.println("Job " + job.getJobId() + " completed");
                jobQueue.remove(job);
            } else {
                // Move the job to the end of the queue if it is not completed
                jobQueue.remove(job);
                jobQueue.insert(job);
            }
        }

        // End when all jobs are completed
        System.out.println();
        System.out.println("All jobs completed. Job Queue is empty.");
    }
}