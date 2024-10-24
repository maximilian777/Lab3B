package model.matcher;

import model.*;

/**
 * A matcher implementation that checks if a task is taken by a specific user.
 * The matcher will return {@code true} if the task is taken by the user specified
 * in the constructor.
 */
public class TakenByMatcher implements ITaskMatcher{
    public String takenBy;

    /**
     * Constructs a {@code TakenByMatcher} with the specified user.
     *
     * @param takenBy The user to match the task against.
     */
    public TakenByMatcher(String takenBy) {
        this.takenBy = takenBy;
    }

    /**
     * Matches a task based on whether it has been taken by the specified user.
     *
     * @param task The task to be checked.
     * @return {@code true} if the task is taken by the user specified during construction,
     *         {@code false} otherwise.
     */
    @Override
    public boolean match(Task task) {
        if (task.getTakenBy().equals(takenBy)) {
            return true;
        }
        return false;
    }

}
