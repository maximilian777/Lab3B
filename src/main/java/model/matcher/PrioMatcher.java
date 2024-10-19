package model.matcher;

import model.*;

public class PrioMatcher implements ITaskMatcher {
    public TaskPrio prio;

    public PrioMatcher(TaskPrio prio) {

    }

    @Override
    public boolean match(Task task) {
        return false;
    }
}
