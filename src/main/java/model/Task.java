package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Comparable<Task>, Serializable {
    private final int id;
    private final String description;
    private String takenBy;
    private TaskState state;
    private TaskPrio prio;
    private LocalDate lastUpdated;
    private final LocalDate created;

    /**
     * Constructs a new {@code Task} with the specified ID, description, and priority.
     * The task state is initialized to {@code TaskState.TO_DO}, and the creation date is set to the current date.
     * @param id          The unique identifier for the task.
     * @param description The description of the task.
     * @param prio        The priority of the task.
     */
    Task(int id, String description, TaskPrio prio) {
        this.id = id;
        this.description = description;
        this.takenBy = takenBy;
        this.state = TaskState.TO_DO;
        this.prio = prio;
        this.created = LocalDate.now();
        this.lastUpdated = created;
    }

    /**
     * Sets the user who has taken the task.
     * Throws an {@code IllegalStateException} if the task has already been taken by someone.
     * @param takenBy The name of the user taking the task.
     * @throws IllegalStateException if the task is already taken.
     */
    public void setTakenBy(String takenBy) {
        if (this.takenBy != null && !this.takenBy.isEmpty()) {
            throw new IllegalStateException("Task is already taken by someone.");
        }
        this.takenBy = takenBy;
        this.lastUpdated = LocalDate.now();
    }

    /**
     * Updates the state of the task.
     * @param state The new {@code TaskState} of the task.
     */
    public void setState(TaskState state) {
        this.state = state;
        this.lastUpdated = LocalDate.now();
    }

    /**
     * Updates the priority of the task.
     * @param prio The new priority of the task.
     */
    public void setPrio(TaskPrio prio) {
        this.prio = prio;
        this.lastUpdated = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public TaskState getState() {
        return state;
    }

    public TaskPrio getPrio() {
        return prio;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public LocalDate getCreated() {
        return created;
    }

    @Override
    public int compareTo(Task other) {
        int prioComparison = this.prio.compareTo(other.prio);
        if (prioComparison != 0) {
            return prioComparison;
        }
        return this.description.compareTo(other.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Task task = (Task) o;
        return description.equals(task.description) && prio == task.prio;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", takenBy='" + takenBy + '\'' +
                ", state=" + state +
                ", prio=" + prio +
                '}';
    }
}