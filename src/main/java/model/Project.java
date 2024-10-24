package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.matcher.ITaskMatcher;

/**
 * Constructs a new {@code Project} with the specified title, description, and ID.
 * The creation date is set to the current date, and the task list is initialized as empty.
 */
public class Project implements Comparable<Project> {
    private final String title;
    private final int id;
    private final String description;
    private final LocalDate created;
    private  int nextTaskId;
    private final ArrayList<Task> tasks;

    /**
     * Retrieves a task by its unique ID.
     * @param id The ID of the task.
     * @return The {@code Task} with the specified ID, or {@code null} if not found.
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
     * Adds a new task to the project with the specified description and priority.
     * The task is assigned a unique ID within the project.
     * @return The newly created {@code Task}.
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
     * The task is assigned a unique ID within the project.
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
     * Finds and returns tasks that match the specified criteria.
     * The tasks are filtered based on the provided {@code ITaskMatcher} and sorted by their natural order.
     * @param matcher The matcher that defines the task filtering criteria.
     * @return A list of matched tasks, sorted by priority and description.
     */
    public List<Task> findTasks(ITaskMatcher matcher) {
        List<Task> matchedTasks = tasks.stream().filter(matcher::match).collect(Collectors.toList());
        matchedTasks.sort(Comparator.naturalOrder());
        return matchedTasks;
    }

    /**
     * Determines the state of the project based on the state of its tasks.
     * Returns {@code ProjectState.EMPTY} if the project has no tasks, {@code ProjectState.ONGOING} if any tasks are
     * in progress, and {@code ProjectState.COMPLETED} otherwise.
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
     * Returns the date when the project or any of its tasks were last updated.
     * If the project has no tasks, the creation date is returned.
     * @return The last update date of the project or its tasks.
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
     *
     * @param task The task to be removed.
     * @return {@code true} if the task was removed, {@code false} if it was not found.
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
