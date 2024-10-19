package model.matcher;

import model.*;

public interface ITaskMatcher {
    default boolean match(Task task) {
        return true;
    };
}
