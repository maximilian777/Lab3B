package model;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private final List<Project> projects;
    private int nextProjectId;

    public ProjectsManager() {
        projects = new ArrayList<>();
        nextProjectId = 1;
    }

    public void setProjects(List<Project> newProjects) {
        projects.clear();
        if (newProjects != null) {
            projects.addAll(newProjects);
        }
        nextProjectId = projects.size() + 1;
    }

    public boolean isTitleUnique(String title) {
        for (Project project : projects) {
            if (project.getName().equals(title)) {
                return false;
            }
        }
        return true;
    }

    public Project addProject(String title, String description) {
        if (!isTitleUnique(title)) {
            throw new IllegalArgumentException("The project title must be unique");
        }
        Project newProject = new Project(title, description, nextProjectId++);
        projects.add(newProject);
        return newProject;
    }

    public void removeProject(Project project) {
        projects.removeIf(p -> p.equals(project));
    }

    public Project getProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }

    public List<Project> findProjects(String title) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.getName().contains(title)) {
                result.add(project);
            }
        }
        return result;
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }
}
