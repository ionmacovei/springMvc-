package net.codejava.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Adress;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("/listUsers")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("user/UserList");
		model.addObject("userList", listUsers);
		return model;
	}
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("user/UserForm");
		model.addObject("user", new User());
		return model;		
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(userId);
		ModelAndView model = new ModelAndView("user/UserForm");
		model.addObject("user", user);
		return model;		
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userDao.delete(userId);
		return new ModelAndView("redirect:/listUsers");		
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/listUsers");
	}
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public ModelAndView userDetails(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userDao.getUserWithAdresses(userId);
		List<Adress> addresses= user.getAdresses();
		ModelAndView model = new ModelAndView("user/UserDetails");
		model.addObject("user", user);
		model.addObject("addresses", addresses);
		return model;		
	}
	
}
