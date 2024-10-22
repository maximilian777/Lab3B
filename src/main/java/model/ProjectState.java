package model;

public enum ProjectState {
    EMPTY("EMPTY"), ONGOING("ONGOING"), COMPLETED("COMPLETED");
    private final String state;

    ProjectState(String state) {
        this.state = state;
    };
}
