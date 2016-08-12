package net.codejava.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.convertor.SimpleUserEditor;
import net.codejava.spring.dao.AdressDao;
import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Adress;
import net.codejava.spring.model.User;

@Controller
public class AdressController {

	@Autowired
	private AdressDao adressDao;
	@Autowired
	private UserDao userDao;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(User.class, new SimpleUserEditor(userDao));
	}

	@RequestMapping("/listAdress")
	public ModelAndView handleRequest() throws Exception {
		List<Adress> listAdresses = adressDao.getAdress();
		ModelAndView model = new ModelAndView("adress/AdressList");
		model.addObject("adressList", listAdresses);
		return model;
	}

	@RequestMapping(value = "/newAdress", method = RequestMethod.GET)
	public ModelAndView newaAdress() {
		ModelAndView model = new ModelAndView("adress/AdressForm");
		model.addObject("adress", new Adress());
		model.addObject("users", userDao.list());
		return model;
	}

	@RequestMapping(value = "/editAdress", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int adressId = Integer.parseInt(request.getParameter("id"));
		Adress adress = adressDao.getAdress(adressId);
		ModelAndView model = new ModelAndView("adress/AdressForm");
		model.addObject("adress", adress);
		model.addObject("users", userDao.list());
		return model;
	}

	@RequestMapping(value = "/deleteAdress", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int adressId = Integer.parseInt(request.getParameter("id"));
		adressDao.deleteAdress(adressId);
		return new ModelAndView("redirect:/listAdress");
	}

	@RequestMapping(value = "/saveAdress", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Adress adress) {
		adressDao.saveOrUpdateAdress(adress);
		return new ModelAndView("redirect:/listAdress");
	}
}
