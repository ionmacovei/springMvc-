package net.codejava.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.convertor.SimpleUserEditor;
import net.codejava.spring.dao.ProjectDao;
import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Adress;
import net.codejava.spring.model.Project;
import net.codejava.spring.model.User;


@Controller
public class ProjectController {
    @Autowired
    ProjectDao projectDao;
    @Autowired
    UserDao userdao ;
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(User.class, new SimpleUserEditor(userdao));
	}
	@RequestMapping("/listProjects")
	public ModelAndView handleRequest() throws Exception {
		List<Project> listProjects = projectDao.getProjects();
		ModelAndView model = new ModelAndView("project/ProjectList");
		model.addObject("projectsList", listProjects);
		return model;
	} 
	
	@RequestMapping(value = "/newProject", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("project/ProjectForm");
		List<User> users = userdao.list();
		model.addObject("project", new Project());
		model.addObject("users",users);
		return model;		
	}
	
	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		projectDao.deleteProject(projectId);
		return new ModelAndView("redirect:/listProjects");		
	}
	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public ModelAndView editProject(HttpServletRequest request) {
		int projectID = Integer.parseInt(request.getParameter("id"));
		Project project = projectDao.getproject(projectID);
		List<User> users = userdao.getUsersNotWithTheProject(projectID);
		ModelAndView model = new ModelAndView("project/ProjectForm");
		model.addObject("project", project);
		model.addObject("users",users);
		return model;		
	}
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Project project) {
		projectDao.saveOrUpdateProject(project);
		return new ModelAndView("redirect:/listProjects");
	}
	
	@RequestMapping(value = "/projectDetails", method = RequestMethod.GET)
	public ModelAndView userDetails(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectDao.getProjectWithUsers(projectId);
		List<User> users= project.getUsers();
		ModelAndView model = new ModelAndView("project/ProjectDetails");
		model.addObject("project", project);
		model.addObject("users", users);
		return model;		
	}

}
