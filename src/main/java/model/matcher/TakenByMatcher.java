package model.matcher;

import model.*;

public class TakenByMatcher implements ITaskMatcher{
    public String takenBy;

    public TakenByMatcher(String takenBy) {
        this.takenBy = takenBy;
    }
    @Override
    public boolean match(Task task) {
        if (task.getTakenBy().equals(takenBy)) {
            return true;
        }
        return false;
    }

}
