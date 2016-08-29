package net.codejava.spring.dao;

import net.codejava.spring.model.Project;

import java.io.Serializable;
import java.util.List;

public interface ProjectDao extends GenericDao {
    void saveOrUpdateProject(Project project);

    Project getproject(Serializable id);

    void deleteProject(Serializable id);

    List<Project> getProjects();

    Project getProjectWithUsers(Serializable id);

}
