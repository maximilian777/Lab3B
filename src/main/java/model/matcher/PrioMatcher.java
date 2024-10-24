package model.matcher;

import model.*;

/**
 * A matcher implementation that checks if a task has a specific priority.
 * This matcher returns {@code true} if the task's priority matches the priority
 * specified in the constructor.
 */
public class PrioMatcher implements ITaskMatcher {
    public TaskPrio prio;

    /**
     * Constructs a {@code PrioMatcher} with the specified priority.
     * @param prio The priority to match tasks against.
     */
    public PrioMatcher(TaskPrio prio) {
        this.prio = prio;
    }

    /**
     * Matches a task based on whether its priority equals the specified priority.
     * @param task The task to be checked.
     * @return {@code true} if the task's priority matches the priority given during construction,
     *         {@code false} otherwise.
     */
    @Override
    public boolean match(Task task) {
        if (task.getPrio() == prio) {
            return true;
        }
        return false;
    }
}
