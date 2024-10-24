package model.matcher;

import model.*;

/**
 * A matcher implementation that checks if a task is not marked as {@code TaskState.DONE}.
 */
public class NotDoneMatcher implements ITaskMatcher {
    /**
     * Determines whether the task is not in the {@code TaskState.DONE} state.
     *
     * @param task The task that is being checked.
     * @return {@code true} if the task is not done, {@code false} otherwise.
     */
    @Override
    public boolean match(Task task) {
        if (task.getState() != TaskState.DONE) {
            return true;
        }
        return false;
    }
}
