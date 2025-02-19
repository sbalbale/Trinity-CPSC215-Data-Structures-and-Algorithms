package edu.trincoll.part3;
public class Test {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Task 1", "Description 1", 2023, 12, 31, 1);
        Task task2 = new Task(2, "Task 2", "Description 2", 2023, 12, 30, 2);
        Task task3 = new Task(3, "Task 3", "Description 3", 2023, 12, 29, 3);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println("All Tasks:");
        taskManager.displayAllTasks();

        taskManager.removeTask(2);
        System.out.println("\nAfter removing task with ID 2:");
        taskManager.displayAllTasks();

        Task updatedTask = new Task(1, "Updated Task 1", "Updated Description 1", 2023, 12, 31, 1);
        taskManager.updateTask(1, updatedTask);
        System.out.println("\nAfter updating task with ID 1:");
        taskManager.displayAllTasks();
    }
}
