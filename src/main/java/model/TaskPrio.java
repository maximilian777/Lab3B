package model;

public enum TaskPrio {
    LOW(3), MEDIUM(2), HIGH(1);

    private final int priority;

    TaskPrio(int priority) {
        this.priority = priority;
    }
}
