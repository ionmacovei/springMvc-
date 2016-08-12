package net.codejava.spring.convertor;

import net.codejava.spring.dao.*;
import net.codejava.spring.model.User;

import java.beans.PropertyEditorSupport;

public class SimpleUserEditor extends PropertyEditorSupport {

	private UserDao userDao;

	public SimpleUserEditor(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = null;
		try {
			Integer id = Integer.parseInt(text);
			user = userDao.get(id);
			System.out.println("Department name:" + user.getUsername());
		} catch (NumberFormatException ex) {
			System.out.println("Department will be null");
		}
		setValue(user);
	}
}
