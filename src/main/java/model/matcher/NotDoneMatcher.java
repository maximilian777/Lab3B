package model.matcher;

import model.*;

public class NotDoneMatcher implements ITaskMatcher {
    @Override
    public boolean match(Task task) {
        return true;
    }
}
