package net.codejava.spring.dao;

import java.io.Serializable;
import java.util.List;

import net.codejava.spring.model.Project;

public interface ProjectDao {
	public void saveOrUpdateProject(Project project);

	public Project getproject(Serializable id);

	public void deleteProject(Serializable id);

	public List<Project> getProjects();

	public Project getProjectWithUsers(Serializable id);

}
