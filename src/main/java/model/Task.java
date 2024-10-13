package model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private String takenBy;
    private TaskState state;
    private TaskPrio prio;
    private LocalDate lastUpdated;
    private final LocalDate created;

    Task(int id, String description, TaskPrio prio) {
        this.id = id;
        this.description = description;
        this.takenBy = takenBy;
        this.state = TaskState.TO_DO;
        this.prio = prio;
        this.lastUpdated = created;
    }


}
