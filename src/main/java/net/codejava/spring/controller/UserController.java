package net.codejava.spring.controller;

import net.codejava.spring.dao.UserDao;
import net.codejava.spring.model.Adress;
import net.codejava.spring.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
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
    public String saveUser(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.info("Returning custSave.jsp page");
            if (logger.isDebugEnabled()) {
                logger.debug("getWelcome is executed!");
            }
            return "user/UserForm";
        }
        logger.info("Returning custSaveSuccess.jsp page");
        userDao.saveOrUpdate(user);
        return "redirect:/listUsers";
    }

    @RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    public ModelAndView userDetails(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDao.getUserWithAdresses(userId);
        List<Adress> addresses = user.getAdresses();
        ModelAndView model = new ModelAndView("user/UserDetails");
        model.addObject("user", user);
        model.addObject("addresses", addresses);
        return model;
    }

}
