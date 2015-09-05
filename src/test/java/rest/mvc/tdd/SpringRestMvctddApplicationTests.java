package rest.mvc.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rest.mvc.tdd.SpringRestMvctddApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringRestMvctddApplication.class)
@WebAppConfiguration
public class SpringRestMvctddApplicationTests {

	@Test
	public void contextLoads() {
	}

}
