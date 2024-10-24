package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of {@code Project} objects, providing functionalities to add,
 * remove, search, and retrieve projects.
 * Each project is assigned a unique ID when added, and project titles must be unique.
 */
public class ProjectsManager {
    private final List<Project> projects;
    private int nextProjectId;

    public ProjectsManager() {
        projects = new ArrayList<>();
        nextProjectId = 1;
    }

    /**
     * Replaces the current list of projects with the specified list.
     * Clears the existing list and sets the {@code nextProjectId} based on the size of the new list.
     * @param newProjects The new list of projects to manage.
     */
    public void setProjects(List<Project> newProjects) {
        projects.clear();
        if (newProjects != null) {
            projects.addAll(newProjects);
        }
        nextProjectId = projects.size() + 1;
    }

    /**
     * Checks if the given title is unique among all existing projects.
     * @param title The title to check.
     * @return {@code true} if the title is unique, {@code false} otherwise.
     */
    public boolean isTitleUnique(String title) {
        for (Project project : projects) {
            if (project.getName().equals(title)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a new project with the specified title and description.
     * The project title must be unique, or an {@code IllegalArgumentException} will be thrown.
     * @param title       The title of the new project.
     * @param description The description of the new project.
     * @return The newly created {@code Project}.
     * @throws IllegalArgumentException if the project title is not unique.
     */
    public Project addProject(String title, String description) {
        if (!isTitleUnique(title)) {
            throw new IllegalArgumentException("The project title must be unique");
        }
        Project newProject = new Project(title, description, nextProjectId++);
        projects.add(newProject);
        return newProject;
    }

    /**
     * Removes the specified project from the list of managed projects.
     * @param project The project to be removed.
     */
    public void removeProject(Project project) {
        projects.removeIf(p -> p.equals(project));
    }

    /**
     * Retrieves a project by its unique ID.
     * @param id The unique ID of the project.
     * @return The {@code Project} with the given ID, or {@code null} if no such project exists.
     */
    public Project getProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }

    /**
     * Finds and returns a list of projects whose titles contain the specified string.
     * @param title The title substring to search for.
     * @return A list of {@code Project} objects with titles containing the given string.
     */
    public List<Project> findProjects(String title) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.getName().contains(title)) {
                result.add(project);
            }
        }
        return result;
    }

    /**
     * Retrieves the list of all projects managed by this manager.
     * The returned list is a copy, so modifications to it will not affect the original list.
     * @return A list of all {@code Project} objects.
     */
    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }
}
