package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.matcher.ITaskMatcher;

/**
 * Represents a project that contains a collection of tasks.
 * Each project has a unique ID, title, description, creation date, and a list of tasks.
 * The class allows for adding, retrieving, filtering, and removing tasks.
 */
public class Project implements Comparable<Project>, Serializable {
    private final String title;
    private final int id;
    private final String description;
    private final LocalDate created;
    private  int nextTaskId;
    private final ArrayList<Task> tasks;

    /**
     * Constructs a new {@code Project} with the specified title, description, and ID.
     * The project creation date is set to the current date, and the task list is initialized empty.
     * @param title       The title of the project.
     * @param description The description of the project.
     * @param id          The unique identifier for the project.
     */
    Project(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.created = LocalDate.now();
        this.nextTaskId = 1;
        this.tasks = new ArrayList<>();
    }

    /**
     * Retrieves a task from the project by its unique ID.
     *
     * @param id The ID of the task to retrieve.
     * @return The task with the specified ID, or {@code null} if not found.
     */
    public Task getTaskById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
    /**
     * Adds a new task to the project with the specified description and priority.
     *
     * The task is assigned a unique ID and added to the project's task list.
     *
     * @param descr The description of the new task.
     * @param prio  The priority of the new task.
     * @return The newly created {@code Task}.
     */
    public Task addTask(String descr, TaskPrio prio) {
        Task task = new Task(nextTaskId, descr, prio);
        nextTaskId++;
        tasks.add(task);
        return task;
    }

    /**
     * Finds and returns tasks that match the specified criteria using an {@code ITaskMatcher}.
     * The matched tasks are sorted by their natural order (priority, then description).
     * @param matcher The matcher used to filter tasks.
     * @return A list of tasks that match the given criteria, sorted by natural order.
     */
    public List<Task> findTasks(ITaskMatcher matcher) {
        List<Task> matchedTasks = tasks.stream().filter(matcher::match).collect(Collectors.toList());
        matchedTasks.sort(Comparator.naturalOrder());
        return matchedTasks;
    }

    /**
     * Determines the current state of the project based on the state of its tasks.
     * Returns {@code ProjectState.EMPTY} if the project has no tasks, {@code ProjectState.ONGOING}
     * if any tasks are in progress, and {@code ProjectState.COMPLETED} if all tasks are completed.
     * @return The current state of the project.
     */
    public ProjectState getProjectState() {
        if (tasks.isEmpty()) {return ProjectState.EMPTY;}
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).getState();
            if (tasks.get(i).getState() == TaskState.IN_PROGRESS) {return ProjectState.ONGOING;}
        }
        return ProjectState.COMPLETED;
    }

    /**
     * Returns the last update date of the project.
     * If the project has no tasks, the creation date of the project is returned.
     * @return The most recent update date of the project or its tasks.
     */
    public LocalDate getLastUpdated() {
        LocalDate lastUpdated;
        if (tasks.isEmpty()) {
            return created;
        }
        return tasks.stream().map(Task::getLastUpdated).max(LocalDate::compareTo).orElse(created);
    }

    /**
     * Removes the specified task from the project.
     * @param task The task to be removed.
     * @return {@code true} if the task was removed, {@code false} otherwise.
     */
    public boolean removeTask(Task task){
        return this.tasks.remove(task);
    }

    public String getName() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
