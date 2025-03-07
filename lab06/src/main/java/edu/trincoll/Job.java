package edu.trincoll;

/**
 * Represents a job with an ID, owner, execution time, remaining time, and
 * priority.
 */
public class Job {

    /**
     * The unique identifier for the job.
     */
    private int jobId;

    /**
     * The owner of the job.
     */
    private String owner;

    /**
     * The total execution time required for the job.
     */
    private int executionTime;

    /**
     * The remaining execution time for the job.
     */
    private int remainingTime;

    /**
     * The priority of the job.
     */
    private int priority;

    /**
     * Constructs a new Job with the specified ID, owner, execution time, and
     * priority.
     *
     * @param jobId         the unique identifier for the job
     * @param owner         the owner of the job
     * @param executionTime the total execution time required for the job
     * @param priority      the priority of the job
     */
    public Job(int jobId, String owner, int executionTime, int priority) {
        this.jobId = jobId;
        this.owner = owner;
        this.executionTime = executionTime;
        this.remainingTime = executionTime;
        this.priority = priority;
    }

    /**
     * Returns the job ID.
     *
     * @return the job ID
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * Sets the job ID.
     *
     * @param jobId the job ID to set
     */
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     * Returns the owner of the job.
     *
     * @return the owner of the job
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the job.
     *
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Returns the total execution time required for the job.
     *
     * @return the execution time
     */
    public int getExecutionTime() {
        return executionTime;
    }

    /**
     * Sets the total execution time required for the job.
     *
     * @param executionTime the execution time to set
     */
    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * Returns the remaining execution time for the job.
     *
     * @return the remaining time
     */
    public int getRemainingTime() {
        return remainingTime;
    }

    /**
     * Sets the remaining execution time for the job.
     *
     * @param remainingTime the remaining time to set
     */
    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    /**
     * Returns the priority of the job.
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority of the job.
     *
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Returns a string representation of the job.
     *
     * @return a string representation of the job
     */
    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Owner: " + owner + ", Execution Time: " + executionTime + ", Remaining Time: "
                + remainingTime + ", Priority: " + priority;
    }
}
