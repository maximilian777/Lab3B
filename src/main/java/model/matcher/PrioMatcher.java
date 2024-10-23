package model.matcher;

import model.*;

public class PrioMatcher implements ITaskMatcher {
    public TaskPrio prio;

    public PrioMatcher(TaskPrio prio) {
        this.prio = prio;
    }

    @Override
    public boolean match(Task task) {
        if (task.getPrio() == prio) {
            return true;
        }
        return false;
    }
}
