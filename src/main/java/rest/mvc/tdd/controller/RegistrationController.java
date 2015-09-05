package rest.mvc.tdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.mvc.tdd.beans.UserRegister;
import rest.mvc.tdd.dao.UserDAO;

@RestController
public class RegistrationController {
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/register/users", method = RequestMethod.POST)
	public UserRegister registerUser(@RequestBody UserRegister user) {
		userDao.create(user);
		return user;
	}
	
	@RequestMapping(value = "/register/users/{name}", method = RequestMethod.GET)
	public UserRegister registerUser(@PathVariable final String name) {
		return userDao.readById(name);
	}
	
	@RequestMapping(value = "/register/users", method = RequestMethod.GET)
	public List<UserRegister> listUser() {
		return userDao.listAllUsers();
	}
	
	@RequestMapping(value = "/register/users/{name}", method = RequestMethod.DELETE)
	public int deleteUser(@PathVariable final String name) {
		return userDao.deleteById(name);
	}
}
