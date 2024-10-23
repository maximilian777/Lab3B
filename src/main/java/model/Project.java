package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.matcher.ITaskMatcher;

public class Project implements Comparable<Project> {
    private final String title;
    private final int id;
    private final String description;
    private final LocalDate created;
    private  int nextTaskId;
    private final ArrayList<Task> tasks;

    Project(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.created = LocalDate.now();
        this.nextTaskId = 1;
        this.tasks = new ArrayList<>();
    }

    public Task getTaskById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
    public Task addTask(String descr, TaskPrio prio) {
        Task task = new Task(nextTaskId, descr, prio);
        nextTaskId++;
        tasks.add(task);
        return task;
    }

    public List<Task> findTasks(ITaskMatcher matcher) {
        List<Task> matchedTasks = tasks.stream().filter(matcher::match).collect(Collectors.toList());
        matchedTasks.sort(Comparator.naturalOrder());
        return matchedTasks;
    }

    public ProjectState getProjectState() {
        if (tasks.isEmpty()) {return ProjectState.EMPTY;}
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).getState();
            if (tasks.get(i).getState() == TaskState.IN_PROGRESS) {return ProjectState.ONGOING;}
        }
        return ProjectState.COMPLETED;
    }

    public LocalDate getLastUpdated() {
        LocalDate lastUpdated;
        if (tasks.isEmpty()) {
            return created;
        }
        return tasks.stream().map(Task::getLastUpdated).max(LocalDate::compareTo).orElse(created);
    }

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
