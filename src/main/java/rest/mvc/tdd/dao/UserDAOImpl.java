package rest.mvc.tdd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import rest.mvc.tdd.beans.UserRegister;

import com.mongodb.WriteResult;

@Component
public class UserDAOImpl implements UserDAO {
	
	public UserDAOImpl(){
		
	}

	@Autowired
	private MongoOperations mongoOps;
	private static final String USER_COLLECTION = "UserRegister";
	
	@Override
	public void create(UserRegister user) {
		this.mongoOps.insert(user, USER_COLLECTION);
	}

	@Override
	public UserRegister readById(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		UserRegister user1 = this.mongoOps.findOne(query, UserRegister.class, USER_COLLECTION);
		return user1;
	}
	
	@Override
	public List<UserRegister> listAllUsers() {
		return this.mongoOps.findAll(UserRegister.class, USER_COLLECTION);
	}

	@Override
	public void update(UserRegister user) {
		this.mongoOps.save(user, USER_COLLECTION);
	}

	@Override
	public int deleteById(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		WriteResult result = this.mongoOps.remove(query, UserRegister.class, USER_COLLECTION);
		return result.getN();
	}

}
