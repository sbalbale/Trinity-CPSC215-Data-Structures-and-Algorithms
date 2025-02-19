package edu.trincoll.part3;

public class TaskManager {
    private Node<Task> head;
    private Node<Task> tail;

    /**
     * Constructs an empty TaskManager.
     */
    public TaskManager() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds a new task to the task manager.
     *
     * @param task the task to add
     */
    public void addTask(Task task) {
        if (head == null) {
            head = new Node<Task>(task);
            tail = head;
        } else {
            Node<Task> newNode = new Node<Task>(task);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Removes a task from the task manager by its ID.
     *
     * @param taskId the ID of the task to remove
     */
    public void removeTask(int taskId) {
        Node<Task> current = head;
        while (current.next != null) {
            if (current.next.data.getTaskId() == taskId) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                } else {
                    tail = current;
                }
            } else {
                current = current.next;
            }
        }
    }

    /**
     * Updates an existing task in the task manager.
     *
     * @param taskId the ID of the task to update
     * @param updatedTask the updated task object
     */
    public void updateTask(int taskId, Task updatedTask) {
        Node<Task> current = head;
        while (current != null) {
            if (current.data.getTaskId() == taskId) {
                current.data = updatedTask;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Retrieves a task from the task manager by its ID.
     *
     * @param taskId the ID of the task to retrieve
     * @return the task with the specified ID, or null if not found
     */
    public Task getTask(int taskId) {
        Node<Task> current = head;
        while (current != null) {
            if (current.data.getTaskId() == taskId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Displays all tasks in the task manager.
     */
    public void displayAllTasks() {
        Node<Task> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}