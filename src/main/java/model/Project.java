package model;

import java.time.LocalDate;
import java.util.ArrayList;

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
