package rest.mvc.tdd.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import rest.mvc.tdd.beans.UserRegister;
import rest.mvc.tdd.utils.IntegrationTestUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring.xml", "spring.xml" })
@Configurable
@Transactional
public class RegistrationControllerTest {
	private MockMvc mockMVC;
	@Before
	public void setUp(){
		mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
	}
	@Autowired
	private RegistrationController controller;
	@Test
	public void insertUser() throws Exception {
		
		UserRegister user = getTestUserRegistration();		
		 mockMVC.perform(post("/register/user")
	                .content(asJsonString(user))
	                .contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8))
	             .andExpect(status().isOk())
	             .andExpect(content().string(asJsonString(user)));	        		 
	}
	
	
	@Test
	public void findUsers() throws Exception {
		
		 mockMVC.perform(get("/register/REDDY/user"))
	                .andExpect(status().isOk())
	                .andExpect(
	                        content().contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
	                 )	                        
	             .andExpect(content().string(containsString("REDDY")));	        		 
	}
	
	@Test
	public void deleteUsersByName(){
		 try {
			//mockMVC.perform(delete("/register/{name}/user", "REDDY"))
			// .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private UserRegister getTestUserRegistration() {
		UserRegister user = new UserRegister();
		user.setName("REDDY");
		user.setEmail("reddy@gmail.com");	
		user.setPhone("00767670");
		return user;
	}
	
	private String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
