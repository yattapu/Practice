package rest.mvc.tdd.dao;

import java.util.List;

import rest.mvc.tdd.beans.UserRegister;


public interface UserDAO {

	public void create(UserRegister user);
	
	public UserRegister readById(String id);
	
	public void update(UserRegister user);
	
	public int deleteById(String id);

	List<UserRegister> listAllUsers();
}
