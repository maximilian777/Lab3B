package model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private String takenBy;
    private TaskState state;
    private TaskPrio prio;
    private LocalDate lastUpdated;

    Task(int id, String description, String takenBy, TaskState state, TaskPrio prio) {
        this.id = id;
        this.description = description;
        this.takenBy = takenBy;
        this.state = state;
        this.prio = prio;
    }


}
