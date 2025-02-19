package edu.trincoll.part3;

public class Task {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private int dueYear;
    private int dueMonth;
    private int dueDay;
    private int priority;

    // Constructor
    /**
     * Constructs a new Task with the specified details.
     *
     * @param taskId          the unique identifier for the task
     * @param taskName        the name of the task
     * @param taskDescription a brief description of the task
     * @param dueYear         the year the task is due
     * @param dueMonth        the month the task is due (1-12)
     * @param dueDay          the day the task is due (1-31)
     * @param priority        the priority level of the task
     */
    public Task(int taskId, String taskName, String taskDescription, int dueYear, int dueMonth, int dueDay,
            int priority) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.dueYear = dueYear;
        this.dueMonth = dueMonth;
        this.dueDay = dueDay;
        this.priority = priority;
    }

    /**
     * Retrieves the unique identifier for this task.
     *
     * @return the task ID
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Sets the task ID for this task.
     *
     * @param taskId the ID to set for this task
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * Retrieves the name of the task.
     *
     * @return the name of the task as a String.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Sets the name of the task.
     *
     * @param taskName the name to set for the task
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Retrieves the description of the task.
     *
     * @return the task description as a String.
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Sets the description of the task.
     *
     * @param taskDescription the description to set for the task
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * Retrieves the year the task is due.
     *
     * @return the due year as an integer.
     */
    public int getDueYear() {
        return dueYear;
    }

    /**
     * Sets the year the task is due.
     *
     * @param dueYear the year to set for the task
     */
    public void setDueYear(int dueYear) {
        this.dueYear = dueYear;
    }

    /**
     * Retrieves the month the task is due.
     *
     * @return the due month as an integer.
     */
    public int getDueMonth() {
        return dueMonth;
    }

    /**
     * Sets the month the task is due.
     *
     * @param dueMonth the month to set for the task
     */
    public void setDueMonth(int dueMonth) {
        this.dueMonth = dueMonth;
    }

    /**
     * Retrieves the day the task is due.
     *
     * @return the due day as an integer.
     */
    public int getDueDay() {
        return dueDay;
    }

    /**
     * Sets the day the task is due.
     *
     * @param dueDay the day to set for the task
     */
    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    /**
     * Retrieves the priority level of the task.
     *
     * @return the priority level as an integer.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority level of the task.
     *
     * @param priority the priority level to set for the task
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return a string containing the task details.
     */
    @Override
    public String toString() {
        // return "Task ID: " + taskId + "\nTask Name: " + taskName + "\nTask
        // Description: " + taskDescription
        // + "\nDue Date: " + dueYear + "-" + dueMonth + "-" + dueDay + "\nPriority: " +
        // priority;
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", dueYear=" + dueYear +
                ", dueMonth=" + dueMonth +
                ", dueDay=" + dueDay +
                ", priority=" + priority +
                '}';
    }
}
