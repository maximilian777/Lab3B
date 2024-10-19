package model;

import java.util.List;

public class ProjectsManager {
    private int nextProjectId;

    ProjectsManager() {

    }

    public void setNextProjectId(int nextProjectId) {
        this.nextProjectId = nextProjectId;
    }

    public boolean isTitleUnique(String title) {
        return true;
    }

    public Project addProject(String title, String descr) {
        return null;
    }

    public Project removeProject() {
        return null;
    }

    public Project getProjectId(int id) {
        return null;
    }

    public List<Project> findProjects(String titleStr) {
        return null;
    }

    public int getHighestId() {
        return 0;
    }
}
